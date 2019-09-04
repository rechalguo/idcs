package com.blc.apps.idcs.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blc.apps.idcs.admin.entity.IcUser;
import com.blc.apps.idcs.admin.entity.IcUserRefers;
import com.blc.apps.idcs.admin.entity.IcUserRefersExample;
import com.blc.apps.idcs.admin.entity.IcUserWithBLOBs;
import com.blc.apps.idcs.admin.mapper.ext.UserMapper;
import com.blc.apps.idcs.admin.mapper.ext.UserRefersMapper;
import com.blc.apps.idcs.admin.model.UserModel;
import com.blc.apps.idcs.admin.model.UserRefersModel;
import com.blc.apps.idcs.util.rsa.RSAUtils;

@Service
public class IcUserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRefersMapper userRefersMapper;
	
	public UserModel listUsers(UserModel model){
		List<IcUser> users=this.userMapper.selectUsersByPage(model);
		model.getRows().addAll(users);
		return model;
	};
	
	public void saveUser(IcUserWithBLOBs user) {
		this.userMapper.updateByPrimaryKeySelective(user);
	};
	
	public void addUser(IcUserWithBLOBs user) throws Exception{
		Map<String, String> userKeys=RSAUtils.genKeyPair(1024);
		user.setPrivateKey(userKeys.get(RSAUtils.PRIVATE_KEY));
		user.setPublicKey(userKeys.get(RSAUtils.PUBLIC_KEY));
		
		Map<String, String> serverKeys=RSAUtils.genKeyPair(512);
		user.setPrivateKeyApi(serverKeys.get(RSAUtils.PRIVATE_KEY));
		user.setPublicKeyApi(serverKeys.get(RSAUtils.PUBLIC_KEY));
		
		user.setPayType("2");
		this.userMapper.insertSelective(user);
	};
	
	public IcUser queryUserById(String userId){
		return this.userMapper.selectByPrimaryKey(userId);
	}
	
	
	
	
	
	
	
	
	/**
	 * =================  用户接口  ========================
	 * 用户和接口的关联关系在修改后，需要通过页面主动触发
	 */
	public UserRefersModel listUserRefers(UserRefersModel model){
		List<IcUserRefers> users=this.userRefersMapper.selectUserRefersByPage(model);
		model.getRows().addAll(users);
		return model;
	};
	
	/**
	 * @param urs
	 * @return
	 */
	public int saveUserRefers(IcUserRefers urs)throws Exception{
		if(StringUtils.isBlank(urs.getrUserId()) || urs.getrSeqNo()==null) 
			throw new Exception ("[401]参数错误");
		IcUserRefersExample e=new IcUserRefersExample();
		e.createCriteria().andRUserIdEqualTo(urs.getrUserId());
		e.getOredCriteria().get(0).andRSeqNoEqualTo(urs.getrSeqNo());
		return this.userRefersMapper.updateByExampleSelective(urs, e);
	};
	/**
	 * @param urs
	 * @return
	 */
	public int addUserRefers(IcUserRefers urs){
		return this.userRefersMapper.insert(urs);
	};
	
	/**
	 * 删除关联后需要使API系统知道
	 * 
	 * @param urs
	 * @return
	 */
	public int delUserRefers(IcUserRefers urs) throws Exception{
		if(StringUtils.isBlank(urs.getrUserId()) || urs.getrSeqNo()==null) 
			throw new Exception ("[401]参数错误");
		IcUserRefersExample e=new IcUserRefersExample();
		e.createCriteria().andRUserIdEqualTo(urs.getrUserId()).andRSeqNoEqualTo(urs.getrSeqNo());
		int delCounts=this.userRefersMapper.deleteByExample(e);
		return delCounts;
	};
}
