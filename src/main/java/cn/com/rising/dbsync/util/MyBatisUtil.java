package cn.com.rising.dbsync.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public static SqlSession getSession(String configFile) {
		SqlSession session = null;
		try {
			InputStream is = Resources.getResourceAsStream(configFile);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	public static void closeSession(SqlSession session) {
		session.close();
	}
}
