package com.github.support.cbb.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StramUtiles
{
	public boolean InputStream2File(InputStream is, String filePath)
	{
		FileOutputStream outputStrem = null;
		try
		{
			outputStrem = new FileOutputStream(filePath);

			int ch = 0;
			while ((ch = is.read()) != -1)
			{
				outputStrem.write(ch);

			}

			return true;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		finally
		{
			closeStream(outputStrem);
			closeStream(is);
		}

		return false;
	}

	public boolean InputStream2FileViaBuf(InputStream is, String filePath)
	{
		FileOutputStream outputStrem = null;
		try
		{
			outputStrem = new FileOutputStream(filePath);
			int bytesRead = 0;
			final int BUF_SIZE = 1024 * 1024;
			byte[] buffer = new byte[BUF_SIZE];

			while ((bytesRead = is.read(buffer, 0, BUF_SIZE)) != -1)
			{
				outputStrem.write(buffer, 0, bytesRead);
			}

			return true;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeStream(outputStrem);
			closeStream(is);
		}

		return false;
	}

	private void closeStream(InputStream inpputStrem)
	{
		try
		{
			if (inpputStrem != null)
			{
				inpputStrem.close();
			}
			inpputStrem = null;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeStream(OutputStream outputStrem)
	{
		try
		{
			if (outputStrem != null)
			{
				outputStrem.close();
				outputStrem = null;
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
