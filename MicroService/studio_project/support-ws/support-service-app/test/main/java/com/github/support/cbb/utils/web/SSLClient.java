package com.github.support.cbb.utils.web;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
// 用于进行Https请求的HttpClient
public class SSLClient extends  CloseableHttpClient
{
	public SSLClient() throws Exception
	{
		super();
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager()
		{
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
			{}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
			{}

			@Override
			public X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}

		};
		ctx.init(null, new TrustManager[]{tm}, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = this.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
	}

	@Override
	public ClientConnectionManager getConnectionManager()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpParams getParams()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected CloseableHttpResponse doExecute(HttpHost arg0, HttpRequest arg1, HttpContext arg2)
																								throws IOException,
																								ClientProtocolException
	{
		// TODO Auto-generated method stub
		return null;
	}
}