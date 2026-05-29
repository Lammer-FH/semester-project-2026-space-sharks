export interface Hotel {
  id: number;
  name: string;
  description: string;
  location: string;
  imageUrl: string;
}

export interface Feature {
  id: number;
  name: string;
  icon: string;
}

export interface Room {
  id: number;
  hotelId: number;
  name: string;
  description: string;
  pricePerNight: number;
  maxOccupants: number;
  imageUrl: string;
  features: Feature[];
}

export interface Guest {
  id?: number;
  firstName: string;
  lastName: string;
  email: string;
}

export interface Booking {
  id: number;
  room: Room;
  guest: Guest;
  startDate: string;
  endDate: string;
  breakfast: boolean;
  confirmed: boolean;
  createdAt: string;
}

export interface AvailabilityResponse {
  roomId: number;
  startDate: string;
  endDate: string;
  available: boolean;
}

export interface PaginatedResponse<T> {
  content: T[];
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
}
