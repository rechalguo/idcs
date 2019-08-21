package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IcRefers {
    private BigDecimal seqNo;

    private String rUrl;

    private String rUserKey;

    private BigDecimal rTimeOut;

    private BigDecimal rWeight;

    private String isOff;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date expiredDate;

    private String rDescription;

    private String className;

    private String rName;

    private String rId;

    private String rServerKey;

    public BigDecimal getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(BigDecimal seqNo) {
        this.seqNo = seqNo;
    }

    public String getrUrl() {
        return rUrl;
    }

    public void setrUrl(String rUrl) {
        this.rUrl = rUrl == null ? null : rUrl.trim();
    }

    public String getrUserKey() {
        return rUserKey;
    }

    public void setrUserKey(String rUserKey) {
        this.rUserKey = rUserKey == null ? null : rUserKey.trim();
    }

    public BigDecimal getrTimeOut() {
        return rTimeOut;
    }

    public void setrTimeOut(BigDecimal rTimeOut) {
        this.rTimeOut = rTimeOut;
    }

    public BigDecimal getrWeight() {
        return rWeight;
    }

    public void setrWeight(BigDecimal rWeight) {
        this.rWeight = rWeight;
    }

    public String getIsOff() {
        return isOff;
    }

    public void setIsOff(String isOff) {
        this.isOff = isOff == null ? null : isOff.trim();
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrServerKey() {
        return rServerKey;
    }

    public void setrServerKey(String rServerKey) {
        this.rServerKey = rServerKey == null ? null : rServerKey.trim();
    }
}