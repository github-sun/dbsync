package cn.com.rising.dbsync.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import cn.com.rising.dbsync.db.DatabasePoolConnection;
import cn.com.rising.dbsync.entity.DatabaseSource;

public class DatabaseUtil {

	private static final Logger logger = Logger.getLogger(DatabaseUtil.class);

//	public static Connection createConnection(DatabaseSource databaseSource) {
//		try {
//			Class.forName(databaseSource.getDriver());
//			Connection conn = DriverManager.getConnection(databaseSource.getUrl(), databaseSource.getUsername(),
//					databaseSource.getPassword());
//			conn.setAutoCommit(false);
//			return conn;
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//		return null;
//	}

	public static Connection createConnection(DatabasePoolConnection dpConnection) {
		try {
			return dpConnection.getConnection();
		} catch (Exception e) {
			logger.error("创建数据库连接对象异常 "+e.getMessage());
		}
		return null;
	}
	
//	public static void closeConnection(Connection conn) {
//		try {
//			if (conn != null) {
//				conn.close();
//				logger.info("数据库连接关闭");
//			}
//		} catch (SQLException e) {
//			logger.error(e.getMessage());
//		}
//	}

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
	
//	public static void checkConnectionState(Connection conn, DatabaseSource ds) {
//		try {
//			if (conn == null || conn.isClosed()) {
//				conn = DatabaseUtil.createConnection(ds);
//			}
//		} catch (SQLException e) {
//			logger.error("重新获取inner对象出错" + e.getMessage());
//		}
//	}
	
//	public static void checkConnectionState(Connection conn, DatabaseSource ds) {
//		try {
//			if (conn == null || conn.isClosed()) {
//				conn = createConnection(ds);
//			}
//		} catch (SQLException e) {
//			logger.error("重新获取inner对象出错" + e.getMessage());
//		}
//	}
}
