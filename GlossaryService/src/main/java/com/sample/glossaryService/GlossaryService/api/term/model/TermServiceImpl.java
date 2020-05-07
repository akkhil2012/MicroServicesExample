package com.sample.glossaryService.GlossaryService.api.term.model;

import com.sample.glossaryService.GlossaryService.api.term.ResponseGlossaryTerm;
import com.sample.glossaryService.GlossaryService.api.term.TermService;
import com.sample.glossaryService.db2.AbstractDb2GlossaryServices;
import com.sample.glossaryService.db2.WorkflowableServiceImpl;

public class TermServiceImpl extends WorkflowableServiceImpl<TermEntity,ResponseGlossaryTerm> implements TermService{

	
	 public TermServiceImpl() {
		 
	 }
	
	 public TermServiceImpl(AbstractDb2GlossaryServices parent){
		 // NEED TO UNCOMMENT IN SECOND PHASE...*************** important
	      //  super(parent);
	    }
	 
	// THIS IS THE ACTUAL INSTANCE RETRURNED
	/*public TermService getTermService() {
		// TODO Auto-generated method stub
		return new TermService();
	}*/

}
