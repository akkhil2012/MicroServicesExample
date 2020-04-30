package com.usr.mgmt.management_project_db.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.transaction.Transactional;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usr.mgmt.management_project_db.BusDao;
import com.usr.mgmt.management_project_db.CustomerDao;
import com.usr.mgmt.management_project_db.SourceDestinationDao;
import com.usr.mgmt.management_project_db.model.Bus;
import com.usr.mgmt.management_project_db.model.Customer;
import com.usr.mgmt.management_project_db.model.SourceDestination;
import com.usr.mgmt.management_project_db.model.Ticket;

@RestController
public class StorageResource {
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private SourceDestinationDao sourceDestinationDao;
	
	
//	@GetMapping("/home")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	    public String home(Model model) {
		  model.addAttribute("message","akkhil");
	        return "/home";
	 }

	
	
	
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<Customer>  updatePerson(@RequestBody Customer customer,ContainerRequestContext requestContext) {
		System.out.println("Entering the Storage layer.........................");
		
		// Saving only the Customer
	//	customer = new Customer();
		customer.setUsername(customer.getUsername());
		customer.setPassword(customer.getPassword());
		
		
		customerDao.saveCustomer(customer);
		
		System.out.println("exiting  the Storage layer.........................");
	 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	// blow is for a User
	/*@RequestMapping(value="/customer/add", method=RequestMethod.POST)
	@Transactional
	public ResponseEntity <Customer> addUser(@RequestBody Customer customer) {
		customer = new Customer();
		customer.setFirstName(name);
		customerDao.saveInstructor(customer);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}*/





	
	
	// Add the list of Users
/*	@RequestMapping(value="/customer/add", method=RequestMethod.POST)
	@Transactional
	public @ResponseBody ResponseEntity<Customer[]> addUser(@RequestBody Customer[] customers) {
		customer = new Customer();
		customer.setFirstName(name);
		for(Customer customer : customers)
		   customerDao.saveInstructor(customer);
			//customerDao.saveInstructor(customer);
		return new ResponseEntity<>(customers,HttpStatus.CREATED);
	}
	
	//displayRecords
	//1. Fetch Customers
	@GetMapping(value="/customers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Customer>> fetchCustomers() {
		// Saving only the Customer
		List<Customer> customers = customerDao.fetchCustomers();
		return ResponseEntity.ok(customers);
	}
	
	
	//2.Fetch one Customer
	@GetMapping(value="/customers/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable int id) {
		// Saving only the Customer
		Customer customer = customerDao.getCustomerByID(id);
		return ResponseEntity.ok(customer);
	}
	
	//3. fetch the tickets booked by Customer
	@GetMapping(value="/customers/{id}/tickets",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Ticket>> fetchCustomerTicketsById(@PathVariable int id) {
		// Saving only the Customer
		List<Ticket> tickets = customerDao.getTicketsForCustomer(id);
		return ResponseEntity.ok(tickets);
	}
	
	
	// 4. create source and destination
	@RequestMapping(value="/sourceDestination/add", method=RequestMethod.POST)
	@Transactional
	public ResponseEntity <SourceDestination> addSrcDest(@RequestBody SourceDestination sourceDestination) {
		sourceDestinationDao.saveSourceAndDestination(sourceDestination);
		return new ResponseEntity<>(sourceDestination,HttpStatus.CREATED);
	}
	
	
	// 5 create bus
	@RequestMapping(value="/bus/add", method=RequestMethod.POST)
//	/@Transactional
	public ResponseEntity <Bus> addBus(@RequestBody Bus bus) {
		busDao.saveBus(bus);
		return new ResponseEntity<>(bus,HttpStatus.CREATED);
	}
	
	// create bus
	@RequestMapping(value="/bus/add", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<Bus[]> addUser(@RequestBody Bus[] buses) {
		customer = new Customer();
		customer.setFirstName(name);
		for(Bus bus : buses)
		   busDao.saveBus(bus);
			//customerDao.saveInstructor(customer);
		return new ResponseEntity<>(buses,HttpStatus.CREATED);
	}
	
	
	//7. to Edit User profile
	 @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Customer> updateUser(@PathVariable("id") int id, @RequestBody Customer customer) {
	        System.out.println("Updating Cuustomer " + id);
	         
	        Customer currentUser = customerDao.getCustomer(id);
	         
	        if (currentUser==null) {
	            System.out.println("Customer with id " + id + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setFirstName(customer.getFirstName());
	        currentUser.setLastName(customer.getLastName());
	        currentUser.setEmail(customer.getEmail());
	        currentUser.setTickets(customer.getTickets());
	         
	        customerDao.updateInstructor(customer);
	        return new ResponseEntity<Customer>(currentUser, HttpStatus.OK);
	    }
	
	//6. fetch a ticket for Customer
		@GetMapping(value="/customers/{id}/tickets/{ticket_id}",produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<List<Ticket>> fetchCustomerTicketsById(@PathVariable("id") int id,
				@PathVariable("ticket_id") int ticket_id) {
			// Saving only the Customer
			List<Ticket> tickets = customerDao.getTicketsForCustomer(id);
			return ResponseEntity.ok(tickets);
		}
		
		
*/		
		

}
