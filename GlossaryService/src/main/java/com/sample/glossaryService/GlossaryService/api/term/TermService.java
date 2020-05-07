package com.sample.glossaryService.GlossaryService.api.term;

import com.sample.glossaryService.GlossaryService.api.term.model.TermEntity;
import com.sample.glossaryService.GlossaryService.workflow.WorkflowableService;

public interface TermService extends WorkflowableService<TermEntity,ResponseGlossaryTerm> {

}
