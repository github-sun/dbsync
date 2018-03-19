package cn.com.rising.dbsync.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.com.rising.dbsync.common.Common;
import cn.com.rising.dbsync.dao.AdminDAO;
import cn.com.rising.dbsync.entity.Admin;
import cn.com.rising.dbsync.util.MyBatisUtil;

public class AdminDAOImpl implements AdminDAO {

	private static final Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	private static final String namespace = "cn.com.rising.dbsync.dao.adminDao.";
	
	public List<Admin> getAdminDatas() {
		 List<Admin> datas = null;
	        SqlSession session = MyBatisUtil.getSession(Common.innerConfigFile);
	        try {
	        	datas = session.selectList(namespace + "getAdminDatas", Admin.class);
	            //注意：此处有陷阱，如果做了更新、插入或删除操作，必须使用：
	            //session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            logger.error("Exception "+e);
	        }finally{
	            MyBatisUtil.closeSession(session);
	        }
	        return datas;
	}

}
