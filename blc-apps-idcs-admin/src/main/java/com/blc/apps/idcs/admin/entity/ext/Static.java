package com.blc.apps.idcs.admin.entity.ext;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Static {

	@JSONField(format="yyyy-MM-dd")
	private Date vDate;
	private Date vDateEnd;
	private String userId;
	private String userName;
	private String dataSrc;
	private Integer counts; //接口调用数量 
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDataSrc() {
		return dataSrc;
	}
	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	public Date getvDateEnd() {
		return vDateEnd;
	}
	public void setvDateEnd(Date vDateEnd) {
		this.vDateEnd = vDateEnd;
	}
}
