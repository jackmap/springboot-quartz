//package com.example.task;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
//  *@deprecated:
//  *@author作者：mp
//  *2019年5月30日,下午2:18:32
//*/
//
//@Component
//@Configurable
//@EnableScheduling
//@EnableAsync
//public class ScheduledTasks {
// 
//   Log logger = LogFactory.getLog(ScheduledTasks.class);
// 
//   // cron接受cron表达式，根据cron表达式确定定时规则
//   @Scheduled(cron="0/5 * * * * ? ")   //每5秒执行一次 
//    public void testCron() throws InterruptedException {
//       DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//       System.err.println(sdf.format(new Date())+"*********每5秒执行一次"+Thread.currentThread().getName());
//        Thread.sleep(10000);
//   }
//   
//   @Scheduled(cron="0/5 * * * * ? ")   //每5秒执行一次 
//   public void testCron1() throws InterruptedException {
//      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//      System.err.println(sdf.format(new Date())+"*********每5秒执行一次"+Thread.currentThread().getName());
//       Thread.sleep(10000);
//  }
//}
