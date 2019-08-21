package com.blc.apps.idcs.admin.mapper.ext;

import java.util.List;
import java.util.Map;

import com.blc.apps.idcs.admin.model.BaseInfoModel;

public interface BaseInfoMapper {

	public List<Map<String,String>> queryCheckType(BaseInfoModel p);
	public List<Map<String,String>> queryReqType(BaseInfoModel p);
	public List<Map<String,String>> queryOrgs(BaseInfoModel p);
}
