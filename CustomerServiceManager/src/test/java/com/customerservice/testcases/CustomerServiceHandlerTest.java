package com.customerservice.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.utilityservicemanager.customerservice.registration.model.Customer;
import com.utilityservicemanager.customerservice.registration.service.CustomerServiceHandler;

public class CustomerServiceHandlerTest {

	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setUsername("Chandra");
		customer.setPassword("Mouli");
		customer.setEmail("cm@mail.com");
		customer.setPhoneNum("8765423456");

		CustomerServiceHandler custImpl = Mockito.mock(CustomerServiceHandler.class);

		when(custImpl.getCustomer(1)).thenReturn(customer);

		assertEquals(custImpl.getCustomer(1), customer);
	}

}
