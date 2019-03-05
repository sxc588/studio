package com.github.support.controller.setting.config;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.support.controller.setting.config.cbb.net.IpUtil;
import com.github.support.dbaccess.dto.ConfigDto;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/setting/config")
public class ConfigController extends SimpleFormatter
{
	private static Logger log = LoggerFactory.getLogger(ConfigController.class);

	@Autowired
	private ConfigServcie configService;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.replaceValidators(new ConfigValidator());
	}

	// 我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
	// 所以在这里注册校验器
	// @InitBinder
	// public void initBainder(DataBinder binder)
	// {
	// binder.replaceValidators(new ConfigValidator());
	// }

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Model model)
	{

		log.info(">>edit");

		String id = request.getParameter("configId");

		ConfigDto dto = configService.get(id);
		long begin = System.currentTimeMillis();
		if (dto == null)
		{
		
			dto = new ConfigDto();
			dto.setLastUpdateTime(new Date());
			dto.setLastUpdateBy(IpUtil.getIpAddr());
		}
			model.addAttribute(dto);
			long end = System.currentTimeMillis();
			log.info(">>edit.save" + (end - begin));

		return "/settings/configsEdit";
	}

	// 处理登录表单
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String save(@Validated ConfigDto configDto, BindingResult br)
	{

		long begin = System.currentTimeMillis();
		log.info(">>edit.save");
		if (br.hasErrors())
		{
			return "/settings/configsEdit";
		}

		configDto.setLastUpdateBy(IpUtil.getIpAddr());

		configService.save(configDto);

		long end = System.currentTimeMillis();
		log.info(">>edit.save" + (end - begin));

		return "redirect:list";
	}

	/**
	 * 任务列表页
	 **/
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(ModelMap modelMap)
	{
		long begin = System.currentTimeMillis();
		log.info(">>list");
		Collection<ConfigDto> dtos = configService.list();
		modelMap.put("dtoList", dtos);
		long end = System.currentTimeMillis();
		log.info(">>edit.save" + (end - begin));
		return "/settings/configsList";
	}

}
