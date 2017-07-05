package com.github.cbb.security;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * 文本加解密工具类
 * Encryption and decryption tools
 * @author Administrator
 *
 */
public class EncriptUtils
{
	
	/**
	 * 明文加密
	 * @param cleartext
	 * @return cipherText
	 */
	public String encrypt(String cleartext  )
	{
		
		if (StringUtils.isBlank(cleartext))
		{
			return cleartext;
		}
		
		String cipherText= cleartext;
		return cipherText;
		
	}
	
	
	/**
	 * 密文解密
	 * @param cipherText
	 * @return cleartext
	 */
	public String decrypt(String  cipherText )
	{
		if (StringUtils.isBlank(cipherText))
		{
			return cipherText;
		}
		String cleartext= cipherText;
		return cleartext;
	}


}
