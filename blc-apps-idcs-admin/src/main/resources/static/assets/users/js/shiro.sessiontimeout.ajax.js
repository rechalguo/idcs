(function($ , undefined) {
	$.ajaxSetup({
		complete: function(jqXHR, textStatus){  
	        switch (jqXHR.status){  
	            case(500):  
	                alert("服务器系统内部错误");  
	                break;  
	            case(401):  
	            	alert("登陆超时，请重新登陆");
	            	window.location.href = "/";
	                break;  
	            case(403):  
	                alert("无权限执行此操作");  
	                break;  
	            case(408):  
	                alert("请求超时");  
	                break;  
	            default: ;  
	        }  
	    }
	});
})(window.jQuery);