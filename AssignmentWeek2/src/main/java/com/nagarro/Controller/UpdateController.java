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
import com.nagarro.Services.UpdateImageServices;

/**
 * Servlet implementation class UpdateController update image name by calling
 * services for new name from user
 */
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String imageId = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		imageId = request.getParameter("imageId");
		response.sendRedirect("UpdateImage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		int imageIdToBeUpdated = Integer.parseInt(imageId);

		String newImageName = request.getParameter("newImageName");

		UpdateImageServices updateImageServices = new UpdateImageServices();
		ImageBean updatedImage = updateImageServices.updateImage(imageIdToBeUpdated, newImageName);

		LoginBean userLoginImageList = (LoginBean) session.getAttribute("dbUser");

		List<ImageBean> allImages = userLoginImageList.getImages();

		System.out.println("list size " + allImages.size());

		int count = 0;

		for (ImageBean eachImage : allImages) {
			if (eachImage.getImage_id() != imageIdToBeUpdated)
				count++;
			else
				break;
		}

		userLoginImageList.getImages().set(count, updatedImage);

		response.sendRedirect("ImageUpload.jsp");
	}
}
