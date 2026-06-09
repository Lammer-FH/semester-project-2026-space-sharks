# API Specification

Base URL: `/api/v1`

All endpoints return JSON. Dates use `YYYY-MM-DD` format.

---

## Guests

### POST /guests

Register a new guest.

**Request Body:**

```json
{
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@example.com"
}
```

**Responses:**

| Status            | Description                                      |
|-------------------|--------------------------------------------------|
| `201 Created`     | Guest created successfully                       |
| `400 Bad Request` | Validation error (missing fields, invalid email) |
| `409 Conflict`    | Email already registered                         |

**Response Body (201):**

```json
{
  "id": 1,
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@example.com"
}
```

### GET /guests/{id}

Get guest details and their bookings.

**Responses:**

| Status          | Description          |
|-----------------|----------------------|
| `200 OK`        | Guest found          |
| `404 Not Found` | Guest does not exist |

**Response Body (200):**

```json
{
  "id": 1,
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@example.com",
  "bookings": [
    {
      "id": 10,
      "roomId": 3,
      "startDate": "2026-07-01",
      "endDate": "2026-07-05",
      "breakfast": true,
      "confirmed": true,
      "createdAt": "2026-06-15T10:30:00"
    }
  ]
}
```

### PUT /guests/{id}

Update guest data.

**Request Body:**

```json
{
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@example.com"
}
```

**Responses:**

| Status            | Description          |
|-------------------|----------------------|
| `200 OK`          | Guest updated        |
| `400 Bad Request` | Validation error     |
| `404 Not Found`   | Guest does not exist |

### DELETE /guests/{id}

Delete a guest.

**Responses:**

| Status           | Description          |
|------------------|----------------------|
| `204 No Content` | Guest deleted        |
| `404 Not Found`  | Guest does not exist |

---

## Hotels

### GET /hotels

Get all hotels (paginated).

**Query Parameters:**

| Parameter | Type | Default | Description               |
|-----------|------|---------|---------------------------|
| `page`    | int  | 0       | Page number (zero-based)  |
| `size`    | int  | 5       | Number of hotels per page |

**Responses:**

| Status   | Description    |
|----------|----------------|
| `200 OK` | List of hotels |

**Response Body (200):**

```json
{
  "content": [
    {
      "id": 1,
      "name": "Boutique Hotel Technikum",
      "description": "A modern boutique hotel in the heart of Vienna.",
      "location": "Vienna, Austria",
      "imageUrl": "/images/hotels/1.jpg"
    }
  ],
  "page": 0,
  "size": 5,
  "totalElements": 1,
  "totalPages": 1
}
```

### GET /hotels/{id}

Get hotel details.

**Responses:**

| Status          | Description          |
|-----------------|----------------------|
| `200 OK`        | Hotel found          |
| `404 Not Found` | Hotel does not exist |

**Response Body (200):**

```json
{
  "id": 1,
  "name": "Boutique Hotel Technikum",
  "description": "A modern boutique hotel in the heart of Vienna.",
  "location": "Vienna, Austria",
  "imageUrl": "/images/hotels/1.jpg"
}
```

---

## Rooms

### GET /rooms

Get all rooms for a hotel (paginated).

**Query Parameters:**

| Parameter  | Type | Default | Description                                    |
|------------|------|---------|------------------------------------------------|
| `page`     | int  | 0       | Page number (zero-based)                       |
| `size`     | int  | 5       | Number of rooms per page                       |
| `hotel_id` | int  | none    | id of hotel from which rooms are to be queried |

**Responses:**

| Status          | Description          |
|-----------------|----------------------|
| `200 OK`        | List of rooms        |
| `404 Not Found` | Hotel does not exist |

**Response Body (200):**

```json
{
  "content": [
    {
      "id": 1,
      "hotelId": 1,
      "name": "Deluxe Suite",
      "description": "Spacious suite with city view.",
      "pricePerNight": 150,
      "maxOccupants": 2,
      "imageUrl": "/images/rooms/1.jpg",
      "features": [
        { "id": 1, "name": "WiFi", "icon": "wifi" },
        { "id": 2, "name": "Air Conditioning", "icon": "thermometer-snow" }
      ]
    }
  ],
  "page": 0,
  "size": 5,
  "totalElements": 8,
  "totalPages": 2
}
```

### GET /rooms/{roomId}

Get details of a specific room.

**Query Parameters:**

| Parameter  | Type | Default | Description               | required |
|------------|------|---------|---------------------------|----------|
| `page`     | int  | 0       | Page number (zero-based)  | no       |
| `size`     | int  | 5       | Number of rooms per page  | no       |

**Responses:**

| Status          | Description                  |
|-----------------|------------------------------|
| `200 OK`        | Room found                   |
| `404 Not Found` | Hotel or room does not exist |

**Response Body (200):**

