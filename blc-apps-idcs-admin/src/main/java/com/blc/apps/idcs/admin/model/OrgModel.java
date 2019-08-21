package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

import com.blc.apps.idcs.admin.entity.IcCompany;

public class OrgModel extends PageParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7176445146906269410L;
	private IcCompany org=new IcCompany();
	public IcCompany getOrg() {
		return org;
	}
	public void setOrg(IcCompany org) {
		this.org = org;
	}
}
