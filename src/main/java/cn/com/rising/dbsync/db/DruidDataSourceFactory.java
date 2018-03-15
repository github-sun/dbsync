package cn.com.rising.dbsync.db;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidDataSourceFactory implements DataSourceFactory {
	private Properties props;

	public DataSource getDataSource() {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(this.props.getProperty("driver"));
		dds.setUrl(this.props.getProperty("url"));
		dds.setUsername(this.props.getProperty("username"));
		dds.setPassword(this.props.getProperty("password"));
		dds.setInitialSize(Integer.valueOf(this.props.getProperty("initialSize")));
		dds.setMaxActive(Integer.valueOf(this.props.getProperty("maxActive")));
		dds.setMaxWait(Long.valueOf(this.props.getProperty("maxWait")));
		dds.setTimeBetweenEvictionRunsMillis(Long.valueOf(this.props.getProperty("timeBetweenEvictionRunsMillis")));
		dds.setMinEvictableIdleTimeMillis(Long.valueOf(this.props.getProperty("minEvictableIdleTimeMillis")));
		try {
			dds.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dds;
	}

	public void setProperties(Properties props) {
		this.props = props;
	}
}
