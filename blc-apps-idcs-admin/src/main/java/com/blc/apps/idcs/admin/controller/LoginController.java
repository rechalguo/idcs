/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blc.apps.idcs.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@GetMapping(value="/login")
    public String loginTemplate() {
    	System.out.println("Login html");
        return "login";
    }
	@PostMapping(value="/login")
    public ModelAndView loginTemplate2(String username, String password, Boolean rememberMe) {
    	System.out.println("Login2 html");
    	
    	ModelAndView v=new ModelAndView();
    	UsernamePasswordToken token=new UsernamePasswordToken(username, password, rememberMe);
    	Subject subject=SecurityUtils.getSubject();
    	try {
    		subject.login( token );
    	    //if no exception, that's it, we're done!
    		v.setViewName("index");
    		v.addObject("url", "/idcs/user/account");
    		return v;
    	} catch ( UnknownAccountException uae ) {
    		v.addObject("message", "账号不存在");
    		uae.printStackTrace();
    	} catch ( IncorrectCredentialsException ice ) {
    	    //password didn't match, try again?
    		v.addObject("message", "密码错误");
    		ice.printStackTrace();
    	} catch ( LockedAccountException lae ) {
    	    //account for that username is locked - can't login.  Show them a message?
    		v.addObject("message", "账号异常(过期/锁定等)");
    		lae.printStackTrace();
    	} catch ( AuthenticationException ae ) {
    	    //unexpected condition - error?
    		v.addObject("message", "账号异常(未知)");
    		ae.printStackTrace();
    	}
    	v.setViewName("login");
        return v;
    }
    
    @RequestMapping(value="/index.html")
    public ModelAndView onLoginSuccess() {
    	ModelAndView view=new ModelAndView("index");
    	view.addObject("url", "/idcs/user/account");
    	System.out.println("login sucess by form authc");
    	return view;
    }
    
    @RequestMapping(value="/unAuthorized.html")
    public ModelAndView unAuthorized() {
    	ModelAndView view=new ModelAndView("401");
    	return view;
    }
}
