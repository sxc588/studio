package com.itcast.workflow;

import java.util.List;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.util.CollectionUtils;



public class Process01HelloWorld
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
				.name("helloworld入门程序") // 添加的部署名称
				.addClasspathResource("diagrams/HelloWorld.bpmn") // 从 classpass 的资源中加载，一次只能加载一个文件
				.addClasspathResource("diagrams/HelloWorld.png") // 从classpass的资源中加载，一次只能加载一个文件
				.deploy();

		System.out.println("部署ID:" +deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 2. 启动流程实例
	 */
	@Test
	public void startProcessInstance()
	{

		RuntimeService runtimeService = processEngine.getRuntimeService(); // 与正在执行的流程实例和执行对象相关的Service

		ProcessInstance  pi =runtimeService.startProcessInstanceByKey("helloworld"); // 使用流程定义的key 启动流程实例 --xxx.bpmn -->id
		System.out.println("流程实例ID:" + pi.getId()); // 流程实例ID
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); //流程定义的id
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
		List<Task> list= taskService.createTaskQuery().taskAssignee(assignee).list();
		
		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有任务" );
			return ;
		}
		
		for (Task  task :list)
		{
			System.out.println("任务ID:" + task.getId()); // 流程实例ID
			System.out.println("任务名称:" + task.getName()); //流程定义的id
			System.out.println("创建时间:" +  task.getCreateTime()); //流程定义的id
			System.out.println("任务办理人:" +  task.getCreateTime()); //流程定义的id
			System.out.println("流程实例:" +  task.getProcessInstanceId()); //流程定义的id
			System.out.println("执行对象ID:" +  task.getExecutionId()); //流程定义的id
			System.out.println("流程定义ID:" +  task.getProcessDefinitionId()); //流程定义的id
			System.out.println("##########################################" );
		}
	}
	
	/**
	 * 3. 完成我个人任务
	 */
	@Test
	public void completeMyPersonalTask()
	{
		String assignee = "张三";

		TaskService taskService = processEngine.getTaskService(); // 与正在执行的任务管理相关的service

		List<Task> list= taskService.createTaskQuery().taskAssignee(assignee).list();
		
		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有任务" );
			return ;
		}
		
		for (Task  task :list)
		{
			System.out.println("任务ID:" + task.getId()); // 流程实例ID
			System.out.println("任务名称:" + task.getName()); //流程定义的id
			System.out.println("创建时间:" +  task.getCreateTime()); //流程定义的id
			System.out.println("任务办理人:" +  task.getCreateTime()); //流程定义的id
			System.out.println("流程实例:" +  task.getProcessInstanceId()); //流程定义的id
			System.out.println("执行对象ID:" +  task.getExecutionId()); //流程定义的id
			System.out.println("流程定义ID:" +  task.getProcessDefinitionId()); //流程定义的id
			System.out.println("##########################################" );
			
			taskService.complete(task.getId());
			break;
		}

	}
	
}
