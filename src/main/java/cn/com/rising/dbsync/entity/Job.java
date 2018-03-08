package cn.com.rising.dbsync.entity;

public class Job {

	// job名称
	private String name;

	// job的调度周期
	private String cron;

	// job是否执行 0:不执行 1:执行
	private String executeState;
	
	//job的真正执行对象名称 全路径
	private String classname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getExecuteState() {
		return executeState;
	}

	public void setExecuteState(String executeState) {
		this.executeState = executeState;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "Job [name=" + name + ", cron=" + cron + ", executeState=" + executeState + ", classname=" + classname
				+ "]";
	}
}
