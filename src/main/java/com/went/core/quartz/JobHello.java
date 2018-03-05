package com.went.core.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/8  Wen TieHu Create </pre>
 */
public class JobHello implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = simpleDateFormat.format(date);
    System.out.println("JOb   当前时间为" + format);
    System.out.println("Hello job");
  }
}

class hello {
  public static void main(String[] args) throws SchedulerException {
    JobDetail jobDetail = JobBuilder.newJob(JobHello.class).withIdentity("nameId", "groupId").build();
    String name = jobDetail.getKey().getName();
    String group = jobDetail.getKey().getGroup();
    String className = jobDetail.getJobClass().getName();
    System.out.println("name="+name+"---group="+group+"-----className="+className);

    //创建一个trigger实例， 定义该job立即执行，并且每隔两秒执行一次。
//    SimpleTrigger trigger = TriggerBuilder.newTrigger()
//        .withIdentity("nameId", "groupId").startAt(date).endAt(endDate)
////        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
//        .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(5)).build();

    CronTrigger trigger = TriggerBuilder.newTrigger()
        .withIdentity("nameId", "groupId")
        .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")).build();


    //创建Scheduler实例
    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    Scheduler scheduler = schedulerFactory.getScheduler();
    scheduler.start();
    Date date = new Date();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = simpleDateFormat.format(date);
    System.out.println("JOb main   当前时间为" + format);
    System.out.println("Hello job");
    scheduler.scheduleJob(jobDetail, trigger);

  }
}
