package com.usr.mgmt.management_project_db.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "bus")
public class Bus {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_no")
    private int bus_no;
	
	@Column(name = "bus_type")
	private String bus_type;
	
	@ManyToMany(mappedBy="listOfBookedBuses")
	private Collection<Customer> customerList = new ArrayList<>();

	
	public Collection<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Collection<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	public String getBus_type() {
		return bus_type;
	}

	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}
}
