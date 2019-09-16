package com.github.support.controller.monitor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.dbaccess.dto.ScheduleJob;
import com.github.support.dbaccess.service.ScheduleJobServiceDb;
import com.github.support.quartz.service.ScheduleJobService;
import com.github.support.utils.HttpRequestUtil;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 定时任务控制器 version : 1.0
 */
@Controller
@RequestMapping(value = "/monitor/http")
public class HttpController {
	private static Logger log = LoggerFactory.getLogger(HttpController.class);

	int offset = 0;
	
	private int pageSize = 10;
	
	private String pabeBale = "?offset=" + offset + "&pageSize=" + pageSize;



	/** job service */
	@Autowired
	private ScheduleJobService scheduleJobService;
	@Autowired
	private ScheduleJobServiceDb service;

	/**
	 * 删除任务
	 *
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteScheduleJob(HttpServletRequest request, Long scheduleJobId) {
		pg(request);
		log.info(">>deleteScheduleJob");
		scheduleJobService.delete(scheduleJobId);
		return "monitor/list" + pabeBale;
	}

	/**
	 * 任务页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String inputScheduleJob(HttpServletRequest request, ScheduleJobVo scheduleJobVo, ModelMap modelMap) {

		scheduleJobVo.setCronExpression("0 */1 * * * ?");

		if (scheduleJobVo.getScheduleJobId() != null) {
			ScheduleJobVo scheduleJob = scheduleJobService.get(scheduleJobVo.getScheduleJobId());
			scheduleJob.setKeywords(scheduleJobVo.getKeywords());
			modelMap.put("scheduleJobVo", scheduleJob);
		}

		return "monitor/http/input";
	}

	/**
	 * 暂停
	 *
	 * @return
	 */
	@RequestMapping(value = "pause", method = RequestMethod.GET)
	public String pauseScheduleJob(HttpServletRequest request, Long scheduleJobId) {
		pg(request);
		log.info(">>pauseScheduleJob");
		scheduleJobService.pauseJob(scheduleJobId);
		return "monitor/list" + pabeBale;
	}

	private void pg(HttpServletRequest request) {
		int pageSize = HttpRequestUtil.getParameterInteger(request, "psize", 10);

		int offset = HttpRequestUtil.getParameterInteger(request, "offset", 0);

		HttpSession session = request.getSession();
		// 将数据存储到session中
		session.setAttribute("offset", offset);
		// 将数据存储到session中
		session.setAttribute("pageSize", pageSize);

		pabeBale = "?offset=" + offset + "&pageSize=" + pageSize;
	}

	/**
	 * 恢复
	 *
	 * @return
	 */
	@RequestMapping(value = "resume", method = RequestMethod.GET)
	public String resumeScheduleJob(HttpServletRequest request, Long scheduleJobId) {
		pg(request);
		log.info(">>resumeScheduleJob");
		scheduleJobService.resumeJob(scheduleJobId);
		return "monitor/list" + pabeBale;
	}

	/**
	 * 运行一次
	 *
	 * @return
	 */
	@RequestMapping(value = "runonce", method = RequestMethod.GET)
	public String runOnceScheduleJob(HttpServletRequest request, Long scheduleJobId) {
		pg(request);
		log.info(">>runOnceScheduleJob");
		scheduleJobService.runOnce(scheduleJobId);
		return "monitor/list" + pabeBale;
	}

	/**
	 * 保存任务
	 *
	 * @param scheduleJobVo
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveScheduleJob(HttpServletRequest request, ScheduleJobVo scheduleJobVo) {

		pg(request);

		scheduleJobVo.setJobName("jobName");
		// 测试用随便设个状态
		scheduleJobVo.setStatus("1");

		if (scheduleJobVo.getScheduleJobId() == null) {
			scheduleJobService.insert(scheduleJobVo);
		} else if (StringUtils.equalsIgnoreCase(scheduleJobVo.getKeywords(), "delUpdate")) {
			// 直接拿keywords存一下，就不另外重新弄了
			scheduleJobService.delUpdate(scheduleJobVo);
		} else {
			scheduleJobService.update(scheduleJobVo);
		}

		return "monitor/http/Slist" + pabeBale;
	}

	/**
	 * 任务列表页
	 *
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Map<String, Object> search(HttpServletRequest request) {

		System.err.println("DDDDDDDDDDDDDDDDDDD");
		pageSize = HttpRequestUtil.getParameterInteger(request, "psize", 10);
		offset = HttpRequestUtil.getParameterInteger(request, "offset", 0);

		HttpSession session = request.getSession();
		// 将数据存储到session中
		session.setAttribute("offset", offset);
		// 将数据存储到session中
		session.setAttribute("pageSize", pageSize);

		String pabeBale = "?offset=" + offset + "&pageSize=" + pageSize;

		log.info(">>listScheduleJob");

		List<ScheduleJob> scheduleJobVoList = scheduleJobService.getList(offset, pageSize);

		Map<String, Object> valus = new HashedMap<String, Object>();

		valus.put("pgIdex", 0);
		valus.put("pgSize", pageSize);
		valus.put("records", scheduleJobVoList.size());

		valus.put("data", scheduleJobVoList);

		return valus;
	}

	/**
	 * 任务列表页
	 *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

		pageSize = HttpRequestUtil.getParameterInteger(request, "psize", 10);
		offset = HttpRequestUtil.getParameterInteger(request, "offset", 0);

		HttpSession session = request.getSession();
		// 将数据存储到session中
		session.setAttribute("offset", offset);
		// 将数据存储到session中
		session.setAttribute("pageSize", pageSize);

		String pabeBale = "?offset=" + offset + "&pageSize=" + pageSize;

		log.info(">>listScheduleJob");

		List<ScheduleJob> scheduleJobVoList = scheduleJobService.getList(offset, pageSize);

		// modelMap.put("scheduleJobVoList", scheduleJobVoList);

		// List<ScheduleJobVo> executingJobList =
		// scheduleJobService.queryExecutingJobList();
		// modelMap.put("executingJobList", executingJobList);
		// log.info("scheduleJobVoList" + scheduleJobVoList.size());

//		log.info("executingJobList" + executingJobList.size());
		return "monitor/http/list";
	}

}
