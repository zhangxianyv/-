package com.bootdo.point;

import com.alibaba.fastjson.JSON;
import com.bootdo.point.dao.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/point")
public class PointController {

    @Autowired
    PointMapper pointMapper;

    @RequestMapping("/showPointPage")
    public String showPointPage() {
        return "/point/main";
    }

    @RequestMapping("/queryAllPoint")
    @ResponseBody
    public String queryAllPoint() {
        List<Map<String,Object>> pointList = pointMapper.queryAllPoint();
        return JSON.toJSONString(pointList);
    }

    @RequestMapping("/queryNumByDate")
    @ResponseBody
    public String queryNumByDate(@RequestBody Map paramMap){
        List<Map<String,Object>> numList = pointMapper.queryNumByDate(paramMap);
        return JSON.toJSONString(numList);
    }

    @RequestMapping("/queryAPINumDate")
    @ResponseBody
    public String queryAPINumDate(){
        List<Map<String,Object>> numList = pointMapper.queryAPINumDate();
        return JSON.toJSONString(numList);
    }

    @RequestMapping("/queryCityPercent")
    @ResponseBody
    public String queryCityPercent(){
        List<Map<String,Object>> numList = pointMapper.queryCityPercent();
        return JSON.toJSONString(numList);
    }

    @RequestMapping("/queryDisPercent")
    @ResponseBody
    public String queryDisPercent ( @RequestBody Map<String , Object> paramMap ){
        System.out.println("paramMap.toString() = " + paramMap.toString());
        List<Map<String,Object>> numList = pointMapper.queryDisPercent(paramMap);
        return JSON.toJSON(numList).toString();
    }
}
