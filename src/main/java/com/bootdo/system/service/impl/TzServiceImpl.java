package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.TzDao;
import com.bootdo.system.domain.TzDO;
import com.bootdo.system.service.TzService;



@Service
public class TzServiceImpl implements TzService {
	@Autowired
	private TzDao tzDao;
	
	@Override
	public TzDO get(Long id){
		return tzDao.get(id);
	}
	
	@Override
	public List<TzDO> list(Map<String, Object> map){
		return tzDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return tzDao.count(map);
	}
	
	@Override
	public int save(TzDO tz){
		return tzDao.save(tz);
	}
	
	@Override
	public int update(TzDO tz){
		return tzDao.update(tz);
	}
	
	@Override
	public int remove(Long id){
		return tzDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return tzDao.batchRemove(ids);
	}
	
}
