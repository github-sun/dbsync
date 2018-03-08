package cn.com.rising.dbsync.service;

import java.sql.Connection;

import cn.com.rising.dbsync.entity.WriteData;

public abstract class AbstractReadWirte {
	
	//内网连接对象
	public Connection mInner;
	//外网连接对象
	public Connection mOuter;
	
	public AbstractReadWirte(Connection inner, Connection outer) {
		this.mInner = inner;
		this.mOuter = outer;
	} 
	
	public void executeReadWrite() {
		WriteData<?> data = readData();
		writeData(data);
	}
	
	/**
	 * 读取源数据库数据
	 */
	public abstract WriteData<?> readData();
	
	/**
	 * 写入目标数据库数据
	 * @param data
	 */
	public abstract void writeData(WriteData<?> data);
	
}
