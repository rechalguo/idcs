package com.blc.apps.idcs.admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.blc.shiro.filter.LoginFormFilter;
import com.blc.shiro.filter.LogoutExtFilter;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
@ControllerAdvice
public class ShiroConf {

	private static Logger logger = LoggerFactory.getLogger(ShiroConf.class);
	
	/**
	 * 配置会话管理器，设定会话超时及保存
	 * @return
	 */
	@Bean("sessionManager")
	public SessionManager sessionManager() {
	    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//	    Collection<SessionListener> listeners = new ArrayList<SessionListener>();
//	    //配置监听
//	    listeners.add(sessionListener());
//	    sessionManager.setSessionListeners(listeners);
//	    sessionManager.setSessionIdCookie(sessionIdCookie());
//	    sessionManager.setSessionDAO(sessionDAO());
//	    sessionManager.setCacheManager(ehCacheManager());
	    
	    //关键在这里
  		//sessionManager.sessionManager.setSessionDAO(getRedisSessionDao());

	    //全局会话超时时间（单位毫秒），默认30分钟  暂时设置为10秒钟 用来测试
	    sessionManager.setGlobalSessionTimeout(10*1000);
	    //是否开启删除无效的session对象  默认为true
	    sessionManager.setDeleteInvalidSessions(true);
	    //是否开启定时调度器进行检测过期session 默认为true
	    sessionManager.setSessionValidationSchedulerEnabled(true);
	    //设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 1个小时
	    //设置该属性 就不需要设置 ExecutorServiceSessionValidationScheduler 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
	    //暂时设置为 5秒 用来测试
	    sessionManager.setSessionValidationInterval(5000);

	    //取消url 后面的 JSESSIONID
	    sessionManager.setSessionIdUrlRewritingEnabled(false);
	    return sessionManager;
	}
	
	@Bean(name = "securityManager")
	public org.apache.shiro.mgt.SecurityManager sm(){
		logger.debug("初始化bean:securityManager");
		DefaultWebSecurityManager s=new DefaultWebSecurityManager();
		s.setRealm(realm());
		//s.setSessionManager(sessionManager);
		return s;
	}
	
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager sm) {
		logger.debug("初始化bean:shiroFilter");
		
		ShiroFilterFactoryBean f=new ShiroFilterFactoryBean();
		f.setSecurityManager(sm);
		
		f.setLoginUrl("/login");
		f.setSuccessUrl("/index.html");
		f.setUnauthorizedUrl("401");
		
		Map<String,String> paths=new HashMap<>();
		paths.put("/favicon.ico", "anon");  //首次登陆会跳转到这个地址，这样可以避免
		paths.put("/assets/**", "anon");
		paths.put("/logout", "logout");
		paths.put("/login", "authc");
		paths.put("/**", "authc");
		f.setFilterChainDefinitionMap(paths);
		
		Map<String,Filter> filters=new HashMap<>();
		filters.put("logout", new LogoutExtFilter("/login"));
		filters.put("authc", new LoginFormFilter());
		f.setFilters(filters);
		
		return f;
	}
	
	@Bean
    public FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBean() {
        FilterRegistrationBean<DelegatingFilterProxy> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistration.setDispatcherTypes(DispatcherType.FORWARD);
        return filterRegistration;
    }

//    @ModelAttribute(name = "subject")
//    public Subject subject() {
//        return SecurityUtils.getSubject();
//    }
    
	/**
	 * 不要配置成bean，直接在ShiroFilterFactoryBean中调用即可。 不然shiroFilter拦截后，还会被mvc拦截
	 * @return
	 */
    public Filter logoutFilter() {
    	logger.debug("创建filter:logoutFilter");
        LogoutFilter f=new LogoutFilter();
        f.setRedirectUrl("/login");
        return f;
    }
    
    
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public Realm realm() {
    	logger.debug("初始化bean:textConfigurationRealm");
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("joe.coder=password,user\n" +
                "jill.coder=password,admin");

        realm.setRoleDefinitions("admin=read,write\n" +
                "user=read");
        realm.setCachingEnabled(true);
        return realm;
    }
    
    
    @Bean
    public ErrorProperties errorProps(){
    	ErrorProperties ep=new ErrorProperties();
    	ep.setIncludeException(true);
    	ep.setIncludeStacktrace(ErrorProperties.IncludeStacktrace.ALWAYS);
    	ep.setPath("/error");
    	return ep;
    }
    
    
    
    
    
    
    
    
    //Shiro生命周期处理器
    /**
     * LifecycleBeanPostProcessorBean 的时候总是先于spring 读取yml文件。导致配置失败
     * 所以用static修饰可以解决{@value}失效问题
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    	logger.debug("初始化bean:lifecycleBeanPostProcessor");
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
    	logger.debug("初始化bean:DefaultAdvisorAutoProxyCreator");
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }
    
    @Bean
    public ShiroDialect getShiroDialect() {    // 必须配置此操作才可以使用thymeleaf-extras-shiro开发包
    	logger.debug("初始化shiroDialect:ShiroDialect");
        return new ShiroDialect() ;
    }
    
    
    /**
     * 解决： 无权限页面不跳转 shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized") 无效
     * shiro的源代码ShiroFilterFactoryBean.Java定义的filter必须满足filter instanceof AuthorizationFilter，
     * 只有perms，roles，ssl，rest，port才是属于AuthorizationFilter，而anon，authcBasic，auchc，user是AuthenticationFilter，
     * 所以unauthorizedUrl设置后页面不跳转 Shiro注解模式下，登录失败与没有权限都是通过抛出异常。
     * 并且默认并没有去处理或者捕获这些异常。在SpringMVC下需要配置捕获相应异常来通知用户信息
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
        Properties properties=new Properties();
        //这里的 /unauthorized 是页面，不是访问的路径
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/401");
        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException","/401");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }
    
}
