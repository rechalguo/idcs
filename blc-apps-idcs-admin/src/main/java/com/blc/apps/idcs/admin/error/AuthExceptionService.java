package com.blc.apps.idcs.admin.error;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class AuthExceptionService extends BasicErrorController {


	public AuthExceptionService(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
	}

	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView v=new ModelAndView("401");
		
		Map<String,Object> errors=getErrorAttributes(request, true);
		
		return v;
	}

	@Override
	protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		Enumeration<String> attrs=request.getAttributeNames();
		return super.getErrorAttributes(request, includeStackTrace);
	}

	
}
