package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

import com.blc.apps.idcs.admin.entity.IcRefers;

public class ReferModel extends PageParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5836668202397746919L;

	IcRefers refer=new IcRefers();

	public IcRefers getRefer() {
		return refer;
	}

	public void setRefer(IcRefers refer) {
		this.refer = refer;
	}
	
}
