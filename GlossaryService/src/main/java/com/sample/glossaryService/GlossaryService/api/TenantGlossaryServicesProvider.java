package com.sample.glossaryService.GlossaryService.api;

import java.util.Collections;
import java.util.Map;

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
		 GlossaryServices services = tenantsById.get(tenantId);
	 return services;
	 }
	 
	 public String getTenantId()  {
	        ISessionInfo session = SessionManager.getCurrentSession();

	        if (session == null) {
	          //  throw new GlossaryException(Message.WKCBG1002E);
	        }
	        String tenantId = session.getTenantId();
	        if (tenantId == null) {
	          //  throw new GlossaryException(Message.WKCBG1003E);
	        }
	        return tenantId;
	    }

}
