package com.usr.mgmt.management_project_db.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.usr.mgmt.management_project_db.model.Bus;
import com.usr.mgmt.management_project_db.model.Customer;
import com.usr.mgmt.management_project_db.model.MultiPassangerTicket;
import com.usr.mgmt.management_project_db.model.SinglePassangerTicket;
import com.usr.mgmt.management_project_db.model.SourceDestination;
import com.usr.mgmt.management_project_db.model.Ticket;



/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getSessionFactory() {	
	if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
	           // sessionFactory = configuration.configure().buildSessionFactory();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.ibm.db2.jcc.DB2Driver");
				settings.put(Environment.URL, "jdbc:db2://uptalk1.fyre.ibm.com:50000/bts");
				settings.put(Environment.USER, "db2inst1");
				settings.put(Environment.PASS, "LJuY.9wx");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.DB2Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Ticket.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(SourceDestination.class);
				configuration.addAnnotatedClass(Bus.class);
				configuration.addAnnotatedClass(MultiPassangerTicket.class);
				configuration.addAnnotatedClass(SinglePassangerTicket.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	  return sessionFactory;
	}


	private static ThreadLocal<Session> threadLocal
	          = new ThreadLocal<Session>();
	
	public static Session getSession() {
		Session session = null;
		if(threadLocal.get()==null) {
			
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}else {
			session = threadLocal.get();
		}
		return session;
		
	}
	
	
	//public static SessionFactory getSessionFactory() {
	//	return sessionFactory;
	
}
