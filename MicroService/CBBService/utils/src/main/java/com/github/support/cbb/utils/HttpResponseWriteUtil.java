package com.github.support.cbb.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

public class HttpResponseWriteUtil
{
	
	
	/**
	 * 写入数据到输出流
	 * @param xmlContent
	 * @param response
	 * @return
	 */
	public boolean toSteam(String contentName,byte[] content,  HttpServletResponse response)
	{
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename=" + new String (contentName .getBytes()));
		response.setHeader("Content-Length", "" +  content.length);
		response.setHeader("ServerInfo:", getAddress());
		response.setContentType("application/octet-stream");

		ServletOutputStream out = null;
		try
		{
			// 获取输出流
			out = response.getOutputStream();
			
			out.write(content,0, content.length);
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
