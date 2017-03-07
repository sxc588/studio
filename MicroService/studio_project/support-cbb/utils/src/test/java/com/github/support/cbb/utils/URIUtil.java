package com.github.support.cbb.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class URIUtil
{

	@Test
	public void test()
	{
		try
		{

			String ip = "58.214.5.162";
			// URL url=new
			// URL("http://www.youdao.com/smartresult-xml/search.s?type=ip&q=58.214.5.162");
			URL url = new URL("http://whois.pconline.com.cn/ip.jsp?ip=" + ip);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			InputStream is = connect.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buff = new byte[256];
			int rc = 0;
			while ((rc = is.read(buff, 0, 256)) > 0)
			{
				outStream.write(buff, 0, rc);
			}
			byte[] b = outStream.toByteArray();
			// 关闭
			outStream.close();
			is.close();
			connect.disconnect();

			String address = new String(b);
			String ipprovince;
			if (address.indexOf("省") != -1)
			{
				ipprovince = address.substring(0, address.indexOf("省") + 1);
				System.out.println("省地址为：" + ipprovince);
			}
			else if (address.indexOf("区") != -1)
			{
				ipprovince = address.substring(0, address.indexOf("区") + 1);
				System.out.println("省地址为：" + ipprovince);
			}
			else
			{
				// ipprovince = address.substring(0, address.indexOf("市") + 1);
				System.out.println("省地址为：" + address);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void test2() throws MalformedURLException
	{

		URL url = new URL("http://whois.pconline.com.cn:9999/ip.jsp?ip=127.0.0.1");
		System.out.println(url.getHost());
		System.out.println(url.getProtocol());

		System.out.println(url.getPort());

	}
	@Test
	public void test3() throws MalformedURLException
	{
		String v = URIUtil.sendGet("http://support.huawei.com/evideo/zh/multimedia-libarary"," ");
		System.out.println(v);
	
	}


	public static String sendGet(String url, String param)
	{
		String result = "";
		try
		{
			String urlName = url + "?" + param;//

			URL U = new URL(urlName);
			URLConnection connection = U.openConnection();
			connection.connect();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Helloword！！" + e);
		}
		return result;
	}

	public static String sendPost(String url, String param)
	{
		String result = "";
		try
		{
			URL httpurl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
			in.close();
		}
		catch (Exception e)
		{
			System.out.println("Helloword！" + e);
		}
		return result;
	}

	/**
	 * 写入数据到输出流
	 * 
	 * @param xmlContent
	 * @param response
	 * @return
	 */
	public boolean toSteam(String contentName, byte[] content, HttpServletResponse response)
	{
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(contentName.getBytes()));
		response.setHeader("Content-Length", "" + content.length);
		response.setHeader("ServerInfo:", getAddress());
		response.setContentType("application/octet-stream");

		ServletOutputStream out = null;
		try
		{
			// 获取输出流
			out = response.getOutputStream();

			out.write(content, 0, content.length);
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(out);
		}
		return false;
	}

	/**
	 * 写入数据到输出流
	 * 
	 * @param xmlContent
	 * @param response
	 * @return
	 */
	public boolean toSteam(String xmlContent, HttpServletResponse response)
	{
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename=backupnamelist.xml");
		response.setHeader("Content-Length", "" + xmlContent.length());
		response.setHeader("ServerInfo:", getAddress());
		response.setContentType("application/xml");

		ByteArrayInputStream in = new ByteArrayInputStream(xmlContent.getBytes());
		ServletOutputStream out = null;

		try
		{
			byte buffer[] = new byte[1024];
			int length = 0;
			// 获取输出流
			out = response.getOutputStream();

			// 循环将数据写入输出流
			while ((length = in.read(buffer)) > 0)
			{
				// 输出到缓冲区，实现下载
				out.write(buffer, 0, length);
			}
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		return false;
	}

	private String getAddress()
	{

		return "127.0.0.1";
	}
}
