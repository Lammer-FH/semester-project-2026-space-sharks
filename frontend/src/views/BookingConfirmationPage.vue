<template>
  <PageLayout title="Booking Confirmed" back-href="/rooms">
    <div class="content-section" id="booking-confirmation">
      <div v-if="!booking" class="status-message">
        <p>No booking found.</p>
        <AppButton color="primary" router-link="/rooms">
          Browse Rooms
        </AppButton>
      </div>

      <template v-else>
        <!-- Header -->
        <div class="confirmation-header">
          <div class="confirmation-icon">
            <ion-icon :icon="checkmarkCircleOutline" color="success" />
          </div>
          <h1 class="confirmation-title">Booking Confirmed!</h1>
          <p class="confirmation-subtitle">
            Your reservation has been successfully created. Below you will find all details for your stay.
          </p>
          <ion-badge color="success" class="booking-id-badge">Booking #{{ booking.id }}</ion-badge>
        </div>

        <!-- Room details -->
        <section class="section">
          <h2 class="section-title">Your Room</h2>
          <RoomSummary :room="booking.room" />
        </section>

        <!-- Booking period -->
        <section class="section">
          <h2 class="section-title">Stay Details</h2>
          <ion-card>
            <ion-card-content>
              <div class="detail-row">
                <span class="detail-label">Check-in</span>
                <span class="detail-value">{{ formatDate(booking.startDate) }}</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Check-out</span>
                <span class="detail-value">{{ formatDate(booking.endDate) }}</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Nights</span>
                <span class="detail-value">{{ nightCount }}</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Breakfast</span>
                <span class="detail-value">{{ booking.breakfast ? 'Included' : 'Not included' }}</span>
              </div>
              <div class="detail-divider" />
              <div class="detail-row">
                <span class="detail-label">Status</span>
                <ion-badge color="success">Confirmed</ion-badge>
              </div>
            </ion-card-content>
          </ion-card>
        </section>

        <!-- Guest data -->
        <section class="section">
          <h2 class="section-title">Guest Information</h2>
          <ion-card>
            <ion-card-content>
              <div class="detail-row">
                <span class="detail-label">Name</span>
                <span class="detail-value">{{ booking.guest?.firstName }} {{ booking.guest?.lastName }}</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Email</span>
                <span class="detail-value">{{ booking.guest?.email }}</span>
              </div>
            </ion-card-content>
          </ion-card>
        </section>

        <!-- Directions -->
        <section class="section">
          <h2 class="section-title">Directions</h2>
          <ion-card>
            <ion-card-content>
              <div class="directions-info">
                <div class="detail-row">
                  <span class="detail-label">Address</span>
                  <span class="detail-value">Hoechstaedtplatz 6, 1200 Vienna</span>
                </div>
                <div class="detail-divider" />
                <div class="transport-options">
                  <div class="transport-item">
                    <ion-icon :icon="trainOutline" class="transport-icon" />
                    <div>
                      <strong>By train</strong>
                      <p>U6 station Dresdner Strasse (2 min walk) or S-Bahn Traisengasse</p>
                    </div>
                  </div>
                  <div class="transport-item">
                    <ion-icon :icon="carOutline" class="transport-icon" />
                    <div>
                      <strong>By car</strong>
                      <p>A22 exit Brigittenauer Laende, parking available nearby</p>
                    </div>
                  </div>
                  <div class="transport-item">
                    <ion-icon :icon="airplaneOutline" class="transport-icon" />
                    <div>
                      <strong>From airport</strong>
                      <p>Vienna Airport (VIE) — S7 to Praterstern, then U2/U5 to Traisengasse (~35 min)</p>
                    </div>
                  </div>
                </div>
              </div>
            </ion-card-content>
            <div class="map-wrapper">
              <iframe
                title="Hotel Location"
                :src="mapUrl"
                allowfullscreen
                loading="lazy"
              />
            </div>
          </ion-card>
        </section>

        <!-- Contact -->
        <section class="section">
          <h2 class="section-title">Contact</h2>
          <ion-card>
            <ion-card-content>
              <div class="detail-row">
                <span class="detail-label">Phone</span>
                <span class="detail-value">+43 1 333 40 77-0</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Email</span>
                <span class="detail-value">info@hotel-technikum.at</span>
              </div>
              <div class="detail-row">
                <span class="detail-label">Reception</span>
                <span class="detail-value">24/7</span>
              </div>
            </ion-card-content>
          </ion-card>
        </section>

        <!-- Actions -->
        <div class="actions no-print">
          <AppButton expand="block" fill="outline" color="primary" router-link="/rooms">
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
import { ref, computed } from 'vue';
import {
  onIonViewWillEnter,
  onIonViewWillLeave,
  IonCard,
  IonCardContent,
  IonIcon,
  IonBadge,
} from '@ionic/vue';
import {
  checkmarkCircleOutline,
  trainOutline,
  carOutline,
  airplaneOutline,
} from 'ionicons/icons';
import PageLayout from '@/components/templates/PageLayout.vue';
import AppButton from '@/components/atoms/AppButton.vue';
import RoomSummary from '@/components/molecules/RoomSummary.vue';
import { useBookingStore } from '@/store/useBookingStore';
import type { Booking } from '@/types';

const bookingStore = useBookingStore();
const booking = ref<Booking | null>(null);

const mapUrl = 'https://www.openstreetmap.org/export/embed.html?bbox=16.3685%2C48.2365%2C16.3745%2C48.2405&layer=mapnik&marker=48.2385%2C16.3715';

const nightCount = computed(() => {
  if (!booking.value) return 0;
  const start = new Date(booking.value.startDate);
  const end = new Date(booking.value.endDate);
  return Math.max(0, Math.ceil((end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24)));
});

onIonViewWillEnter(() => {
  booking.value = bookingStore.createdBooking;
});

onIonViewWillLeave(() => {
  bookingStore.reset();
});

function formatDate(dateStr: string): string {
  return new Date(dateStr).toLocaleDateString('en-GB', {
    weekday: 'short',
    day: '2-digit',
    month: 'short',
    year: 'numeric',
  });
}

</script>

<style scoped>
.content-section {
  max-width: 700px;
  margin: 0 auto;
  padding: 24px 16px 32px;
}

.confirmation-header {
  text-align: center;
  margin-bottom: 24px;
}

.confirmation-icon ion-icon {
  font-size: 64px;
}

.confirmation-title {
  font-size: 1.6rem;
  font-weight: 700;
  margin: 12px 0 4px;
}

.confirmation-subtitle {
  color: var(--ion-color-medium);
  margin-bottom: 12px;
  line-height: 1.5;
}

.booking-id-badge {
  font-size: 0.9rem;
  padding: 6px 14px;
}

.section {
  margin-bottom: 20px;
}

.section-title {
  font-size: 1.1rem;
  font-weight: 600;
  margin-bottom: 8px;
  color: var(--ion-text-color);
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

.transport-options {
  display: flex;
  flex-direction: column;
  gap: 14px;
  margin-top: 8px;
}

.transport-item {
  display: flex;
  gap: 12px;
  align-items: flex-start;
}

.transport-item p {
  margin: 2px 0 0;
  font-size: 0.9rem;
  color: var(--ion-color-medium-shade);
}

.transport-icon {
  font-size: 1.4rem;
  color: var(--ion-color-primary);
  margin-top: 2px;
  flex-shrink: 0;
}

.map-wrapper {
  width: 100%;
  height: 250px;
  overflow: hidden;
}

.map-wrapper iframe {
  width: 100%;
  height: 100%;
  border: none;
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
