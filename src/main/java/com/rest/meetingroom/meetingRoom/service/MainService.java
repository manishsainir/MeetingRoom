package com.rest.meetingroom.meetingRoom.service;

import java.util.List;

import com.rest.meetingroom.meetingRoom.model.Customer;
import com.rest.meetingroom.meetingRoom.model.Room;

public interface MainService {

	List<Room> getRooms();

	
	Object bookARoom(int roomId, String email);

	

	List<Room> getRoomsByRoomType(String roomType);

	

	Object cancelBooking(int bookingId);

}
