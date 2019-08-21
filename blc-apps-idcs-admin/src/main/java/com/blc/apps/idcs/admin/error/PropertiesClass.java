package com.blc.apps.idcs.admin.error;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * 读取resource下的.properties文件，将文件中的内容封装到map中，注入到bean中方便依赖注入
 * @author Administrator
 *
 */
@Configuration
public class PropertiesClass {
	private Logger logger = LoggerFactory.getLogger(PropertiesClass.class);
	
	public Map<String, String> responseMessage = new HashMap<String, String>();
	
	//可以添加其它 更多的配置
	//public Map<String, String> payMap = new HashMap<String, String>();
	
	public void init(String name) {
		try {
			Properties properties = new Properties();
			InputStream in = PropertiesClass.class.getClassLoader().getResourceAsStream(name + ".properties");
			properties.load(in);
			
			logger.info("加载{}.properties配置文件",name);
			for (String keyName : properties.stringPropertyNames()) {
				String value = properties.getProperty(keyName);
				responseMessage.put(keyName, value);
				logger.info("{}.properties---------key:{},value:{}",name, keyName, value);
			}
			logger.info("{}.properties参数加载完毕",name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Bean(name="responseMessage")
	public Map<String, String> responseMessage(){
		init("response_message");
		return responseMessage;
	}
	
}