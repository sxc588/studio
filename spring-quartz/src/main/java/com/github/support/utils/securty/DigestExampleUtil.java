package com.github.support.utils.securty;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DigestExampleUtil {
	private static final String PASSWORD = "WTF";

	public static byte[] decrypt(byte[] content) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(PASSWORD.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encryptResultStr) {
		String ym = "";
		try {
			byte[] decryptFrom = Base64.decodeBase64(encryptResultStr);
			byte[] decryptResult = decrypt(decryptFrom);
			ym = new String(decryptResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ym;
	}

	public static byte[] encrypt(String content) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(PASSWORD.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encrypt2(String content) {
		String encryptResultStr = "";
		try {
			byte[] encryptResult = encrypt(content);
			encryptResultStr = new String(Base64.encodeBase64(encryptResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptResultStr;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String content = "123456";
		// 加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = encrypt(content);
		String encryptResultStr = new String(Base64.encodeBase64(encryptResult));
		System.out.println(encryptResultStr);
		// 解密

		byte[] decryptFrom = Base64.decodeBase64(encryptResultStr);
		byte[] decryptResult = decrypt(decryptFrom);
		System.out.println("解密后：" + new String(decryptResult));
	}
}