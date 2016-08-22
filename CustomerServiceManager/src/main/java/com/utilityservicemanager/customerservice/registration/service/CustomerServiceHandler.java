
package com.utilityservicemanager.customerservice.registration.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.utilityservicemanager.customerservice.registration.dao.CustomerServiceDao;
import com.utilityservicemanager.customerservice.registration.jms.JmsQueueSender;
import com.utilityservicemanager.customerservice.registration.model.Customer;
import com.utilityservicemanager.customerservice.registration.webservice.ServicePlan;
import com.utilityservicemanager.customerservice.registration.webservice.ServicePlanWS;
import com.utilityservicemanager.customerservice.registration.webservice.ServicePlanWSService;

public class CustomerServiceHandler {

	String urlHost = "http://localhost:8080/UtilityWebService/RestWS/cust/";
	final static Logger logger = Logger.getLogger(CustomerServiceHandler.class);
	
	public CustomerServiceHandler(CustomerServiceDao custServiceDao, JmsQueueSender queueSender) {
		this.custServiceDao = custServiceDao;
		this.queueSender = queueSender;
	}

	private JmsQueueSender queueSender;
	private CustomerServiceDao custServiceDao;

	public Customer saveCustomer(Customer customer) {
		
		Customer cust = null;
		ServicePlan servicepPlan = null;
		
		Integer c_id = custServiceDao.saveCustomer(customer);
		
		if(c_id != 0){
			logger.info("customer created in the database");
			cust = getCustomer(c_id);
		}else{
			logger.info("Failed to create customer");
			return null;
		}
		
		if(cust != null){
			logger.info("customer details fetched from REST call");
		}else{
			logger.info("Rest call failed");
		}
		
		List<ServicePlan> servList = getServiceList();

		if (servList != null) {
			
			servicepPlan = servList.get(0);
			cust.setService_id(servicepPlan.getId());
			queueSender.sendMessage(String.valueOf(c_id) + " " + servicepPlan.getId());
			logger.info("Service Plans retrieved from db");
		}else{
			logger.error("No Service Plans retrieved");
		}
		
		return cust;
	}

	public Customer getCustomer(int c_id) {

		Customer customer = null;

		try {
			Client client = Client.create();

			WebResource webResource = client.resource(urlHost + c_id);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			customer = response.getEntity(Customer.class);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return customer;

	}

	public static List<ServicePlan> getServiceList() {

		ServicePlanWSService swsService = new ServicePlanWSService();
		ServicePlanWS servicePlanWS = swsService.getServicePlanWSPort();

		List<ServicePlan> serviceList = servicePlanWS.getServicePlan();
		return serviceList;
	}

}