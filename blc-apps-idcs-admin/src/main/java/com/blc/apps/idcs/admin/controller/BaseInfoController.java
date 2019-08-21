package com.blc.apps.idcs.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blc.apps.idcs.admin.model.BaseInfoModel;
import com.blc.apps.idcs.admin.service.BaseInfoService;

@Controller
@RequestMapping("/idcs/base")
public class BaseInfoController {

	@Autowired
	private BaseInfoService baseInfoService;
	@GetMapping("/reqType")
	@ResponseBody
	public BaseInfoModel getReqType(BaseInfoModel model){
		return this.baseInfoService.queryBaseInfoByType(model, BaseInfoService.BASE_REQ);
	}
	
	@GetMapping("/ckType")
	@ResponseBody
	public BaseInfoModel getCheckType(BaseInfoModel model){
		return this.baseInfoService.queryBaseInfoByType(model, BaseInfoService.BASE_CK);
	}
	
	@GetMapping("/org")
	@ResponseBody
	public BaseInfoModel getOrgType(BaseInfoModel model){
		/**
		 * ptype: filter/all
		 */
		return this.baseInfoService.queryBaseInfoByType(model, BaseInfoService.BASE_ORG);
	}
	
	
	@GetMapping("/accs")
	@ResponseBody
	public BaseInfoModel getAccounts(BaseInfoModel model){
		return this.baseInfoService.queryUserInfos(model);
	}
	@GetMapping("/refers")
	@ResponseBody
	public BaseInfoModel getRefers(BaseInfoModel model){
		return this.baseInfoService.queryReferInfos(model);
	}
}
