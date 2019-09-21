package com.nagarro.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.web.dao.UserDao;
import com.nagarro.web.model.Login;
import com.nagarro.web.model.User;
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
 
	@Autowired
	public UserDao userDao;
	
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
     
}