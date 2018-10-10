package com.github.support.controller.setting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.controller.setting.validate.ConfigValidator;
import com.github.support.dbaccess.dto.ConfigDto;
import com.github.support.quartz.model.User;
import com.github.support.validator.UserValidator;
import com.github.support.vo.ScheduleJobVo;

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

	 //我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
    //所以在这里注册校验器
    @InitBinder
    public void initBainder(DataBinder binder){
        binder.replaceValidators(new ConfigValidator());

    }
    //这个方法主要是跳转到登录页面
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String edit(Model model){
        model.addAttribute(new ConfigDto());
        return "/settings/configsEdit";
    }
    
    
    //处理登录表单
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String save(@Validated ConfigDto configDto, BindingResult br){

        if (br.hasErrors())
        {
            return "/settings/configsEdit";
        }
        
        return "redirect:list";
    }
    
	/**
	 * 任务列表页
	 **/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(ModelMap modelMap)
    {
    
    	log.info(">>list");
    	
    	ConfigDto dto = new ConfigDto();
    	dto.setKey("Key01");
    	dto.setValue("value01");
    	dto.setDescription("des");
    	
    	List<ConfigDto> dtos = new ArrayList<ConfigDto>();
    	dtos.add(dto);
     	dtos.add(dto);
     	dtos.add(dto);
     	dtos.add(dto);
     	dtos.add(dto);
     	
     	dtos.add(dto);
     	dtos.add(dto);
     	dtos.add(dto);
     	dtos.add(dto);
    	
    	modelMap.put("dtoList", dtos);

        return "/settings/configsList";
    }
    
    
}
