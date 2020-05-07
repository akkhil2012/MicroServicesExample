package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.api.term.TermService;

public interface GlossaryServices {
	
	TermService getTermService(); /*throws GlossaryException;*/

}
