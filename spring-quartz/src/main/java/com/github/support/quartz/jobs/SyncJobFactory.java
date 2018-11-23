package com.github.support.quartz.jobs;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.velocity.tools.config.Data;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.github.support.dbaccess.mapper.ScheduleJobMapper;
import com.github.support.dbaccess.service.ScheduleJobServiceDb;
import com.github.support.jms.ActiveMqProducerService;
import com.github.support.quartz.model.ScheduleJob;
import com.github.support.utils.PingUtils;
import com.github.support.utils.TelnetUtils;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 同步任务工厂 version : 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SyncJobFactory extends QuartzJobBean
{

	/* 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(SyncJobFactory.class);

	@Autowired
	private ScheduleJobServiceDb mapper;

    //队列消息生产者
    @Resource(name = "activeMqProducerService")
    private ActiveMqProducerService producer;

	
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	
	{	
		Date date = new Date();
		 producer.sendMessage(date.toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
//		 producer.sendMessage(new Data().toString());
		 

//		HttpStatus status = TelnetUtils.telnet("support.huawei.comA", 8080);
//		telnetUtils.telnet("www.sohu.com", 80);
		
//		System.err.println(status);
		//LOG.info("SyncJobFactory execute" + status);
		

	//	boolean pinStatus = PingUtils.ping("support.huawei.comA");
//		telnetUtils.telnet("www.sohu.com", 80);
		
	//	System.err.println(pinStatus);
		
		
		
//		
//		LOG.info("SyncJobFactory execute");
//		JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
//		ScheduleJob scheduleJob = (ScheduleJob) mergedJobDataMap.get(ScheduleJobVo.JOB_PARAM_KEY);
//
//		List<com.github.support.dbaccess.dto.ScheduleJob> tt = mapper.getList(1, 100);
//
//		LOG.info("SyncJobFactory execute" + CollectionUtils.size(tt));

		// System.out.println("jobName:" + scheduleJob.getJobName() + " " +
		// scheduleJob);
		// String url = scheduleJob.getUrl();
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// HttpGet httpGet = new HttpGet(url);
		// CloseableHttpResponse response;
		// try {
		// response = httpclient.execute(httpGet);
		// System.out.println(response.getStatusLine());
		// HttpEntity entity = response.getEntity();
		// EntityUtils.consume(entity);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
