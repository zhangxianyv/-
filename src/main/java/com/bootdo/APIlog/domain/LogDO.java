package com.bootdo.APIlog.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2023-07-11 10:24:34
 */
public class LogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String logId;
	//
	private String userName;
	//
	private String password;
	//
	private String apiCode;
	//
	private String returnCode;
	//
	private String returnMsg;
	//
	private String updateTime;

	/**
	 * 设置：
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
	/**
	 * 获取：
	 */
	public String getLogId() {
		return logId;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}
	/**
	 * 获取：
	 */
	public String getApiCode() {
		return apiCode;
	}
	/**
	 * 设置：
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * 获取：
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * 设置：
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	/**
	 * 获取：
	 */
	public String getReturnMsg() {
		return returnMsg;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public String getUpdateTime() {
		return updateTime;
	}
}
