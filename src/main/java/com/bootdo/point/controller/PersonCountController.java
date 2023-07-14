package com.bootdo.point.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.point.domain.PersonCountDO;
import com.bootdo.point.service.PersonCountService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * InnoDB free: 6144 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 16:00:53
 */
 
@Controller
@RequestMapping("/point/personCount")
public class PersonCountController {
	@Autowired
	private PersonCountService personCountService;
	
	@GetMapping()
	String PersonCount(){
	    return "point/personCount/personCount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PersonCountDO> personCountList = personCountService.list(query);
		int total = personCountService.count(query);
		PageUtils pageUtils = new PageUtils(personCountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")

	String add(){
	    return "point/personCount/add";
	}

	@GetMapping("/edit/{countId}")
	String edit(@PathVariable("countId") String countId,Model model){
		PersonCountDO personCount = personCountService.get(countId);
		model.addAttribute("personCount", personCount);
	    return "point/personCount/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( PersonCountDO personCount){
		if(personCountService.save(personCount)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( PersonCountDO personCount){
		personCountService.update(personCount);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( String countId){
		if(personCountService.remove(countId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") String[] countIds){
		personCountService.batchRemove(countIds);
		return R.ok();
	}
	
}
