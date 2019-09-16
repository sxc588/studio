package com.github.support.utils.securty;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	/**
	 * 重写父类方法，解密指定属性名对应的属性值
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptPropertyVal(propertyName)) {
			// 调用解密方法
			return DigestExampleUtil.decrypt(propertyValue);
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断属性是否需要解密
	 * 
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptPropertyVal(String propertyName) {
		if (propertyName != null && "username,password".contains(propertyName)) {
			return true;
		} else {
			return false;
		}
	}

}
