package com.blc.apps.idcs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blc.apps.idcs.admin.model.StatModel;
import com.blc.apps.idcs.admin.service.StatService;

@Controller
@RequestMapping("/sta")
public class StatController {

	@Autowired
	private StatService statService;
	
	
	@PostMapping("/user")
	public String user(){
		return "apis/account";
	}
	@PostMapping("/thirdparty")
	public String apis(){
		return "apis/apis";
	}
	
	@PostMapping("/user/list")
	@ResponseBody
	public Object listUserStaticPage(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectUserStatics(model));
		return dataObject;
	}
	@PostMapping("/user/showchart")
	@ResponseBody
	public Object listUserStaticChart(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectUserStaticsChart(model));
		return dataObject;
	}
	@PostMapping("/user/dsdist")
	@ResponseBody
	public Object listUserDsDist(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectUserDsStatics(model));
		return dataObject;
	}
	
	
	@PostMapping("/api/list")
	@ResponseBody
	public Object listApiStaticPage(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectApiStatics(model));
		return dataObject;
	}
	@PostMapping("/api/showchart")
	@ResponseBody
	public Object listApiStaticChart(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectApiStaticsChart(model));
		return dataObject;
	}
	@PostMapping("/api/dsdist")
	@ResponseBody
	public Object listApiDsDist(StatModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.statService.selectApiDsStatics(model));
		return dataObject;
	}
}
