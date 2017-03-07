package com.github.support.cbb.utils.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/*
 * 目前，要为另一个项目提供接口，接口是用HTTP URL实现的，最初的想法是另一个项目用jQuery post进行请求。
 * 但是，很可能另一个项目是部署在别的机器上，那么就存在跨域问题，而JQuery的post请求是不允许跨域的。
 * 这时，就只能够用HttpClient包进行请求了，同时由于请求的URL是HTTPS的，
 * 为了避免需要证书，所以用一个类继承DefaultHttpClient类，忽略校验过程。
 * 
 * 1.写一个SSLClient类，继承至HttpClient,利用HttpClient进行post请求的工具类
 */
public class HttpSendUtil
{
	public static String doPost(String url, Map<String, String> map, String charset)
	{
		SSLClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try
		{
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext())
			{
				Entry<String, String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			
			if (list.size() > 0)
			{
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null)
			{
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null)
				{
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		}
		catch (Exception ex)
		{
		//	ex.printStackTrace();
		}
		IOUtils.closeQuietly(httpClient);
		return result;
	}
}
