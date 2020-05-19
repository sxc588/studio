package com.github.support.utils;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;

public class GetMD5One {
	private final static String[] strHex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f" };

	public static String getMD5One(String path) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(FileUtils.readFileToByteArray(new File(path)));
			for (int i = 0; i < b.length; i++) {
				int d = b[i];
				if (d < 0) {
					d += 256;
				}
				int d1 = d / 16;
				int d2 = d % 16;
				sb.append(strHex[d1] + strHex[d2]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}


	void tt() {
		String str = "e:\\宽带.png";
		String value = getMD5One(str);
		System.out.print(value);

	}

}
