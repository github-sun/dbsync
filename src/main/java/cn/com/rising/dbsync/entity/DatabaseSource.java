package cn.com.rising.dbsync.entity;

public class DatabaseSource {

	//驱动URL
	private String url;
	
	//数据库用户名
	private String username;
	
	//数据库密码
	private String password;
	
	//数据库类型
	private String type;
	
	//数据库驱动
	private String driver;
	
	//druid初始化大小
	private String initialSize;
	
	private String maxActive;
	
	private String maxWait;
	
	private String timeBetweenEvictionRunsMillis;
	
	private String minEvictableIdleTimeMillis;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}

	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	@Override
	public String toString() {
		return "DatabaseSource [url=" + url + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", driver=" + driver + ", initialSize=" + initialSize + ", maxActive=" + maxActive + ", maxWait="
				+ maxWait + ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis
				+ ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis + "]";
	}

}
