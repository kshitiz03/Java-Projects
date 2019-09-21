package com.nagarro.Services;

import com.nagarro.Dao.DeleteDao;
import com.nagarro.Model.ImageBean;


/**
 * delete bean for particular imageid
 * @author kshitizrawat
 *
 */
public class DeleteServices {

	public ImageBean deleteImage(int imageIdToBeDeleted) {

		DeleteDao deleteDao = new DeleteDao();
		ImageBean deletedImageBean = deleteDao.deleteImageFromDb(imageIdToBeDeleted);
		
		return deletedImageBean;
		
	}

}
