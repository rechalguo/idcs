package com.blc.apps.idcs.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blc.apps.idcs.admin.entity.IcRefers;
import com.blc.apps.idcs.admin.model.ReferModel;
import com.blc.apps.idcs.admin.service.ReferService;

@Controller
@RequestMapping("/idcs/refer")
public class ReferController {

	@Autowired
	private ReferService referService;
	
	
	@PostMapping("/refer")
	public String orgManager() {
		return "users/refers";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public Object listUser(ReferModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.referService.listRefers(model));
		return dataObject;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Object saveRefer(IcRefers refers){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			referService.saveRefers(refers);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save Refers Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/add")
	@ResponseBody
	public Object addRefers(IcRefers refers){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			referService.addRefers(refers);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save Refers Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Save Refers Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/exists")
	@ResponseBody
	public Object existsRefer(IcRefers refers){
		List<IcRefers> user=this.referService.queryReferByrId(refers.getrId());
		
		Map<String, Object> dataObject =new HashMap<>();
		if(user!=null&&!user.isEmpty()&& user.get(0).getrName()!=null){
			dataObject.put("code", "1");
		} else {
			dataObject.put("code", "0");
		}
		dataObject.put("msg", "success");
		return dataObject;
	}
}
