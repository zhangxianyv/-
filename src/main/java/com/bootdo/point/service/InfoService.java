package com.bootdo.point.service;

import com.bootdo.point.domain.InfoDO;
import com.bootdo.point.domain.XyDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 13:36:00
 */
public interface InfoService {
	
	InfoDO get(String disId);
	
	List<InfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int update(InfoDO info);

	int save(InfoDO info);

	
	int remove(String disId);
	
	int batchRemove(String[] disIds);
}
