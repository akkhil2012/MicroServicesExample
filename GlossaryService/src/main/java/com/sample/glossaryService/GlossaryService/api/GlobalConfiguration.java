package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.util.ConfigurationUtils;

public class GlobalConfiguration {
	
	public static final String TENANT_CACHE_SIZE_PROPERTY = "bg.tenant.cache.size";
    public static final String TENANT_CACHE_SIZE_UNDERSCORE_PROPERTY = "BG_TENANT_CACHE_SIZE";
    public static final int DEFAULT_TENANT_CACHE_SIZE = 1000;
    
    public static final String TENANT_CACHE_EVICTION_WARNING_THRESHOLD_PROPERTY = "bg.tenant.cache.eviction.warning.threshold";
    public static final String TENANT_CACHE_EVICTION_WARNING_THRESHOLD_UNDERSCORE_PROPERTY = "BG_TENANT_CACHE_EVICTION_WARNING_THRESHOLD";
    public static final int DEFAULT_TENANT_CACHE_EVICTION_WARNING_THRESHOLD = -1;
    
    public static final String GLOSSARY_SERVICES_FACTORY_IMPL_PROPERTY = "bg.glossary.services.factory.impl";
    
    public static final String GLOSSARY_SERVICES_FACTORY_IMPL_UNDERSCORE_PROPERTY = "BG_GLOSSARY_SERVICES_FACTORY_IMPL";
    private static final String DEFAULT_GLOSSARY_SERVICES_FACTORY_IMPL = "com.ibm.wdp.bg.api.impl.db2.Db2GlossaryServicesFactory";
    
    /// WHY VOLATILE HERE?????????
    private static volatile Class<? extends GlossaryServicesFactory> glossaryServicesFactoryClass;
	
	
	 public static int getTenantCacheSize() {
	        return ConfigurationUtils.getWithDefault(TENANT_CACHE_SIZE_PROPERTY, TENANT_CACHE_SIZE_UNDERSCORE_PROPERTY,
	            DEFAULT_TENANT_CACHE_SIZE);
	    }
	 
	 
	 public static int getTenantCacheEvictionWarningThreshold() {
	        return ConfigurationUtils.getWithDefault(TENANT_CACHE_EVICTION_WARNING_THRESHOLD_PROPERTY,
	            TENANT_CACHE_EVICTION_WARNING_THRESHOLD_UNDERSCORE_PROPERTY, DEFAULT_TENANT_CACHE_EVICTION_WARNING_THRESHOLD);
	    }
	 
	 
	/*public static Class<? extends GlossaryServicesFactory> getGlossaryServicesFactoryImpl(){
		// YET TO IMPLEMENT SYNCRONIZATION
		  if (glossaryServicesFactoryClass == null) {
              glossaryServicesFactoryClass = ConfigurationUtils.getWithDefault(GLOSSARY_SERVICES_FACTORY_IMPL_PROPERTY,
                  GLOSSARY_SERVICES_FACTORY_IMPL_UNDERSCORE_PROPERTY, DEFAULT_GLOSSARY_SERVICES_FACTORY_IMPL,
                  GlossaryServicesFactory.class);
          }
		
	}*/

}
