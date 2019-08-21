package com.blc.apps.idcs.admin.model;

import org.grc.common.mybatis.page.PageParameter;

import com.blc.apps.idcs.admin.entity.ext.Static;

public class StatModel  extends PageParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7231364416731758574L;
	Static stat=new Static();
	private boolean columnDisplayedUser=true;

	public Static getStat() {
		return stat;
	}

	public void setStat(Static stat) {
		this.stat = stat;
	}

	public boolean isColumnDisplayedUser() {
		return columnDisplayedUser;
	}

	public void setColumnDisplayedUser(boolean columnDisplayedUser) {
		this.columnDisplayedUser = columnDisplayedUser;
	}
}
