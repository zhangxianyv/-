package com.bootdo.APIlog.service;

import com.bootdo.APIlog.domain.LogDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 10:24:34
 */
public interface APILogService {
	
	LogDO get(String logId);
	
	List<LogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LogDO log);
	
	int update(LogDO log);
	
	int remove(String logId);
	
	int batchRemove(String[] logIds);
}
