package com.blc.apps.idcs.admin.mapper.ext;

import java.util.List;

import com.blc.apps.idcs.admin.entity.IcUser;
import com.blc.apps.idcs.admin.mapper.IcUserMapper;
import com.blc.apps.idcs.admin.model.UserModel;

public interface UserMapper extends IcUserMapper{

	List<IcUser> selectUsersByPage(UserModel model);
}
