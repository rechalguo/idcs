package com.blc.apps.idcs.admin.entity.ext;

import java.math.BigDecimal;
import java.util.Date;

public class UserRefers {
    private String userName;
    
    private String rUserId;
    private BigDecimal rSeqNo;
    private BigDecimal rWeight;
    private Date rIsExpired;
    private String rIsOff;
    private String rDescription;
    
    private String rId;
    private String rName;

    
    public String getrUserId() {
        return rUserId;
    }

    public void setrUserId(String rUserId) {
        this.rUserId = rUserId == null ? null : rUserId.trim();
    }

    public BigDecimal getrSeqNo() {
        return rSeqNo;
    }

    public void setrSeqNo(BigDecimal rSeqNo) {
        this.rSeqNo = rSeqNo;
    }

    public BigDecimal getrWeight() {
        return rWeight;
    }

    public void setrWeight(BigDecimal rWeight) {
        this.rWeight = rWeight;
    }

    public Date getrIsExpired() {
        return rIsExpired;
    }

    public void setrIsExpired(Date rIsExpired) {
        this.rIsExpired = rIsExpired;
    }

    public String getrIsOff() {
        return rIsOff;
    }

    public void setrIsOff(String rIsOff) {
        this.rIsOff = rIsOff == null ? null : rIsOff.trim();
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
}