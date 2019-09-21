package com.nagarro.web.service;

import com.nagarro.web.model.Login;
import com.nagarro.web.model.User;
 
public interface UserService {
 
	User validateUser(Login login);
     
}