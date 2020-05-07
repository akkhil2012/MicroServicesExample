package com.sample.glossaryService.GlossaryService.api.term.model;

import com.sample.glossaryService.GlossaryService.termimport.IgcTermStatus;

public enum ManagedEntityState {
	
	DRAFT(IgcTermStatus.CANDIDATE),
    PUBLISHED(IgcTermStatus.STANDARD),
    DRAFT_HISTORY(IgcTermStatus.DEPRECATED),
    PUBLISHED_HISTORY(IgcTermStatus.DEPRECATED),
    DELETED(IgcTermStatus.DEPRECATED),
    ARCHIVED(IgcTermStatus.DEPRECATED);

    IgcTermStatus igcStatus;
    
    ManagedEntityState(IgcTermStatus igcStatus) {
        this.igcStatus = igcStatus;
    }

    public IgcTermStatus getIgcStatus() {
        return igcStatus;
    }

}
