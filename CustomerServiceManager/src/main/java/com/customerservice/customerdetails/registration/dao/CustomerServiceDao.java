package com.customerservice.customerdetails.registration.dao;



import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customerservice.customerdetails.registration.model.Customer;
import com.customerservice.customerdetails.registration.util.HibernateUtil;

public class CustomerServiceDao {

	public Integer saveCustomer(Customer customer) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
		Integer c_Id = null;
		try {
			session.getTransaction().begin();
			Customer cust = new Customer();
			cust.setUsername(customer.getUsername());
			cust.setPassword(customer.getPassword());
			cust.setEmail(customer.getEmail());
			cust.setPhoneNum(customer.getPhoneNum());
			c_Id = (Integer) session.save(cust);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} 
		return c_Id;
	}
}
