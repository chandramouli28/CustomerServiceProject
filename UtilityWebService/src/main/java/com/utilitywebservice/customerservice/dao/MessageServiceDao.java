package com.utilitywebservice.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.utilitywebservice.customerservice.model.Customer;
import com.utilitywebservice.customerservice.util.HibernateUtil;

public class MessageServiceDao {
	
	public int saveCustomerService(int c_id, int serv_id){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//Customer cust = new Customer();
		
		session.getTransaction().begin();
		int row = 0;
		try {
			
			Customer cust = (Customer)session.get(Customer.class, c_id); 
	         cust.setService_id(String.valueOf(serv_id));
	         session.update(cust); 
	         
				
			System.out.println(row);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			
			session.close();
		}
		return row;	
	}
}
