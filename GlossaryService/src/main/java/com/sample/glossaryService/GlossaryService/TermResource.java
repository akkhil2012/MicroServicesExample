package com.sample.glossaryService.GlossaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.glossaryService.GlossaryService.api.TenantGlossaryServicesProvider;
import com.sample.glossaryService.GlossaryService.api.term.GlossaryTerm;
import com.sample.glossaryService.GlossaryService.api.term.NewTermEntity;
import com.sample.glossaryService.GlossaryService.api.term.ResponseGlossaryTerm;
import com.sample.glossaryService.GlossaryService.api.term.TermService;
import com.sample.glossaryService.GlossaryService.api.term.model.TermEntity;
import com.sample.glossaryService.GlossaryService.api.workflow.WorkflowController;
import com.sample.glossaryService.GlossaryService.auth.ISessionInfo;
import com.sample.glossaryService.GlossaryService.auth.SessionInfo;
import com.sample.glossaryService.GlossaryService.auth.SessionManager;
import com.sample.glossaryService.GlossaryService.rest.annotations.Authenticated;

import io.swagger.annotations.ApiParam;



/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
@RestController
@RequestMapping(value = "/users")
public class TermResource {

   // private final UserService userService;

  

    @PostMapping(value = "/me")
    @Authenticated
    public @ResponseBody NewTermEntity getMe(@RequestBody NewTermEntity termEntity) {
    //	System.out.println("Entered the COntroller..........ME.........");
    //	TermService termService = TenantGlossaryServicesProvider.INSTANCE.getGlossaryServices().getTermService();
    	TermService termService = TenantGlossaryServicesProvider.INSTANCE.getGlossaryServices().getTermService();
    	List<GlossaryTerm> newTerms = new ArrayList<GlossaryTerm>();
    	
    	WorkflowController<TermEntity, GlossaryTerm, ResponseGlossaryTerm, TermService> controller =
                new WorkflowController<>(termService, GlossaryTerm.class);
    	
    	// hardcoded
    	/*boolean skipWorkflowIfPossible = true;
    	// for (NewTermEntity newTermEntity : termEntities) {
    		 // Create Artifact MUST call Database to persists entity ????
             GlossaryTerm term = controller.createArtifact(termEntity, skipWorkflowIfPossible);
             newTerms.add(term);*/
       //  }
    	
    	// Calling a workflow Controller that calls WorrkFlow Service using JAX RS client
    //	System.out.println("Before responding back the Response+++++++++++++++++");
    	return new NewTermEntity("term1","1.0"); //    return user;
    }

    
    @GetMapping(value = "/metoo")
    @Authenticated
    public String getMeToo() {
    	System.out.println("Entered the COntroller...........METOO........");
    	return "created..............";
    //    return user;
    }
   
}