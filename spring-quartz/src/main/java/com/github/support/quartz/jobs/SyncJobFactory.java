package com.github.support.quartz.jobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.github.support.dbaccess.service.ScheduleJobServiceDb;
import com.github.support.jms.ActiveMqProducerService;
import com.github.support.quartz.matrix.MatrixInteger;

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

    private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
   
    @Autowired
   private MatrixInteger abcd;
	
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	
	{	
		Date date = new Date();
		String msg =  sdf.format(date);
		producer.sendMessage(msg);
	    abcd.inc("SyncJobFactory");
	    
	    
	    
	    
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
