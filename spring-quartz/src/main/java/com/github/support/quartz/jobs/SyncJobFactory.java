package com.github.support.quartz.jobs;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.github.support.dbaccess.mapper.ScheduleJobMapper;
import com.github.support.dbaccess.service.ScheduleJobServiceDb;
import com.github.support.quartz.model.ScheduleJob;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin
 * createTime : 2017.06.06
 * description : 同步任务工厂
 * version : 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SyncJobFactory extends QuartzJobBean {

    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(SyncJobFactory.class);

    
    @Autowired
    private ScheduleJobServiceDb mapper;
    
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOG.info("SyncJobFactory execute");
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        ScheduleJob scheduleJob = (ScheduleJob) mergedJobDataMap.get(ScheduleJobVo.JOB_PARAM_KEY);
        
     
		List<com.github.support.dbaccess.dto.ScheduleJob> tt = mapper.getList(1,100);
		
		   LOG.info("SyncJobFactory execute" + CollectionUtils.size(tt));
		
//       System.out.println("jobName:" + scheduleJob.getJobName() + "  " + scheduleJob);
//        String url = scheduleJob.getUrl();
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response;
//        try {
//            response = httpclient.execute(httpGet);
//            System.out.println(response.getStatusLine());
//            HttpEntity entity = response.getEntity();
//            EntityUtils.consume(entity);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
