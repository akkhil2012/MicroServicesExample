package com.sample.glossaryService.GlossaryService.api.workflow;

import com.sample.glossaryService.GlossaryService.api.term.model.ManagedEntity;
import com.sample.glossaryService.GlossaryService.util.ReflectionUtils;
import com.sample.glossaryService.GlossaryService.workflow.WdpApiModeledObject;
import com.sample.glossaryService.GlossaryService.workflow.WorkflowableService;

public class WorkflowController<ET extends ManagedEntity, MOT extends WdpApiModeledObject<ET>,
RMOT extends WdpApiModeledObject<? extends ManagedEntity>, WST extends WorkflowableService<ET, RMOT>> {

	
	private static WorkflowService workflowService=null;
	
	private Class<MOT> motClass; /// Why as Class.???
	
	public WorkflowController(WorkflowableService<ET, RMOT> workflowableService, Class<MOT> motClass) {
		this.workflowService = workflowService;
		this.motClass = motClass;
		// Workflowservice is called as many times its invoked
		createWorkflowService();
	}
	
	
	public static WorkflowService createWorkflowService() {
		if(workflowService==null) {
				synchronized(WorkflowController.class) {
				workflowService = WorkflowServiceSingleton.getInstance();
			}
		}
		
		return workflowService;
	}
	
	
	 public MOT createArtifact(ET managedEntity, boolean skipWorkflowIfPossible) {
		 
		 MOT managedObject = ReflectionUtils.wrapManagedEntity(managedEntity, motClass);
		 // Yet to implement: candidate for integration testing
		// Workflow workflow = workflowService.createWorkflow(managedObject, null, null, null, skipWorkflowIfPossible);
		 return managedObject;
	 }
	 
	
	 
	
}
