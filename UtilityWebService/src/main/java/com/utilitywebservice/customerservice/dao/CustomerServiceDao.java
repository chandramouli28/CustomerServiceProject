package com.utilitywebservice.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.utilitywebservice.customerservice.model.Customer;
import com.utilitywebservice.customerservice.util.HibernateUtil;

public class CustomerServiceDao{

	public Customer getCustomerDAO(int id){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Customer cust = new Customer();
		
		try {
			session.getTransaction().begin();
			cust = (Customer)session.get(Customer.class, id);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return cust;	
	}
}
