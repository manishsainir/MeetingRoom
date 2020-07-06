package com.rest.meetingroom.meetingRoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.meetingroom.meetingRoom.dao.MainDao;
import com.rest.meetingroom.meetingRoom.model.Room;

@Service
@Transactional
public class MainServiceImp implements MainService {

	@Autowired
	MainDao mainDao;

	@Override
	public List<Room> getRooms() {
		return this.mainDao.getRooms();
	}

	

	@Override
	public Object bookARoom(int roomId, String email) {

		return this.mainDao.bookARoom(roomId, email);
	}

	

	@Override
	public List<Room> getRoomsByRoomType(String roomType) {

		return this.mainDao.getRoomsByRoomType(roomType);
	}

	

	@Override
	public Object cancelBooking(int bookingId) {
		
		return this.mainDao.cancelBooking(bookingId);
	}

}
