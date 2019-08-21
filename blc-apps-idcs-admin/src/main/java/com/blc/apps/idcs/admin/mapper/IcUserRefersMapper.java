package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcUserRefers;
import com.blc.apps.idcs.admin.entity.IcUserRefersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcUserRefersMapper {
    int countByExample(IcUserRefersExample example);

    int deleteByExample(IcUserRefersExample example);

    int insert(IcUserRefers record);

    int insertSelective(IcUserRefers record);

    List<IcUserRefers> selectByExample(IcUserRefersExample example);

    int updateByExampleSelective(@Param("record") IcUserRefers record, @Param("example") IcUserRefersExample example);

    int updateByExample(@Param("record") IcUserRefers record, @Param("example") IcUserRefersExample example);
}