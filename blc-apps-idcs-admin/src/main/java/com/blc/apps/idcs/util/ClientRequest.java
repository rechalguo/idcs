package com.blc.apps.idcs.util;

public class ClientRequest {
	private String version;	// 身份认证系统版本
	private String account; // 请求者的账号信息
	private String entCode;		// 企业在海关备案电商代码，报文中的身份证应该是此企业的订单中的
	private String reqAsynType; // 1web 2api
	private String msgCnt;  // 加密后的报文 ,报文json格式json=[{idCard:1234, idName:sss, bizNo:2323, msgCode:200, msgCnt:一致}...]&timestamp=yyyy/mm/dd hh:mm:ss
	private String signature; // 数据签名
	
	@Override
	public String toString() {
		return String.format(" version:"+this.version+","
				+ "account:"+this.account+","
				+ "entCode:"+this.entCode+","
				+ "reqAsynType:"+this.reqAsynType+","
				+ "msgCnt:"+this.msgCnt+","
				+ "signature:"+this.signature+" ") ;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getReqAsynType() {
		return reqAsynType;
	}
	public void setReqAsynType(String reqAsynType) {
		this.reqAsynType = reqAsynType;
	}
	public String getMsgCnt() {
		return msgCnt;
	}
	public void setMsgCnt(String msgCnt) {
		this.msgCnt = msgCnt;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getEntCode() {
		return entCode;
	}
	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}
}
