package com.nagarro.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.Model.LoginBean;
import com.nagarro.Services.ImageServices;

/**
 * Servlet implementation class ImageController
 */

/**
 * @author kshitizrawat 
 * validation call on image and extraction
 *
 */
@MultipartConfig(
//      fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
		maxFileSize = 1024 * 1024 * 1, // 1 MB
		maxRequestSize = 1024 * 1024 * 10 // 10 MB
//		location = "D:/Uploads"
)

public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			// check if user logged in
			if (session == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/LoginController");
				rd.forward(request, response);
			}
			LoginBean userLoginInfo = (LoginBean) session.getAttribute("userLoginInfo");

			LoginBean userLoginImageList = (LoginBean) session.getAttribute("dbUser");

			ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> listOfFiles = servletFileUpload.parseRequest(request);


			Boolean errorImage = false;

			ImageServices imageServices = new ImageServices();
			errorImage = imageServices.loadEachImageAndStore(userLoginInfo, listOfFiles, userLoginImageList,
					errorImage);

			if (errorImage == true) {
				request.setAttribute("errorSizeExceeding", "The file size is exceeding the permitted size!!");
			}
			request.getRequestDispatcher("ImageUpload.jsp").forward(request, response);


		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
