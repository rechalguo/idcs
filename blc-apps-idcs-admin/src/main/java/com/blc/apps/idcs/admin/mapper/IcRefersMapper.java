package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcRefers;
import com.blc.apps.idcs.admin.entity.IcRefersExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcRefersMapper {
    int countByExample(IcRefersExample example);

    int deleteByExample(IcRefersExample example);

    int deleteByPrimaryKey(BigDecimal seqNo);

    int insert(IcRefers record);

    int insertSelective(IcRefers record);

    List<IcRefers> selectByExample(IcRefersExample example);

    IcRefers selectByPrimaryKey(BigDecimal seqNo);

    int updateByExampleSelective(@Param("record") IcRefers record, @Param("example") IcRefersExample example);

    int updateByExample(@Param("record") IcRefers record, @Param("example") IcRefersExample example);

    int updateByPrimaryKeySelective(IcRefers record);

    int updateByPrimaryKey(IcRefers record);
}