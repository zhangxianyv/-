package com.bootdo.APIlog.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.APIlog.domain.LogDO;
import com.bootdo.APIlog.service.APILogService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 10:24:34
 */
 
@Controller
@RequestMapping("/APIlog/log")
public class APILogController {
	@Autowired
	private APILogService logService;
	
	@GetMapping()
	String Log(){
	    return "APIlog/log/log";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LogDO> logList = logService.list(query);
		int total = logService.count(query);
		PageUtils pageUtils = new PageUtils(logList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "APIlog/log/add";
	}

	@GetMapping("/edit/{logId}")
	String edit(@PathVariable("logId") String logId,Model model){
		LogDO log = logService.get(logId);
		model.addAttribute("log", log);
	    return "APIlog/log/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( LogDO log){
		if(logService.save(log)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( LogDO log){
		logService.update(log);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( String logId){
		if(logService.remove(logId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] logIds){
		logService.batchRemove(logIds);
		return R.ok();
	}
	
}
