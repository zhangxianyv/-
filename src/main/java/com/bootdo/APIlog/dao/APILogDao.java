package com.bootdo.APIlog.dao;

import com.bootdo.APIlog.domain.LogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 10:24:34
 */
@Mapper
public interface APILogDao {

	LogDO get(String logId);
	
	List<LogDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LogDO log);
	
	int update(LogDO log);
	
	int remove(String log_id);
	
	int batchRemove(String[] logIds);
}
