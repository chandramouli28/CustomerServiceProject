package com.utilitywebservice.customerservice.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.utilitywebservice.customerservice.model.ServicePlan;
import com.utilitywebservice.customerservice.service.UtilityService;

@WebService
public class ServicePlanWS {

	@WebMethod
	public List<ServicePlan> getServicePlan() {

		UtilityService utilityService = new UtilityService();

		 List<ServicePlan> servicePlans = new ArrayList<ServicePlan>();
		 servicePlans = utilityService.getServicePlan();
		
		return servicePlans;
	}
	
}
