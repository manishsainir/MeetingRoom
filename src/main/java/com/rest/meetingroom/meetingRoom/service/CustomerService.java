package com.rest.meetingroom.meetingRoom.service;

import com.rest.meetingroom.meetingRoom.model.Customer;

public interface CustomerService {

	boolean verifyCustomer(int customerId);
	boolean verifyCustomer(String email, String password);
	boolean save(Customer customer);

}
