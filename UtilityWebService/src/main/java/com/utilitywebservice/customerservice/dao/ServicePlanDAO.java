package com.utilitywebservice.customerservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.utilitywebservice.customerservice.model.ServicePlan;
import com.utilitywebservice.customerservice.util.HibernateUtil;

public class ServicePlanDAO {
	
	@SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlanDAO(){
		
		List<ServicePlan> serviceList = new ArrayList<ServicePlan>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.getTransaction().begin();
			serviceList = session.createQuery("from ServicePlan").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} 
		
		if(serviceList.isEmpty()){
			return null;
		}
		else{
			return serviceList;	
		}
		
	}

}