```json
{
  "id": 1,
  "hotelId": 1,
  "name": "Deluxe Suite",
  "description": "Spacious suite with city view.",
  "pricePerNight": 150,
  "maxOccupants": 2,
  "imageUrl": "/images/rooms/1.jpg",
  "features": [
    { "id": 1, "name": "WiFi", "icon": "wifi" },
    { "id": 2, "name": "Air Conditioning", "icon": "thermometer-snow" }
  ]
}
```

---

## Availability

### GET /rooms/{roomId}/availability

Check if a room is available for a given period.

**Query Parameters:**

| Parameter   | Type                | Required | Description                   |
|-------------|---------------------|----------|-------------------------------|
| `startDate` | string (YYYY-MM-DD) | yes      | Check-in date                 |
| `endDate`   | string (YYYY-MM-DD) | yes      | Check-out date                |

**Responses:**

| Status            | Description                                                           |
|-------------------|-----------------------------------------------------------------------|
| `200 OK`          | Availability check result                                             |
| `400 Bad Request` | Invalid or missing dates, endDate before startDate, dates in the past |
| `404 Not Found`   | Hotel or room does not exist                                          |

**Response Body (200):**

```json
{
  "roomId": 1,
  "startDate": "2026-07-01",
  "endDate": "2026-07-05",
  "available": true
}
```

---

## Bookings

### POST /bookings

Create a booking for a room.

**Request Body:**

```json
{
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@example.com",
  "startDate": "2026-07-01",
  "endDate": "2026-07-05",
  "breakfast": true
}
```
**Query Parameters:**

| Parameter | Type | Required | Description                       |
|-----------|------|----------|-----------------------------------|
| `user_id` | int  | yes      | id of the current user of the app |

**Responses:**

| Status            | Description                                                     |
|-------------------|-----------------------------------------------------------------|
| `201 Created`     | Booking created successfully                                    |
| `400 Bad Request` | Validation error (missing fields, invalid email, invalid dates) |
| `404 Not Found`   | Hotel or room does not exist                                    |
| `409 Conflict`    | Room is not available for the requested period                  |

**Response Body (201):**

```json
{
  "id": 10,
  "room": {
    "id": 1,
    "hotelId": 1,
    "name": "Deluxe Suite",
    "description": "Spacious suite with city view.",
    "pricePerNight": 150,
    "maxOccupants": 2,
    "imageUrl": "/images/rooms/1.jpg",
    "features": [
      { "id": 1, "name": "WiFi", "icon": "wifi" }
    ]
  },
  "guest": {
    "firstName": "Max",
    "lastName": "Mustermann",
    "email": "max@example.com"
  },
  "startDate": "2026-07-01",
  "endDate": "2026-07-05",
  "breakfast": true,
  "confirmed": true,
  "createdAt": "2026-06-15T10:30:00"
}
```

### GET /bookings

Get all bookings of a specified user.

**Query Parameters:**

| Parameter | Type | Required | Description                                |
|-----------|------|----------|--------------------------------------------|
| `user_id` | int  | yes      | id of the user that created the bookings   |


**Responses:**

| Status          | Description                            |
|-----------------|----------------------------------------|
| `200 OK`        | List of bookings                       |
| `404 Not Found` | user has not created a booking before  |
| `403 No Access` | current user is not the requested user |

**Response Body (200):**

```json
[
  {
    "id": 10,
    "guestId": 1,
    "startDate": "2026-07-01",
    "endDate": "2026-07-05",
    "breakfast": true,
    "confirmed": true,
    "createdAt": "2026-06-15T10:30:00"
  }
]
```

### GET /bookings/{id}

Get a specific booking by ID.

**Query Parameters:**

| Parameter | Type | Required | Description                                |
|-----------|------|----------|--------------------------------------------|
| `user_id` | int  | yes      | id of the user that created the booking    |

**Responses:**

| Status          | Description                                           |
|-----------------|-------------------------------------------------------|
| `200 OK`        | Booking found                                         |
| `404 Not Found` | Booking does not exist                                |
| `403 No Access` | current user is not the user of the reuqested booking |

**Response Body (200):**

```json
{
  "id": 10,
  "room": {
    "id": 1,
    "hotelId": 1,
    "name": "Deluxe Suite",
    "description": "Spacious suite with city view.",
    "pricePerNight": 150,
    "maxOccupants": 2,
    "imageUrl": "/images/rooms/1.jpg",
    "features": [
      { "id": 1, "name": "WiFi", "icon": "wifi" }
    ]
  },
  "guest": {
    "firstName": "Max",
    "lastName": "Mustermann",
    "email": "max@example.com"
  },
  "startDate": "2026-07-01",
  "endDate": "2026-07-05",
  "breakfast": true,
  "confirmed": true,
  "createdAt": "2026-06-15T10:30:00"
}
```
