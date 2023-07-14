package com.bootdo.point.dao;

import com.bootdo.point.domain.PersonCountDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 6144 kB
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 16:00:53
 */
@Mapper
public interface PersonCountDao {

	PersonCountDO get(String countId);
	
	List<PersonCountDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PersonCountDO personCount);
	
	int update(PersonCountDO personCount);
	
	int remove(String count_id);
	
	int batchRemove(String[] countIds);
}
