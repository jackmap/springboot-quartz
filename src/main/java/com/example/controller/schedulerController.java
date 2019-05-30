package com.example.controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @deprecated:
 * @author作者：mp 2019年5月30日,下午4:08:14
 */
public class schedulerController {
	@Autowired
    @Qualifier("sch")
    private Scheduler scheduler;
	/**
	 * @Description 用处：动态关闭任务
	 * @author作者：mp
	 * @date   2019年5月30日,下午4:11:44
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pause")
	@ResponseBody
	public String pause() throws Exception {
		System.out.println(scheduler);
		JobKey key = new JobKey("job1");
		scheduler.pauseJob(key);
		return "pause";
	}

	/**
	 * @Description 用处：动态启动任务
	 * @author作者：mp
	 * @date   2019年5月30日,下午4:11:51
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/start")
	@ResponseBody
	public String start() throws Exception {
		System.out.println(scheduler);
		JobKey key = new JobKey("job1");
		scheduler.resumeJob(key);
		return "start";

	}

	/**
	 * @Description 用处：动态修改任务执行的时间
	 * @author作者：mp
	 * @date   2019年5月30日,下午4:11:54
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/trigger")
	@ResponseBody
	public String trigger() throws Exception {
		// 获取任务
		JobKey jobKey = new JobKey("job1");
		// 获取 jobDetail
		JobDetail jobDetail = scheduler.getJobDetail(jobKey);
		// 生成 trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
				.build();
		// 删除任务，不删除会报错。报任务已存在
		scheduler.deleteJob(jobKey);
		// 启动任务
		scheduler.scheduleJob(jobDetail, trigger);
		return "trigger";
	}
}
