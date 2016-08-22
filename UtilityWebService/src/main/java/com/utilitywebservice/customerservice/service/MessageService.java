package com.utilitywebservice.customerservice.service;

import com.utilitywebservice.customerservice.dao.MessageServiceDao;

public class MessageService {

	public int setCustomerService(int c_id, int serv_id) {
	
		MessageServiceDao messServiceDao = new MessageServiceDao();
		int rowUpdate = messServiceDao.saveCustomerService(c_id, serv_id);
		return rowUpdate;
	}
}
