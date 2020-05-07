package com.sample.glossaryService.GlossaryService.workflow;

import com.sample.glossaryService.GlossaryService.api.term.model.Metadata;
import com.sample.glossaryService.GlossaryService.api.term.model.ModeledObject;

public class WdpApiModeledObject <T extends Entity>  implements ModeledObject{
	
	 protected T entity;
	 
	 private Metadata metadata;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}
