package com.usr.mgmt.management_project_db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "sourceDestination")
public class SourceDestination {
	
	 @Id
	  @Column(name="surDestId")
	  private int surDestId = 1;
	 
	@Column(name = "source")
    private String source;
	
	@Column(name = "destination")
    private String destination;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
