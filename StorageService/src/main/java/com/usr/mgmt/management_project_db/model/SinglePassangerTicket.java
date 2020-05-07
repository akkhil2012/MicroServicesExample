package com.usr.mgmt.management_project_db.model;

import javax.persistence.Entity;

@Entity
public class SinglePassangerTicket  extends Ticket{

	private String singlePassangerPerTicket;

	public String getSinglePassangerPerTicket() {
		return singlePassangerPerTicket;
	}

	public void setSinglePassangerPerTicket(String singlePassangerPerTicket) {
		this.singlePassangerPerTicket = singlePassangerPerTicket;
	}

}
