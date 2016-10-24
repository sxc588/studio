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


//select * from act_re_deployment   	 #部署对象表
//select * from act_re_procdef			#流程定义对象表
//select * from act_ge_bytearray  	    #资源文件表
//select * from act_ge_property   		#主键生成策略表

/**
 * 流程定义>> 流程启动 >> 流程执行>> 结束
 * 
 */

public class Process02DefinitionTest
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
				.addClasspathResource("diagrams/HelloWorld.bpmn") // 从 classpath 资源中加载，一次只能加载一个文件
				.addClasspathResource("diagrams/HelloWorld.png")     // 从classpath的资源中加载，一次只能加载一个文件
				.deploy();

		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 1. 部署流程定义
	 */
	@Test
	public void deploymentProcess_Zip()
	{
		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		InputStream in = this.getClass().getClassLoader().getResourceAsStream("diagrams/HelloWorld.zip");// 从classpath根目录下加载指定名称的文件		
		ZipInputStream zipInputStream= new ZipInputStream(in);
		Deployment deployment = repositoryService.createDeployment() // 创建一个部署对象
				.name("流程定义") // 添加的部署名称
				.addZipInputStream(zipInputStream) // 指定一个zip 格式的文件完成部署
				.deploy();

		System.out.println("部署ID:" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}
	
	/**
	 * 查询流程定义
	 */
	@Test
	public void findProcessdefinition()
	{
		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery() // 创建一个部署对象
				.orderByProcessDefinitionVersion().asc().list(); // 添加的部署名称

		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有任务");
			return;
		}

		for (ProcessDefinition pd : list)
		{
			System.out.println("流程定义的ID:" + pd.getId()); // 流程定义的key +
			System.out.println("流程定义的名称:" + pd.getName()); // 流程定义的xxx.bpmn文件的name属性
			System.out.println("流程定义的Key:" + pd.getKey()); // 流程定义的xxx.bpmn文件的id属性
			System.out.println("流程定义的版本:" + pd.getVersion()); // 当流程的key
																// 相同，版本升级，默认是
																// 1;
			System.out.println("资源bpmn文件:" + pd.getResourceName()); // 流程定义的id
			System.out.println("资源png文件:" + pd.getDiagramResourceName()); // 流程定义的id
			System.out.println("部署对象ID:" + pd.getDeploymentId()); // 流程定义的id
			System.out.println("##########################################");
		}
	}

	/**
	 * 删除流程定义
	 */
	@Ignore
	@Test
	public void deleteProcessdefinition()
	{

		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		/**
		 *  不带级联删除
		 *  只能删除没有启动的流程，如果流程启动，会抛出异常。
		 */
		String deploymentId = "1701";
		repositoryService.deleteDeployment(deploymentId);// 创建一个部署对象

		
		/**
		 *  -级联删除
		 *  -不管流程是否启动，都能删除
		 *  -项目中，删除操作一般开放给系统管理员使用，所以一般使用级联删除比较多
		 */
		String deploymentId2 = "1701";
		repositoryService.deleteDeployment(deploymentId2,true);// 创建一个部署对象
		
		
		
	}
	
	@Ignore
	@Test
	public void deleteAllProcessdefinition()
	{

		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery() // 创建一个部署对象
				.orderByProcessDefinitionVersion().asc().list(); // 添加的部署名称

		if (CollectionUtils.isEmpty(list))
		{
			System.out.println("当前没有任务");
			return;
		}

		for (ProcessDefinition pd : list)
		{
			System.out.println("流程定义的ID:" + pd.getId()); // 流程定义的key +
			System.out.println("流程定义的名称:" + pd.getName()); // 流程定义的xxx.bpmn文件的name属性
			System.out.println("流程定义的Key:" + pd.getKey()); // 流程定义的xxx.bpmn文件的id属性
			System.out.println("流程定义的版本:" + pd.getVersion()); // 当流程的key
																// 相同，版本升级，默认是
																// 1;
			System.out.println("资源bpmn文件:" + pd.getResourceName()); // 流程定义的id
			System.out.println("资源png文件:" + pd.getDiagramResourceName()); // 流程定义的id
			System.out.println("部署对象ID:" + pd.getDeploymentId()); // 流程定义的id
			System.out.println("##########################################");
			
			try
			{
				repositoryService.deleteDeployment(pd.getDeploymentId(),true);// 创建一个部署对象
			} catch (Exception e)
			{
				// TODO: handle exception
			}
			
		}
		
	}
	
	/**
	 * 查看流程图
	 * @throws IOException 
	 */
	@Test
	public void viewProcessdefinition() throws IOException
	{

		RepositoryService repositoryService = processEngine.getRepositoryService(); // 与流程定义和部署对象相关的Service

		/**
		 *  不带级联删除
		 *  只能删除没有启动的流程，如果流程启动，会抛出异常。
		 */
		String deploymentId = "1701";
		String resourceName="diagrams/HelloWorld.png";
		
		// 将生成的图片存放到文件夹下
		InputStream inputStream= repositoryService.getResourceAsStream(deploymentId, resourceName);
		
    // 生成到D盘下
		
		File file = new File("d:/"+resourceName);
		FileUtils.copyInputStreamToFile(inputStream, file);
		
	}

}
