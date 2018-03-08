package cn.com.rising.dbsync.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseSQLStorage {

	public Connection mConnection;

	public DatabaseSQLStorage(Connection connection) {
		this.mConnection = connection;
	}
	
	/**
	 * 通过sql和对应的参数值进行查询
	 * @param sql
	 * @param selectionArgs
	 * @return
	 */
	public abstract ResultSet rawQuery(String sql, String[] selectionArgs);
	
	/**
	 * 通过sql执行该语句
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public abstract void execSQL(String sql) throws SQLException;
}
