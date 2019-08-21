package com.blc.apps.idcs.admin.entity;

public class IcUserWithBLOBs extends IcUser {
    private String privateKey;

    private String publicKey;

    private String privateKeyApi;

    private String publicKeyApi;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    public String getPrivateKeyApi() {
        return privateKeyApi;
    }

    public void setPrivateKeyApi(String privateKeyApi) {
        this.privateKeyApi = privateKeyApi == null ? null : privateKeyApi.trim();
    }

    public String getPublicKeyApi() {
        return publicKeyApi;
    }

    public void setPublicKeyApi(String publicKeyApi) {
        this.publicKeyApi = publicKeyApi == null ? null : publicKeyApi.trim();
    }
}