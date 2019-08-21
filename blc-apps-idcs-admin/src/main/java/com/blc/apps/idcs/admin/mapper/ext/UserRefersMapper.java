package com.blc.apps.idcs.admin.mapper.ext;

import java.util.List;

import com.blc.apps.idcs.admin.entity.IcUserRefers;
import com.blc.apps.idcs.admin.mapper.IcUserRefersMapper;
import com.blc.apps.idcs.admin.model.UserRefersModel;

public interface UserRefersMapper extends IcUserRefersMapper{
	
	List<IcUserRefers> selectUserRefersByPage(UserRefersModel model);
}