package com.github.support.quartz.jobs;

import java.util.ArrayList;
import java.util.List;

import com.github.support.vo.ScheduleJobVo;

public class TaskFactory {
	List<ScheduleJobVo> getTaskHttp() {
		return new ArrayList<ScheduleJobVo>();
	}

	List<ScheduleJobVo> getTaskNginx() {
		return new ArrayList<ScheduleJobVo>();
	}

	List<ScheduleJobVo> getTaskSLA() {
		return new ArrayList<ScheduleJobVo>();
	}

	List<ScheduleJobVo> getTaskTimer() {
		return new ArrayList<ScheduleJobVo>();
	}
}
