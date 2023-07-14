package com.bootdo.point.service;

import com.bootdo.point.domain.PersonCountDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 6144 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 16:00:53
 */
public interface PersonCountService {
	
	PersonCountDO get(String countId);
	
	List<PersonCountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PersonCountDO personCount);
	
	int update(PersonCountDO personCount);
	
	int remove(String countId);
	
	int batchRemove(String[] countIds);
}
