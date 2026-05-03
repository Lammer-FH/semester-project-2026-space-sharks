/user/:ID - GET - Display Users bookings and personal details
    only displays data, if the current user is the requested user, otherwise 404
/user/:ID - PUT - Update User Data
    only displays data, if the current user is the requested user, otherwise 404
/user/:ID - DELETE - delete User
    only displays data, if the current user is the requested user, otherwise 404
/user - POST - Register a new User

/hotels - GET - Display all hotels
/hotels?hotels_shown=X&page=Y - GET - get hotel info
    dispalys hotel info if hotel exists, 404 otherwise
    hotels_shown - positive integer, how many hotels are shown per page
    page - page selector
/hotel/:ID - GET - get hotel info
    dispalys hotel info if hotel exists, 404 otherwise

/hotel/:ID/rooms - GET - Display all rooms of hotel :ID
    only displays data, if hotel with this id exists, otherwise 404
/hotel/:HOTEL_ID/room/:ROOM_ID - GET - Display details of Room ROOM_ID of hotel HOTEL_ID

/hotel/:HOTEL_ID/room/:ROOM_ID/availability?start_date=X&end_date=Y - GET - checks availability of an hotel room
    returns true or false if the room exists, 404 otherwise

/hotel/:HOTEL_ID/room/:ROOM_ID/booking - POST - Request booking of Room ROOM_ID of hotel HOTEL_ID
/hotel/:HOTEL_ID/room/:ROOM_ID/booking - GET -  Get booking information of Room ROOM_ID of hotel HOTEL_ID
