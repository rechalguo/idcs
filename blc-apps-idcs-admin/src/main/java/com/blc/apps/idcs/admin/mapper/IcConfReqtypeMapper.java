package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcConfReqtype;
import com.blc.apps.idcs.admin.entity.IcConfReqtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcConfReqtypeMapper {
    int countByExample(IcConfReqtypeExample example);

    int deleteByExample(IcConfReqtypeExample example);

    int deleteByPrimaryKey(String rId);

    int insert(IcConfReqtype record);

    int insertSelective(IcConfReqtype record);

    List<IcConfReqtype> selectByExample(IcConfReqtypeExample example);

    IcConfReqtype selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") IcConfReqtype record, @Param("example") IcConfReqtypeExample example);

    int updateByExample(@Param("record") IcConfReqtype record, @Param("example") IcConfReqtypeExample example);

    int updateByPrimaryKeySelective(IcConfReqtype record);

    int updateByPrimaryKey(IcConfReqtype record);
}