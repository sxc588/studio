package com.github.support.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class HwBeanUtils {
	/**
	 * 
	 * 
	 * Map转换层Bean，使用泛型免去了类型转换的麻烦。
	 * 
	 * @param        <T>
	 * @param map
	 * @param class1
	 * @return
	 */
	public static <T> T map2Bean(Map<String, String> map, Class<T> class1) {
		T bean = null;
		try {
			bean = class1.newInstance();
			BeanUtils.populate(bean, map);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * BeanUtils.populate( Object bean, Map properties ) 这个方法会遍历map<key,
	 * value>中的key，如果bean中有这个属性 就把这个key对应的value值赋给bean的属性。 bean 转换成 map
	 * 
	 * @param obj
	 * @return
	 */
	public Map<String, Object> bean2Map(Object obj) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = BeanUtils.describe(obj);
			return map;

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
