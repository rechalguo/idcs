package com.blc.apps.idcs.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blc.apps.idcs.admin.entity.IcCompany;
import com.blc.apps.idcs.admin.mapper.ext.CompanyMapper;
import com.blc.apps.idcs.admin.model.OrgModel;
import com.blc.apps.idcs.util.DateTimeUtil;

@Service
public class IcCompanyService {

	@Autowired
	private CompanyMapper orgMapper;
	
	public OrgModel listOrgs(OrgModel model){
		List<IcCompany> users=this.orgMapper.selectOrgByPage(model);
		model.getRows().addAll(users);
		return model;
	}; 
	
	public void saveOrg(IcCompany org){
		this.orgMapper.updateByPrimaryKeySelective(org);
	};
	
	public void addOrg(IcCompany org){
		org.setCreateTime(DateTimeUtil.getCurrentDate());
		this.orgMapper.insertSelective(org);
	};
	
	public IcCompany queryOrgById(String orgId){
		return this.orgMapper.selectByPrimaryKey(orgId);
	}; 
}
