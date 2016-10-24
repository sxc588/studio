package com.itcast.workflow;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.util.CollectionUtils;



//部署对象和流程定义相关的表
//select * from act_re_deployment   	 #部署对象表
//select * from act_re_procdef			#流程定义对象表
//select * from act_ge_bytearray  	    #资源文件表
//select * from act_ge_property   		#主键生成策略表

//流程实例，启动，执行，控制执行
//select * from act_ru_execution 		# 正在执行的执行对象表
//select * from act_hi_actinst 		 		# 流程实例历史表
//select * from act_ru_task		 			# 正在执行的任务表(只有节点是userTask 该表中才存数据）
//select * from act_hi_taskinst		    # 任务表历史表(只有节点是userTask 该表中才存数据）
//select * from act_hi_actinst			    # 所有活动节点历史表

//流程变量
//select * from act_ru_variable 		# 正在执行的流程变量表
//select * from act_hi_varinst 		# 历史流程变量表


/**
 * 流程变量的作用:
 * 1. 用来传递业务参数（请假天数，起始时间，原因...）
 * 2. 指定业务完成任务（同意，拒绝，转审批）
 * 3.动态指定任务的办理人
 */

/**
 * 流程定义>> 流程启动 >> 流程执行>> 结束
 * 
 */
public class Process205SequenceTest
{

	// Logger logger = java.util.logging.Logger.getGlobal();

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	/**
	 * 1. 部署流程定义[InputStream]
	 * 
	 */
	@Test
	public void s01_deploymentProcess()
	{
		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		InputStream in1 = this.getClass().getResourceAsStream("/diagrams/secquenceFlow.bpmn");// 从classpath根目录下加载指定名称的文件
		InputStream in2 = this.getClass().getResourceAsStream("/diagrams/secquenceFlow.png"); // 从当前包等下架子指定的文件
		// InputStream in1 =
		// this.getClass().getClassLoader().getResourceAsStream("diagrams/HelloWorld.zip");//
		// 从classpath根目录下加载指定名称的文件
		// InputStream in2 =
		// this.getClass().getResourceAsStream("diagrams/HelloWorld.zip"); //
		// 从当前包等下架子指定的文件
		// InputStream in3 =
		// this.getClass().getResourceAsStream("/diagrams/HelloWorld.zip");//
		// 从classpath根目录下加载指定名称的文件

		String resourceName1 = "secquenceFlow.bpmn";
		String resourceName2 = "secquenceFlow.png";
		Deployment deployment = repositoryService.createDeployment() // 创建一个部署对象
				.name("流程定义-secquenceFlow") // 添加的部署名称
				.addInputStream(resourceName1, in1) // 资源名称名称，要去与文件名称一致
				.addInputStream(resourceName2, in2) // 资源名称名称，要去与文件名称一致
				.deploy();

		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 2. 启动流程实例
	 */
	@Test
	public void s02_startProcessInstance()
	{
		RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的实例对象相关的Service

		String processDefinitionKey = "secquenceFlow";
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefinitionKey);// 使用流程另一的key
																							// 启动实例，key
																							// 对应xxx.bpm
																							// 文件中的Id
		System.out.println("部署ID:" + pi.getId()); // 部署ID:93001
		System.out.println("流程实例ID:" + pi.getProcessDefinitionId()); // 流程实例ID:helloworld:16:92604
	}

	
	/**
	 * 3. 查询当前人的个人任务
	 */
	@Test
	public void s03_findMyPersonalInstance()
	{
		String assignee = "赵六";

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
	/**
	 * 3. 完成我个人任务
	 */
	@Test
	public void s04_completeMyPersonalTask()
	{
		TaskService taskService = processEngine.getTaskService(); // 与正在执行的任务管理相关的service

		String taskId = "94604";// 任务ID
		// 任务完成同时，设置环境变量来指定完成任务后的下一个连续，对应 xxxx.bpmn 文件中的 ${message=='不重要'}
		Map<String, Object> variables = new HashMap<String, Object>(); //<流程变量名称,流程变量值>
		variables.put("message", "重要");
		taskService.complete(taskId, variables);
		System.out.println("完成任务： " + taskId);
	}
	
	
	/**
	 * 3. 设置变量 【	任务执行】 
	 * select * from act_ru_variable 	
	 */
	@Test
	public void s03_setVariable()
	{
		  RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的实例对象相关的Service
		 String executionId= "94001";  // 任务ID
		 

		 // 设置流程执行变量，使用基本数据类型 ，与任务执行ID 绑定
		runtimeService.setVariable(executionId, "请假天数",3);
		runtimeService.setVariable(executionId, "请假日期", new Date());
		runtimeService.setVariable(executionId, "请假原因","我怀孕了");

		System.out.println("设置运行变量成功:" +executionId); //设置运行变量成功
	}

	/** 获取流程变量 */
	@Test
	public void s04_getVariable()
	{
		  TaskService taskService = processEngine.getTaskService(); // 与正在执行的实例对象相关的Service
			 String executionId= "94001";

		
			 
			 // 设置流程执行变量，使用基本数据类型 ，与任务执行ID 绑定
			Integer  days= (Integer) taskService.getVariable(executionId, "请假天数");
			Date date = (Date) taskService.getVariable(executionId, "请假日期");
			String reasonString = (String) taskService.getVariable(executionId, "请假原因");

			System.out.println("请假天数" +days); //设置运行变量成功
			System.out.println("请假日期" +date); //设置运行变量成功
			System.out.println("请假原因" +reasonString); //设置运行变量成功
	}

	/** 模拟设置和获取流程变量的场景 */
	@Test
	public void s05_setAndGetVariable()
	{
		RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的实例对象相关的Service
		TaskService taskService = processEngine.getTaskService(); // 与流程定义和部署对象相关的Service

		// 设置环境变量【运行】
		{
			// String executionId =null;
			// String variableName =null;
			// Object value =null;
			// runtimeService.setVariable(executionId, variableName, value);
			// runtimeService.setVariables(executionId, variables);
		}

		// 设置环境变量【任务】
		{
			// String task =null;
			// String variableName =null;
			// Object value =null;
			// taskService.setVariable(task, variableName, value);
		}
		
		// 设置环境变量【启动流程实例】
		{
//		String processDefinitionKey = "parocessVariable";
//		String variables =null;
//		runtimeService.startProcessInstanceById(processDefinitionKey, variables);
		}
		
		
		// 设置环境变量【完成任务】
		{
//			 String taskId =null;
//			 Map<String, Object> variables =null;
//			 taskService.complete(taskId, variables);
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
