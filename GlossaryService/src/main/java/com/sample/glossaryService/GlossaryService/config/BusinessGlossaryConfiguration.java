package com.sample.glossaryService.GlossaryService.config;

import org.apache.commons.configuration2.Configuration;

public class BusinessGlossaryConfiguration {
	
	private static volatile BusinessGlossaryConfiguration INSTANCE;
	
	private Configuration config;
	
	
	 public static BusinessGlossaryConfiguration getInstance() /*throws GlossaryException*/ {
	        if (INSTANCE == null) {
	            synchronized (BusinessGlossaryConfiguration.class) {
	                if (INSTANCE == null) {
	                    INSTANCE = new BusinessGlossaryConfiguration();
	                }
	            }
	        }
	        
	        return INSTANCE;
	    }
	 
	 public Configuration getConfiguration() {
	        return config;
	    }

}
