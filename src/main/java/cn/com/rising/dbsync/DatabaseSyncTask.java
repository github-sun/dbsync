package cn.com.rising.dbsync;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.rising.dbsync.db.DatabasePoolConnection;
import cn.com.rising.dbsync.entity.Job;
import cn.com.rising.dbsync.service.IDataSyn;
import cn.com.rising.dbsync.util.DatabaseUtil;

public class DatabaseSyncTask implements org.quartz.Job {

	private static final Logger logger = Logger.getLogger(DatabaseSyncTask.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap data = context.getJobDetail().getJobDataMap();
		
		Job job = (Job) data.get("job");
		String jobTitle = (String) data.get("logTitle");
		
		logger.info(jobTitle + " 启动任务调度");
		
		DatabasePoolConnection innerSource = (DatabasePoolConnection) data.get("inner");
		DatabasePoolConnection outerSource = (DatabasePoolConnection) data.get("outer");
		
		logger.error(jobTitle + "获取连接对象出错,请检查00000");
		
		Connection inner = DatabaseUtil.createConnection(innerSource);
		
		logger.error(jobTitle + "获取连接对象出错,请检查11111 inner "+inner);
		
		Connection outer = DatabaseUtil.createConnection(outerSource);
		
		logger.error(jobTitle + "获取连接对象出错,请检查22222 outer "+outer);
		
		if (inner == null || outer == null) {
			logger.error(jobTitle + "获取连接对象出错,请检查 inner "+inner + " outer "+outer);
			return;
		}

		long start = new Date().getTime();
		logger.info(jobTitle + " 开始任务调度: " + (new Date().getTime() - start) + "ms");
		Object obj = null;
		String classname = job.getClassname();
		Object[] args = new Object[]{inner, outer};
		Class[] argsClass = new Class[args.length];
		argsClass[0] = Connection.class;
		argsClass[1] = Connection.class;
		try {
			Class newoneClass = Class.forName(classname);
			Constructor constructor = newoneClass.getConstructor(argsClass);
			obj = constructor.newInstance(args);
		} catch (Exception e) {
			logger.error(jobTitle + " 任务调度实例化对象出错: " +e.getMessage());
		} 
		
		if (obj != null) {
			IDataSyn dataSyn = (IDataSyn) obj;
			long eStart = new Date().getTime();
			dataSyn.doDataSyn();
			this.logger.info(jobTitle + " 结束任务调度: " + (new Date().getTime() - eStart) + "ms");
		}
	}

}
