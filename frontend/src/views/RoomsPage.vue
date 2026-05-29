<template>
  <PageLayout title="Rooms">
    <div class="content-section">
      <SectionTitle
        title="Our Rooms"
        subtitle="Choose your perfect room"
      />

      <div v-if="roomStore.loading" class="status-message">
        <ion-spinner name="crescent" />
        <p>Loading rooms...</p>
      </div>

      <div v-else-if="roomStore.error" class="status-message">
        <p class="error-text">{{ roomStore.error }}</p>
        <AppButton color="primary" @click="roomStore.fetchRooms()">
          Try Again
        </AppButton>
      </div>

      <template v-else>
        <div class="room-list">
          <RoomCard
            v-for="room in roomStore.rooms"
            :key="room.id"
            :room="room"
          />
        </div>

        <PaginationButtons
          v-if="roomStore.totalPages > 1"
          :current-page="roomStore.currentPage"
          :total-pages="roomStore.totalPages"
          @page-change="roomStore.goToPage"
        />
      </template>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import { onMounted } from 'vue';
import { IonSpinner } from '@ionic/vue';
import PageLayout from '@/components/templates/PageLayout.vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';
import AppButton from '@/components/atoms/AppButton.vue';
import RoomCard from '@/components/molecules/RoomCard.vue';
import PaginationButtons from '@/components/molecules/PaginationButtons.vue';
import { useRoomStore } from '@/store/useRoomStore';

const roomStore = useRoomStore();

onMounted(() => {
  roomStore.fetchRooms();
});
</script>

<style scoped>
.content-section {
  padding: 24px 16px;
  max-width: 900px;
  margin: 0 auto;
}

.room-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.status-message {
  text-align: center;
  padding: 48px 16px;
}

.error-text {
  color: var(--ion-color-danger);
  margin-bottom: 16px;
}
</style>
