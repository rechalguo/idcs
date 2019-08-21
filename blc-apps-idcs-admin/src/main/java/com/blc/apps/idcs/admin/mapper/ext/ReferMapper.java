package com.blc.apps.idcs.admin.mapper.ext;

import java.util.List;

import com.blc.apps.idcs.admin.entity.IcRefers;
import com.blc.apps.idcs.admin.mapper.IcRefersMapper;
import com.blc.apps.idcs.admin.model.ReferModel;

public interface ReferMapper extends IcRefersMapper {

	List<IcRefers> selectRefersByPage(ReferModel model);
	
	int insertSelective(IcRefers record);
}
