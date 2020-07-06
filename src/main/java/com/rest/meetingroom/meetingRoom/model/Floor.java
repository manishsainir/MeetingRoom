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
@Table(name = "Floor")
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int floorId;

	@Column(name = "floorName", nullable = false)
	private String floorName;

	@ManyToOne
	@JoinColumn(name = "buildingId", nullable = false)
	private Building buildingId;
	
	

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Building getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Building buildingId) {
		this.buildingId = buildingId;
	}
	

}
