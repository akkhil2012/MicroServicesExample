package com.sample.glossaryService.db2;

import com.sample.glossaryService.GlossaryService.api.GlobalService;

public class GlobalServiceImpl implements GlobalService{
	
	
	 private static volatile GlobalService instance;
	    public GlobalServiceImpl() {
	    }

	public static GlobalService getInstance() {
        
	       if (instance == null) {
	           synchronized (GlobalServiceImpl.class) {
	               if (instance == null) {
	                   instance = new GlobalServiceImpl();
	               }
	           }
	        }
	       
	        return instance;
	    }
	
	
}

