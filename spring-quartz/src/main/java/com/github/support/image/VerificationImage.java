package com.github.support.image;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.support.image.v1.SCaptcha;
import com.github.support.image.v2.ValidateCodeV2;
import com.github.support.image.v3.ValidateCode;

@Controller
@RequestMapping(value = "/verification")
public class VerificationImage
{
	/**
	 * @author jiaqing.xu@hand-china.com
	 * @date 2017/8/23
	 * @description 生成图片验证码
	 */
	@RequestMapping(value = "/image/v1", method =
	{RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void verificationv1(
								HttpServletRequest request,
								HttpServletResponse response,
								HttpSession session) throws IOException
	{
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 实例生成验证码对象
		SCaptcha instance = new SCaptcha();
		// 将验证码存入session
		session.setAttribute("verification", instance.getCode());
		// 向页面输出验证码图片
		instance.write(response.getOutputStream());
	}

	/**
	 * @author jiaqing.xu@hand-china.com
	 * @date 2017/8/23
	 * @description 生成图片验证码
	 */
	@RequestMapping(value = "/image/v2", method =
	{RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void verificationv2(
								HttpServletRequest request,
								HttpServletResponse response,
								HttpSession session) throws IOException
	{
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		ValidateCodeV2 vCode = new ValidateCodeV2(120, 40, 5, 100);
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());
	}
	/**
	 * @author jiaqing.xu@hand-china.com
	 * @date 2017/8/23
	 * @description 生成图片验证码
	 */
	@RequestMapping(value = "/image/v3", method =
	{RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void verificationv3(
								HttpServletRequest request,
								HttpServletResponse response,
								HttpSession session) throws IOException
	{

		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		ValidateCode vCode = new ValidateCode(120, 40, 5, 100);
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());

	}
}
