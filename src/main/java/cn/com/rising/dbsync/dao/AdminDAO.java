package cn.com.rising.dbsync.dao;

import java.util.List;

import cn.com.rising.dbsync.entity.Admin;

public interface AdminDAO {

	 List<Admin> getAdminDatas();
	 
	 boolean addAdmin(Admin admin);
}
