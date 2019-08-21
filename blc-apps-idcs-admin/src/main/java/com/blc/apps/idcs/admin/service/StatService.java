package com.blc.apps.idcs.admin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blc.apps.idcs.admin.entity.ext.Static;
import com.blc.apps.idcs.admin.mapper.ext.StatMapper;
import com.blc.apps.idcs.admin.model.StatModel;
import com.blc.apps.idcs.util.DateTimeUtil;

@Service
public class StatService {

	@Autowired
	private StatMapper statMapper;
	
	/**
	 * 数据统计
	 */
	public boolean apiStatics(Date start, Date end) throws Exception{
		if(start==null||end==null) throw new Exception("[400] Bad parameter for start/end.");
		Map<String,Date> p=new HashMap<>(2);
		p.put("start", start);
		p.put("end", end);
		try{
			this.statMapper.apiStatics(p);
		}catch(Exception e){
			throw new Exception("[500] 统计出错", e);
		}
		return true;
	}
	
	
	public StatModel selectUserStatics(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectUserStaticsByPage(model);
		model.getRows().addAll(stats);
		return model;
	}
	public StatModel selectUserStaticsChart(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectUserStaticsChart(model);
		model.getRows().addAll(stats);
		return model;
	}
	
	public StatModel selectApiStatics(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectApiStaticsByPage(model);
		model.getRows().addAll(stats);
		return model;
	}
	public StatModel selectApiStaticsChart(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectApiStaticsChart(model);
		model.getRows().addAll(stats);
		return model;
	}
	
	public StatModel selectUserDsStatics(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectUserByDataSources(model);
		model.getRows().addAll(stats);
		return model;
	}
	
	public StatModel selectApiDsStatics(StatModel model){
		if(model.getStat().getvDate()==null)
			model.getStat().setvDate(DateTimeUtil.getCurrentDate());
		
		if(model.getStat().getvDateEnd()==null)
			model.getStat().setvDateEnd(model.getStat().getvDate());
		List<Static> stats=this.statMapper.selectApiByDataSources(model);
		model.getRows().addAll(stats);
		return model;
	}
}
