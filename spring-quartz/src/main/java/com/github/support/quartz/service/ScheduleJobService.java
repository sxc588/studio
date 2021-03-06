package com.github.support.quartz.service;

import java.util.List;

import org.quartz.JobDetail;

import com.github.support.dbaccess.dto.ScheduleJob;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 定时任务服务 version : 1.0
 */
public interface ScheduleJobService {

	/**
	 * 删除
	 * 
	 * @param scheduleJobId
	 */
	public void delete(Long scheduleJobId);

	/**
	 * 删除重新创建方式
	 * 
	 * @param scheduleJobVo
	 */
	public void delUpdate(ScheduleJobVo scheduleJobVo);

	/**
	 * 获取任务对象
	 * 
	 * @param scheduleJobId
	 * @return
	 */
	public ScheduleJobVo get(Long scheduleJobId);

	/**
	 * 获取正在执行的任务
	 *
	 * @return
	 */
	public JobDetail getJobDetails(String name, String group);

	public List<ScheduleJob> getList(int offset, int pagesize);

	/**
	 * 初始化定时任务
	 */
	public void initScheduleJob();

	/**
	 * 新增
	 * 
	 * @param scheduleJobVo
	 * @return
	 */
	public Long insert(ScheduleJobVo scheduleJobVo);

	/**
	 * 暂停任务
	 *
	 * @param scheduleJobId the schedule job id
	 * @return
	 */
	public void pauseJob(Long scheduleJobId);

	/**
	 * 获取运行中的任务列表
	 *
	 * @return
	 */
	public List<ScheduleJobVo> queryExecutingJobList();

	/**
	 * 查询任务列表
	 * 
	 * @param scheduleJobVo
	 * @return
	 */
	public List<ScheduleJobVo> queryList(ScheduleJobVo scheduleJobVo);

	/**
	 * 恢复任务
	 *
	 * @param scheduleJobId the schedule job id
	 * @return
	 */
	public void resumeJob(Long scheduleJobId);

	/**
	 * 运行一次任务
	 *
	 * @param scheduleJobId the schedule job id
	 * @return
	 */
	public void runOnce(Long scheduleJobId);

	/**
	 * 直接修改 只能修改运行的时间，参数、同异步等无法修改
	 * 
	 * @param scheduleJobVo
	 */
	public void update(ScheduleJobVo scheduleJobVo);

}
