package com.boot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.UserMapper;
import com.boot.model.User;
import com.mysql.fabric.xmlrpc.base.Data;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers(){
		return userMapper.getUsers();
	}
	
	@PostMapping("/addUser")
	public Map<String, Object> addUser(@RequestBody User user){
		if(user.getId() == null) {
			user.setId("DSC"+new Date().getTime());
		}
		userMapper.insert(user);
		Map<String, Object> result = new HashMap<>();
		result.put("success", "true");
		result.put("msg", "添加用户成功！");
		return result;
	}
}
