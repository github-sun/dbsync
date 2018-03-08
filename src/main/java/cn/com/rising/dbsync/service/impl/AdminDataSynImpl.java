package cn.com.rising.dbsync.service.impl;

import java.sql.Connection;

import org.apache.log4j.Logger;

import cn.com.rising.dbsync.entity.WriteData;
import cn.com.rising.dbsync.service.AbstractReadWirte;
import cn.com.rising.dbsync.service.IDataSyn;

public class AdminDataSynImpl extends AbstractReadWirte implements IDataSyn{

	private static final Logger logger = Logger.getLogger(AdminDataSynImpl.class);

	public AdminDataSynImpl(Connection inner, Connection outer) {
		super(inner, outer);
		// TODO Auto-generated constructor stub
	}

	public void doDataSyn() {
		executeReadWrite();
		logger.info("开始进行执行同步操作");
	}

	@Override
	public WriteData<?> readData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeData(WriteData<?> data) {
		// TODO Auto-generated method stub
		
	}

}
