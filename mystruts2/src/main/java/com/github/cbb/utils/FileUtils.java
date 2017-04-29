package com.github.cbb.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.cbb.utils.security.CodexCCUtils;

public abstract class  FileUtils
{
	private static int BUF_SIZE = 1024*1024;
	
	private static Logger log = LoggerFactory.getLogger(FileUtils.class);
	
	public static String getLogPath()
	{
		return File.separator + "applog";
	}
	
	public static int writeContent(String filePath, InputStream is)
	{

		try
		{
			OutputStream outputStream= new FileOutputStream(filePath);
			
			try
			{
				byte[] buf = new byte[BUF_SIZE];
				Integer len = 0;
				while((len=is.read(buf))>0)
				{
					outputStream.write(buf, 0, len);
				}
				
				return 1;
			}
			catch (IOException e)
			{
				CodexCCUtils.report(log, "FileNotFoundException", e);
				//e.printStackTrace();
			}finally {
				IOUtils.closeQuietly(outputStream);
			}
			
			
		}
		catch (FileNotFoundException e)
		{
			CodexCCUtils.report(log, "FileNotFoundException", e);
			//e.printStackTrace();
		}
		return 0;
	}
	
	
	
	

}
