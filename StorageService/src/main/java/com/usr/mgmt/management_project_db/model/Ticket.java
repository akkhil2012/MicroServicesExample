package com.usr.mgmt.management_project_db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "bus_ticket")
public class Ticket {

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticket_id;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;

	public Ticket(int ticket_id, int cust_id, String book_id) {
		super();
		this.ticket_id = ticket_id;
		this.cust_id = cust_id;
		this.book_id = book_id;
	}


public String getBook_id() {
		return book_id;
	}



	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}


	/*	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)*/
	@JoinColumn(name = "cust_id")
	private int cust_id;
	
	public int getTicket_id() {
		return ticket_id;
	}



	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}



	public int getCust_id() {
		return cust_id;
	}



	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}



	



	@Column(name = "book_id")
	private String book_id;
	
	

	public Ticket() {

	}

	
	
}
