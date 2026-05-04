# API Specification

## User

### GET /user/{id}
Display user's bookings and personal details.  
Returns data only if the current user matches the requested user, otherwise `404`.

### PUT /user/{id}
Update user data.  
Allowed only if the current user matches the requested user, otherwise `404`.

### DELETE /user/{id}
Delete user.  
Allowed only if the current user matches the requested user, otherwise `404`.

### POST /user
Register a new user.

---

## Hotels

### GET /hotels
Display all hotels.

### GET /hotels?hotels_shown=X&page=Y
Paginated hotel list.  
- `hotels_shown`: number of hotels per page  
- `page`: page number  

### GET /hotel/{id}
Get hotel details.  
Returns `404` if hotel does not exist.

---

## Rooms

### GET /hotel/{id}/rooms
Display all rooms for a given hotel.  
Returns `404` if hotel does not exist.

### GET /hotel/{hotel_id}/room/{room_id}
Display details of a specific room.

---

## Availability

### GET /hotel/{hotel_id}/room/{room_id}/availability?start_date=X&end_date=Y
Check if a room is available for a given period.  
Returns:
- `true` if available  
- `false` if not available  
Returns `404` if room does not exist.

---

## Booking

### POST /hotel/{hotel_id}/room/{room_id}/booking
Request booking of a room.

### GET /hotel/{hotel_id}/room/{room_id}/booking
Get booking information for a room.
