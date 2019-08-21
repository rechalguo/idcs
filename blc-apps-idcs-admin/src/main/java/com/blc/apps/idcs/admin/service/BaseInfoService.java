package com.blc.apps.idcs.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blc.apps.idcs.admin.entity.IcRefers;
import com.blc.apps.idcs.admin.entity.IcRefersExample;
import com.blc.apps.idcs.admin.entity.IcUser;
import com.blc.apps.idcs.admin.entity.IcUserExample;
import com.blc.apps.idcs.admin.mapper.ext.BaseInfoMapper;
import com.blc.apps.idcs.admin.mapper.ext.ReferMapper;
import com.blc.apps.idcs.admin.mapper.ext.UserMapper;
import com.blc.apps.idcs.admin.model.BaseInfoModel;

@Service
public class BaseInfoService {

	@Autowired
	private BaseInfoMapper baseMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ReferMapper referMapper;
	
	public static final String BASE_CK="1";
	public static final String BASE_REQ="2";
	public static final String BASE_ORG="3";
	
	
	public BaseInfoModel queryBaseInfoByType(BaseInfoModel p, String baseInfoType){
		if(p.getP()!=null) p.setP(p.getP().trim());
		List<Map<String,String>> rs= null;
		if(BASE_CK.equals(baseInfoType)) {
			rs=this.baseMapper.queryCheckType(p);
		}else if(BASE_REQ.equals(baseInfoType)){
			rs=this.baseMapper.queryReqType(p);
		}else if(BASE_ORG.equals(baseInfoType)){
			rs=this.baseMapper.queryOrgs(p);
		}
		if(rs==null) return p;
		
		List<Map<String,String>> result=new ArrayList<>(rs.size());
		for(Map<String,String> r:rs){
			Map<String,String> option=new HashMap<String,String>();
			for(Object k:r.keySet()) {
				option.put(k.toString().toLowerCase(), r.get(k));
			}
			result.add(option);
		}
		p.getRows().addAll(result);
		return p;
	}
	
	
	public BaseInfoModel queryUserInfos(BaseInfoModel p){
		List<IcUser> users=this.userMapper.selectByExample(new IcUserExample());
		p.getRows().addAll(users);
		return p;
	}
	public BaseInfoModel queryReferInfos(BaseInfoModel p){
		List<IcRefers> users=this.referMapper.selectByExample(new IcRefersExample());
		p.getRows().addAll(users);
		return p;
	}
}
