package cn.com.rising.dbsync;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import cn.com.rising.dbsync.db.DatabasePoolConnection;
import cn.com.rising.dbsync.entity.DatabaseSource;
import cn.com.rising.dbsync.entity.Job;
import cn.com.rising.dbsync.util.JobsParse;
import cn.com.rising.dbsync.util.MyBatisUtil;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);
	
	private static final String innerConfigFile = "mybatis-inner-config.xml";
	private static final String outerConfigFile = "mybatis-outer-config.xml";
	
	/**
	 * 开始执行
	 */
	public void start() {
		logger.error("正在启动数据库同步引擎");
		Map<String, Object> jobsMap = JobsParse.getJobs();
		if (jobsMap == null) {
			logger.error("获取任务出现异常,请检查");
			return;
		}
		
		SqlSession innerSession = MyBatisUtil.getSession(innerConfigFile);
		SqlSession outerSession = MyBatisUtil.getSession(innerConfigFile);
		logger.error("innerSession "+innerSession + " outerSession "+outerSession);
		
		DatabaseSource innerSource = (DatabaseSource) jobsMap.get("inner");
		DatabaseSource outerSource = (DatabaseSource) jobsMap.get("outer");
		
		DatabasePoolConnection innerPoolConnection = new DatabasePoolConnection(innerSource);
		DatabasePoolConnection outerPoolConnection = new DatabasePoolConnection(outerSource);
		
		List<?> jobList = (List<?>) jobsMap.get("jobs");
		String code = (String) jobsMap.get("code");

		for (int index = 0; index < jobList.size(); index++) {
			Job job = (Job)jobList.get(index);
			String jobTitle = "[" + code + "]" + job.getName() + " ";
			try {
				SchedulerFactory sf = new StdSchedulerFactory();
				Scheduler sched = sf.getScheduler();
				JobDetail jobDetail = newJob(DatabaseSyncTask.class).withIdentity("job-" + job.getName(), code).build();
				jobDetail.getJobDataMap().put("inner", innerPoolConnection);
				jobDetail.getJobDataMap().put("outer", outerPoolConnection);
				jobDetail.getJobDataMap().put("job", job);
				jobDetail.getJobDataMap().put("logTitle", jobTitle);
				logger.info(jobTitle + " cron " + job.getCron());
				
				if ("0".equals(job.getExecuteState())) {
					logger.info(jobTitle + " 状态为不启动 ");
					continue;
				}
				if ("1".equals(job.getExecuteState())) {
					CronTrigger trigger = newTrigger().withIdentity("trigger-" + job.getName(), code)
							.withSchedule(cronSchedule(job.getCron())).build();
					sched.scheduleJob(jobDetail, trigger);
					sched.start();
				}
			} catch (Exception e) {
				logger.error(jobTitle + " 启动出错 " + e.getMessage());
				continue;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
