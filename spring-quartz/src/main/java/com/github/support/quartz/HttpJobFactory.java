package com.github.support.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.github.support.model.ScheduleJob;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin
 * createTime : 2017.06.06
 * description : 同步任务工厂
 * version : 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HttpJobFactory extends QuartzJobBean {

    /* 日志对象 */
    private static final Logger LOG = LoggerFactory.getLogger(HttpJobFactory.class);

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOG.info("SyncJobFactory execute");
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        ScheduleJob scheduleJob = (ScheduleJob) mergedJobDataMap.get(ScheduleJobVo.JOB_PARAM_KEY);
        System.out.println("jobName:" + scheduleJob.getJobName() + "  " + scheduleJob);
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
