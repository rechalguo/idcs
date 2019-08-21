package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IcUserRefers {
    private String rUserId;

    private BigDecimal rSeqNo;

    private BigDecimal rWeight;

    private Date rIsExpired;

    private String rIsOff;

    private String rDescription;

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
}