package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.api.term.model.GlossaryServices;

public interface GlossaryServicesFactory {
	GlobalService getGlobalService();
	
	GlossaryServices createNewGlossaryServices(String tenantId);

}
