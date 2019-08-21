package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;

public class IcInfoUp {
    private String reportDate;

    private String userId;

    private String userName;

    private String dataSrc;

    private String rName;

    private BigDecimal cnt;

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate == null ? null : reportDate.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public BigDecimal getCnt() {
        return cnt;
    }

    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }
}