package com.cl.commodity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cl.commodity.biz.IPriceService;
import com.cl.commodity.utils.ConfigUtil;
import com.cl.commodity.utils.SessionUtil;
import com.cl.privilege.api.IPrivilegeBaseApiService;
import com.cl.privilege.model.User;



/**
 *角色管理相关的控制器 
 */

@Controller
@RequestMapping("/controller/price")
public class PriceController {

	@Autowired
	private IPrivilegeBaseApiService privilegeBaseApiService;
	@Autowired
	private ConfigUtil configUtil;
	@Autowired
	private IPriceService priceService;
	
	@RequestMapping("/list")
    public String main(String visitedModule,String visitedResource,HttpServletRequest request,ModelMap map) {

		//初始化用户、菜单
		User user = SessionUtil.getSessionUser(request);
		String menus = privilegeBaseApiService.getModuleTree(user.getId(),visitedModule,visitedResource);
        map.put("user", user);
        map.put("menus", menus);
        
		return "price/list.ftl";
    }
	
	@RequestMapping("/log")
    public String log(String visitedModule,String visitedResource,HttpServletRequest request,ModelMap map) {

		//初始化用户、菜单
		User user = SessionUtil.getSessionUser(request);
		String menus = privilegeBaseApiService.getModuleTree(user.getId(),visitedModule,visitedResource);
        map.put("user", user);
        map.put("menus", menus);
        
		return "price/log.ftl";
    }
}
