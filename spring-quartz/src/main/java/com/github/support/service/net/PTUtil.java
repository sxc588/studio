package com.github.support.service.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * http://www.cnblogs.com/shea/p/8631789.html
 */
public class PTUtil {
	/***
	 * ping操作
	 * 
	 * @param hostname
	 * @param timeout  in milliseconds
	 * @return
	 */
	public static PTResult pingResult(String hostname, Integer timeout) {
		PTResult jsonResult = new PTResult();
		try {
			InetAddress address = InetAddress.getByName(hostname);
			boolean flag = address.isReachable(timeout);
			if (flag) {
				jsonResult.setMessage("ping结果:the address is reachable.");
			} else {
				jsonResult.setCode(PTConstants.ResultCode.EXCEPTION);
				jsonResult.setMessage("ping结果:the address is unreachable.");
			}
		} catch (UnknownHostException e) {
			jsonResult.setCode(PTConstants.ResultCode.EXCEPTION);
			jsonResult.setMessage("ping结果:UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			jsonResult.setCode(PTConstants.ResultCode.EXCEPTION);
			jsonResult.setMessage("ping结果:IOException:" + e.getMessage());
		}
		return jsonResult;
	}

	/***
	 * telnet 操作
	 * 
	 * @param hostname
	 * @param timeout  in milliseconds
	 * @return
	 */
	public static PTResult telnetResult(String hostname, Integer port, Integer timeout) {
		PTResult jsonResult = new PTResult();
		try {
			Socket server = new Socket();
			InetSocketAddress address = new InetSocketAddress(hostname, port);
			server.connect(address, timeout);
			server.close();
			jsonResult.setMessage("telnet结果:success!");
		} catch (UnknownHostException e) {
			jsonResult.setCode(PTConstants.ResultCode.EXCEPTION);
			jsonResult.setMessage("telnet结果:UnknownHostException:" + e.getMessage());
		} catch (IOException e) {
			jsonResult.setCode(PTConstants.ResultCode.EXCEPTION);
			jsonResult.setMessage("telnet结果:IOException:" + e.getMessage());
		}
		return jsonResult;
	}
}