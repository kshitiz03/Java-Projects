package com.nagarro.web.dao;

import org.springframework.stereotype.Repository;

import com.nagarro.web.model.Login;
import com.nagarro.web.model.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		User user = (User) getSession().get(User.class, login.getUsername());
		if (user.getUpass() != null && user.getUpass().equals(login.getUpassword()))
			return user;
		return null;	}
}