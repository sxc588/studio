package com.github.support.controller.setting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.service.ScheduleJobService;
import com.github.support.service.ScheduleService;
import com.github.support.vo.ScheduleJobVo;

/**
 * 功能说明：系统配置项Action
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "setting/ScheduleJobController")
public class ScheduleJobController
{
	private static Logger log = LoggerFactory.getLogger(ScheduleJobController.class);

	@Autowired
	ScheduleService hostService;

	/** job service */
	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 任务页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputScheduleJob(ScheduleJobVo scheduleJobVo, ModelMap modelMap)
	{

		scheduleJobVo.setCronExpression("0 */1 * * * ?");

		if (scheduleJobVo.getScheduleJobId() != null)
		{
			ScheduleJobVo scheduleJob = scheduleJobService.get(scheduleJobVo.getScheduleJobId());
			scheduleJob.setKeywords(scheduleJobVo.getKeywords());
			modelMap.put("scheduleJobVo", scheduleJob);
		}

		return "schedulejob/input-schedule-job";
	}

	/**
	 * 删除任务
	 *
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteScheduleJob(Long scheduleJobId)
	{
		log.info(">>deleteScheduleJob");
		scheduleJobService.delete(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 运行一次
	 *
	 * @return
	 */
	@RequestMapping(value = "runonce", method = RequestMethod.GET)
	public String runOnceScheduleJob(Long scheduleJobId)
	{

		log.info(">>runOnceScheduleJob");
		scheduleJobService.runOnce(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 暂停
	 *
	 * @return
	 */
	@RequestMapping(value = "pause", method = RequestMethod.GET)
	public String pauseScheduleJob(Long scheduleJobId)
	{
		log.info(">>pauseScheduleJob");
		scheduleJobService.pauseJob(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 恢复
	 *
	 * @return
	 */
	@RequestMapping(value = "resume", method = RequestMethod.GET)
	public String resumeScheduleJob(Long scheduleJobId)
	{
		log.info(">>resumeScheduleJob");
		scheduleJobService.resumeJob(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 保存任务
	 *
	 * @param scheduleJobVo
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveScheduleJob(ScheduleJobVo scheduleJobVo)
	{

		scheduleJobVo.setJobName("jobName");
		// 测试用随便设个状态
		scheduleJobVo.setStatus("1");

		if (scheduleJobVo.getScheduleJobId() == null)
		{
			scheduleJobService.insert(scheduleJobVo);
		} 
		else if (StringUtils.equalsIgnoreCase(scheduleJobVo.getKeywords(), "delUpdate"))
		{
			// 直接拿keywords存一下，就不另外重新弄了
			scheduleJobService.delUpdate(scheduleJobVo);
		}
		else
		{
			scheduleJobService.update(scheduleJobVo);
		}

		return "redirect:list";
	}

	/**
	 * 任务列表页
	 *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listScheduleJob(ScheduleJobVo scheduleJobVo, ModelMap modelMap)
	{

		log.info(">>listScheduleJob");

		List<ScheduleJobVo> scheduleJobVoList = scheduleJobService.queryList(scheduleJobVo);
		modelMap.put("scheduleJobVoList", scheduleJobVoList);
		
		
		

	//	List<ScheduleJobVo> executingJobList = scheduleJobService.queryExecutingJobList();
	//	modelMap.put("executingJobList", executingJobList);
//		log.info("scheduleJobVoList" + scheduleJobVoList.size());
		
		//log.info("executingJobList" + executingJobList.size());
		return "schedulejob/list-schedule-job";
	}



}
