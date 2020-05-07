package com.sample.glossaryService.GlossaryService.factory;

import com.sample.glossaryService.GlossaryService.api.GlobalService;
import com.sample.glossaryService.GlossaryService.api.GlossaryServicesFactory;
import com.sample.glossaryService.GlossaryService.api.term.model.GlossaryServices;
import com.sample.glossaryService.db2.GlobalServiceImpl;
import com.sample.glossaryService.db2.SynchronizedDb2GlossaryServices;

public class Db2GlossaryServicesFactory implements GlossaryServicesFactory{

	@Override
	public GlobalService getGlobalService() {
		// TODO Auto-generated method stub
		return GlobalServiceImpl.getInstance();
	}

	@Override
	public GlossaryServices createNewGlossaryServices(String tenantId) {
		// TODO Auto-generated method stub
		return new SynchronizedDb2GlossaryServices(tenantId);
	}

}
