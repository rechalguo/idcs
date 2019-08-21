package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

import com.blc.apps.idcs.admin.entity.IcUserWithBLOBs;

public class UserModel extends PageParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5667724008457619020L;
	
	private IcUserWithBLOBs user=new IcUserWithBLOBs();

	public IcUserWithBLOBs getUser() {
		return user;
	}

	public void setUser(IcUserWithBLOBs user) {
		this.user = user;
	}
	
}
