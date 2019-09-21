package com.nagarro.Controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.Model.ImageBean;
import com.nagarro.Model.LoginBean;
import com.nagarro.Services.DeleteServices;
import com.nagarro.Services.ImageServices;

/**
 * Servlet implementation class DeleteController to delete image as per imageid
 */
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * delete image as per imageId
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		int imageIdToBeDeleted = Integer.parseInt(request.getParameter("imageId"));

		DeleteServices deleteServices = new DeleteServices();
		ImageBean deleteImageInfo = deleteServices.deleteImage(imageIdToBeDeleted);

		LoginBean userLoginImageList = (LoginBean) session.getAttribute("dbUser");

		userLoginImageList.getImages().removeIf(t -> t.getImage_id() == deleteImageInfo.getImage_id());

//		userLoginImageList.getImages().remove((deleteImageInfo));

		response.sendRedirect("ImageUpload.jsp");
	}

}
