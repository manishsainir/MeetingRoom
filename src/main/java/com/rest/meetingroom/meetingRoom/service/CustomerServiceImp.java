package com.rest.meetingroom.meetingRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.meetingroom.meetingRoom.dao.CustomerDao;
import com.rest.meetingroom.meetingRoom.model.Customer;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public boolean verifyCustomer(int customerId) {

		return this.customerDao.verifyCustomer(customerId);
	}
	
	@Override
	public boolean save(Customer customer) {

		return this.customerDao.save(customer);
	}
	@Override
	public boolean verifyCustomer(String email, String password) {
		
		return this.customerDao.verifyCustomer(email,password);
	}
}
