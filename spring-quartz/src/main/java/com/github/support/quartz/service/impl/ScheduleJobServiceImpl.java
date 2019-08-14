package com.github.support.quartz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.activemq.store.kahadb.disk.index.Index;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dexcoder.commons.bean.BeanConverter;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.build.Criteria;
import com.github.support.dbaccess.dto.MonScheduleJob;
import com.github.support.dbaccess.service.MonScheduleJobService;
import com.github.support.dbaccess.service.ScheduleJobServiceDb;
import com.github.support.quartz.ScheduleUtils;
import com.github.support.quartz.model.ScheduleJob;
import com.github.support.quartz.service.ScheduleJobService;
import com.github.support.utils.CodeCCUtil;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 定时任务服务实现 version :
 * 1.0
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService
{

	/** 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);

	/** 调度工厂Bean */
	@Autowired(required = false)
	private Scheduler scheduler;

	/** 通用dao */
	@Autowired
	private JdbcDao jdbcDao;

	@Autowired
	private ScheduleJobServiceDb scheduleJobServiceDb;

	@Autowired
	private MonScheduleJobService scheduleJobService;

	public void init() throws SchedulerException
	{

		// https://blog.csdn.net/u010558660/article/details/51500986
		JobKey jobKey = JobKey.jobKey("customJob_name", "customJob_group");
		// clusterScheduler = new StdSchedulerFactory().getScheduler();
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);// xml中配置了
		TriggerKey triggerKey = TriggerKey.triggerKey("customTrigger_name", "customTrigger_group");
		boolean isExists = scheduler.checkExists(triggerKey);
		if (isExists)
		{
			scheduler.unscheduleJob(triggerKey);// 停止调度当前Job任务
		}
		String cron = (10 % 50) + " 0/1 * ? * *";// Cron表达式:每隔一分钟执行一次
		Assert.isTrue(CronExpression.isValidExpression(cron), "invalid cron = " + cron);
		Date startDate = new Date(System.currentTimeMillis() + 1 * 60 * 1000);// 开始执行时间
		Map<String, Object> dataMap = new HashMap<String, Object>();// 参数
		dataMap.put("params", "taiyang");

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobDetail)
				.withSchedule(CronScheduleBuilder.cronSchedule(cron)).startAt(startDate).build();
		trigger.getJobDataMap().putAll(dataMap);// 传参
		scheduler.scheduleJob(trigger);
	}

	public void initScheduleJob()
	{
		List<ScheduleJob> scheduleJobList = jdbcDao.queryList(Criteria.select(ScheduleJob.class));
		if (CollectionUtils.isEmpty(scheduleJobList))
		{
			return;
		}

		try
		{
			scheduler.clear();
			LOG.info("scheduler.clear()....");

		} catch (SchedulerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOG.info("scheduler.loading....");

		int index = 1;
		for (ScheduleJob scheduleJob : scheduleJobList)
		{
			CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobName(),
					scheduleJob.getJobGroup());

			if (cronTrigger == null)
			{
				// 不存在，创建一个
				ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
				LOG.info("scheduler.loaded createScheduleJob" + scheduleJob.getJobName() + " >>" + index++);
			} else
			{
				// 已存在，那么更新相应的定时设置
				ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
				LOG.info("scheduler.loaded updateScheduleJob" + scheduleJob.getJobName() + " >>" + index++);
			}
		}

	}

	public Long insert(ScheduleJobVo scheduleJobVo)
	{
		ScheduleJob scheduleJob = scheduleJobVo.getTargetObject(ScheduleJob.class);
		ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
		return jdbcDao.insert(scheduleJob);
	}

	public void update(ScheduleJobVo scheduleJobVo)
	{
		ScheduleJob scheduleJob = scheduleJobVo.getTargetObject(ScheduleJob.class);
		ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
		jdbcDao.update(scheduleJob);
	}

	public void delUpdate(ScheduleJobVo scheduleJobVo, Class<? extends Job> jobClass)
	{
		ScheduleJob scheduleJob = scheduleJobVo.getTargetObject(ScheduleJob.class);
		// 先删除
		ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 再创建
		ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
		// 数据库直接更新即可
		jdbcDao.update(scheduleJob);
	}

	public void delete(Long scheduleJobId)
	{

		ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
		// 删除运行的任务
		ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 删除数据
		jdbcDao.delete(ScheduleJob.class, scheduleJobId);
	}

	public void runOnce(Long scheduleJobId)
	{
		ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
		ScheduleUtils.runOnce(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
	}

	public void pauseJob(Long scheduleJobId)
	{
		ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
		ScheduleUtils.pauseJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 演示数据库就不更新了
	}

	public void resumeJob(Long scheduleJobId)
	{
		ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
		ScheduleUtils.resumeJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
		// 演示数据库就不更新了
	}

	public ScheduleJobVo get(Long scheduleJobId)
	{
		ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
		return scheduleJob.getTargetObject(ScheduleJobVo.class);
	}

	public List<ScheduleJobVo> queryList(ScheduleJobVo scheduleJobVo)
	{

		List<MonScheduleJob> aaa = scheduleJobService.getList(1, 10);

		// List<ScheduleJob> scheduleJobs =
		// jdbcDao.queryList(scheduleJobVo.getTargetObject(ScheduleJob.class));

		List<ScheduleJobVo> scheduleJobVoList = BeanConverter.convert(ScheduleJobVo.class, aaa);
		try
		{
			for (ScheduleJobVo vo : scheduleJobVoList)
			{

				JobKey jobKey = ScheduleUtils.getJobKey(vo.getJobName(), vo.getJobGroup());
				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
				if (CollectionUtils.isEmpty(triggers))
				{
					continue;
				}

				// 这里一个任务可以有多个触发器， 但是我们一个任务对应一个触发器，所以只取第一个即可，清晰明了
				Trigger trigger = triggers.iterator().next();
				vo.setJobTrigger(trigger.getKey().getName());

				// vo.setTrigger(trigger);

				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				vo.setStatus(triggerState.name());

				if (trigger instanceof CronTrigger)
				{
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					vo.setCronExpression(cronExpression);
					vo.setNextFireTime(cronTrigger.getNextFireTime());
					vo.setPreviousFireTime(cronTrigger.getPreviousFireTime());
				}
			}
		} catch (SchedulerException e)
		{
			// 演示用，就不处理了
		}
		return scheduleJobVoList;
	}

	/**
	 * 获取运行中的job列表
	 * 
	 * @return
	 */
	public List<ScheduleJobVo> queryExecutingJobList()
	{

		// 存放结果集
		List<ScheduleJobVo> jobList = new ArrayList<ScheduleJobVo>();
		try
		{
			List<String> groupNames = scheduler.getJobGroupNames();

			LOG.info("groupNames:" + groupNames);

			// 获取scheduler中的JobGroupName
			for (String group : groupNames)
			{

				Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.<JobKey>groupEquals(group));

				//LOG.info(jobKeys.size() + "jobKeys:" + jobKeys);
				// 获取JobKey 循环遍历JobKey
				for (JobKey jobKey : jobKeys)
				{
					try
					{
						JobDetail jobDetail = scheduler.getJobDetail(jobKey);
						JobDataMap jobDataMap = jobDetail.getJobDataMap();
						ScheduleJob scheduleJob = (ScheduleJob) jobDataMap.get(ScheduleJobVo.JOB_PARAM_KEY);
						ScheduleJobVo scheduleJobVo = new ScheduleJobVo();
						BeanConverter.convert(scheduleJobVo, scheduleJob);
						List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
						Trigger trigger = triggers.iterator().next();
						Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
						scheduleJobVo.setJobTrigger(trigger.getKey().getName());
						scheduleJobVo.setStatus(triggerState.name());
						if (trigger instanceof CronTrigger)
						{
							CronTrigger cronTrigger = (CronTrigger) trigger;
							String cronExpression = cronTrigger.getCronExpression();
							scheduleJobVo.setCronExpression(cronExpression);
							
							Date nextFireTime = trigger.getNextFireTime();
							scheduleJobVo.setNextFireTime(nextFireTime);
						}
						// 获取正常运行的任务列表
						// if (triggerState.name().equals("NORMAL"))
						{
							jobList.add(scheduleJobVo);
						}
					} catch (SchedulerException e)
					{

					}
				}

			}
		} catch (SchedulerException e)
		{

		}

		/** 非集群环境获取正在执行的任务列表 */
		/**
		 * List<JobExecutionContext> executingJobs =
		 * scheduler.getCurrentlyExecutingJobs(); List<ScheduleJobVo> jobList =
		 * new ArrayList<ScheduleJobVo>(executingJobs.size()); for
		 * (JobExecutionContext executingJob : executingJobs) { ScheduleJobVo
		 * job = new ScheduleJobVo(); JobDetail jobDetail =
		 * executingJob.getJobDetail(); JobKey jobKey = jobDetail.getKey();
		 * Trigger trigger = executingJob.getTrigger();
		 * job.setJobName(jobKey.getName()); job.setJobGroup(jobKey.getGroup());
		 * job.setJobTrigger(trigger.getKey().getName()); Trigger.TriggerState
		 * triggerState = scheduler.getTriggerState(trigger.getKey());
		 * job.setStatus(triggerState.name()); if (trigger instanceof
		 * CronTrigger) { CronTrigger cronTrigger = (CronTrigger) trigger;
		 * String cronExpression = cronTrigger.getCronExpression();
		 * job.setCronExpression(cronExpression); } jobList.add(job); }
		 */


		return jobList;

	}

	@Override
	public JobDetail getJobDetails(String name, String group)
	{
		JobKey jobKey = JobKey.jobKey(name, group);

		try
		{
			JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			return jobDetail;

		} catch (SchedulerException e)
		{
			CodeCCUtil.LogException(LOG, "SchedulerException", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<com.github.support.dbaccess.dto.ScheduleJob> getList(int offset, int pagesize)
	{
		List<com.github.support.dbaccess.dto.ScheduleJob> abc = scheduleJobServiceDb.getList(offset, pagesize);

		// 存放结果集
		List<ScheduleJobVo> jobList = new ArrayList<ScheduleJobVo>();

		// 获取scheduler中的JobGroupName

		// 获取JobKey 循环遍历JobKey
		for (com.github.support.dbaccess.dto.ScheduleJob job : abc)
		{
			JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());

			try
			{
				JobDetail jobDetail = scheduler.getJobDetail(jobKey);
				if (jobDetail == null)
				continue;

				JobDataMap jobDataMap = jobDetail.getJobDataMap();
				ScheduleJob scheduleJob = (ScheduleJob) jobDataMap.get(ScheduleJobVo.JOB_PARAM_KEY);

				// ScheduleJobVo scheduleJobVo = new ScheduleJobVo();

				/// BeanConverter.convert(scheduleJobVo, scheduleJob);

				List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
				Trigger trigger = triggers.iterator().next();
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());

				job.setJobTrigger(trigger.getKey().getName());
				job.setStatus(triggerState.name());

				// scheduleJobVo.setJobTrigger(trigger.getKey().getName());
				// scheduleJobVo.setStatus(triggerState.name());

				if (trigger instanceof CronTrigger)
				{
					CronTrigger cronTrigger = (CronTrigger) trigger;
					String cronExpression = cronTrigger.getCronExpression();
					// scheduleJobVo.setCronExpression(cronExpression);
					job.setCronExpression(cronExpression);
					job.setNextFireTime(trigger.getNextFireTime());
					job.setPreviousFireTime(trigger.getPreviousFireTime());
				}
				// 获取正常运行的任务列表
				// if (triggerState.name().equals("NORMAL"))
				{
					// jobList.add(scheduleJobVo);
				}
			} catch (SchedulerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return abc;
	}

	@Override
	public void delUpdate(ScheduleJobVo scheduleJobVo)
	{
		// TODO Auto-generated method stub

	}

	public void cleanJobs()
	{
		// TODO Auto-generated method stub
		try
		{
			LOG.info("scheduler.clear()....");
			scheduler.clear();

			LOG.info("scheduler.clear()....Done.");
		} catch (SchedulerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
