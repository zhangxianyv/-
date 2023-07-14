package com.bootdo.location;


import com.bootdo.location.dao.LocationMapper;
import com.bootdo.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    LocationService locationService;

    @RequestMapping("/showLocation")
    public String showLocation(){return "/location/main";}
    @RequestMapping("/getLocation")
    public String getLocation(){return "/location/getlocation";}

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody Map<String,Object> paramMap)
    {
        System.out.println("ssss");
        Map<String,Object> returnMap = locationService.save(paramMap);
        return  returnMap;
    }
}
