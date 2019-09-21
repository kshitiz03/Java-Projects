package com.nagarro.Dao;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.nagarro.Model.ImageBean;
import com.nagarro.Model.LoginBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 
 * @author kshitizrawat data access object for setting session for display of
 *         loggedin page
 */
public class ImageDao {

	public void storeImageInDataBase(ImageBean userImage) {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(ImageBean.class)
				.addAnnotatedClass(LoginBean.class);

		SessionFactory sessionFactory2 = configuration.buildSessionFactory();

		Session session = sessionFactory2.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(userImage);

		transaction.commit();
	}

}
