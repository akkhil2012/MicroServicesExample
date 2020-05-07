package com.sample.glossaryService.GlossaryService.termimport;

import com.sample.glossaryService.GlossaryService.api.term.model.ManagedEntityState;

public enum IgcTermStatus {
	
	CANDIDATE(ManagedEntityState.DRAFT),
    ACCEPTED(ManagedEntityState.PUBLISHED),
    STANDARD(ManagedEntityState.PUBLISHED),
    DEPRECATED(ManagedEntityState.ARCHIVED);

    private ManagedEntityState correspondingStatus;

    IgcTermStatus(ManagedEntityState correspondingStatus) {
        this.correspondingStatus = correspondingStatus;
    }

    public ManagedEntityState getCorrespondingState() {
        return correspondingStatus;
    }

}
