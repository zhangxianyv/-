package com.bootdo.point.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.point.utils.PointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.point.dao.XyDao;
import com.bootdo.point.domain.XyDO;
import com.bootdo.point.service.XyService;



@Service
public class XyServiceImpl implements XyService {
	String bdAK = "6SIVHxzaGNeNp0lBkvhEc1qRIlHxnvC3";
	String bdAreaUrl = "https://api.map.baidu.com/reverse_geocoding/v3/?";
	@Autowired
	private XyDao xyDao;
	
	@Override
	public XyDO get(String pointId){
		return xyDao.get(pointId);
	}
	
	@Override
	public List<XyDO> list(Map<String, Object> map){
		return xyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return xyDao.count(map);
	}

	@Override
	public int save(XyDO xy){
//		4、后台controller获取提交的经纬度数据
		String bdLon = xy.getBdLon();
		String bdLat = xy.getBdLat();
//		5、百度经纬度转wgs84经纬度
		PointUtils pointUtils = new PointUtils();
		// 传入参数需要进行类型转换
		// 	String -> double : Double.parseDouble("要转换类型的字符串")
		double lon_dbl = Double.parseDouble(bdLon);
		double lat_dbl = Double.parseDouble(bdLat);
		// 计算wgs84经纬度
		double [] wgs_dbl = pointUtils.bd09towgs84(lon_dbl,lat_dbl);
		double wgs84lon = wgs_dbl[0];
		double wgs84lat = wgs_dbl[1];
		// 计算结果进行类型转换，并添加到xy属性中
		xy.setWgs84Lat(wgs84lat+"");
		xy.setWgs84Lon(wgs84lon+"");
//		6、通过百度经纬度获取地区归属
		// 组装参数
		Map params = new LinkedHashMap<String, String>();
		params.put("ak", bdAK);
		params.put("output", "json");
		params.put("coordtype", "wgs84ll");
		params.put("extensions_poi", "0");
		params.put("location", xy.getWgs84Lat() + "," + xy.getWgs84Lon());
		try {
			String str = pointUtils.requestGetAK(bdAreaUrl, params);
			Map resultMap = (Map) JSON.parseObject(str, Map.class).get("result");
			String bdCityCode = resultMap.get("cityCode") + "";
			Map addrMap = (Map) resultMap.get("addressComponent");
			String cityName = addrMap.get("city") + "";
			String disCode = addrMap.get("adcode") + "";
			String disName = addrMap.get("district") + "";
			xy.setBdCityCode(bdCityCode);
			xy.setBdCityName(cityName);
			xy.setBdDisCode(disCode);
			xy.setBdDisName(disName);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		7、插入数据库
		return xyDao.save(xy);
	}


	@Override
	public int update(XyDO xy){
		return xyDao.update(xy);
	}
	
	@Override
	public int remove(String pointId){
		return xyDao.remove(pointId);
	}
	
	@Override
	public int batchRemove(String[] pointIds){
		return xyDao.batchRemove(pointIds);
	}
	
}
