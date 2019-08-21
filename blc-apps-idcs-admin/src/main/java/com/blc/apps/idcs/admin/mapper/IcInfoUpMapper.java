package com.blc.apps.idcs.admin.mapper;

import com.blc.apps.idcs.admin.entity.IcInfoUp;
import com.blc.apps.idcs.admin.entity.IcInfoUpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IcInfoUpMapper {
    int countByExample(IcInfoUpExample example);

    int deleteByExample(IcInfoUpExample example);

    int insert(IcInfoUp record);

    int insertSelective(IcInfoUp record);

    List<IcInfoUp> selectByExample(IcInfoUpExample example);

    int updateByExampleSelective(@Param("record") IcInfoUp record, @Param("example") IcInfoUpExample example);

    int updateByExample(@Param("record") IcInfoUp record, @Param("example") IcInfoUpExample example);
}