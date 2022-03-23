package com.nagarro.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate class is responsible for creating session and providing it to the
 * requesting function
 * 
 * @author abhisheksrivastava02
 *
 */
public class Hibernate {
	static SessionFactory factory;
	static Session session;

	/**
	 * createConnection method creates a session and returns it
	 * 
	 * @return created session
	 */
	public static Session createConnection() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		return session;

	}

	/**
	 * getSession method returns a currently running session and if there is no
	 * session running creates a session and returns it
	 * 
	 * @return currently running session
	 */
	public static Session getSession() {
		if (session == null)
			createConnection();
		return session;
	}
}
