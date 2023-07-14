package com.bootdo.point.dao;

import com.bootdo.point.domain.XyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-10 14:32:16
 */
@Mapper
public interface XyDao {

	XyDO get(String pointId);
	
	List<XyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(XyDO xy);
	
	int update(XyDO xy);
	
	int remove(String point_id);
	
	int batchRemove(String[] pointIds);
}
