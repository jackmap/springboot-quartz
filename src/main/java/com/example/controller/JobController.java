package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.JobService;

@RestController
@RequestMapping("/quartztest")
public class JobController {
	@Autowired
	private JobService jobService;

	/**
	 * 创建cron任务
	 * http://localhost:8080/quartztest/cron?jobName=test&jobGroup=test
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	// @RequestMapping(value = "/cron",method = RequestMethod.POST)
	@GetMapping("/cron")
	@ResponseBody
	public String startCronJob(@RequestParam("jobName") String jobName, 
			@RequestParam("jobGroup") String jobGroup) {
		jobService.addCronJob(jobName, jobGroup);
		return "create cron task success";
	}

	/**
	 * 创建异步任务
	 * http://localhost:8080/quartztest/async?jobName=test&jobGroup=test
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
//	@RequestMapping(value = "/async", method = RequestMethod.POST)
	@GetMapping("/async")
	@ResponseBody
	public String startAsyncJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		jobService.addAsyncJob(jobName, jobGroup);
		System.out.print("开始任务：jobName"+jobName+"  jobGroup"+jobGroup);
		return "create async task success";
	}

	/**
	 * 暂停任务
	 * http://localhost:8080/quartztest/pause?jobName=test&jobGroup=test
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
//	@RequestMapping(value = "/pause", method = RequestMethod.POST)
	@GetMapping("/pause")
	@ResponseBody
	public String pauseJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		jobService.pauseJob(jobName, jobGroup);
		System.out.print("暂停任务：jobName"+jobName+"  jobGroup"+jobGroup);
		return "pause job success  ";
	}

	/**
	 * 恢复任务
	 * http://localhost:8080/quartztest/resume?jobName=test&jobGroup=test
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	//@RequestMapping(value = "/resume", method = RequestMethod.POST)
	@GetMapping("/resume")
	@ResponseBody
	public String resumeJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		jobService.resumeJob(jobName, jobGroup);
		System.out.print("暂停任务：jobName"+jobName+"  jobGroup"+jobGroup);
		return "resume job success";
	}

	/**
	 * 删除务
	 * http://localhost:8080/quartztest/delete?jobName=test&jobGroup=test
	 * @param jobName
	 * @param jobGroup
	 * @return
	 */
	//@RequestMapping(value = "/delete", method = RequestMethod.PUT)
	@GetMapping("/delete")
	@ResponseBody
	public String deleteJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup) {
		jobService.deleteJob(jobName, jobGroup);
		return "delete job success";
	}
}