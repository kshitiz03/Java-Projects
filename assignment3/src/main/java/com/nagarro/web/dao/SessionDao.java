package com.nagarro.web.dao;

import org.hibernate.Session;

public interface SessionDao {

	public Session getSession();

	public void begin();

	public void commit();

	public void close();

	public void rollback();

}
