package com.blc.apps.idcs.admin.error;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理类
 * https://blog.csdn.net/vi_young_95/article/details/86310747
 * @author yangwei
 *
 * 用于全局返回json，如需返回ModelAndView请使用ControllerAdvice
 * 继承了ResponseEntityExceptionHandler，对于一些类似于请求方式异常的异常进行捕获
 */
//@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	@Qualifier("responseMessage")
    public  Map<String, String> responseMessage;

    /**
     * 重写handleExceptionInternal，自定义处理过程
     **/
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //这里将异常直接传给handlerException()方法进行处理，返回值为OK保证友好的返回，而不是出现500错误码。
    	Map<String,Object> result=new HashMap<>();
    	result.put("code", "2001");
    	result.put("message", "用户密码过期");
    	URI uri=null;
        try {
        	uri=new URI("/login");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        return ResponseEntity.created(uri).body(result);
    }

    
}