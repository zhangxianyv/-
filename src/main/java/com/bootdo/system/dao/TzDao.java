package com.bootdo.system.dao;

import com.bootdo.system.domain.TzDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 通知通告
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-13 10:04:51
 */
@Mapper
public interface TzDao {

	TzDO get(Long id);
	
	List<TzDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TzDO tz);
	
	int update(TzDO tz);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
