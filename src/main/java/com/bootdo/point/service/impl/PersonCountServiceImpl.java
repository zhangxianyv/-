package com.bootdo.point.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.point.dao.PersonCountDao;
import com.bootdo.point.domain.PersonCountDO;
import com.bootdo.point.service.PersonCountService;



@Service
public class PersonCountServiceImpl implements PersonCountService {
	@Autowired
	private PersonCountDao personCountDao;
	
	@Override
	public PersonCountDO get(String countId){
		return personCountDao.get(countId);
	}
	
	@Override
	public List<PersonCountDO> list(Map<String, Object> map){
		return personCountDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return personCountDao.count(map);
	}
	
	@Override
	public int save(PersonCountDO personCount){
		return personCountDao.save(personCount);
	}
	
	@Override
	public int update(PersonCountDO personCount){
		return personCountDao.update(personCount);
	}
	
	@Override
	public int remove(String countId){
		return personCountDao.remove(countId);
	}
	
	@Override
	public int batchRemove(String[] countIds){
		return personCountDao.batchRemove(countIds);
	}
	
}
