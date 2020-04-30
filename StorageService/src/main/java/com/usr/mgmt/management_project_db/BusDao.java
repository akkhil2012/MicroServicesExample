package com.usr.mgmt.management_project_db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usr.mgmt.management_project_db.model.Bus;
import com.usr.mgmt.management_project_db.model.Customer;
import com.usr.mgmt.management_project_db.model.Ticket;
import com.usr.mgmt.management_project_db.util.HibernateUtil;


@Service
public class BusDao {
	
	public void saveBus(Bus bus) {
		Transaction transaction = null;
		//SessionFactory sessionFactory = HibernateUtil.bu
		//System.out.println("factory " + sessionFactory);
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(bus);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

}
