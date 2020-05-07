package com.sample.glossaryService.GlossaryService.util;

import com.sample.glossaryService.GlossaryService.config.BusinessGlossaryConfiguration;
import org.apache.commons.configuration2.Configuration;

public class ConfigurationUtils {
	
	
	private Configuration config;
	
	 public static int getWithDefault(String property, String propertyWithUnderScore, int defaultValue) {

	        try {
	            Configuration config = BusinessGlossaryConfiguration.getInstance().getConfiguration();
	            Integer value = config.getInteger(property, null);
	            if (value == null) {
	                value = config.getInt(propertyWithUnderScore, defaultValue);
	            }
	            return value;
	        } catch (Exception e) {
	            //LOGGER.warn("Error when retrieving config property" + property + " - defaulting to " + defaultValue, e);
	            return defaultValue;
	        }
	    }
	 
	 
	 
	 public Configuration getConfiguration() {
	        return config;
	    }

}
