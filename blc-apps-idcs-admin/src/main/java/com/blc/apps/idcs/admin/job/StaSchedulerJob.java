package com.blc.apps.idcs.admin.job;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.blc.apps.idcs.admin.service.StatService;

public class StaSchedulerJob extends QuartzJobBean{

	private static Logger logger = LoggerFactory.getLogger(StaSchedulerJob.class);

	@Value("${app.job.name}")
	private String name;
	
	@Autowired
	private StatService statService;
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		Calendar c=Calendar.getInstance();
		
		c.add(Calendar.DATE, -1);
		Date start=DateUtils.truncate(c.getTime(), Calendar.MONTH);
		c.setTime(start);
		c.add(Calendar.MONTH, 1);
		Date end=c.getTime();
		if(logger.isDebugEnabled())
			logger.debug("Job[static] starting from[{}] to[{}]", 
				DateFormatUtils.format(start, "yyyy/MM/dd"),
				DateFormatUtils.format(end, "yyyy/MM/dd"));
		
		try {
			this.statService.apiStatics(start, end);
			logger.info("Job[static] done success with parameters[{},{}]", 
					DateFormatUtils.format(start, "yyyy/MM/dd"),
					DateFormatUtils.format(end, "yyyy/MM/dd"));
		} catch (Exception e) {
			logger.error("Job[static] done failed", e);
			e.printStackTrace();
		}
		
	}
}
