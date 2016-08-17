package com.customerservice.customerdetails.service;

import com.customerservice.customerdetails.dao.MessageServiceDao;

public class MessageService {

	public int setCustomerService(int c_id, int serv_id) {
	
		MessageServiceDao messServiceDao = new MessageServiceDao();
		int rowUpdate = messServiceDao.saveCustomerService(c_id, serv_id);
		return rowUpdate;
	}
}
