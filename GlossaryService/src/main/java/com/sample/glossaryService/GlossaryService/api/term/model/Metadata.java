package com.sample.glossaryService.GlossaryService.api.term.model;

import java.time.ZonedDateTime;

public class Metadata {
	
	private String artifactId;
	
	private String versionId;
	
	private ManagedEntityState state;
	
	
	private ZonedDateTime createdAt;

    public ManagedEntityState getState() {
		return state;
	}

	public void setState(ManagedEntityState state) {
		this.state = state;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	private String modifiedBy;

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

}
