package com.customerservice.customerdetails.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.customerservice.customerdetails.registration.model.Customer;
import com.customerservice.customerdetails.registration.service.CustomerServiceHandler;


@Controller
public class CustomerServiceController {
	
	@Autowired
	private CustomerServiceHandler customerServHandler;

		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView controlRegistration(@ModelAttribute("registerPage") Customer customer) {
		
			Customer cust = customerServHandler.saveCustomer(customer);
			return new ModelAndView("register","customer",cust );
		}
	}