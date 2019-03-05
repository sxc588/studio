package com.github.support.controller.debug;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.quartz.service.ScheduleJobService;
import com.github.support.service.HostService;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin 
 * 
 * createTime : 2017.06.06 
 * 
 * description : 定时任务控制器 version : 1.0
 */
@Controller
@RequestMapping(value = "/debug/comqry")
public class DCommonQueryController
{
	/** job service */
	@Autowired
	private ScheduleJobService scheduleJobService;
	
	
	@Autowired
	HostService hostService;

	/**
	 * 任务页面
	 *
	 * @return
	 */
	@RequestMapping(value = "comquery-input", method = RequestMethod.GET)
	public String inputScheduleJob(ScheduleJobVo scheduleJobVo, ModelMap modelMap)
	{

		if (scheduleJobVo.getScheduleJobId() != null)
		{
			ScheduleJobVo scheduleJob = scheduleJobService.get(scheduleJobVo.getScheduleJobId());
			scheduleJob.setKeywords(scheduleJobVo.getKeywords());
			modelMap.put("scheduleJobVo", scheduleJob);
		}

		return "input";
	}

	/**
	 * 删除任务
	 *
	 * @return
	 */
	@RequestMapping(value = "comquery-delete", method = RequestMethod.GET)
	public String deleteScheduleJob(Long scheduleJobId)
	{

		scheduleJobService.delete(scheduleJobId);

		return "redirect:list";
	}

	/**
	 * 运行一次
	 *
	 * @return
	 */
	@RequestMapping(value = "comquery-run", method = RequestMethod.GET)
	public String runOnceScheduleJob(Long scheduleJobId)
	{

		scheduleJobService.runOnce(scheduleJobId);

		return "redirect:list";
	}

	/**
	 * 暂停
	 *
	 * @return
	 */
	@RequestMapping(value = "pause-schedule-job", method = RequestMethod.GET)
	public String pauseScheduleJob(Long scheduleJobId)
	{
		scheduleJobService.pauseJob(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 恢复
	 *
	 * @return
	 */
	@RequestMapping(value = "resume-schedule-job", method = RequestMethod.GET)
	public String resumeScheduleJob(Long scheduleJobId)
	{
		scheduleJobService.resumeJob(scheduleJobId);
		return "redirect:list";
	}

	/**
	 * 保存任务
	 *
	 * @param scheduleJobVo
	 * @return
	 */
	@RequestMapping("/export")
	public @ResponseBody String export(HttpServletResponse response)
	{
		response.setContentType("application/binary;charset=UTF-8");
		try
		{
			ScheduleJobVo scheduleJobVo = new ScheduleJobVo();
			List<ScheduleJobVo> scheduleJobVoList = scheduleJobService.queryList(scheduleJobVo);
			
			ServletOutputStream out = response.getOutputStream();
			String fileName = new String(
					("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
			String[] titles = { "任务名称", "任务别名", "任务分组", "触发器" , "任务状态", "时间表达式", "是否异步", "任务执行url", "时间表达式任务描述"};
			hostService.export(titles,scheduleJobVoList, out);
			return "success";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "导出信息失败";
		}
	}

	/**
	 * 任务列表页
	 *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listScheduleJob(ScheduleJobVo scheduleJobVo, ModelMap modelMap)
	{

		List<ScheduleJobVo> scheduleJobVoList = scheduleJobService.queryList(scheduleJobVo);
		modelMap.put("scheduleJobVoList", scheduleJobVoList);

//		List<ScheduleJobVo> executingJobList = scheduleJobService.queryExecutingJobList();
//		modelMap.put("executingJobList", executingJobList);

		return "comquery/list";
	}

	/**
	 * 保存任务
	 *
	 * @param scheduleJobVo
	 * @return
	 */
	@RequestMapping(value = "save-schedule-job", method = RequestMethod.POST)
	public String exportResult(ScheduleJobVo scheduleJobVo)
	{
	
		for (int i = 1000; i < 2000; i++)
		{
			scheduleJobVo.setJobName("jobName" + i);
			// 测试用随便设个状态
			scheduleJobVo.setStatus("1");
	
			if (scheduleJobVo.getScheduleJobId() == null)
			{
				scheduleJobService.insert(scheduleJobVo);
			} else if (StringUtils.equalsIgnoreCase(scheduleJobVo.getKeywords(), "delUpdate"))
			{
				// 直接拿keywords存一下，就不另外重新弄了
				scheduleJobService.delUpdate(scheduleJobVo);
			} else
			{
				scheduleJobService.update(scheduleJobVo);
			}
		}
		return "redirect:list";
	}

}
