package com.bootdo.point.dao;

import com.bootdo.point.domain.InfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 13:36:00
 */
@Mapper
public interface InfoDao {

	InfoDO get(String disId);
	
	List<InfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(InfoDO info);
	
	int update(InfoDO info);
	
	int remove(String dis_id);
	
	int batchRemove(String[] disIds);
}
