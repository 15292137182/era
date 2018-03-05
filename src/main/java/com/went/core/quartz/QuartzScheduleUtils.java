package com.went.core.quartz;

import com.went.core.utils.UtilsTool;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/7  Wen TieHu Create </pre>
 */
public class QuartzScheduleUtils {
  private static Logger logger = LoggerFactory.getLogger(QuartzScheduleUtils.class);

  private volatile static Scheduler scheduler;

  public static Scheduler getInstanceScheduler() {
    if (scheduler == null) {
      synchronized (QuartzScheduleUtils.class) {
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
}

class ScheduleNameUtils {

  public static String getJobName(String taskSubId) {
    return taskSubId + "Job";
  }

  public static String getTriggerName(String taskSubId) {
    return taskSubId + "Trigger";
  }

  public static String getGroupName(String taskId) {
    return "group_" + taskId;
  }
}

class ScheduleJob implements Job {

  private static final Logger LOG = LoggerFactory.getLogger(ScheduleJob.class);

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
    String json = jobDataMap.getString("taskInfoDtoJson");
    if (UtilsTool.isValid(json)) {
      return;
    }
    // TODO: what you want to do.
  }


  static void doJob() throws Exception {
    Scheduler scheduler = QuartzScheduleUtils.getInstanceScheduler();
    scheduler.start();
    JobDetail job = JobBuilder.newJob(ScheduleJob.class)
        .withIdentity(ScheduleNameUtils.getJobName("123")
            , ScheduleNameUtils.getGroupName("234"))
        .usingJobData("taskInfoDtoJson", "23432")
        .build();

    CronScheduleBuilder cronScheduleBuilder = null;
    try {
      cronScheduleBuilder = CronScheduleBuilder.cronSchedule("* * * * * ? *");
    } catch (Exception e) {
      LOG.error("创建trigger的cron有问题：{}", e);
    }

    Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity(ScheduleNameUtils.getTriggerName("123"),
            ScheduleNameUtils.getGroupName("12321"))
        .startNow()
        .withSchedule(cronScheduleBuilder)
        .build();

    try {
      scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException e) {
      LOG.error("执行定时调度任务，job={}, trgger={}，抛错:{}", job, trigger, e);
    }
    // 某种情况下，需要取消定时任务
    cancelScheduleJob("12321", "!2312");
  }

  /**
   * 取消定时任务
   *
   * @param taskId
   * @param taskSubId
   * @return
   */
  public static boolean cancelScheduleJob(String taskId, String taskSubId) {
    Scheduler scheduler = null;
    scheduler = QuartzScheduleUtils.getInstanceScheduler();
    if (scheduler == null) {
      return false;
    }

    boolean isSuc = false;
    TriggerKey triggerKey = new TriggerKey(ScheduleNameUtils.getTriggerName(taskSubId),
        ScheduleNameUtils.getGroupName(taskId));
    try {
      isSuc = scheduler.unscheduleJob(triggerKey);
    } catch (SchedulerException e) {
      LOG.error("移除任务时抛错：{}", e);
    }
    return isSuc;
  }

  public static void main(String[] args) throws Exception {
    doJob();
  }
}
