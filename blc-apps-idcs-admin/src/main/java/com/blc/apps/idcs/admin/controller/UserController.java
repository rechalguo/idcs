package com.blc.apps.idcs.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blc.apps.idcs.admin.entity.IcCompany;
import com.blc.apps.idcs.admin.entity.IcUser;
import com.blc.apps.idcs.admin.entity.IcUserRefers;
import com.blc.apps.idcs.admin.entity.IcUserWithBLOBs;
import com.blc.apps.idcs.admin.model.OrgModel;
import com.blc.apps.idcs.admin.model.UserModel;
import com.blc.apps.idcs.admin.model.UserRefersModel;
import com.blc.apps.idcs.admin.service.ApiNotificationService;
import com.blc.apps.idcs.admin.service.IcCompanyService;
import com.blc.apps.idcs.admin.service.IcUserService;
import com.blc.apps.idcs.util.rsa.RSAUtils;

@Controller
@RequestMapping("/idcs/user")
public class UserController {

	
	@Autowired
	IcUserService userService;
	@Autowired
	IcCompanyService orgService;
	@Autowired
	private ApiNotificationService notiferService;
	
	@PostMapping("/account")
	public String userPage() {
		return "users/account";
	}
	@PostMapping(value="/org")
    public String orgPage() {
		return "users/org";
    }
	@PostMapping(value="/refers")
    public String userRefersPage() {
		return "users/refers_acc";
    }
	
	
	/**
	 * ====================  user  ==============================
	 */
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/list")
	@ResponseBody
	public Object listUser(UserModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.userService.listUsers(model));
		return dataObject;
	}
	
	@PostMapping("/exists")
	@ResponseBody
	public Object existsUser(IcUser usr){
		IcUser user=this.userService.queryUserById(usr.getUserId());
		
		Map<String, Object> dataObject =new HashMap<>();
		if(user!=null&&user.getUserName()!=null){
			dataObject.put("code", "1");
		} else {
			dataObject.put("code", "0");
		}
		dataObject.put("msg", "success");
		return dataObject;
	}
	
	@PostMapping("/rsa/reset")
	@ResponseBody
	public Object resetRsa(String userId){
		Map<String, Object> dataObject =new HashMap<>();
		if(userId==null||"".equals(userId.trim())){
			dataObject.put("code", "1");
			dataObject.put("msg", "Select a User Please");
			return dataObject;
		}
		
		Map<String, String> keys =new HashMap<>(4);
		try {
			Map<String, String> userKeys=RSAUtils.genKeyPair(512);
			keys.put("publicKey", userKeys.get(RSAUtils.PUBLIC_KEY));
			keys.put("privateKey", userKeys.get(RSAUtils.PRIVATE_KEY));
			
			Map<String, String> serverKeys=RSAUtils.genKeyPair(512);
			keys.put("publicKeyApi", serverKeys.get(RSAUtils.PUBLIC_KEY));
			keys.put("privateKeyApi", serverKeys.get(RSAUtils.PRIVATE_KEY));
			
			
			IcUserWithBLOBs user=new IcUserWithBLOBs();
			user.setUserId(userId);
			user.setPrivateKey(keys.get("privateKey"));
			user.setPublicKey(keys.get("publicKey"));
			user.setPrivateKeyApi(keys.get("privateKeyApi"));
			user.setPublicKeyApi(keys.get("publicKeyApi"));
			this.userService.saveUser(user);
			
			dataObject.put("code", "0");
			dataObject.put("msg", "Update Success");
			dataObject.put("data", keys);
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Keys Generate Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	
	@PostMapping("/save")
	@ResponseBody
	public Object saveUser(IcUserWithBLOBs user){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			userService.saveUser(user);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save User Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Save User Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/add")
	@ResponseBody
	public Object addUser(IcUserWithBLOBs user){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			userService.addUser(user);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save User Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Save User Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	
	/**
	 * -------------------- 机构 -----------------------
	 */
	@PostMapping("/orgList")
	@ResponseBody
	public Object listOrgnization(OrgModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.orgService.listOrgs(model));
		return dataObject;
	}
	@PostMapping("/orgSave")
	@ResponseBody
	public Object saveOrg(IcCompany org){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			this.orgService.saveOrg(org);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save Org Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Save User Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/orgAdd")
	@ResponseBody
	public Object addOrg(IcCompany org){
		Map<String, Object> dataObject =new HashMap<>();
		try {
			this.orgService.addOrg(org);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save Org Success!");
		} catch (Exception e) {
			dataObject.put("code", "1");
			dataObject.put("msg", "Save User Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/orgExists")
	@ResponseBody
	public Object existsOrg(IcCompany org){
		IcCompany user=this.orgService.queryOrgById(org.getOrgId());
		
		Map<String, Object> dataObject =new HashMap<>();
		if(user!=null&&user.getOrgName()!=null){
			dataObject.put("code", "1");
		} else {
			dataObject.put("code", "0");
		}
		dataObject.put("msg", "success");
		return dataObject;
	}
	
	
	/**
	 * ====================  user refers  ==============================
	 */
	@PostMapping("/accRefers")
	@ResponseBody
	public Object listAccRefers(UserRefersModel model){
		Map<String, Object> dataObject =new HashMap<>();
		dataObject.put("code", "0");
		dataObject.put("msg", "success");
		dataObject.put("data", this.userService.listUserRefers(model));
		return dataObject;
	}
	@PostMapping("/saveUR")
	@ResponseBody
	public Object saveAccRefers(IcUserRefers urs){
		Map<String, Object> dataObject =new HashMap<>();
		try{
			this.userService.saveUserRefers(urs);
			dataObject.put("code", "0");
			dataObject.put("msg", "Save Success");
		}catch(Exception e){
			dataObject.put("code", "1");
			dataObject.put("msg", "Save Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	@PostMapping("/addUR")
	@ResponseBody
	public Object addAccRefers(IcUserRefers urs){
		Map<String, Object> dataObject =new HashMap<>();
		try{
			this.userService.addUserRefers(urs);
			dataObject.put("code", "0");
			dataObject.put("msg", "Add Success");
		}catch(Exception e){
			dataObject.put("code", "1");
			dataObject.put("msg", "Add Error!");
			e.printStackTrace();
		}
		return dataObject;
	}
	
	@PostMapping("/reloadApis")
	@ResponseBody
	public Object reloadApi(){
		return this.notiferService.reloadApis();
	}
	
	@PostMapping("/reloadUserApi")
	@ResponseBody
	public Object reloadUserApi(String userId, String apiId){
		return this.notiferService.reloadUserApi(userId, apiId);
	}
}
