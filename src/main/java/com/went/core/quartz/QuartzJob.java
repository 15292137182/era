package com.went.core.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/7  Wen TieHu Create </pre>
 */
public class QuartzJob implements Job{
  /**
   * <p>
   * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
   * fires that is associated with the <code>Job</code>.
   * </p>
   * <p>
   * <p>
   * The implementation may wish to set a
   * {@link JobExecutionContext#setResult(Object) result} object on the
   * {@link JobExecutionContext} before this method exits.  The result itself
   * is meaningless to Quartz, but may be informative to
   * <code>{@link JobListener}s</code> or
   * <code>{@link TriggerListener}s</code> that are watching the job's
   * execution.
   * </p>
   *
   * @param context
   * @throws JobExecutionException if there is an exception while executing the job.
   */
  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobKey key = context.getJobDetail().getKey();
    System.out.println(key);
    JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
    System.out.println(mergedJobDataMap);
  }
}
