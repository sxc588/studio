package com.github.support.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class HostUtils {
	public static String getHostNameAndIp() {

		try {

			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // 获得机器IP
			String address = addr.getHostName().toString(); // 获得机器名称
			String ipAddress = ip + "|" + address;

			return ipAddress;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "unnkonw";
	}

	/**
	 * 一、通过IP获取机器名 or 通过机器名获取ip
	 * 
	 * @param obj
	 * @return
	 */
	public static String getHostNameAndIp(String name) {
		name = "cp01-fengchao-public-7.epc.baidu.com";
		InetAddress addr = null;
		String ip = "";
		String address = "";
		try {
			// cp01-fengchao-public-7.epc.baidu.com|10.95.130.73
			addr = InetAddress.getByName(name);
			ip = addr.getHostAddress().toString(); // 获得机器IP
			address = addr.getHostName().toString(); // 获得机器名称
			String ipAddress = ip + "|" + address;

			return ipAddress;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "unnkonw";
	}

}
