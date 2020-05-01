package com.sample.glossaryService.GlossaryService.util;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.sample.glossaryService.GlossaryService.api.term.model.ManagedEntity;
import com.sample.glossaryService.GlossaryService.api.term.model.ManagedEntityState;
import com.sample.glossaryService.GlossaryService.workflow.WdpApiModeledObject;

/*
 * Inspect calss sing reflection
 */
public class ReflectionUtils {

	public static <ET extends ManagedEntity, MOT extends WdpApiModeledObject<ET>> MOT wrapManagedEntity(ET entity, Class<MOT> clazz) {
		MOT obj = null;   
        try {
            obj = clazz.newInstance();
            obj.setEntity(entity);
            String artifactId = UUID.randomUUID().toString();
            obj.getMetadata().setArtifactId(artifactId);
            // SYNC TO ORMS
           /* String repoId = GlobalConfiguration.getOmrsRepositoryId();
            obj.setSourceRepositoryId(repoId);
            obj.setGlobalId(OmrsUtils.formatGlobalId(repoId, artifactId));*/
            obj.getMetadata().setVersionId(UUID.randomUUID().toString());
            ZonedDateTime presentTime = ZonedDateTime.now();
           // obj.setCreatedAt(presentTime);
            //obj.setModifiedAt(presentTime);
            obj.getMetadata().setState(ManagedEntityState.DRAFT);
          //  setMetadataAttributes(obj.getMetadata(), entity, null);
          //  return obj;
        } catch (IllegalAccessException | InstantiationException e) {
            //throw new GlossaryException(Message.WKCBG1060E, e, clazz.getName());
        }
        return obj;
    }
	
	
}
