/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.github.support.cbb.ehcache.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StringReplaceUtil
{
	public static void Relplase(String src, String dst, String target, String replacement) throws IOException
	{
		File file = new File(src);
		File dest = new File(dst);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
		String line = reader.readLine();

		while (line != null)
		{
			line = line.replace(target, replacement);
			writer.write(line);
			line = reader.readLine();
		}
		writer.flush();
		reader.close();
		writer.close();
	}

	public static void RelplaseMutl(String src, String dst, Map<String, String> map) throws IOException
	{
		File file = new File(src);
		File dest = new File(dst);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
		String line = reader.readLine();
		while (line != null)
		{
			for (Map.Entry<String, String> entry : map.entrySet())
			{
				String target = entry.getKey();
				String replacement = entry.getValue();
				line = line.replace(target, replacement);
			}
			writer.write(line);
			writer.newLine();
			line = reader.readLine();
		}
		writer.flush();
		reader.close();
		writer.close();
	}
	
	
	// 测试代码
		public static void main(String[] args) throws IOException
		{
			String src = "test.properties";
			String dst = "meta.properties";
			String profilepath= "D:\\Workspaces\\MyEclipsePro2013\\CBBService\\src\\main\\java\\com\\huawei\\support\\cbbservice\\jms\\";
			URL url= StringReplaceUtil.class.getResource("/");
			
			System.err.println(url.getPath());
			
			profilepath = url.getPath();

			Map<String, String> abcd = new HashMap<String, String>();
			abcd.put("${SERVER1}", "value1");
			abcd.put("${SERVER2}", "value2");
			abcd.put("${SERVER3}", "value3");
			abcd.put("${SERVER4}", "value4");
			RelplaseMutl(profilepath+src, profilepath+dst, abcd);
		}
}
