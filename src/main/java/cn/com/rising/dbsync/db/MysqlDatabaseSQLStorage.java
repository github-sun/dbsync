package cn.com.rising.dbsync.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDatabaseSQLStorage extends DatabaseSQLStorage{

	public MysqlDatabaseSQLStorage(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet rawQuery(String sql, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
