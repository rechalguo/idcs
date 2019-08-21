package com.blc.apps.idcs.admin.mapper.ext;

import java.util.List;

import com.blc.apps.idcs.admin.entity.IcCompany;
import com.blc.apps.idcs.admin.mapper.IcCompanyMapper;
import com.blc.apps.idcs.admin.model.OrgModel;

public interface CompanyMapper extends IcCompanyMapper{
    
	List<IcCompany> selectOrgByPage(OrgModel model);
}