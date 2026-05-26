# Backlog

## Done (Backend – Milestone 2)

### U2: Hotel Room Selection (backend)
- `GET /api/v1/rooms` with `hotel_id`, pagination (`page`, `size=5`)
- `GET /api/v1/rooms/{roomId}` with `hotel_id`
- Room JSON includes `hotelId`, features, image URL (matches API spec)
- Seed data: 8 rooms across 2 pages

### U3: Check Availability (backend)
- `GET /api/v1/rooms/{roomId}/availability` with `startDate`, `endDate`, `hotel_id`
- Date validation (past dates, end before start)
- Overlap detection against existing bookings
- Error responses via `GlobalExceptionHandler` (400, 404)

### Supporting (backend)
- `GET /api/v1/hotels` and `GET /api/v1/hotels/{id}`
- H2 database, JPA entities, `data.sql` seed
- CORS for `http://localhost:5173`
- Guest and Booking endpoints remain stubs (final / U4–U5)

---

## Todo

### U1: Hotel Website (frontend)
As a guest, I want to be presented with the hotel in the form of a website in order to learn more about it.

### U2: Hotel Room Selection (frontend)
As a guest, I want to see an overview of hotel rooms and their details in order to choose a suitable room.
- Integrate `GET /api/v1/rooms?hotel_id=1&page=0&size=5`
- Pagination UI, room images, feature icons

### U3: Check Availability (frontend)
As a guest, I want to check whether a specific room is available for my desired period.
- Integrate `GET /api/v1/rooms/{id}/availability?startDate=...&endDate=...&hotel_id=1`
- Date picker and availability feedback

### U4: Book a Hotel Room
As a guest, I want to book a selected room.
- Backend: implement `POST /bookings`, guest APIs (final)

### U5: Improve Booking Confirmation
As a guest, I want to receive detailed confirmation after booking.
- Backend: `GET /bookings/{id}` (final); mostly frontend
