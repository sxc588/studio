/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.github.support.cbb.ehcache.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DirReplaceUtil
{
	/**
	 * 处理文件内容替换项
	 */
	private static Map<String, String> map4File;
	
	/**
	 * 处理文件路径替换项（文件名，文件夹）
	 */
	private static Map<String, String> map4Dir;
	
	
	// 递归显示C盘下所有文件夹及其中文件
	public static void RelplaseMutl() throws IOException
	{
		map4File = new HashMap<String, String>();
		
		map4File.put("2016-10-04", "20161004");
		map4File.put("org.springframework.web", "springframework");
		
		
		map4Dir = new HashMap<String, String>();
		map4Dir.put("aaa", "bbb");
		
		File root = new File("D:\\新建文件夹 (2)\\aaa");
		handleAllFiles(root);
	}
	
	/** 
	 *  将字符串line ，安装 map 中的key value 替换
	 * @param line
	 * @param replace
	 * @return
	 */
	public static String replaceEx(String line, Map<String, String> replace)
	{
		String temp = line;
		for (Map.Entry<String, String> entry : replace.entrySet())
		{
			temp = temp.replace(entry.getKey(), entry.getValue());
		}
		return temp;
	}
	
	/**
	 * 递归遍历 dir 目录下的所有文件
	 * @param dir
	 * @throws IOException 
	 */
	final static void handleAllFiles(File dir) throws IOException
	{
		File[] fs = dir.listFiles();
		for (File file : fs)
		{
			if (file.isDirectory())
			{
				handleAllFiles(file);
			}
			else
			{
				String src = file.getAbsolutePath();
				String dst = replaceEx(src,map4Dir);
				
				FileReplaceUtil.RelplaseMutl(src, dst, map4File);
				System.out.println(file.getAbsolutePath());
			}
		}
	}
}
