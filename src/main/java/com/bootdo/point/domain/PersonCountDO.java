package com.bootdo.point.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * InnoDB free: 6144 kB
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 16:00:53
 */
public class PersonCountDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String countId;
	//
	private String pointId;
	//
	private String personNumber;
	//
	private String countTime;

	/**
	 * 设置：
	 */
	public void setCountId(String countId) {
		this.countId = countId;
	}
	/**
	 * 获取：
	 */
	public String getCountId() {
		return countId;
	}
	/**
	 * 设置：
	 */
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	/**
	 * 获取：
	 */
	public String getPointId() {
		return pointId;
	}
	/**
	 * 设置：
	 */
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	/**
	 * 获取：
	 */
	public String getPersonNumber() {
		return personNumber;
	}
	/**
	 * 设置：
	 */
	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}
	/**
	 * 获取：
	 */
	public String getCountTime() {
		return countTime;
	}
}
