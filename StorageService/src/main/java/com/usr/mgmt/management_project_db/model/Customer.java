package com.usr.mgmt.management_project_db.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/*
 * create table customer(
  customer_id integer NOT NULL PRIMARY KEY,
  ticket_id integer NOT NULL,
  is_Admin SMALLINT NOT NULL WITH DEFAULT 0,
  FOREIGN KEY bus_ticlet_fkey (ticket_id) 
  REFERENCES bus_ticket ON DELETE NO ACTION)
 */
@Component
@Entity
@Table(name = "customer")
public class Customer {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int cust_id;

    @Column(name = "first_name")
    private String firstName;
    
    
   /* public Collection<Ticket> getTicket() {
		return ticket;
	}



	public void setTicket(Collection<Ticket> ticket) {
		this.ticket = ticket;
	}*/

	/*@OneToMany
    @JoinTable(name="customer_tickets",joinColumns=@JoinColumn(name="cust_id"),
     inverseJoinColumns=@JoinColumn(name="ticket_id")
    )*/
    
@OneToMany(mappedBy="customer")
private Collection<Ticket> listOfTickets = new ArrayList<>();
    

public Collection<Bus> getListOfBookedBuses() {
	return listOfBookedBuses;
}



public void setListOfBookedBuses(Collection<Bus> listOfBookedBuses) {
	this.listOfBookedBuses = listOfBookedBuses;
}



public Collection<Ticket> getListOfTickets() {
	return listOfTickets;
}



public void setListOfTickets(Collection<Ticket> listOfTickets) {
	this.listOfTickets = listOfTickets;
}

@ManyToMany
private Collection<Bus> listOfBookedBuses = new ArrayList<>();

    public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List < Ticket > tickets = new ArrayList < Ticket > ();

    public Customer() {

    }

    

	public Customer(int cust_id,String firstName, String lastName, String email) {
		this.cust_id=cust_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

   
}