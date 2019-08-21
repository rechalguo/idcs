package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcUser;
import com.blc.apps.idcs.admin.entity.IcUserExample;
import com.blc.apps.idcs.admin.entity.IcUserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcUserMapper {
    int countByExample(IcUserExample example);

    int deleteByExample(IcUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(IcUserWithBLOBs record);

    int insertSelective(IcUserWithBLOBs record);

    List<IcUserWithBLOBs> selectByExampleWithBLOBs(IcUserExample example);

    List<IcUser> selectByExample(IcUserExample example);

    IcUserWithBLOBs selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") IcUserWithBLOBs record, @Param("example") IcUserExample example);

    int updateByExampleWithBLOBs(@Param("record") IcUserWithBLOBs record, @Param("example") IcUserExample example);

    int updateByExample(@Param("record") IcUser record, @Param("example") IcUserExample example);

    int updateByPrimaryKeySelective(IcUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(IcUserWithBLOBs record);

    int updateByPrimaryKey(IcUser record);
}