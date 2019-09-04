package com.blc.apps.idcs.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blc.apps.idcs.util.ClientRequest;
import com.blc.apps.idcs.util.HttpUtils;
import com.blc.apps.idcs.util.rsa.Algorithm;
import com.blc.apps.idcs.util.rsa.Base64Utils;
import com.blc.apps.idcs.util.rsa.EncryptAESUtils;

/**
 * 接口变动通知API系统
{
	"version":"2.0.0",
	"account":"account_str",
	"entCode":"administrator",
	"reqAsynType":"2"
	"msgCnt":"***"
	"signature":""
}
{
	"cmd":"updateUserApi",
	"parameters":["system", "Api-test"]
}
{
	"cmd":"mode",
	"parameters":["ONLINE"]
}
 * 
 * 
 * @date 2019年7月29日 上午10:27:48
 * @version 1.0.0
 * @author rechel
 */
@Service
public class ApiNotificationService {
	private static Logger logger = LoggerFactory.getLogger(ApiNotificationService.class);
	
	
	@Value("${app.api.notification}")
	private boolean notification;
	@Value("${app.api.url}")
	private String url;
	@Value("${app.api.secret}")
	private String secret;
	@Value("${app.api.version}")
	private String version;
	private Map<String,String> headers=null;
	
	
	public ApiNotificationService(){
		this.notification=false;
		headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json;charset=utf-8");
	}
	
	
	/**
	 * 重新加载所有接口
	 * 1. 系统接口
	 * 2. 用户接口
	 */
	public Map<String,String> reloadApis(){
		Map<String,String> r=new HashMap<>();
		r.put("code", "200");
		if(!this.notification){
			r.put("code", "401");
			r.put("msg", "不支持在线更新API系统");
			return r;
		}
		
		Map<String,Object> cmd=new HashMap<>();
		cmd.put("cmd", "reloadApis");
		cmd.put("parameters",new ArrayList<String>(0));
		String cmdStr=JSON.toJSONString(cmd);
		
		Algorithm alg=new Algorithm(Algorithm.ALG_AES, secret, Algorithm.ALG_AES_KEY_SIZE);
		ClientRequest req=new ClientRequest();
		req.setAccount("Admin");
		req.setEntCode("administrator");
		try {
			req.setMsgCnt(Base64Utils.encode(EncryptAESUtils.encrypt(alg, cmdStr.getBytes("utf-8"))));
			req.setReqAsynType("2");
			req.setSignature("");
			req.setVersion(version);
		} catch (Exception e) {
			r.put("code", "400");
			r.put("msg", "请求加密失败");
			e.printStackTrace();
			return r;
		}
		
		try {
			String body=JSON.toJSONString(req, SerializerFeature.WriteNullStringAsEmpty);
			if(logger.isInfoEnabled())
				logger.info("Request Api Opt[{}]", body);
			String resp=HttpUtils.getInstance().postBodyRequest(url, body, headers);
			if(logger.isInfoEnabled())
				logger.info("Get Response[{}]", resp);
			if(StringUtils.isNotBlank(resp)) {
				JSONObject resObj=JSON.parseObject(resp);
				if("200".equals(resObj.getString("code"))){
					r.put("msg", resObj.getString("msg"));
				} else {
					r.put("code", "400");
					r.put("msg", resObj.getString("msg"));
				}
			}else{
				r.put("code", "400");
				r.put("msg", "API系统响应错误");
			}
		} catch (Exception e) {
			r.put("code", "400");
			r.put("msg", "系统错误");
			e.printStackTrace();
		}
		return r;
	}
	
	/**
	 * 重新加载用户的API
	 * 除了用户表中的用户，还有test/system这两个
	 * 当只重新加载接口（不是关联用户）时需要指定是test还是system
	 * @param userId
	 * @param apiId
	 */
	public Map<String,String> reloadUserApi(String userId, String apiId) {
		Map<String,String> r=new HashMap<>();
		r.put("code", "200");
		if(!this.notification){
			r.put("code", "401");
			r.put("msg", "不支持在线更新API系统");
			return r;
		}
		
		if("System".equalsIgnoreCase(userId)){
			if(apiId.startsWith("Api-test")) userId="test";
		}
		
		
		List<String> ptypes=new ArrayList<>(2);
		ptypes.add(userId);
		ptypes.add(apiId);
		
		Map<String,Object> cmd=new HashMap<>();
		cmd.put("cmd", "updateUserApi");
		cmd.put("parameters",ptypes);
		String cmdStr=JSON.toJSONString(cmd);
		
		Algorithm alg=new Algorithm(Algorithm.ALG_AES, secret, Algorithm.ALG_AES_KEY_SIZE);
		ClientRequest req=new ClientRequest();
		req.setAccount("Admin");
		req.setEntCode("administrator");
		try {
			req.setMsgCnt(Base64Utils.encode(EncryptAESUtils.encrypt(alg, cmdStr.getBytes("utf-8"))));
			req.setReqAsynType("2");
			req.setSignature("");
			req.setVersion(version);
		} catch (Exception e) {
			r.put("code", "400");
			r.put("msg", "请求加密失败");
			e.printStackTrace();
			return r;
		}
		
		try {
			String body=JSON.toJSONString(req, SerializerFeature.WriteNullStringAsEmpty);
			if(logger.isInfoEnabled())
				logger.info("Request Api Opt[{}]", body);
			String resp=HttpUtils.getInstance().postBodyRequest(url, body, headers);
			if(logger.isInfoEnabled())
				logger.info("Get Response[{}]", resp);
			if(StringUtils.isNotBlank(resp)) {
				JSONObject resObj=JSON.parseObject(resp);
				if("200".equals(resObj.getString("code"))){
					r.put("msg", resObj.getString("msg"));
				} else {
					r.put("code", "400");
					r.put("msg", resObj.getString("msg"));
				}
			}else{
				r.put("code", "400");
				r.put("msg", "API系统响应错误");
			}
		} catch (Exception e) {
			r.put("code", "400");
			r.put("msg", "系统错误");
			e.printStackTrace();
		}
		return r;
	}
	
}
