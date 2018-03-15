package cn.com.rising.dbsync.db;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import cn.com.rising.dbsync.entity.DatabaseSource;

public class DatabasePoolConnection {

	private DruidDataSource druid = new DruidDataSource();

	public DatabasePoolConnection(DatabaseSource ds) {
		druid.setDriverClassName(ds.getDriver());
		druid.setUrl(ds.getUrl());
		druid.setUsername(ds.getUsername());
		druid.setPassword(ds.getPassword());
		try {
			druid.setFilters("stat");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		druid.setInitialSize(Integer.valueOf(ds.getInitialSize()));
		druid.setMaxActive(Integer.valueOf(ds.getMaxActive()));
		druid.setMaxWait(Long.valueOf(ds.getMaxWait()));
		druid.setTimeBetweenEvictionRunsMillis(Long.valueOf(ds.getTimeBetweenEvictionRunsMillis()));
		druid.setMinEvictableIdleTimeMillis(Long.valueOf(ds.getMinEvictableIdleTimeMillis()));
	}

	public DruidPooledConnection getConnection() throws SQLException {
		return druid.getConnection();
	}
}
