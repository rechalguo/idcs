package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

public class BaseInfoModel extends PageParameter{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1195156464256138439L;
	private String p;
	private String ptype;
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
}
