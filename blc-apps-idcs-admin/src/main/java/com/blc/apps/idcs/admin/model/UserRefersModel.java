package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

import com.blc.apps.idcs.admin.entity.ext.UserRefers;

public class UserRefersModel extends PageParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1875564261007607199L;

	UserRefers accRefer=new UserRefers();

	public UserRefers getAccRefer() {
		return accRefer;
	}

	public void setAccRefer(UserRefers accRefer) {
		this.accRefer = accRefer;
	}
	
}
