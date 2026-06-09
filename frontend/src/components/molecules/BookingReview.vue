<template>
  <div class="booking-review">
    <SectionTitle
      title="Review Your Booking"
      subtitle="Please confirm your details"
    />

    <ion-card>
      <ion-card-content>
        <div class="review-row">
          <span class="review-label">Room</span>
          <span class="review-value">{{ roomName }}</span>
        </div>
        <div class="review-row">
          <span class="review-label">Check-in</span>
          <span class="review-value">{{ formatDate(startDate) }}</span>
        </div>
        <div class="review-row">
          <span class="review-label">Check-out</span>
          <span class="review-value">{{ formatDate(endDate) }}</span>
        </div>
        <div class="review-row">
          <span class="review-label">Nights</span>
          <span class="review-value">{{ nightCount }}</span>
        </div>
        <div class="review-row">
          <span class="review-label">Breakfast</span>
          <span class="review-value">{{ breakfast ? 'Yes' : 'No' }}</span>
        </div>

        <div class="review-divider" />

        <div class="review-row">
          <span class="review-label">Guest</span>
          <span class="review-value">{{ firstName }} {{ lastName }}</span>
        </div>
        <div class="review-row">
          <span class="review-label">Email</span>
          <span class="review-value">{{ email }}</span>
        </div>

        <div class="review-divider" />

        <div class="review-row total">
          <span class="review-label">Total</span>
          <span class="review-value">{{ totalPrice }} €</span>
        </div>
      </ion-card-content>
    </ion-card>

    <p v-if="error" class="error-text">{{ error }}</p>

    <div class="review-actions">
      <ion-button expand="block" color="primary" :disabled="loading" @click="$emit('confirm')">
        <ion-spinner v-if="loading" name="crescent" />
        <span v-else>Confirm Booking</span>
      </ion-button>
      <ion-button expand="block" fill="outline" color="medium" :disabled="loading" @click="$emit('back')">
        Back
      </ion-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { IonCard, IonCardContent, IonButton, IonSpinner } from '@ionic/vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';

defineProps<{
  roomName: string;
  startDate: string;
  endDate: string;
  nightCount: number;
  totalPrice: number;
  firstName: string;
  lastName: string;
  email: string;
  breakfast: boolean;
  loading: boolean;
  error: string | null;
}>();

defineEmits<{
  confirm: [];
  back: [];
}>();

function formatDate(dateStr: string): string {
  return new Date(dateStr).toLocaleDateString('en-GB', {
    day: '2-digit',
    month: 'short',
    year: 'numeric',
  });
}
</script>

<style scoped>
.booking-review {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.review-row {
  display: flex;
  justify-content: space-between;
  padding: 6px 0;
}

.review-label {
  color: var(--ion-color-medium);
}

.review-value {
  font-weight: 600;
  text-align: right;
}

.review-row.total {
  padding-top: 8px;
}

.review-row.total .review-value {
  font-size: 1.2rem;
  color: var(--ion-color-primary);
}

.review-divider {
  height: 1px;
  background: var(--ion-color-light-shade);
  margin: 4px 0;
}

.review-actions {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.error-text {
  color: var(--ion-color-danger);
  text-align: center;
}
</style>
