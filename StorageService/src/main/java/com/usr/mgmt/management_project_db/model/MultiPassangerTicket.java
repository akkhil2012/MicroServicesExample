package com.usr.mgmt.management_project_db.model;

import javax.persistence.Entity;

@Entity
public class MultiPassangerTicket extends Ticket{

	
	private String multiPassangerPerTicket;
	
	
	public String getMultiPassangerPerTicket() {
		return multiPassangerPerTicket;
	}

	public void setMultiPassangerPerTicket(String multiPassangerPerTicket) {
		this.multiPassangerPerTicket = multiPassangerPerTicket;
	}

	
	
}
