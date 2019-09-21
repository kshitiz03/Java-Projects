package com.nagarro.web.dao;

import com.nagarro.web.model.Login;
import com.nagarro.web.model.User;
 
public interface UserDao {
 
	User validateUser(Login login);
 
}