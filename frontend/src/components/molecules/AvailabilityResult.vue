<template>
  <div :class="['availability-result', available ? 'is-available' : 'is-unavailable']">
    <div class="result-badge">
      <ion-icon :icon="available ? checkmarkCircleOutline : closeCircleOutline" />
    </div>

    <div class="result-body">
      <p class="result-status">{{ available ? 'Available' : 'Unavailable' }}</p>
      <p class="result-message">
        {{ available
          ? 'Great news — this room is free for your selected dates.'
          : 'Sorry, this room is already booked for the selected period.' }}
      </p>

      <div v-if="available && nightCount > 0" class="price-breakdown">
        <div class="price-row">
          <span class="price-label">{{ nightCount }} {{ nightCount === 1 ? 'night' : 'nights' }}</span>
          <span class="price-value">{{ totalPrice }} €</span>
        </div>
        <div class="price-row sub">
          <span class="price-label">per night</span>
          <span class="price-value">{{ Math.round(totalPrice / nightCount) }} €</span>
        </div>
      </div>
    </div>

    <ion-button
      v-if="available"
      expand="block"
      color="primary"
      class="book-btn"
      @click="$emit('book')"
    >
      Book Now
    </ion-button>
  </div>
</template>

<script setup lang="ts">
import { IonIcon, IonButton } from '@ionic/vue';
import { checkmarkCircleOutline, closeCircleOutline } from 'ionicons/icons';

defineProps<{
  available: boolean;
  nightCount: number;
  totalPrice: number;
}>();

defineEmits<{
  book: [];
}>();
</script>

<style scoped>
.availability-result {
  border-radius: 14px;
  padding: 20px;
  position: relative;
  overflow: hidden;
}

.availability-result.is-available {
  background: linear-gradient(135deg, #e8f5e9 0%, #f1f8e9 100%);
  border: 1px solid #c8e6c9;
}

.availability-result.is-unavailable {
  background: linear-gradient(135deg, #fbe9e7 0%, #fce4ec 100%);
  border: 1px solid #ffcdd2;
}

.result-badge {
  width: 48px;
  height: 48px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 14px;
}

.is-available .result-badge {
  background: rgba(76, 175, 80, 0.15);
  color: #2e7d32;
}

.is-unavailable .result-badge {
  background: rgba(244, 67, 54, 0.15);
  color: #c62828;
}

.result-badge ion-icon {
  font-size: 26px;
}

.result-body {
  margin-bottom: 4px;
}

.result-status {
  font-size: 1.2rem;
  font-weight: 700;
  margin: 0 0 4px;
}

.is-available .result-status {
  color: #2e7d32;
}

.is-unavailable .result-status {
  color: #c62828;
}

.result-message {
  font-size: 0.92rem;
  color: var(--ion-color-medium-shade);
  margin: 0 0 16px;
  line-height: 1.5;
}

.price-breakdown {
  background: rgba(255, 255, 255, 0.7);
  border-radius: 10px;
  padding: 12px 14px;
  margin-bottom: 8px;
}

.price-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.price-row.sub {
  margin-top: 4px;
  opacity: 0.6;
  font-size: 0.85rem;
}

.price-label {
  color: var(--ion-color-medium-shade);
}

.price-value {
  font-weight: 700;
  font-size: 1.1rem;
  color: var(--ion-text-color);
}

.price-row.sub .price-value {
  font-size: 0.85rem;
  font-weight: 600;
}

.book-btn {
  margin-top: 14px;
  --border-radius: 10px;
}
</style>
