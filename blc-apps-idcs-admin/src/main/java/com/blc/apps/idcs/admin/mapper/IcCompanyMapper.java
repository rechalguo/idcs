package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcCompany;
import com.blc.apps.idcs.admin.entity.IcCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcCompanyMapper {
    int countByExample(IcCompanyExample example);

    int deleteByExample(IcCompanyExample example);

    int deleteByPrimaryKey(String orgId);

    int insert(IcCompany record);

    int insertSelective(IcCompany record);

    List<IcCompany> selectByExample(IcCompanyExample example);

    IcCompany selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") IcCompany record, @Param("example") IcCompanyExample example);

    int updateByExample(@Param("record") IcCompany record, @Param("example") IcCompanyExample example);

    int updateByPrimaryKeySelective(IcCompany record);

    int updateByPrimaryKey(IcCompany record);
}