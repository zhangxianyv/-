package com.bootdo.APIlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.APIlog.dao.APILogDao;
import com.bootdo.APIlog.domain.LogDO;
import com.bootdo.APIlog.service.APILogService;



@Service
public class APILogServiceImpl implements APILogService {
	@Autowired
	private APILogDao logDao;
	
	@Override
	public LogDO get(String logId){
		return logDao.get(logId);
	}
	
	@Override
	public List<LogDO> list(Map<String, Object> map){
		return logDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return logDao.count(map);
	}
	
	@Override
	public int save(LogDO log){
		return logDao.save(log);
	}
	
	@Override
	public int update(LogDO log){
		return logDao.update(log);
	}
	
	@Override
	public int remove(String logId){
		return logDao.remove(logId);
	}
	
	@Override
	public int batchRemove(String[] logIds){
		return logDao.batchRemove(logIds);
	}
	
}
