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
 *  data access object for extracting and commiting session for particular user
 *
 */
public class LoginDao {

	public LoginBean LoginDaos(String iUsername) {

		LoginBean dbLoginBean = new LoginBean();

		Configuration configuration = new Configuration().configure().addAnnotatedClass(LoginBean.class)
				.addAnnotatedClass(ImageBean.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// session.save(loginBean);
		dbLoginBean = (LoginBean) session.get(LoginBean.class, iUsername);

		transaction.commit();

		return dbLoginBean;

	}

}
