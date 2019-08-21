package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcConfCktype;
import com.blc.apps.idcs.admin.entity.IcConfCktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcConfCktypeMapper {
    int countByExample(IcConfCktypeExample example);

    int deleteByExample(IcConfCktypeExample example);

    int deleteByPrimaryKey(String ckId);

    int insert(IcConfCktype record);

    int insertSelective(IcConfCktype record);

    List<IcConfCktype> selectByExample(IcConfCktypeExample example);

    IcConfCktype selectByPrimaryKey(String ckId);

    int updateByExampleSelective(@Param("record") IcConfCktype record, @Param("example") IcConfCktypeExample example);

    int updateByExample(@Param("record") IcConfCktype record, @Param("example") IcConfCktypeExample example);

    int updateByPrimaryKeySelective(IcConfCktype record);

    int updateByPrimaryKey(IcConfCktype record);
}