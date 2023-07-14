package com.bootdo.location.service;

import com.bootdo.location.dao.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LocationService {
    @Autowired
    LocationMapper locationMapper;
    public Map<String, Object> save(Map<String, Object> paramMap) {
        System.out.println("111");

        System.out.println("111"+paramMap);
        Map<String, Object> locMap = new HashMap<>();
        String lng = paramMap.get("lng") + "";
        String lat = paramMap.get("lat") + "";
        locMap.put("locid", UUID.randomUUID().toString());
        locMap.put("lng", lng);
        locMap.put("lat", lat);
        locMap.put("date", (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));

        locationMapper.save(locMap);
        //统计信息插入坐标点人数统计表
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "插入成功");
        return map;
    }
}
