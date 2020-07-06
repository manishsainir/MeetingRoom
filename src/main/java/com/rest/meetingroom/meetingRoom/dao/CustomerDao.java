package com.rest.meetingroom.meetingRoom.dao;

import com.rest.meetingroom.meetingRoom.model.Customer;

public interface CustomerDao {
	boolean save(Customer customer);

	boolean verifyCustomer(int customerId);

	boolean verifyCustomer(String email, String password);

}
