package com.blc.apps.idcs.util;

/**
 * 
 * @description
 * 
reponse staut != 200 时 msgCnt 为错误明文
1. 创建响应报文时出错：未配置密钥/或对方公钥信息.
2. 
 * @date 2018年12月7日 上午9:42:20
 * @version 1.0.0
 * @author rechel
 */
public class ClientResponse {
	private String version;	// 身份认证系统版本
	private String respTime;	// 响应时间
	private String entCode;		// 企业在海关备案电商代码，报文中的身份证应该是此企业的订单中的
	private String msgCnt;  // 加密后的报文,报文json格式json=[{idCard:1234, idName:sss, bizNo:2323, msgCode:200, msgCnt:一致}...]
	private String signature; // 数据签名
	
	protected String msgDecrypted=null;
	protected int responseStatus=200;
	protected String responseMessamge="";
	
	@Override
	public String toString() {
		return "version:"+this.version+";" +
				"respTime:"+this.respTime+";" +
				"entCode:"+this.entCode+";"+
				"msgCnt:"+this.msgCnt+";"+
				"sign:"+this.signature+";"+
				"status:"+this.responseStatus+";"+
				"response: "+this.responseMessamge+";"+
				"msgDecrypted:"+this.msgDecrypted;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getRespTime() {
		return respTime;
	}
	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	public int getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMessamge() {
		return responseMessamge;
	}
	public void setResponseMessamge(String responseMessamge) {
		this.responseMessamge = responseMessamge;
	}
	public String getMsgDecrypted() {
		return msgDecrypted;
	}
	public void setMsgDecrypted(String msgDecrypted) {
		this.msgDecrypted = msgDecrypted;
	}
}
