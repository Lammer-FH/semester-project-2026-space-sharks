import { defineStore } from 'pinia';
import api from '@/services/api';
import type { Room, AvailabilityResponse } from '@/types';

export const useBookingStore = defineStore('booking', {
  state: () => ({
    selectedRoom: null as Room | null,
    startDate: '',
    endDate: '',
    availability: null as AvailabilityResponse | null,
    loading: false,
    error: null as string | null,
  }),

  getters: {
    isAvailable: (state) => state.availability?.available ?? null,
    nightCount: (state) => {
      if (!state.startDate || !state.endDate) return 0;
      const start = new Date(state.startDate);
      const end = new Date(state.endDate);
      const diff = end.getTime() - start.getTime();
      return Math.max(0, Math.ceil(diff / (1000 * 60 * 60 * 24)));
    },
    totalPrice(): number {
      if (!this.selectedRoom) return 0;
      return this.nightCount * this.selectedRoom.pricePerNight;
    },
  },

  actions: {
    setDates(startDate: string, endDate: string) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.availability = null;
      this.error = null;
    },

    setRoom(room: Room) {
      this.selectedRoom = room;
      this.availability = null;
      this.error = null;
    },

    async checkAvailability() {
      if (!this.selectedRoom || !this.startDate || !this.endDate) return;

      this.loading = true;
      this.error = null;
      this.availability = null;

      try {
        const response = await api.get<AvailabilityResponse>(
          `/rooms/${this.selectedRoom.id}/availability`,
          {
            params: {
              hotel_id: this.selectedRoom.hotelId,
              startDate: this.startDate,
              endDate: this.endDate,
            },
          }
        );
        this.availability = response.data;
      } catch (err: any) {
        if (err.response?.status === 400) {
          this.error = 'Invalid dates. Please check your input.';
        } else if (err.response?.status === 404) {
          this.error = 'Room not found.';
        } else {
          this.error = 'Could not check availability.';
        }
      } finally {
        this.loading = false;
      }
    },

    reset() {
      this.selectedRoom = null;
      this.startDate = '';
      this.endDate = '';
      this.availability = null;
      this.loading = false;
      this.error = null;
    },
  },
});
