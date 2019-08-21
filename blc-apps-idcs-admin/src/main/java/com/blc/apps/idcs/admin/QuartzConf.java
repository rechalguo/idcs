package com.blc.apps.idcs.admin;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.blc.apps.idcs.admin.job.StaSchedulerJob;

@Configuration
public class QuartzConf {
    @Bean
    public JobDetail myJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(StaSchedulerJob.class)
                .withIdentity("StaticJob","Default")
                //JobDataMap可以给任务execute传递参数
                //.usingJobData("job_param","job_param1")
                .storeDurably()
                .build();
        return jobDetail;
    }
    @Bean
    public Trigger myTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("StaticTrigger","Default")
                //.usingJobData("job_trigger_param","job_trigger_param1")
                .startNow()
                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .withSchedule(CronScheduleBuilder.cronSchedule("0 1 0 * * ?"))
                .build();
        return trigger;
    }
}