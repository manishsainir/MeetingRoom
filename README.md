# MeetingRoom

A project is all about:
A company has multiple buildings (offices); each building has multiple floors; and each floor has multiple meeting rooms.

Meeting rooms are of 2 types: 4 seater and 8 seater

Multiple employees will try to book meeting rooms online at the same time. Conflicts should be handled.

# Getting Started
First of all you need to clone repo to your system :

````git clone https://github.com/manishsainir/MeetingRoom.git````

# Prerequisites
You should have any java IDE, here we are using Eclipse:
to install Eclipse go through the given link:
````https://www.eclipse.org/downloads/````

You should have MysSql server: ````https://dev.mysql.com/downloads/mysql/````
And you can also use workbench for your convenience : ````https://dev.mysql.com/downloads/workbench/````


# Installing

````Open mySQL server from terminal or use workbech to create schema MeetingRoom.````
````Open Eclipse and import cloned package as maven project.````
```` Make sure that your mysql version and hibernate driver is same or not. if not then please change hibernate driver in application.properties.````

# Runnig the tests
````Run application by click on maven build.````
````Use postman to handle request and set header Content-Type : application/json.````
## Here is Request url and Descriptions: 

### for get Rooms:
#### Get Request
````localhost:8085/getRooms````
### for get Rooms by Room Type:
#### Get Request
````localhost:8085/getRooms/{roomType}````
Where {roomType} is String '4 seater' Or '8 seater'
### for register customer to book a room:
#### Post request
````localhost:8085/customer/registration````
And set Body as { "email" : "", "name" : "", "contact": "", "password": ""}
any field should not be empty and type of body must be json.

### for Book a room:
#### Post request
````localhost:8085/booking/{roomId}/customer/{email}/{password}````
Where {roomId} is Room Id of Room which you want to Book.
{email} and {password} is your email and password which you entered while registration.

### for cancel a booked room:
#### Delete request
````localhost:8085/cancel/{bookingId}/customer/{email}/{password}````
Where {bookingId} is Booking Id of Room which you get while you are booking a room. .
{email} and {password} is your email and password which you entered while registration.
