package cn.com.rising.dbsync.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import cn.com.rising.dbsync.entity.DatabaseSource;

public class DatabaseUtil {

	private static final Logger logger = Logger.getLogger(DatabaseUtil.class);

	public static Connection createConnection(DatabaseSource databaseSource) {
		try {
			Class.forName(databaseSource.getDriver());
			Connection conn = DriverManager.getConnection(databaseSource.getUrl(), databaseSource.getUsername(),
					databaseSource.getPassword());
			conn.setAutoCommit(false);
			return conn;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				logger.info("数据库连接关闭");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}
}
