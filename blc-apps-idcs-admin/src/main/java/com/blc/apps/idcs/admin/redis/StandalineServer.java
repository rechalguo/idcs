package com.blc.apps.idcs.admin.redis;

import java.io.File;
import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * https://blog.csdn.net/zilong_zilong/article/details/78252037
 * @date 2019年8月1日 下午3:26:30
 * @version 1.0.0
 * @author rechel
 */
public class StandalineServer {

	public static void main(String[] args) {
		try {
			RedissonClient c=new StandalineServer().redisson();
			c.getBucket("grc").set("grc3");
			System.out.println(c.getBucket("grc").get());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testJavaRedission() {
		Config config = new Config();
		 
		//指定编码，默认编码为org.redisson.codec.JsonJacksonCodec
		//之前使用的spring-data-redis，用的客户端jedis，编码为org.springframework.data.redis.serializer.StringRedisSerializer
		//改用redisson后为了之间数据能兼容，这里修改编码为org.redisson.client.codec.StringCodec
		config.setCodec(new org.redisson.client.codec.StringCodec());
		 
		//指定使用单节点部署方式
		config.useSingleServer().setClientName("client");
		config.useSingleServer().setAddress("redis://192.168.103.126:6379");
		//config.useSingleServer().setPassword("password");
		config.useSingleServer().setConnectionPoolSize(500);//设置对于master节点的连接池中连接数最大为500
		config.useSingleServer().setIdleConnectionTimeout(10000);//如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
		config.useSingleServer().setConnectTimeout(30000);//同任何节点建立连接时的等待超时。时间单位是毫秒。
		config.useSingleServer().setTimeout(3000);//等待节点回复命令的时间。该时间从命令发送成功时开始计时。
		config.useSingleServer().setPingConnectionInterval(2000);
		config.useSingleServer().setRetryAttempts(3);
		config.useSingleServer().setRetryInterval(1000);
		 
		//创建客户端(发现创建RedissonClient非常耗时，基本在2秒-4秒左右)
		RedissonClient redisson = Redisson.create(config);
		 
		//首先获取redis中的key-value对象，key不存在没关系
		RBucket<String> keyObject = redisson.getBucket("grc");
		//如果key存在，就设置key的值为新值value
		//如果key不存在，就设置key的值为value
		System.out.println(keyObject.get());
		 
		//最后关闭RedissonClient
		redisson.shutdown();
	}
	public static void testSpringRedission() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/blc/apps/idcs/admin/redis/applicationContext-redssion.xml");
		RedissonClient redisson = (RedissonClient) applicationContext.getBean("standalone");
		// 首先获取redis中的key-value对象，key不存在没关系
		RBucket<String> keyObject = redisson.getBucket("key");
		// 如果key存在，就设置key的值为新值value
		// 如果key不存在，就设置key的值为value
		keyObject.set("value");
	}
	
	/**
	 * springboot 方式
	 * @return
	 * @throws IOException
	 */
	@Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
		String d=System.getProperty("user.dir");
        RedissonClient redisson = Redisson.create(
                Config.fromYAML(new File(d.concat(File.separator).concat("/src/main/resources/redisson.yml"))));
        return redisson;
    }
}
