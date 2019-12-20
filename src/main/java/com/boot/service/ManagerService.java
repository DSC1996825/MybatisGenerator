package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.ManagerMapper;
import com.boot.model.Manager;

@Service
public class ManagerService {
	@Autowired
	private ManagerMapper managerMapper;
	
	public Manager login(String username,String password) {
		return managerMapper.selectByUsernamePassword(username, password);
	}
}
