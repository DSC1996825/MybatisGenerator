package com.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.ManagerMapper;
import com.boot.model.Manager;
import com.boot.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;

	@RequestMapping("/login")
	public Map<String, Object> login(@RequestParam("username") String username,@RequestParam("password")String password) {
		Manager manager = managerService.login(username, password);
		Map<String, Object> resultMap = new HashMap<>();
		if(manager==null) {
			resultMap.put("success", false);
			resultMap.put("data", "登录失败！");
			return resultMap;
			
		}
		resultMap.put("success", true);
		resultMap.put("data", manager);
		return resultMap;
	}
}
