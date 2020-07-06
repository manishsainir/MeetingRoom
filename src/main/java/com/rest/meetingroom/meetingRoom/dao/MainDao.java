package com.rest.meetingroom.meetingRoom.dao;

import java.util.List;

import com.rest.meetingroom.meetingRoom.model.Customer;
import com.rest.meetingroom.meetingRoom.model.Room;

public interface MainDao {

	List<Room> getRooms();

	List<Room> getRoomsByRoomType(String roomType);

	Object bookARoom(int roomId, String email);

	
	Object cancelBooking(int bookingId);

}
