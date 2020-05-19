package com.github.support.controller.setting.validate;

import java.util.logging.SimpleFormatter;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.github.support.controller.setting.dao.ConfigDto;


/**
 * https://blog.csdn.net/u012706811/article/details/51079740
 */
public class ConfigValidator extends SimpleFormatter implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		// 判断是否是要校验的类,这里是ConfigDto
		return ConfigDto.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ConfigDto obj = (ConfigDto) o;
		if (StringUtils.isBlank(obj.getKey())) {
			// 此方法可以加四个参数,第一个表单域field,
			// 区分是哪个表单出错,第二个errorCode错误码,
			// 第三个制定了资源文件中占位符,第四个具体错误返回信息
			// 简写版可以把2,3参数去掉
			errors.rejectValue("key", null, null, "key is not allowed blank!");
		}

		if (StringUtils.isBlank(obj.getValue())) {
			// 此方法可以加四个参数,第一个表单域field,
			// 区分是哪个表单出错,第二个errorCode错误码,
			// 第三个制定了资源文件中占位符,第四个具体错误返回信息
			// 简写版可以把2,3参数去掉
			errors.rejectValue("value", null, null, "value is not allowed blank!");
		}

		if (StringUtils.isBlank(obj.getDescription())) {
			// 此方法可以加四个参数,第一个表单域field,
			// 区分是哪个表单出错,第二个errorCode错误码,
			// 第三个制定了资源文件中占位符,第四个具体错误返回信息
			// 简写版可以把2,3参数去掉
			errors.rejectValue("description", null, null, "description is not allowed blank!");
		}

	}

}
