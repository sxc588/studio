package com.github.support.cbbservice.quartz;

import java.io.File;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.support.cbb.ehcache.quartz.QuartzManager;
import com.github.support.cbb.ehcache.quartz.job.QuartzJob;
import com.github.support.cbb.ehcache.quartz.job.QuartzJobCheckResult;
import com.github.support.cbb.ehcache.quartz.job.QuartzJobMigration;
import com.github.support.cbb.ehcache.quartz.job.QuartzJobUpload;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-quartz.xml")
public class QuartzManagerTest
{

	@Test
	public void testDynamicModify() throws Exception
	{
			String job_name = "动态任务调度";
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(job_name, QuartzJob.class, "0/1 * * * * ?");

			Thread.sleep(2000);
			System.out.println("【修改时间】开始(每2秒输出一次)...");
			QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?");
			Thread.sleep(2000);
			System.out.println("【移除定时】开始...");
			QuartzManager.removeJob(job_name);
			System.out.println("【移除定时】成功");

			System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
			QuartzManager.addJob(job_name, QuartzJob.class, "*/10 * * * * ?");
			Thread.sleep(15000);
			QuartzManager.startJobs();
			QuartzManager.shutdownJobs();

			System.out.println("【移除定时】开始..." + File.separator);
			QuartzManager.removeJob(job_name);
			System.out.println("【移除定时】成功");
	}
	
	@Test
	public void testVirusScan() throws Exception
	{
			String job_name1 = "VirusScan_UploadFile";
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(job_name1, QuartzJobUpload.class, "0/1 * * * * ?");

			String job_name2 = "VirusScan_checkResount";
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(job_name2, QuartzJobCheckResult.class, "0/1 * * * * ?");
			
			String job_name3 = "Migration_checkResount";
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(job_name3, QuartzJobMigration.class, "0/1 * * * * ?");
			
			
			Thread.sleep(15000);
	}

	@Test
	public void testDynamicModify2() throws Exception
	{
			String job_name = "动态任务调度";
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(job_name, QuartzJob.class, "0/1 * * * * ?");
			Thread.sleep(15000);
	}

}
