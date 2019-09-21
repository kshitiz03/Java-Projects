package com.nagarro.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hibernate.Session;

import com.nagarro.Dao.ImageDao;
import com.nagarro.Model.ImageBean;
import com.nagarro.Model.LoginBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;

/**
 * 
 * @author kshitizrawat All the services to be performed in logged in page or
 *         main page
 *
 */
public class ImageServices {

	/**
	 * 
	 * @param userLoginInfo      bean of that user
	 * @param listOfFiles        info of image details stored for a user
	 * @param userLoginImageList
	 * @throws Exception
	 */
	public boolean loadEachImageAndStore(LoginBean userLoginInfo, List<FileItem> listOfFiles,
			LoginBean userLoginImageList, Boolean errorImage) throws Exception {

		System.out.println("In Image Services Store Image!");

		try {
			for (FileItem eachFile : listOfFiles) {

				long imageSize = eachFile.getSize();

				if (imageSize > 1024 * 1024) {
					throw new FileNotFoundException();
				}

				errorImage = false;

				String eachImageName = eachFile.getName();

				// storing in user system memory
				eachFile.write(new File("C:\\Users\\Public\\" + eachFile.getName()));

				String pathOfFile = "C:\\Users\\Public\\" + eachFile.getName();

				File file = new File(pathOfFile);
				// conversion of image to byte array
				byte[] imageByteArray = new byte[(int) file.length()];

				FileInputStream inputStream = null;

				try {

					inputStream = new FileInputStream(file);
					inputStream.read(imageByteArray);

				} catch (IOException e) {
					throw new Exception("Unable to convert file to byte array. " + e.getMessage());
				}

				finally {
					if (inputStream != null)
						inputStream.close();
				}

				// setting image details in database
				try {

					Blob blobImage = new SerialBlob(imageByteArray);
					ImageBean imageBean = new ImageBean();
					imageBean.setImagename(eachImageName);
					imageBean.setImage(blobImage);
					imageBean.setUser_info(userLoginInfo);

					ImageDao imageDao = new ImageDao();
					imageDao.storeImageInDataBase(imageBean);

					userLoginImageList.getImages().add(imageBean);
					file.delete();

				} catch (Exception e) {
					System.out.println(e);
				}

			}
		} catch (FileNotFoundException e) {
			errorImage = true;
		}
		return errorImage;
	}
}
