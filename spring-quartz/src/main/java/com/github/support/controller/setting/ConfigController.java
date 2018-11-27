package com.github.support.controller.setting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.support.controller.setting.service.ConfigServcie;
import com.github.support.controller.setting.service.IpUtil;
import com.github.support.controller.setting.validate.ConfigValidator;
import com.github.support.dbaccess.dto.ConfigDto;

/**
 * 功能说明：系统配置项Action
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/setting/config")
public class ConfigController
{
	private static Logger log = LoggerFactory.getLogger(ConfigController.class);

	@Autowired
    private ConfigServcie configService;
	
	
	 //我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
    //所以在这里注册校验器
    @InitBinder
    public void initBainder(DataBinder binder){
        binder.replaceValidators(new ConfigValidator());

    }
    //这个方法主要是跳转到登录页面
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(HttpServletRequest request,Model model){
        model.addAttribute(new ConfigDto());
        return "/settings/configsEdit";
    }
    
    
    //处理登录表单
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String save(@Validated ConfigDto configDto, HttpServletRequest request,BindingResult br){

        if (br.hasErrors())
        {
            return "/settings/configsEdit";
        }
        
        
        
        String lastUpdateBy = IpUtil.getIpAddr(request);
		configDto.setLastUpdateBy(lastUpdateBy);
        
        configService.save(configDto);
        return "redirect:list";
    }
    
	/**
	 * 任务列表页
	 **/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(ModelMap modelMap)
    {
    	log.info(">>list");
    	List<ConfigDto> dtos = configService.list();
    	modelMap.put("dtoList", dtos);
        return "/settings/configsList";
    }
    
    
}
