package com.bootdo.subway.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SubwayMapper {
    @Insert("INSERT INTO subway(logid,subway_city,subway_station,date) VALUES (#{logid}, #{subway_city}, #{subway_station},#{date})")
    void save(Map<String, Object> subMap);

    @Select("SELECT " +
            " subway_city, " +
            "COUNT(*) AS record_count " +
            "FROM " +
            "subway " +
            "WHERE " +
            "date LIKE '${date}%' " +
            "GROUP BY " +
            "subway_city")
    List<Map<String, Object>> queryNumByDate(Map paramMap);
}
