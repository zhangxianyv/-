package com.bootdo.subway.service;

import com.bootdo.subway.dao.SubwayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class SubwayService {
    @Autowired
    SubwayMapper subwayMapper;

    public Map<String, Object> save(Map<String, Object> paramMap) {
        System.out.println("111");

        System.out.println("111"+paramMap);
        Map<String, Object> subMap = new HashMap<>();
        String subway_city = paramMap.get("subway_city") + "";
        String subway_station = paramMap.get("subway_station") + "";
        subMap.put("logid", UUID.randomUUID().toString());
        subMap.put("subway_city", subway_city);
        subMap.put("subway_station", subway_station);
        subMap.put("date", (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));

        subwayMapper.save(subMap);
        //统计信息插入坐标点人数统计表
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "插入成功");
        return map;
    }
}
