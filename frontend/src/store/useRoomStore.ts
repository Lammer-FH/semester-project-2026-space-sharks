import { defineStore } from 'pinia';
import api from '@/services/api';
import type { Room, PaginatedResponse } from '@/types';

export const useRoomStore = defineStore('rooms', {
  state: () => ({
    rooms: [] as Room[],
    currentPage: 0,
    pageSize: 5,
    totalPages: 0,
    totalElements: 0,
    loading: false,
    error: null as string | null,
  }),

  getters: {
    hasNextPage: (state) => state.currentPage < state.totalPages - 1,
    hasPreviousPage: (state) => state.currentPage > 0,
  },

  actions: {
    async fetchRooms(page = 0) {
      this.loading = true;
      this.error = null;
      try {
        const response = await api.get<PaginatedResponse<Room>>('/rooms', {
          params: {
            hotel_id: 1,
            page,
            size: this.pageSize,
          },
        });
        this.rooms = response.data.content;
        this.currentPage = response.data.page;
        this.totalPages = response.data.totalPages;
        this.totalElements = response.data.totalElements;
      } catch (err) {
        this.error = 'Could not load rooms.';
      } finally {
        this.loading = false;
      }
    },

    async nextPage() {
      if (this.hasNextPage) {
        await this.fetchRooms(this.currentPage + 1);
      }
    },

    async previousPage() {
      if (this.hasPreviousPage) {
        await this.fetchRooms(this.currentPage - 1);
      }
    },

    async goToPage(page: number) {
      if (page >= 0 && page < this.totalPages) {
        await this.fetchRooms(page);
      }
    },
  },
});
