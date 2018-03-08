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

	@Override
	public String toString() {
		return "DataSource [url=" + url + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", driver=" + driver + "]";
	}
}
