package com.utilitywebservice.customerservice.service;

import java.util.List;

import com.utilitywebservice.customerservice.dao.ServicePlanDAO;
import com.utilitywebservice.customerservice.model.ServicePlan;

public class UtilityService {

	public List<ServicePlan> getServicePlan() {
		ServicePlanDAO servicePlanDAO = new ServicePlanDAO();

		 List<ServicePlan> servicePlans = servicePlanDAO.getServicePlanDAO();

		return servicePlans;
	}
}
