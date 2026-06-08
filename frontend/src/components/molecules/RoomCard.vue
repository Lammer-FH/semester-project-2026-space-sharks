<template>
  <RoomSummary :room="room">
    <AppButton
      expand="block"
      color="primary"
      :router-link="`/rooms/${room.id}?hotel_id=${room.hotelId}`"
      class="check-btn"
    >
      View Details
    </AppButton>
  </RoomSummary>
</template>

<script setup lang="ts">
import type { Room } from '@/types';
import RoomSummary from '@/components/molecules/RoomSummary.vue';
import AppButton from '@/components/atoms/AppButton.vue';

defineProps<{
  room: Room;
}>();
</script>

<style scoped>
.check-btn {
  margin-top: 12px;
}
</style>
