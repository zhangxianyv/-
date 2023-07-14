package com.bootdo.subway;

import com.alibaba.fastjson.JSON;
import com.bootdo.point.dao.PointMapper;
import com.bootdo.subway.dao.SubwayMapper;
import com.bootdo.subway.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/subway")
public class SubwayController {
    @Autowired
    SubwayService subwayService;

    @Autowired
    SubwayMapper subwayMapper;

    @RequestMapping("/showSubway")
    public String showLocation(){return "/subway/main";}

    @RequestMapping("/showSubway1")
    public String showLocation1(){return "/subway/main1";}

    @RequestMapping("/showshow")
    public String showshow(){return "/subway/show";}

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody Map<String,Object> paramMap)
    {
        Map<String,Object> returnMap = subwayService.save(paramMap);
        return  returnMap;
    }

    @RequestMapping("/queryNumByDate")
    @ResponseBody
    public String queryNumByDate(@RequestBody Map paramMap){
        List<Map<String,Object>> numList = subwayMapper.queryNumByDate(paramMap);
        return JSON.toJSONString(numList);
    }

}
