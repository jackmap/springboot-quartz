package com.example.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.task.NewTask;

//@Configuration
//@Component
//public class TaskRunner implements CommandLineRunner {
//
//	public void run(String... args) throws Exception {
//		System.out.println(">>>>>>>>>>>>>>>任务服务启动执行 ...<<<<<<<<<<<<<");
//		// 创建一个jobDetail的实例，将该实例与HelloJob Class绑定
//		// Job – 任务
//		// JobDetail – 任务描述
//		JobDetail job_order = JobBuilder.newJob(NewTask.class).withIdentity("order").build();
//		// Trigger – 触发器
//		SimpleTrigger trigger_order = TriggerBuilder.newTrigger().withIdentity("order").startNow()
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
//
//		// 创建schedule实例 Scheduler – 核心调度器
//		StdSchedulerFactory factory = new StdSchedulerFactory();
//		Scheduler scheduler = factory.getScheduler();
//		scheduler.start();
//		scheduler.scheduleJob(job_order, trigger_order);
//	}
//}
