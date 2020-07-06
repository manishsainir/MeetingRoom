package com.rest.meetingroom.meetingRoom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.meetingroom.meetingRoom.model.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean verifyCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session.createQuery("from Customer where customerId='" + customerId + "'");
		int i = q.list().size();
		if (i < 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		boolean response = false;
		try {
			session.save(customer);
			response = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public boolean verifyCustomer(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session
				.createQuery("from Customer where email='" + email + "' and password='" + password + "'");
		int i = q.list().size();
		if (i < 1) {
			return false;
		} else {
			return true;
		}
	}
}
