package com.sample.glossaryService.GlossaryService.auth;

public class SessionManager {
	
	
	private static ThreadLocal<ISessionInfo> currentSessionTL = new ThreadLocal<ISessionInfo>();
	
	
	public static void setCurrentSession(ISessionInfo authSession) {
        /*if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Setting current session");
        }*/
        currentSessionTL.set(authSession);
       
    }
	
	
	 public static ISessionInfo getCurrentSession() {
	        ISessionInfo authSession = currentSessionTL.get();
	        return authSession;
	    }

}
