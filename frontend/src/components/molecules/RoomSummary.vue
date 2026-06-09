<template>
  <ion-card>
    <RoomImage :src="room.imageUrl" :alt="room.name" />
    <ion-card-header>
      <ion-card-title>{{ room.name }}</ion-card-title>
      <ion-card-subtitle>
        {{ room.pricePerNight }} € / night · max. {{ room.maxOccupants }} guests
      </ion-card-subtitle>
    </ion-card-header>
    <ion-card-content>
      <p>{{ room.description }}</p>
      <div v-if="room.features?.length" class="features">
        <FeatureIcon
          v-for="feature in room.features"
          :key="feature.id"
          :icon="feature.icon"
          :name="feature.name"
        />
      </div>
      <slot />
    </ion-card-content>
  </ion-card>
</template>

<script setup lang="ts">
import { IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonCardContent } from '@ionic/vue';
import type { Room } from '@/types';
import RoomImage from '@/components/atoms/RoomImage.vue';
import FeatureIcon from '@/components/atoms/FeatureIcon.vue';

defineProps<{
  room: Room;
}>();
</script>

<style scoped>
.features {
  display: flex;
  flex-wrap: wrap;
  gap: 4px;
  margin-top: 8px;
}
</style>
