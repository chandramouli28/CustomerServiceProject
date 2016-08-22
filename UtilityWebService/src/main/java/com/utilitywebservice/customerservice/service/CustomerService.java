package com.utilitywebservice.customerservice.service;

import com.utilitywebservice.customerservice.dao.CustomerServiceDao;
import com.utilitywebservice.customerservice.model.Customer;

public class CustomerService{
	
	public Customer getCustomerDetails(int c_id){
		
		CustomerServiceDao cust_DAO = new CustomerServiceDao();
		
		Customer cust = cust_DAO.getCustomerDAO(c_id);
		
		return cust;
	}

}
