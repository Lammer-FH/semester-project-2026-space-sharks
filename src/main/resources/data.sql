INSERT INTO hotel (id, name, description, location, image_url) VALUES
(1, 'Boutique Hotel Technikum', 'A modern boutique hotel in the heart of Vienna.', 'Vienna, Austria', '/images/hotels/1.jpg');

INSERT INTO feature (id, name, icon) VALUES
(1, 'WiFi', 'wifi'),
(2, 'Air Conditioning', 'thermometer-snow'),
(3, 'Breakfast', 'cup-hot'),
(4, 'TV', 'tv'),
(5, 'Parking', 'p-square');

INSERT INTO room (id, hotel_id, name, description, price_per_night, max_occupants, image_url) VALUES
(1, 1, 'Deluxe Suite', 'Spacious suite with city view.', 150, 2, '/images/rooms/1.jpg'),
(2, 1, 'Single Room', 'Comfortable room for one guest.', 80, 1, '/images/rooms/2.jpg'),
(3, 1, 'Double Room', 'Modern room for two guests.', 120, 2, '/images/rooms/3.jpg'),
(4, 1, 'Family Room', 'Large room for families.', 180, 4, '/images/rooms/4.jpg'),
(5, 1, 'Business Room', 'Quiet room with work desk.', 130, 2, '/images/rooms/5.jpg'),
(6, 1, 'Economy Room', 'Simple and affordable room.', 70, 1, '/images/rooms/6.jpg'),
(7, 1, 'Premium Suite', 'Luxury suite with premium amenities.', 220, 2, '/images/rooms/7.jpg'),
(8, 1, 'Twin Room', 'Room with two separate beds.', 110, 2, '/images/rooms/8.jpg');

INSERT INTO room_feature (room_id, feature_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 1), (2, 4),
(3, 1), (3, 2), (3, 4),
(4, 1), (4, 2), (4, 3), (4, 4),
(5, 1), (5, 2), (5, 4),
(6, 1),
(7, 1), (7, 2), (7, 3), (7, 4), (7, 5),
(8, 1), (8, 2), (8, 4);

INSERT INTO guest (id, first_name, last_name, email) VALUES
(1, 'Max', 'Mustermann', 'max@example.com');

INSERT INTO booking (id, room_id, guest_id, start_date, end_date, breakfast, confirmed, created_at) VALUES
(1, 1, 1, '2026-07-01', '2026-07-05', true, true, CURRENT_TIMESTAMP),
(2, 3, 1, '2026-08-10', '2026-08-15', false, true, CURRENT_TIMESTAMP);