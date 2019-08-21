package com.blc.apps.idcs.admin.entity;

public class IcConfCktype {
    private String ckId;

    private String ckName;

    public String getCkId() {
        return ckId;
    }

    public void setCkId(String ckId) {
        this.ckId = ckId == null ? null : ckId.trim();
    }

    public String getCkName() {
        return ckName;
    }

    public void setCkName(String ckName) {
        this.ckName = ckName == null ? null : ckName.trim();
    }
}