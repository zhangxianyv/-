package com.bootdo.location.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface LocationMapper {
    @Insert("INSERT INTO locpoint(locid, lng, lat, date ) " +
            "VALUES " +
            "(#{locid}, #{lng}, #{lat},#{date})")
    void save(Map<String, Object> locMap);
}
