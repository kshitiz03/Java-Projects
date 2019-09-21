package com.nagarro.Services;

import com.nagarro.Dao.LoginDao;
import com.nagarro.Model.LoginBean;

/**
 * 
 * @author kshitizrawat
 * All services for login of user into a session
 *
 */
public class LoginServices {

	String iUsername;
	String iPassword;

	LoginDao loginDao = new LoginDao();

	/**
	 * 
	 * @param loginBean info of user stored to bean
	 * @return
	 */
	public LoginBean LoginService(LoginBean loginBean) {


		String username = loginBean.getUsername();
		String password = loginBean.getPassword();


		iUsername = username;
		iPassword = password;


		LoginBean dbLoginBean = loginDao.LoginDaos(iUsername);

		if (dbLoginBean == null) {
			return dbLoginBean;
		}

		//validation for user by matching details to database
		if (iUsername.equalsIgnoreCase(dbLoginBean.getUsername())) {
			if (iPassword.equalsIgnoreCase(dbLoginBean.getPassword())) {
				System.out.println("Details Matched!!");
			} else {
				System.out.println("Wrong Password");
				return null;
			}
		} else {
			System.out.println("Wrong Username");
			return null;

		}
		return dbLoginBean;

	}
}
