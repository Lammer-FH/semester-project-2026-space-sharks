# Backlog

## Milestone 2

### Done – Backend

- **U2** – `GET /rooms`, `GET /rooms/{id}` (pagination, features, 8 rooms seed data)
- **U3** – `GET /rooms/{id}/availability` (date validation, overlap check, 400/404 errors)
- Hotels API, JPA entities, `data.sql`, CORS, H2 + MySQL profile

### Done – Frontend

- **U1** – Hotel website (landing, imprint, about), atomic design structure, Pinia + Axios setup, theming
- **U2** – Room list with pagination, RoomCard, FeatureIcon, PaginationButtons, useRoomStore
- **U3** – Room detail page, date picker, availability check, useBookingStore, back navigation

### Done – Infrastructure

- Docker + docker-compose setup (Spring Boot + MySQL)
- Static room/hotel images served from backend, Vite proxy for `/images`

## Final delivery

- **U4** – Booking flow (backend: `POST /bookings`, guest APIs)
- **U5** – Booking confirmation (backend: `GET /bookings/{id}`)
