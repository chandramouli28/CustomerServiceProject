package com.utilityservicemanager.customerservice.registration.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.utilityservicemanager.customerservice.registration.model.Customer;

public class CustomerServiceDao {
	
	@Autowired
	SessionFactory mySessionFactory;

	public Integer saveCustomer(Customer customer) {

		Session session = mySessionFactory.openSession();
	
		Integer c_Id = null;
		try {
			Customer cust = new Customer();
			cust.setUsername(customer.getUsername());
			cust.setPassword(customer.getPassword());
			cust.setEmail(customer.getEmail());
			cust.setPhoneNum(customer.getPhoneNum());
			c_Id = (Integer) session.save(cust);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} 
		return c_Id;
	}
}
