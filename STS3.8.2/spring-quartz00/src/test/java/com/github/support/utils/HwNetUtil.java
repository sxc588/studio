package com.github.support.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HwNetUtil {

	public static String getHostNameL() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			// String ip=addr.getHostAddress().toString(); //获取本机ip
			String hostName = addr.getHostName().toString(); // 获取本机计算机名称
			return hostName;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return "UnknownHostException";
	}

	public static String getIPL() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // 获取本机ip
			// String hostName = addr.getHostName().toString(); // 获取本机计算机名称
			return ip;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "UnknownHostException";
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress().toString(); // 获取本机ip
		String hostName = addr.getHostName().toString(); // 获取本机计算机名称
		System.out.println(ip);
		System.out.println(hostName);
	}

}
