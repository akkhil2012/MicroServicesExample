package com.sample.glossaryService.db2;

import com.sample.glossaryService.GlossaryService.api.term.TermService;
import com.sample.glossaryService.GlossaryService.api.term.model.GlossaryServices;
import com.sample.glossaryService.GlossaryService.api.term.model.TermServiceImpl;

public class AbstractDb2GlossaryServices implements GlossaryServices{
	
	protected final String tenantId_;
	
	public AbstractDb2GlossaryServices(String tenantId) {
		System.out.println(" ------- > "+ tenantId);
		
		this.tenantId_ = tenantId;
	}

	@Override
	public TermService getTermService() {
		// TODO Auto-generated method stub
		// YET TO IMPLEMENT
		//ARTIFACT TYPE GLOSSARYTMAP
		return new TermServiceImpl();
	}

}
