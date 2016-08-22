package com.utilitywebservice.customerservice.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.utilitywebservice.customerservice.model.Customer;
import com.utilitywebservice.customerservice.service.CustomerService;

@Path("/cust")
@Produces("application/json")
public class CustomerServiceWS {

	final static Logger logger = Logger.getLogger(CustomerServiceWS.class);
	
	  @Path("{param}")
	  @GET
	  @Produces("application/json")
	public Customer getCustomerDetails(@PathParam("param") int c_id) {

		CustomerService custService = new CustomerService();

		Customer customer = custService.getCustomerDetails(c_id);
		
		if(customer == null){
			logger.info("Rest call failed to get customer");			
		}else{
			logger.info("Rest call fetched data");
		}

		return customer;
	}
	
}
