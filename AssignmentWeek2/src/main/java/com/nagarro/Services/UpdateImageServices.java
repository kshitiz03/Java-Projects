package com.nagarro.Services;

import com.nagarro.Dao.UpdateDao;
import com.nagarro.Model.ImageBean;

/**
 * 
 * @author kshitizrawat
 * services required for updating user image
 *
 */
public class UpdateImageServices {

	
	/**
	 * Extraction and setting image name by passing imageid
	 * @param imageIdToBeUpdated
	 * @param newImageName
	 * @return
	 */
	public ImageBean updateImage(int imageIdToBeUpdated, String newImageName) {

		UpdateDao updateDao = new UpdateDao();
		ImageBean imageToBeUpdated = updateDao.getDetailsOfImageAndDeleteOldImage(imageIdToBeUpdated);

		imageToBeUpdated.setImagename(newImageName);

		updateDao.addUpdateImagesToDatabase(imageToBeUpdated);

		return imageToBeUpdated;

	}
	
}
