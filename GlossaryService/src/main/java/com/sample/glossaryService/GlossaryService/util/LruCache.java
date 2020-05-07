package com.sample.glossaryService.GlossaryService.util;

import java.util.Date;
import java.util.LinkedHashMap;

public class LruCache<K,V> extends LinkedHashMap<K, V> {

	
	 private long evictionsSinceWarning = 0;
	 
	 private int evictionWarningThrottle;

	    // When the last eviction warning was issued.
	    private Date lastEvictionWarning = new Date();

	    // The maximum number of entries the cache holds.
	    private int capacity;
	
	  public LruCache(int cacheSize, int evictionWarningThrottle) {
	        super(cacheSize, 0.75f, true);
	        this.evictionWarningThrottle = evictionWarningThrottle;
	        this.capacity = cacheSize;
	    }
	  
	  
}
