package com.usr.mgmt.management_project_db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.usr.mgmt.management_project_db.model.Customer;
import com.usr.mgmt.management_project_db.model.SourceDestination;
import com.usr.mgmt.management_project_db.model.Ticket;
import com.usr.mgmt.management_project_db.util.HibernateUtil;

@Service
public class SourceDestinationDao {
	public void saveSourceAndDestination(SourceDestination srcDest) {
		Transaction transaction = null;
		Session session=HibernateUtil.getSession();
		try{
			System.out.println("Starting Transaction.............");
			transaction = session.beginTransaction();
			// Save the source And Destionation By Admin
			// Exception while saving the commit
			session.save(srcDest);
			// commit transaction
			transaction.commit();
			System.out.println("Ending Transaction.............");
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
