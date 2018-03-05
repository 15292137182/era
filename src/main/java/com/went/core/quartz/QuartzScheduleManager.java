package com.went.core.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: QuartzScheduleManager</p>
 * <p>Description:Quartz 管理  </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/7  Wen TieHu Create </pre>
 */
public class QuartzScheduleManager {

  private static Logger logger = LoggerFactory.getLogger(QuartzScheduleManager.class);

  private volatile static Scheduler scheduler;

  public static Scheduler getInstanceScheduler() {
    if (scheduler == null) {
      synchronized (QuartzScheduleManager.class) {
        if (scheduler == null) {
          SchedulerFactory sf = new StdSchedulerFactory();
          try {
            scheduler = sf.getScheduler();
          } catch (SchedulerException e) {
            logger.error("获取Schedule时抛错：", e);
          }
        }
      }
    }
    return scheduler;
  }

  /**
   * 添加任务
   *
   * @param name      任务名称
   * @param group     任务分组
   * @param quartzCls class
   * @param cron      cron表达式
   * @param params    参数
   */
  public static void addTask(String name, String group, Class<? extends Job> quartzCls, String cron, JobDataMap params) {
    //获得调度器
    Scheduler scheduler = getInstanceScheduler();
    //获取执行对象
    JobDetail jobDetail = JobBuilder.newJob(quartzCls).withIdentity(name, group).usingJobData(params).build();
    JobKey key = jobDetail.getKey();
    logger.info("name=" + key.getName() + "---group=" + key.getGroup() + "-----className=" + jobDetail.getJobClass().getName());

    //将cron表达式添加到cronin调度中
    CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(cron);
    //定义cronTrigger 触发器
    CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(cronSchedule).build();
    try {
      JobKey jobKey = JobKey.jobKey(name, group);
      if (scheduler.checkExists(jobKey)) {
        return;
      }
      if (!scheduler.isShutdown()) {
        scheduler.start();
        //将任务和cronTrigger加入scheduler
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        logger.info("***************quartz启动***********************" + format);
        logger.info("***************下一次执行任务的时间******************" + date);
      }
    } catch (SchedulerException e) {
      logger.error("执行定时调度任务，jobDetail={}, cronTrigger={}，抛错:{}", jobDetail, cronTrigger, e);
    }
  }

  /**
   * 立即执行调度任务
   */
  public static void instantlyTask(String name, String group) {
    try {
      Scheduler scheduler = QuartzScheduleManager.getInstanceScheduler();
      // job1 将只会执行一次
      JobDetail job;
      job = JobBuilder.newJob(JobHello.class).withIdentity(name, group)
          .storeDurably().build();
      scheduler.addJob(job, true);
      System.out.println("手动触发  (立即执行)");
      scheduler.triggerJob(JobKey.jobKey(name, group));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}