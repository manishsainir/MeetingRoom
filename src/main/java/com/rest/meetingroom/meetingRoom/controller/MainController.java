package com.rest.meetingroom.meetingRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.meetingroom.meetingRoom.model.Customer;
import com.rest.meetingroom.meetingRoom.model.Room;
import com.rest.meetingroom.meetingRoom.service.CustomerService;
import com.rest.meetingroom.meetingRoom.service.MainService;

@RestController
@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

	@Autowired
	MainService mainService;
	
	@Autowired
	CustomerService customerService;

	@GetMapping(value = { "/getRooms", "/getRooms/{roomType}" })
	public List<Room> getRooms(@PathVariable(required = false) String roomType) {
		if (roomType == "" || roomType == null) {
			List<Room> list = this.mainService.getRooms();
			return list;
		} else {
			List<Room> list = this.mainService.getRoomsByRoomType(roomType);
			return list;
		}
	}

	@PostMapping(value = "/customer/registration")
	public String registerAsCustomer(@RequestBody Customer customer) {
		boolean response = this.customerService.save(customer);
		if (response) {
			return "registeration successfull. Now  you can Book A room";
		} else {
			return "something went wrong please try again";
		}
	}

	@PostMapping(value = "/booking/{roomId}/customer/{email}/{password}")
	public Object bookARoom(@PathVariable int roomId, @PathVariable String email,@PathVariable String password) {
		boolean verify = this.customerService.verifyCustomer(email,password);
		if (verify) {
			return this.mainService.bookARoom(roomId, email);
		} else {
			return "please try again, may email or password is wrong or you are not registered user";
		}
	}
	
	@DeleteMapping(value="/cancel/{bookingId}/customer/{email}/{password}")
	public Object cancelBooking(@PathVariable int bookingId,@PathVariable String email,@PathVariable String password) {
		boolean verify = this.customerService.verifyCustomer(email,password);
		if (verify) {
			return this.mainService.cancelBooking(bookingId);
		} else {
			return "please try again, may email or password is wrong or you are not registered user";
		}
	}
}
