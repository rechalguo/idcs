package com.blc.apps.idcs.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.blc.apps.idcs.util.DateTimeUtil;

/**
 * Hello world!
 * https://developer.mozilla.org/zh-CN/docs/Web/JavaScript
 */

@SpringBootApplication(
		exclude = {
				//jdbc auto configure
				//DataSourceAutoConfiguration.class,
				//DataSourceTransactionManagerAutoConfiguration.class,
				//QuartzAutoConfiguration.class
})
@MapperScan(basePackages = {"com.blc.apps.idcs.admin.mapper"})
@ComponentScan(basePackages = {"com.blc.apps.idcs.admin"})
@Configuration
public class IdcsAdmin 
{
	private static Logger logger = LoggerFactory.getLogger(IdcsAdmin.class);
    public static void main( String[] args)
    {
    	SpringApplication.run(IdcsAdmin.class, args);
    }
    
    
    /**
     * 处理日期问题
     * @return
     */
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
            	String fmt=DateTimeUtil.getDateFormat(source);
                SimpleDateFormat sdf = new SimpleDateFormat(fmt);
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return date;
            }
        };
    }
   
}
