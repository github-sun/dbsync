package cn.com.rising.dbsync.service;

import java.sql.Connection;
import java.util.List;

import cn.com.rising.dbsync.entity.BaseData;

public abstract class AbstractReadWirte implements IDataSynService{
	
	//内网连接对象
	public Connection mInner;
	//外网连接对象
	public Connection mOuter;
	
	public AbstractReadWirte(Connection inner, Connection outer) {
		this.mInner = inner;
		this.mOuter = outer;
	} 
	
	public void onService() {
		List<? extends BaseData> data = readData();
		writeData(data);
	}
	
	/**
	 * 读取源数据库数据
	 */
	public abstract List<? extends BaseData> readData();
	
	/**
	 * 写入目标数据库数据
	 * @param data
	 */
	public abstract void writeData(List<? extends BaseData> data);
	
}
