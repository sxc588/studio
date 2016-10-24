package com.itcast.workflow;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.bpmn.data.Data;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.CollectionUtils;


// 部署对象和流程定义相关的表
//select * from act_re_deployment   	 #部署对象表
//select * from act_re_procdef			#流程定义对象表
//select * from act_ge_bytearray  	    #资源文件表
//select * from act_ge_property   		#主键生成策略表

//流程实例，启动，执行，控制执行
// select * from act_ru_execution 		# 正在执行的执行对象表
// select * from act_hi_actinst 		 		# 流程实例历史表
// select * from act_ru_task		 			# 正在执行的任务表(只有节点是userTask 该表中才存数据）
// select * from act_hi_taskinst		    # 任务表历史表(只有节点是userTask 该表中才存数据）
// select * from act_hi_actinst			    # 所有活动节点历史表

//流程变量
//select * from act_ru_variable 		# 正在执行的流程变量表

/**
 * 流程定义>> 流程启动 >> 流程执行>> 结束
 * 
 */
public class Process03InstanceTest
{

	// Logger logger = java.util.logging.Logger.getGlobal();

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	/**
	 * 1. 部署流程定义
	 */
	@Test
	public void deploymentProcess()
	{
		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		Deployment deployment = repositoryService.createDeployment() // 创建一个部署对象
				.name("流程定义") // 添加的部署名称
				.addClasspathResource("diagrams/HelloWorld.bpmn") // 从 classpath
																	// 资源中加载，一次只能加载一个文件
				.addClasspathResource("diagrams/HelloWorld.png") // 从classpath的资源中加载，一次只能加载一个文件
				.deploy();

		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 2. 启动流程
	 */
	@Test
	public void startProcessInstance()
	{
		RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的实例对象相关的Service

		String processDefinitionKey = "helloworld";
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefinitionKey);// 使用流程另一的key
																							// 启动实例，key
																							// 对应
																							// helloworld.bpm
																							// 文件中的Id

		System.out.println("部署ID:" + pi.getId()); // 部署ID:93001
		System.out.println("流程实例ID:" + pi.getProcessDefinitionId()); // 流程实例ID:helloworld:16:92604
	}

	/**
	 * 3. 查询当前人的个人任务
	 */
	@Test
	public void findMyPersonalInstance()
	{
		String assignee = "李四";

		TaskService taskService = processEngine.getTaskService(); // 与正在执行的任务管理相关的service

		// 条件>>排序>>结果集
		List<Task> list = taskService.createTaskQuery().taskAssignee(assignee).list();

		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有任务");
			return;
		}

		for (Task task : list)
		{
			System.out.println("任务ID:" + task.getId()); // 流程实例ID
			System.out.println("任务名称:" + task.getName()); // 流程定义的id
			System.out.println("创建时间:" + task.getCreateTime()); // 流程定义的id
			System.out.println("任务办理人:" + task.getCreateTime()); // 流程定义的id
			System.out.println("流程实例:" + task.getProcessInstanceId()); // 流程定义的id
			System.out.println("执行对象ID:" + task.getExecutionId()); // 流程定义的id
			System.out.println("流程定义ID:" + task.getProcessDefinitionId()); // 流程定义的id
			System.out.println("##########################################");
		}
	}

	/*** 办理 完成我的一项任务 */
	@Test
	public void findProcessdefinition()
	{
		TaskService taskService = processEngine.getTaskService(); // 与流程定义和部署对象相关的Service

		String taskId = "93311";
		taskService.complete(taskId);// 创建一个部署对象
		System.out.println("完成任务");
	}

	/*** 查询流程状态（判断正在执行，还是结束） */
	@Test
	public void isProcessEnd()
	{
		RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的实例对象相关的Service

		String processInstanceId = "92801";
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()// 使用流程另一的key
				.processInstanceId(processInstanceId).singleResult();

		if (pi == null)
		{
			System.out.println("部署已结束:" + processInstanceId);
		} else
		{
			System.out.println("部署未结束:" + processInstanceId);
		}

	}

	/***
	 * 查询历史任务 select * act_hi_taskinst
	 */
	@Test
	public void findHistoryTask()
	{
		HistoryService historyService = processEngine.getHistoryService(); // 与历史数据相关的Service
		String taskAssignee = "张三";
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()// 历史实例查询
				.taskAssignee(taskAssignee).list();

		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有历史流程");
			return;
		}

		for (HistoricTaskInstance hist : list)
		{
			System.out.println("任务ID:" + hist.getId()); // 流程定义的key +
			System.out.println("任务名称:" + hist.getName()); // 流程定义的xxx.bpmn文件的name属性
			System.out.println("流程实例ID:" + hist.getProcessInstanceId()); // 流程定义的xxx.bpmn文件的id属性
			System.out.println("任务开始时间:" + hist.getStartTime());
			System.out.println("任务持续时间:" + hist.getDurationInMillis());

			System.out.println("##########################################");
		}
	}

	/**
	 * 查询历史实例 select * act_hi_actinst
	 */
	@Test
	public void findHistoryInstance()
	{
		HistoryService historyService = processEngine.getHistoryService(); // 与历史数据相关的Service

		String processDefinitionId = "93605 ";
		HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()// 历史实例查询
				.processInstanceId(processDefinitionId)// 流程实例ID 查询
				.singleResult();

		if (null == hpi)
		{
			System.out.println("历史流程不存在" + processDefinitionId);
			return;
		}
		System.out.println("历史流程ID:" + hpi.getId()); // 流程定义的key +
		System.out.println("历史流程名称:" + hpi.getProcessDefinitionId()); // 流程定义的xxx.bpmn文件的name属性
		System.out.println("历史流程开始时间:" + hpi.getStartTime());
		System.out.println("历史流程持续时间:" + hpi.getDurationInMillis());

		System.out.println("##########################################");

	}
}
