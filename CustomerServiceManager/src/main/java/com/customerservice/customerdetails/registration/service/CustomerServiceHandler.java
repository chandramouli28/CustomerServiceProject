
package com.customerservice.customerdetails.registration.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.customerservice.customerdetails.registration.dao.CustomerServiceDao;
import com.customerservice.customerdetails.registration.jms.JmsQueueSender;
import com.customerservice.customerdetails.registration.model.Customer;
import com.customerservice.customerdetails.webservice.ServicePlan;
import com.customerservice.customerdetails.webservice.ServicePlanWS;
import com.customerservice.customerdetails.webservice.ServicePlanWSService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CustomerServiceHandler {

	String urlHost = "http://localhost:8080/UtilityWebService/";
	final static Logger logger = Logger.getLogger(CustomerServiceHandler.class);
	
	public CustomerServiceHandler(CustomerServiceDao custServiceDao, JmsQueueSender queueSender) {
		this.custServiceDao = custServiceDao;
		this.queueSender = queueSender;
	}

	private JmsQueueSender queueSender;
	private CustomerServiceDao custServiceDao;

	public Customer saveCustomer(Customer customer) {

		Integer c_id = custServiceDao.saveCustomer(customer);
		logger.info("customer created in the database");

		Customer cust = getCustomer(c_id);
		logger.info("customer details fetched from REST call");
		
		List<ServicePlan> servList = getServiceList();

		if (servList != null) {
			cust.setService_id(String.valueOf(servList.get(0).getId()));
			queueSender.sendMessage(String.valueOf(c_id) + " " + String.valueOf(servList.get(0).getId()));
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

			WebResource webResource = client.resource("http://localhost:7001/UtilityWebService/resources/cust/" + c_id);
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