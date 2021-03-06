package com.github.support.controller.debug;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.support.quartz.service.ScheduleJobService;
import com.github.support.vo.ScheduleJobVo;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "debug/quartz")
public class QuartzController {

	private static Logger log = LoggerFactory.getLogger(QuartzController.class);

	/** job service */
	@Autowired
	private ScheduleJobService scheduleJobService;

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String login(ScheduleJobVo scheduleJobVo, ModelMap modelMap) {

		List<ScheduleJobVo> scheduleJobVoList = scheduleJobService.queryExecutingJobList();
		System.err.println(scheduleJobVoList.size());

		modelMap.put("scheduleJobVoList", scheduleJobVoList);
		return "debug/quartzJobList";
	}
}
