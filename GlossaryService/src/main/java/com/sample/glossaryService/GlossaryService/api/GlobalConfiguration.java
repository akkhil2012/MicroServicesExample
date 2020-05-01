package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.util.ConfigurationUtils;

public class GlobalConfiguration {
	
	public static final String TENANT_CACHE_SIZE_PROPERTY = "bg.tenant.cache.size";
    public static final String TENANT_CACHE_SIZE_UNDERSCORE_PROPERTY = "BG_TENANT_CACHE_SIZE";
    public static final int DEFAULT_TENANT_CACHE_SIZE = 1000;
    
    public static final String TENANT_CACHE_EVICTION_WARNING_THRESHOLD_PROPERTY = "bg.tenant.cache.eviction.warning.threshold";
    public static final String TENANT_CACHE_EVICTION_WARNING_THRESHOLD_UNDERSCORE_PROPERTY = "BG_TENANT_CACHE_EVICTION_WARNING_THRESHOLD";
    public static final int DEFAULT_TENANT_CACHE_EVICTION_WARNING_THRESHOLD = -1;
	
	
	 public static int getTenantCacheSize() {
	        return ConfigurationUtils.getWithDefault(TENANT_CACHE_SIZE_PROPERTY, TENANT_CACHE_SIZE_UNDERSCORE_PROPERTY,
	            DEFAULT_TENANT_CACHE_SIZE);
	    }
	 
	 
	 public static int getTenantCacheEvictionWarningThreshold() {
	        return ConfigurationUtils.getWithDefault(TENANT_CACHE_EVICTION_WARNING_THRESHOLD_PROPERTY,
	            TENANT_CACHE_EVICTION_WARNING_THRESHOLD_UNDERSCORE_PROPERTY, DEFAULT_TENANT_CACHE_EVICTION_WARNING_THRESHOLD);
	    }

}
