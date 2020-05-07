package com.sample.glossaryService.GlossaryService.api.term;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class NewTermEntity extends UpdatableTermEntity{

	private String name;
	private String revision;
	
	
	public NewTermEntity() {
		
	}
	
	public NewTermEntity(String name, String revision) {
		super();
		this.name = name;
		this.revision = revision;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
}
