package com.github.cbb.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.cbb.utils.security.CodexCCUtils;

/**
 * 
 * HttpComponents之httpclient基本使用方法 - httpclient的版本是4.3 <dependency>
 * <groupId>org.apache.httpcomponents</groupId>
 * <artifactId>httpclient</artifactId> <version>4.5.2</version> </dependency>
 * 
 * B、第二种方式，这种方式是用了一个http的连接池，同时使用httpbuilder构造合适的http方法。
 * 
 */

public class HttpClientUtils
{
	
	/**
	 * log
	 */
	private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);
	
	private static PoolingHttpClientConnectionManager connectionManager = null;
	private static HttpClientBuilder httpBulder = null;
	private static RequestConfig requestConfig = null;

	private static int MAXCONNECTION = 10;

	private static int DEFAULTMAXCONNECTION = 5;

	private static String IP = "www.sohu.com";
	private static int PORT = 80;

	static
	{
		// 设置http的状态参数
		requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();

		HttpHost target = new HttpHost(IP, PORT);
		connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(MAXCONNECTION);
		connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);
		connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
		httpBulder = HttpClientBuilder.create();
		httpBulder.setConnectionManager(connectionManager);
	}

	public static CloseableHttpClient getConnection()
	{
		CloseableHttpClient httpClient = httpBulder.build();
		return httpClient;
	}

	public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method)
	{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for (Map.Entry<String, String> e : entrySet)
		{
			String name = e.getKey();
			String value = e.getValue();
			NameValuePair pair = new BasicNameValuePair(name, value);
			params.add(pair);
		}
		HttpUriRequest reqMethod = null;
		if ("post".equals(method))
		{
			reqMethod = RequestBuilder.post().setUri(url).addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();
		}
		else if ("get".equals(method))
		{
			reqMethod = RequestBuilder.get().setUri(url).addParameters(params.toArray(new BasicNameValuePair[params.size()])).setConfig(requestConfig).build();
		}
		return reqMethod;
	}

	/**
	 * post方式提交表单（模拟用户登录请求）
	 */
	public void postForm()
	{
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");
	
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("username", "admin"));
		formparams.add(new BasicNameValuePair("password", "123456"));
		UrlEncodedFormEntity uefEntity;
		try
		{
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			log.info("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try
			{
				HttpEntity entity = response.getEntity();
				if (entity != null)
				{
					log.info("--------------------------------------");
					log.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					log.info("--------------------------------------");
				}
			}
			finally
			{
				IOUtils.closeQuietly(response);
			}
		}
		catch (IOException e)
		{
			CodexCCUtils.report(log, "exctipion", e);
		}
		finally
		{
			// 关闭连接,释放资源
			IOUtils.closeQuietly(httpclient);
		}
	}

	/**
	 * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
	 */
	public void post()
	{
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("type", "house"));
		UrlEncodedFormEntity uefEntity;
		try
		{
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			log.info("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try
			{
				HttpEntity entity = response.getEntity();
				if (entity != null)
				{
					log.info("--------------------------------------");
					log.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					log.info("--------------------------------------");
				}
			}
			finally
			{
				response.close();
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭连接,释放资源
			try
			{
				httpclient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送 get请求
	 */
	public void get()
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try
		{
			// 创建httpget.
			HttpGet httpget = new HttpGet("http://www.baidu.com/");
			log.info("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try
			{
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				log.info("--------------------------------------");
				// 打印响应状态
				log.info(response.getStatusLine().toString());
				if (entity != null)
				{
					// 打印响应内容长度
					log.info("Response content length: " + entity.getContentLength());
					// 打印响应内容
					log.info("Response content: " + EntityUtils.toString(entity));
				}
				log.info("------------------------------------");
			}
			finally
			{
				response.close();
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭连接,释放资源
			try
			{
				httpclient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 上传文件
	 */
	public void upload()
	{
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// try {
		// HttpPost httppost = new
		// HttpPost("http://localhost:8080/myDemo/Ajax/serivceFile.action");
		//
		// FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));
		// StringBody comment = new StringBody("A binary file of some kind",
		// ContentType.TEXT_PLAIN);
		//
		// HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin",
		// bin).addPart("comment", comment).build();
		//
		// httppost.setEntity(reqEntity);
		//
		// System.out.println("executing request " + httppost.getRequestLine());
		// CloseableHttpResponse response = httpclient.execute(httppost);
		// try {
		// System.out.println("----------------------------------------");
		// System.out.println(response.getStatusLine());
		// HttpEntity resEntity = response.getEntity();
		// if (resEntity != null) {
		// System.out.println("Response content length: " +
		// resEntity.getContentLength());
		// }
		// EntityUtils.consume(resEntity);
		// } finally {
		// response.close();
		// }
		// } catch (ClientProtocolException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// httpclient.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
	}

	public static void a(String args[]) throws IOException
	{
		Map<String, String> map = new HashMap<String, String>();
		// map.put("account", "");
		// map.put("password", "");

		HttpClient client = getConnection();
		HttpUriRequest post = getRequestMethod(map, "http://www.sohu.com", "post");
		HttpResponse response = client.execute(post);

		if (response.getStatusLine().getStatusCode() == 200)
		{
			HttpEntity entity = response.getEntity();
			String message = EntityUtils.toString(entity, "utf-8");
			System.out.println(message);
		}
		else
		{
			System.out.println("请求失败" + response.getStatusLine().getStatusCode());
		}
	}

	public static String doGet(String url)
	{
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		// HttpGet httpGet = new
		// HttpGet("http://support.huawei.com/enterprise/Main!getStaticFootHtml.action?language=zh");

		HttpGet httpGet = new HttpGet(url);

		System.out.println(httpGet.getRequestLine());
		try
		{
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);

			if (httpResponse.getStatusLine().getStatusCode() == 200)
			{
				// 获取响应消息实体
				HttpEntity entity = httpResponse.getEntity();

				// 判断响应实体是否为空
				if (entity != null)
				{
					String message = EntityUtils.toString(entity, "utf-8");
					log.info("contentEncoding:" + entity.getContentEncoding());
					log.info(message);
					return message;
				}
			}
			else
			{
				log.error("请求失败:" + httpResponse.getStatusLine().getStatusCode());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭流并释放资源
			IOUtils.closeQuietly(closeableHttpClient);
		}

		return StringUtils.EMPTY;
	}

	public void main(String args[]) throws IOException
	{
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		HttpGet httpGet = new HttpGet("http://support.huawei.com/enterprise/Main!getStaticFootHtml.action?language=zh");
		System.out.println(httpGet.getRequestLine());
		try
		{
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);

			if (httpResponse.getStatusLine().getStatusCode() == 200)
			{
				// 获取响应消息实体
				HttpEntity entity = httpResponse.getEntity();

				// 判断响应实体是否为空
				if (entity != null)
				{
					String message = EntityUtils.toString(entity, "utf-8");
					System.out.println("contentEncoding:" + entity.getContentEncoding());
					System.out.println(message);
				}
			}
			else
			{
				System.out.println("请求失败:" + httpResponse.getStatusLine().getStatusCode());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭流并释放资源
			closeableHttpClient.close();
		}
	}

	public static void doGet(String url, List<BasicNameValuePair> formparams)
	{
		// 创建默认的httpClient实例.
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		// 创建httppost
		HttpPost httppost = new HttpPost(url);

		// 创建参数队列
		// List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		// formparams.add(new BasicNameValuePair("username", "admin"));
		// formparams.add(new BasicNameValuePair("password", "123456"));
		UrlEncodedFormEntity uefEntity;
		try
		{
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = closeableHttpClient.execute(httppost);
			try
			{
				HttpEntity entity = response.getEntity();
				if (entity != null)
				{
					System.out.println("--------------------------------------");
					System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					System.out.println("--------------------------------------");
				}
			}
			finally
			{
				response.close();
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{

		}

	}

	public static void doPostForm(String url, List<BasicNameValuePair> formparams, List<Header> headers)
	{
		// 创建默认的httpClient实例.
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		// 创建httppost
		HttpPost httppost = new HttpPost(url);

		try
		{
			if (CollectionUtils.isNotEmpty(headers))
			{
				for (Header header : headers)
				{
					httppost.setHeader(header);
				}
			}

			if (CollectionUtils.isNotEmpty(formparams))
			{
				//UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
				
//				int CONNECTION_TIMEOUT = 5 * 1000; // timeout in millis
//				RequestConfig requestConfig = RequestConfig.custom()
//				    .setConnectionRequestTimeout(CONNECTION_TIMEOUT)
//				    .setConnectTimeout(CONNECTION_TIMEOUT)
//				    .setSocketTimeout(CONNECTION_TIMEOUT)
//				    .set
//				    .build();
				
				
				HttpParams params = new BasicHttpParams(); 
			

				for (BasicNameValuePair parm : formparams)
				{
					params.setParameter(parm.getValue(), parm.getValue());
				}
				httppost.setParams(params);
				//String abcd = uefEntity.toString();
				
				//log.info(abcd);
				
				//httppost.setEntity(uefEntity);
			}
			
			log.info("executing request " + httppost.getURI());
			CloseableHttpResponse response = closeableHttpClient.execute(httppost);
			try
			{
				HttpEntity entity = response.getEntity();
				if (entity != null)
				{
					log.info("--------------------------------------");
					log.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));
					log.info("--------------------------------------");
				}
			}
			finally
			{
				IOUtils.closeQuietly(response);
			}
		}
		catch (IOException e)
		{
			CodexCCUtils.report(log, "exctipion", e);
		}
		finally
		{
			// 关闭连接,释放资源
			IOUtils.closeQuietly(closeableHttpClient);
		}
	}

}
