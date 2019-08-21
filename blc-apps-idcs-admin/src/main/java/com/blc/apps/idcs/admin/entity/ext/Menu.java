package com.blc.apps.idcs.admin.entity.ext;

import java.util.HashMap;
import java.util.Map;

/**
 * leaf menu:
 * <li class="active open">
		<a href="javascript: skipTo(uri)">
			<i class="menu-icon fa fa-plus purple"></i>
			Add Product
		</a>
		<b class="arrow"></b>
	</li>
 * 
 * 
 * menu has leaf:
 * <li class="active open">
		<a href="#" class="dropdown-toggle">
			<i class="menu-icon fa fa-pencil orange"></i>
			4th level
			<b class="arrow fa fa-angle-down"></b>
		</a>
		<b class="arrow"></b>
		<ul class="submenu">
		   ...
		</ul>
	</li>
 * 
 * @date 2019年7月5日 下午1:13:30
 * @version 1.0.0
 * @author rechel
 */



public class Menu {

	private String uri;
	private String clazz;
	private String iconClazz;
	private boolean isLeaf;
	
	private String dropDownClass; //class=dropdown-toggle
	private String dropDownIconClass;
	private Map<String,String> parameters=new HashMap<>();
}
