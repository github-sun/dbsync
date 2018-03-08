package cn.com.rising.dbsync.db;

import java.sql.Connection;

public class DatabaseFactory {

	public static DatabaseSQLStorage create(String type, Connection connection) {
		if ("mysql".toLowerCase().equals(type)) {
			return new MysqlDatabaseSQLStorage(connection);
		} else if ("sqlserver".toLowerCase().equals(type)) {
			return new SqlserverDatabaseSQLStorage(connection);
		}
		return null;
	}
}
