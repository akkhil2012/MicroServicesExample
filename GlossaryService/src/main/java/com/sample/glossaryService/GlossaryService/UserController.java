package com.sample.glossaryService.GlossaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author Justin Park (aka.asterisk@gmail.com)
 * @since 2018-10-10
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

   // private final UserService userService;

  

    // 자신의 정보를 반환
    @GetMapping(value = "/me")
    public String getMe() {
    	System.out.println("Entered the interceptor...................");
    	return "created";
    //    return user;
    }

   
}