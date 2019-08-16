package com.crud.student.operation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.crud.student.entity.Student;

public class GetUtilities {
	private static SessionFactory sessionFactory = null;

	static {
			loadSessionFactory();
	}

	public static void loadSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() throws HibernateException {

		Session session = sessionFactory.openSession();
		return session;
	}
}
