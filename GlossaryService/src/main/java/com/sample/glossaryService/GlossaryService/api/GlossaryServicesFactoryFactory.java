package com.sample.glossaryService.GlossaryService.api;

import com.sample.glossaryService.GlossaryService.factory.Db2GlossaryServicesFactory;

public class GlossaryServicesFactoryFactory {
	
	private static volatile GlossaryServicesFactory factory;
	
	public static GlossaryServicesFactory createGlossaryServicesFactory() {
		if(factory==null) {
			//sync yet to implement
			
			/*Class <? extends GlossaryServicesFactory>
			        impl = GlobalConfiguration.g
			factory = impl.newInstance();      */  
			
			// Skipping the above Reflection loading part
			// instead directly creating the instance;
			
			factory = new Db2GlossaryServicesFactory();
		}
		
		return factory;
	}

}
