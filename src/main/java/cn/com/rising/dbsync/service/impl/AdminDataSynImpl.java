package cn.com.rising.dbsync.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.rising.dbsync.dao.AdminDAO;
import cn.com.rising.dbsync.dao.impl.AdminDAOImpl;
import cn.com.rising.dbsync.entity.Admin;
import cn.com.rising.dbsync.entity.AdminData;
import cn.com.rising.dbsync.entity.BaseData;
import cn.com.rising.dbsync.service.AbstractReadWirte;

public class AdminDataSynImpl extends AbstractReadWirte {

	private static final Logger logger = Logger.getLogger(AdminDataSynImpl.class);
	
	private AdminDAO mAdminDAO;

	public AdminDataSynImpl(Connection inner, Connection outer) {
		super(inner, outer);
		// TODO Auto-generated constructor stub
		mAdminDAO = new AdminDAOImpl();
	}

	@Override
	public List<? extends BaseData> readData() {
		List<Admin> datas = mAdminDAO.getAdminDatas();
		logger.info("datas "+datas.size());
		List<AdminData> list = new ArrayList<AdminData>();
		AdminData data = new AdminData();
		data.setUsername("test");
		list.add(data);
		return list;
	}

	@Override
	public void writeData(List<? extends BaseData> data) {
		@SuppressWarnings("unchecked")
		List<AdminData> list = (List<AdminData>) data;
		logger.info("list "+list.get(0).getUsername());
	}

}
