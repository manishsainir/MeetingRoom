package com.rest.meetingroom.meetingRoom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	
	@Column(name="roomName", nullable = false)
	private String roomName;
	
	@Column(name="roomType", nullable = false)
	private String roomType;
	
	@ManyToOne
	@JoinColumn(name="floorId", nullable = false)
	private Floor floorId;
	
	@Column(name = "available", nullable = false)
	private boolean available;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Floor getFloorId() {
		return floorId;
	}

	public void setFloorId(Floor floorId) {
		this.floorId = floorId;
	}
	
	
}
