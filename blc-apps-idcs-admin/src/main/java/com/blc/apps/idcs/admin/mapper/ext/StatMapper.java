package com.blc.apps.idcs.admin.mapper.ext;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.blc.apps.idcs.admin.entity.ext.Static;
import com.blc.apps.idcs.admin.model.StatModel;

public interface StatMapper {

	/**
	 * 接口调用量
	 * @param stat
	 * @return
	 */
	List<Static> selectUserStaticsByPage(StatModel stat) ;
	List<Static> selectUserStaticsChart(StatModel stat) ;
	List<Static> selectApiStaticsByPage(StatModel stat) ;
	List<Static> selectApiStaticsChart(StatModel stat) ;
	
	/**
	 * 数据来源分布
	 * @param stat
	 * @return
	 */
	List<Static> selectUserByDataSources(StatModel stat) ;
	List<Static> selectApiByDataSources(StatModel stat) ;
	
	/**
	 * 数据统计
	 * @param p
	 */
	void apiStatics(Map<String, Date> p);
}
