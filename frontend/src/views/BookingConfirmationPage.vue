<template>
  <PageLayout title="Booking Confirmed" back-href="/rooms">
    <div class="content-section">
      <div v-if="!booking" class="status-message">
        <p>No booking found.</p>
        <AppButton color="primary" router-link="/rooms">
          Browse Rooms
        </AppButton>
      </div>

      <template v-else>
        <div class="confirmation-icon">
          <ion-icon :icon="checkmarkCircleOutline" color="success" />
        </div>

        <h1 class="confirmation-title">Booking Confirmed!</h1>
        <p class="confirmation-subtitle">
          Your reservation has been successfully created.
        </p>

        <ion-card>
          <ion-card-content>
            <div class="detail-row">
              <span class="detail-label">Booking ID</span>
              <span class="detail-value">#{{ booking.id }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Room</span>
              <span class="detail-value">{{ booking.room.name }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Guest</span>
              <span class="detail-value">{{ booking.guest.firstName }} {{ booking.guest.lastName }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Email</span>
              <span class="detail-value">{{ booking.guest.email }}</span>
            </div>

            <div class="detail-divider" />

            <div class="detail-row">
              <span class="detail-label">Check-in</span>
              <span class="detail-value">{{ formatDate(booking.startDate) }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Check-out</span>
              <span class="detail-value">{{ formatDate(booking.endDate) }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Breakfast</span>
              <span class="detail-value">{{ booking.breakfast ? 'Yes' : 'No' }}</span>
            </div>
            <div class="detail-row">
              <span class="detail-label">Status</span>
              <ion-badge color="success">Confirmed</ion-badge>
            </div>
          </ion-card-content>
        </ion-card>

        <div class="actions">
          <AppButton expand="block" color="primary" router-link="/rooms">
            Browse More Rooms
          </AppButton>
          <AppButton expand="block" fill="outline" color="medium" router-link="/home">
            Back to Home
          </AppButton>
        </div>
      </template>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { onIonViewWillEnter, onIonViewWillLeave, IonCard, IonCardContent, IonIcon, IonBadge } from '@ionic/vue';
import { checkmarkCircleOutline } from 'ionicons/icons';
import PageLayout from '@/components/templates/PageLayout.vue';
import AppButton from '@/components/atoms/AppButton.vue';
import { useBookingStore } from '@/store/useBookingStore';
import type { Booking } from '@/types';

const bookingStore = useBookingStore();
const booking = ref<Booking | null>(null);

onIonViewWillEnter(() => {
  booking.value = bookingStore.createdBooking;
});

onIonViewWillLeave(() => {
  bookingStore.reset();
});

function formatDate(dateStr: string): string {
  return new Date(dateStr).toLocaleDateString('en-GB', {
    day: '2-digit',
    month: 'short',
    year: 'numeric',
  });
}
</script>

<style scoped>
.content-section {
  max-width: 600px;
  margin: 0 auto;
  padding: 24px 16px;
}

.confirmation-icon {
  text-align: center;
  margin-top: 16px;
}

.confirmation-icon ion-icon {
  font-size: 72px;
}

.confirmation-title {
  text-align: center;
  font-size: 1.6rem;
  font-weight: 700;
  margin: 12px 0 4px;
}

.confirmation-subtitle {
  text-align: center;
  color: var(--ion-color-medium);
  margin-bottom: 24px;
}

.detail-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 6px 0;
}

.detail-label {
  color: var(--ion-color-medium);
}

.detail-value {
  font-weight: 600;
  text-align: right;
}

.detail-divider {
  height: 1px;
  background: var(--ion-color-light-shade);
  margin: 8px 0;
}

.actions {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-top: 24px;
}

.status-message {
  text-align: center;
  padding: 48px 16px;
}
</style>
