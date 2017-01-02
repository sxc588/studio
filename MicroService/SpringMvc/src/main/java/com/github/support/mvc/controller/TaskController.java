package com.github.support.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.github.support.entitement.mybatis.model.MigrationTask;
import com.github.support.mvc.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController
{
	
	
	private static Logger  Logger  = org.apache.log4j.Logger.getLogger(TaskController.class);

//	@Autowired
	private TaskService taskService;

	@RequestMapping("/list")
	public ModelAndView list()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("taskList", taskService.getAll());
		mav.setViewName("task/list");
		return mav;
	}

	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value = "id", required = false) String id)
	{
		ModelAndView mav = new ModelAndView();
		if (id != null)
		{
			mav.addObject("taskList", taskService.get(id));
			mav.setViewName("task/update");
		}
		else
		{
			mav.setViewName("task/add");
		}
		return mav;
	}
	
	@RequestMapping("/save")
	public String save(MigrationTask task)
	{
		Logger.info("save==>" + task);
		taskService.save(task);
		return "redirect:/task/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete (@RequestParam(value = "id") String id)
	{
		taskService.delete(id);
		return "redirect:/task/list";
	}
}
