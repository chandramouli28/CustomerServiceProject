package com.customerservice.customerdetails.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.customerservice.customerdetails.model.Customer;
import com.customerservice.customerdetails.service.CustomerService;

@Path("/cust")
@Produces("application/json")
public class CustomerServiceWS {

	
	  @Path("{param}")
	  @GET
	  @Produces("application/json")
	public Customer getCustomerDetails(@PathParam("param") int c_id) {

		CustomerService custService = new CustomerService();

		Customer customer = custService.getCustomerDetails(c_id);
		
		return customer;
	}
	
}
