package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.api.term.model.GlossaryServices;

public interface GlossaryServicesProvider {

	
	GlossaryServices getGlossaryServices(String tenantId);
}
