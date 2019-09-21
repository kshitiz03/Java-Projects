package com.nagarro.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.Dao.LoginDao;
import com.nagarro.Model.LoginBean;
import com.nagarro.Services.LoginServices;

/**
 * Servlet implementation class LoginController 
 * login checking and applying
 * services for getting session of current user
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String iUserName = request.getParameter("username");
		String iPassword = request.getParameter("password");

		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(iUserName);
		loginBean.setPassword(iPassword);

		LoginServices loginServices = new LoginServices();
		LoginBean dbLoginImageBean = loginServices.LoginService(loginBean);

		if (dbLoginImageBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userLoginInfo", loginBean);

			if (dbLoginImageBean.getImages() != null) {

				session.setAttribute("dbUser", dbLoginImageBean);
				session.setAttribute("userImageList", dbLoginImageBean.getImages());

			}
			request.setAttribute("username", iUserName);
			request.getRequestDispatcher("/ImageUpload.jsp").forward(request, response);

		} else {
			request.setAttribute("error", "Please Try Again!!");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}

}
