package com.usr.mgmt.management_project_db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usr.mgmt.management_project_db.model.Bus;
import com.usr.mgmt.management_project_db.model.Customer;
import com.usr.mgmt.management_project_db.model.MultiPassangerTicket;
import com.usr.mgmt.management_project_db.model.SinglePassangerTicket;
import com.usr.mgmt.management_project_db.model.Ticket;
import com.usr.mgmt.management_project_db.util.HibernateUtil;


@Service
public class CustomerDao {
	/*
	@Autowired
	private Customer customer;*/
	
	 
	public void saveCustomer(Customer customer) {
		Transaction transaction = null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			// putting ticket inside customer
			Ticket ticket = new Ticket(customer.getCust_id(),1, String.valueOf(customer.getCust_id()+(int)Math.random()));
			session.save(ticket);
			
			Ticket ticket1 = new Ticket(customer.getCust_id(),1, String.valueOf(customer.getCust_id()+(int)Math.random()));
			session.save(ticket1);
			
			/*
			 * 
			 * Example of the Ticket Inheritence
			 */
			
			SinglePassangerTicket singlePassangerTicket = new SinglePassangerTicket();
			singlePassangerTicket.setSinglePassangerPerTicket("Single  Passanger ticket : Single Smaple Ticket");
			
			MultiPassangerTicket multiPassangerTicket = new MultiPassangerTicket();
			multiPassangerTicket.setMultiPassangerPerTicket("Multi  Passanger ticket : Multi Smaple Ticket");
			
			session.save(multiPassangerTicket);
			session.save(singlePassangerTicket);
			
			/*
			 * Add Tickets are One to Many Example
			 */
			//customer.getCourses().add(tempCourse1);
			customer.getTickets().add(ticket);
			customer.getTickets().add(ticket1);
			
			
			/*
			 * Add Buses for Many to Many example
			 */
			Bus bus1 = new Bus();
			Bus bus2 = new Bus();
			
			session.save(bus1);
			session.save(bus2);
			customer.getListOfBookedBuses().add(bus1);
			customer.getListOfBookedBuses().add(bus2);
			
			
			session.save(customer);
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

	public void updateInstructor(Customer customer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(customer);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteInstructor(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a customer object
			Customer customer = session.get(Customer.class, id);
			if (customer != null) {
				session.delete(customer);
				System.out.println("customer is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Customer getCustomer(int id) {

		Transaction transaction = null;
		Customer customer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an customer object
			customer = session.get(Customer.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}
	
	/*
	 * To fetch the records
	 */
	public  List<Customer> fetchCustomers() {
		List customerList = new ArrayList();
		Session sessionObj = null;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = HibernateUtil.getSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			customerList = sessionObj.createQuery("FROM Customer").list();
		} catch(Exception sqlException) {
			if(null != sessionObj.getTransaction()) {
				//logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
		return customerList;
	}
	
	
	/*
	 * Fetch Customer by ID
	 */
	public Customer getCustomerByID(int id) {

		Transaction transaction = null;
		Customer customer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			customer = session.get(Customer.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}
	
	/*
	 * to get list of tickets booked by customer
	 * 
	 */
	public List<Ticket> getTicketsForCustomer(int id) { 
		Transaction transaction = null;
		List<Ticket> ticketList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			ticketList = session.get(Customer.class, id).getTickets();
			// commit transaction
			//Hibernate.initialize(ticketList);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return ticketList;
		
		
	}
	
	
	
}
