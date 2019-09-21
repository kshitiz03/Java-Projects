package com.nagarro.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.Model.ImageBean;
import com.nagarro.Model.LoginBean;

/**
 * Servlet implementation class LogoutController
 * to sun on signOut button click to end user session
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

		HttpSession session = request.getSession(false);
		request.setAttribute("error", "You have logged out successfully");


		LoginBean lb = (LoginBean) session.getAttribute("userLoginInfo");

		List<ImageBean> ib = lb.getImages();
		System.out.print(ib.size());

		session.removeAttribute("username");
		session.removeAttribute("userLoginInfo");

		session.invalidate();

		request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	}

}
