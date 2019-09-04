package com.blc.apps.idcs.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blc.apps.idcs.admin.entity.IcRefers;
import com.blc.apps.idcs.admin.entity.IcRefersExample;
import com.blc.apps.idcs.admin.entity.IcUserRefers;
import com.blc.apps.idcs.admin.entity.IcUserRefersExample;
import com.blc.apps.idcs.admin.mapper.ext.ReferMapper;
import com.blc.apps.idcs.admin.mapper.ext.UserRefersMapper;
import com.blc.apps.idcs.admin.model.ReferModel;

@Service
public class ReferService {

	@Autowired
	private ReferMapper referMapper;
	@Autowired
	private UserRefersMapper userRefersMapper;
	@Autowired
	private ApiNotificationService notificationService;
	
	public ReferModel listRefers(ReferModel model){
		List<IcRefers> refers=this.referMapper.selectRefersByPage(model);
		model.getRows().addAll(refers);
		return model;
	}

	/**
	 * 修改为禁用状态，先要解除所有的关联用户
	 * @param refers
	 */
	public void saveRefers(IcRefers refers) throws Exception {
		/**
		 * 修改为禁用状态时，先要解除所有的关联用户
		 * 同时需要 更新 接口服务中的接口对象
		 * 
		 * 当修改为可用时不用重新在API中加载，因为关联用户后，还需要再加载
		 */
		if("0".equals(refers.getIsOff())) {
			IcUserRefersExample e=new IcUserRefersExample();
			e.createCriteria().andRSeqNoEqualTo(refers.getSeqNo());
			List<IcUserRefers> urs=this.userRefersMapper.selectByExample(e);
			if(urs!=null&&urs.size()>0) throw new Exception("接口被其它用户引用,请先解除用户\"限用\"关系");
		}
		this.referMapper.updateByPrimaryKeySelective(refers);
	}

	public void addRefers(IcRefers refers) {
		/**
		 * 添加新接口后不用通知API系统加载，因为接口的任务关联操作都会触发接口的重载，所以不用这个时间重载。
		 */
		this.referMapper.insertSelective(refers);
	}

	public List<IcRefers> queryReferByrId(String getrId) {
		IcRefersExample e=new IcRefersExample();
		e.createCriteria().andRIdEqualTo(getrId);
		return this.referMapper.selectByExample(e);
	}
}
