package com.nagarro.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.Model.ImageBean;
import com.nagarro.Model.LoginBean;


/**
 * 
 * @author kshitizrawat
 *  data access object for extracting session for updating image
 *
 */
public class UpdateDao {

	public ImageBean getDetailsOfImageAndDeleteOldImage(int imageIdToBeUpdated) {

		ImageBean dbImageBean = new ImageBean();

		Configuration configuration = new Configuration().configure().addAnnotatedClass(LoginBean.class)
				.addAnnotatedClass(ImageBean.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		dbImageBean = (ImageBean) session.get(ImageBean.class, imageIdToBeUpdated);

		session.delete(dbImageBean);

		transaction.commit();

		return dbImageBean;
	}

	public void addUpdateImagesToDatabase(ImageBean updatedImageBean) {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(ImageBean.class)
				.addAnnotatedClass(LoginBean.class);

		SessionFactory sessionFactory2 = configuration.buildSessionFactory();

		Session session = sessionFactory2.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(updatedImageBean);

		transaction.commit();
	}

}
