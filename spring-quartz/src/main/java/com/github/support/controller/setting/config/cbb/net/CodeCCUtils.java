package com.github.support.controller.setting.config.cbb.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public final class CodeCCUtils
{

	public void wrtiteContent(String names, byte[]  content )
	{

		File file = FileUtils.getFile(names);
		if (null == file )
		{
			return ;
		}
		
		OutputStream out = null;
		
		try
		{
			out = FileUtils.openOutputStream(file);
			BufferedOutputStream buffer = new BufferedOutputStream(out);
			buffer.write(content);
			buffer.flush();
		}
		catch (IOException e)
		{
			IOUtils.closeQuietly(out);
		}
	}
	
	public void wrtiteContent(String names, DataHandler hander)
	{

		File file = FileUtils.getFile(names);
		if (null == file )
		{
			return ;
		}
		
		OutputStream out = null;
		
		try
		{
			out = FileUtils.openOutputStream(file);
			BufferedOutputStream buffer = new BufferedOutputStream(out);
			hander.writeTo(buffer);
			buffer.flush();
			IOUtils.closeQuietly(out);
		}
		catch (IOException e)
		{
			IOUtils.closeQuietly(out);
		}
	}
	
	public void wrtiteContent(String fielName, InputStream inputStream)
	{

		File file = FileUtils.getFile(fielName);
		if (null == file )
		{
			return ;
		}
		
		OutputStream out = null;
		try
		{
			out = FileUtils.openOutputStream(file);
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);
			int len= 0;
			int totalSz = 0;
			byte [] buffer = new byte[4096];
			while ((len= inputStream.read(buffer,0,buffer.length)) >0)
			{
				outBuffer.write(buffer, 0, len);
				totalSz +=len;
			}

			IOUtils.closeQuietly(out);
		}
		catch (IOException e)
		{
			IOUtils.closeQuietly(out);
		}
	}
	
	public byte[] readContent(String fielName, InputStream inputStream)
	{

		File file = FileUtils.getFile(fielName);
		if (null == file )
		{
			return null;
		}
		
		InputStream in = null;
		try
		{
			in = FileUtils.openInputStream(file);
			BufferedInputStream inBuffer = new BufferedInputStream(in);
			int len= 0;
			int totalSz = 0;
			byte [] byteResults = new byte[inBuffer.available()];
			inBuffer.read(byteResults);
			
			return byteResults;
	
		}
		catch (IOException e)
		{
			IOUtils.closeQuietly(in);
		}
		return null;
	}
	
	public void copyContent(InputStream inputStream, OutputStream outputStream)
	{
		try
		{
			int len= 0;
			int totalSz = 0;
			byte [] buffer = new byte[4096];
			while ((len= inputStream.read(buffer)) >0)
			{
				outputStream.write(buffer, 0, len);
				totalSz +=len;
			}
		}
		catch (IOException e)
		{
		}
	}
	
}
