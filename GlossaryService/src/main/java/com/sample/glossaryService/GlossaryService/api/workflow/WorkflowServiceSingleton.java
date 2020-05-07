package com.sample.glossaryService.GlossaryService.api.workflow;

public class WorkflowServiceSingleton implements WorkflowService{
	
	
	private static volatile WorkflowServiceSingleton instance;

	
	public static WorkflowServiceSingleton getInstance() {
		if(instance==null) {
			synchronized (WorkflowServiceSingleton.class) {
				if(instance==null) {
					instance = new WorkflowServiceSingleton();
				}
				
			}
		}
		return instance;
	}
}
