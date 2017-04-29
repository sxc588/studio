package com.github.cbb.utils.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.binding.xml.interceptor.XMLMessageInInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

public final class JAXRSAuthorizationInterceptor extends XMLMessageInInterceptor
{

	private static Logger logger = LoggerFactory.getLogger(JAXRSAuthorizationInterceptor.class);

	private Properties props;

	private static final int HTTP_UNAUTHORIZED = 401;

	/**
	 * 配置路径
	 */
	private Resource configLocation;

	public final Resource getConfigLocation()
	{
		return this.configLocation;
	}

	public final void setConfigLocation(Resource configLocation)
	{
		this.configLocation = configLocation;
	}

	public Properties getProps()
	{
		if (null != this.props)
		{
			return this.props;
		}

		InputStream is = null;
		try
		{
			this.props = new Properties();
			is = configLocation.getInputStream();
			props.load(is);

		}
		catch (IOException e)
		{
			CodexCCUtils.report(logger, "IOException", e);
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(is);
		}

		return props;
	}
	
	@Override
	public void handleMessage(Message message)
	throws Fault
	{
		final AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
		if (null == policy )
		{
			setErrorResponse(message,HTTP_UNAUTHORIZED);
			return ;
		}
		String username = policy.getUserName();
		String password = policy.getPassword();;
		
		String expected= this.getProps().getProperty(username);
		
		if (StringUtils.equals(password, expected))
		{
			setErrorResponse(message,HTTP_UNAUTHORIZED);
		}
		super.handleMessage(message);
	}

	private void setErrorResponse(Message message, int errCode)
	{
		Message outMessage = getOutMessage(message);
		outMessage.put(Message.RESPONSE_CODE, errCode);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> headers  = (Map<String, Object>) message.get(Message.PROTOCOL_HEADERS);
		
		headers.put("WWW-Authenticate", Arrays.asList(new String[]{"Basic realm=realm"}));
		headers.put("Content-Length", Arrays.asList(new String[]{"0"}));
		
		
		message.getInterceptorChain().abort();

		
	}

	private Message getOutMessage(Message message)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
