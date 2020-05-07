package com.sample.glossaryService.GlossaryService.api;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;


import com.sample.glossaryService.GlossaryService.api.term.model.GlossaryServices;
import com.sample.glossaryService.GlossaryService.auth.ISessionInfo;
import com.sample.glossaryService.GlossaryService.auth.SessionManager;
import com.sample.glossaryService.GlossaryService.util.LruCache;

public class TenantGlossaryServicesProvider implements GlossaryServicesProvider{
	
	public static final TenantGlossaryServicesProvider INSTANCE = new TenantGlossaryServicesProvider();
	
	
	 private final Map<String, GlossaryServices> tenantsById;
	 
	 private final LruCache<String,GlossaryServices> unsynchronizedTenantsById;
	    
	    //Allows access to cache methods not available through the Map interface    
	//    private final LruCache<String, GlossaryServices> unsynchronizedTenantsById;
	
	/*
	 * SingletonConstructor
	 */
	private TenantGlossaryServicesProvider() {
        unsynchronizedTenantsById = new LruCache<String, GlossaryServices>(
                GlobalConfiguration.getTenantCacheSize(),
                GlobalConfiguration.getTenantCacheEvictionWarningThreshold());
        tenantsById = Collections.synchronizedMap(unsynchronizedTenantsById);
    }
	
	
	
	 public GlossaryServices getGlossaryServices() /*throws GlossaryException*/ {
	        return getGlossaryServices(getTenantId());
	    }
	 
	 
	 
	 public GlossaryServices getGlossaryServices(String tenantId) {
		 GlossaryServices services = lookUpService(tenantId);
			return services;
		/* GlossaryServices services = tenantsById.get(tenantId);
	 return services;*/
	 }
	 
	 
	 private GlossaryServicesFactory getGlossaryServicesFactory() {
		 return GlossaryServicesFactoryFactory.createGlossaryServicesFactory();
	 }
	 
	 
	 private GlossaryServices lookUpService(String tenantId) {
			
			GlossaryServices services = tenantsById.get(tenantId);
			if(services==null) {
				// Need to test Syncronization here
				// Need to replace this with Factory Method
			//	synchronized (tenantsById) {
					System.out.println("Thread entered time " + LocalDateTime.now());
					System.out.println("Threadname"+ Thread.currentThread().getName());
					services = tenantsById.get(tenantId);
					if (services == null) {
						/*
						 * Loaded at runtime using ConfigurationUtils.getWithDefault
						 * 
						 * 
						 */
						
						
						services = getGlossaryServicesFactory().createNewGlossaryServices(tenantId);
						
						
						//GlossaryServices termService = new TermService2().getGlossaryServices(tenantId);
						//GlossaryServices dataClassService = new DataClassService().getGlossaryServices(tenantId);
						tenantsById.put(tenantId, services);
						// tenantsById.put(tenantId, dataClassService);
						//services = termService;
					}
					
					System.out.println("Thread EXIT  time " + LocalDateTime.now());
				}
			//}
			return services;
			
		}
	 
	 public String getTenantId()  {
	        ISessionInfo session = SessionManager.getCurrentSession();

	        if (session == null) {
	          //  throw new GlossaryException(Message.WKCBG1002E);
	        }
	        String tenantId = session.getTenantId();
	        if (tenantId == null) {
	        //  tenantId="f68a9f05-09b6-4ecd-bd03-831d49d73fa4";
	        	System.out.println("tenant id null");
	        }
	        return tenantId;
	    }

}
