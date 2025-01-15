package com.exponent.Util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.exponent.Entity.Student;

public class HibernateUtil {
	private HibernateUtil() {
	}

	private static SessionFactory sf = null;

	private static StandardServiceRegistry registry = null;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {

			Map<String, Object> map = new HashMap<String, Object>();

//			Connection properties

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/bath4950");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

//			Hibernate properties

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.FORMAT_SQL, false);
//			map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Student.class);

			sf = mds.getMetadataBuilder().build().getSessionFactoryBuilder().build();

		}

		return sf;

	}

}
