package com.rest.meetingroom.meetingRoom.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.meetingroom.meetingRoom.model.Booking;
import com.rest.meetingroom.meetingRoom.model.Customer;
import com.rest.meetingroom.meetingRoom.model.Room;

@Repository
public class MainDaoImp implements MainDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Room> getRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query<Room> q = session.createQuery("from Room where available='" + 1 + "'");
		List<Room> list = q.list();

		return list;
	}

	

	public List<Customer> findCustomerById(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session.createQuery("from Customer where email='" + email + "'");
		List<Customer> customer = q.list();
		return customer;
	}

	public List<Room> findRoomById(int roomId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Room> q = session.createQuery("from Room where roomId='" + roomId + "'and available='" + 1 + "'");
		List<Room> room = q.list();
		return room;
	}

	public List<Booking> findBookingById(int roomId, int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Booking> q = session.createQuery("from Booking where roomId='" + roomId + "' and customerId='"
				+ customerId + "' and bookingStatus='booked' ");
		List<Booking> booking = q.list();

		return booking;
	}

	@Override
	public Object bookARoom(int roomId,String email) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = findCustomerById(email).get(0);
		List<Room> list = findRoomById(roomId);
		if (list.size() > 0) {
			Room room = list.get(0);
			Booking booking = new Booking();
			booking.setCustomerId(customer);
			booking.setRoomId(room);
			booking.setBookingStatus("booked");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String date = formatter.format(new Date());
			booking.setDateAndTime(date);
			session.save(booking);
			room.setAvailable(false);
			session.save(room);

			Booking bookingData = findBookingById(roomId, customer.getCustomerId()).get(0);
			return bookingData;
		} else {
			return "room is not available";
		}

	}
	
	

	@Override
	public List<Room> getRoomsByRoomType(String roomType) {
		Session session = sessionFactory.getCurrentSession();
		Query<Room> q = session.createQuery("from Room where roomType='" + roomType + "' and available='" + 1 + "'");
		return q.list();
	}

	
	
	public List<Booking> findBooking(int bookingId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Booking> q = session.createQuery("from Booking where bookingId='" + bookingId + "' ");
		List<Booking> booking = q.list();
		return booking;
	}

	@Override
	public Object cancelBooking(int bookingId) {
		Session session = sessionFactory.getCurrentSession();
		List<Booking> list = findBooking(bookingId);
		if(list.size()<1) {
			return "please check your BookingID and try again";
		}else {
			Booking booking = list.get(0);
			booking.setBookingStatus("canceled");
			booking.getRoomId().setAvailable(true);
			session.save(booking);
			return booking;
		}
	}
}
