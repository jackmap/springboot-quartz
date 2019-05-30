package com.example.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class NewTask implements Job{
	final Log log = LogFactory.getLog(NewTask.class);
	
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println("查询开始时间是："+ sf.format(date)+Thread.currentThread().getName());
        long start=System.currentTimeMillis();
        
        //任务详情
    	System.err.println("任务运行开始-------- start --------");   
        try {  
        	String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        	String jobGroup = jobExecutionContext.getJobDetail().getKey().getGroup();
        	String triggerName = jobExecutionContext.getTrigger().getKey().getName();
        	String triggerGroup = jobExecutionContext.getTrigger().getKey().getGroup();
        	
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        	System.err.println("触发器Key:" + triggerName + ".." + triggerGroup + " 正在执行...");
        	System.err.println("任务Key:" + jobName + ".." + jobGroup + " 正在执行，执行时间: "
        			+ dateFormat.format(Calendar.getInstance().getTime()));
        	
        }catch (Exception e) {  
        	System.err.println("捕获异常==="+e);  
        }
        
        long end=System.currentTimeMillis();
        long time=end-start;
        System.out.println("查询结束时间是："+ sf.format(date)+"/n 耗时:"+time+"毫秒" +Thread.currentThread().getName());
    }
}
