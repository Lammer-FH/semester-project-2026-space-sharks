<template>
  <PageLayout title="Room Details" back-href="/rooms">
    <div class="content-section">
      <div v-if="loading" class="status-message">
        <ion-spinner name="crescent" />
        <p>Loading room...</p>
      </div>

      <div v-else-if="error" class="status-message">
        <p class="error-text">{{ error }}</p>
        <AppButton color="primary" router-link="/rooms">
          Back to Overview
        </AppButton>
      </div>

      <template v-else-if="room">
        <!-- Hero image -->
        <div class="hero-image-wrapper">
          <img :src="room.imageUrl" :alt="room.name" class="hero-image" />
        </div>

        <!-- Room info -->
        <div class="room-info">
          <h1 class="room-name">{{ room.name }}</h1>
          <p class="room-description">{{ room.description }}</p>

          <!-- Detail grid -->
          <div class="detail-grid">
            <div class="detail-item">
              <ion-icon :icon="pricetagOutline" class="detail-icon" />
              <div>
                <span class="detail-label">Price per night</span>
                <span class="detail-value">{{ room.pricePerNight }} €</span>
              </div>
            </div>
            <div class="detail-item">
              <ion-icon :icon="peopleOutline" class="detail-icon" />
              <div>
                <span class="detail-label">Max. occupants</span>
                <span class="detail-value">{{ room.maxOccupants }} guests</span>
              </div>
            </div>
          </div>

          <!-- Features -->
          <div v-if="room.features.length" class="features-section">
            <h3 class="section-heading">Amenities</h3>
            <div class="features-list">
              <FeatureIcon
                v-for="feature in room.features"
                :key="feature.id"
                :icon="feature.icon"
                :name="feature.name"
              />
            </div>
          </div>
        </div>

        <!-- Step: Availability check -->
        <div v-if="bookingStore.step === 'availability'" class="booking-section">
          <SectionTitle
            title="Check Availability"
            subtitle="Select your travel dates"
          />

          <DateRangePicker
            :start-date="bookingStore.startDate"
            :end-date="bookingStore.endDate"
            @update:start-date="(v) => bookingStore.setDates(v, bookingStore.endDate)"
            @update:end-date="(v) => bookingStore.setDates(bookingStore.startDate, v)"
          />

          <AppButton
            expand="block"
            color="primary"
            :disabled="!canCheck"
            @click="bookingStore.checkAvailability()"
          >
            <ion-spinner v-if="bookingStore.loading" name="crescent" />
            <span v-else>Check Availability</span>
          </AppButton>

          <p v-if="bookingStore.error" class="error-text">
            {{ bookingStore.error }}
          </p>

          <AvailabilityResult
            v-if="bookingStore.availability"
            :available="bookingStore.isAvailable!"
            :night-count="bookingStore.nightCount"
            :total-price="bookingStore.totalPrice"
            @book="bookingStore.setStep('form')"
          />
        </div>

        <!-- Step: Booking form -->
        <div v-else-if="bookingStore.step === 'form'" class="booking-section">
          <BookingForm
            :first-name="bookingStore.firstName"
            :last-name="bookingStore.lastName"
            :email="bookingStore.email"
            :confirm-email="bookingStore.confirmEmail"
            :breakfast="bookingStore.breakfast"
            @update:first-name="bookingStore.firstName = $event"
            @update:last-name="bookingStore.lastName = $event"
            @update:email="bookingStore.email = $event"
            @update:confirm-email="bookingStore.confirmEmail = $event"
            @update:breakfast="bookingStore.breakfast = $event"
            @continue="bookingStore.setStep('review')"
            @back="bookingStore.setStep('availability')"
          />
        </div>

        <!-- Step: Review -->
        <div v-else-if="bookingStore.step === 'review'" class="booking-section">
          <BookingReview
            :room-name="room.name"
            :start-date="bookingStore.startDate"
            :end-date="bookingStore.endDate"
            :night-count="bookingStore.nightCount"
            :total-price="bookingStore.totalPrice"
            :first-name="bookingStore.firstName"
            :last-name="bookingStore.lastName"
            :email="bookingStore.email"
            :breakfast="bookingStore.breakfast"
            :loading="bookingStore.loading"
            :error="bookingStore.error"
            @confirm="onConfirm"
            @back="bookingStore.setStep('form')"
          />
        </div>
      </template>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { IonIcon, IonSpinner } from '@ionic/vue';
import { pricetagOutline, peopleOutline } from 'ionicons/icons';
import PageLayout from '@/components/templates/PageLayout.vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';
import AppButton from '@/components/atoms/AppButton.vue';
import FeatureIcon from '@/components/atoms/FeatureIcon.vue';
import DateRangePicker from '@/components/molecules/DateRangePicker.vue';
import AvailabilityResult from '@/components/molecules/AvailabilityResult.vue';
import BookingForm from '@/components/molecules/BookingForm.vue';
import BookingReview from '@/components/molecules/BookingReview.vue';
import { useBookingStore } from '@/store/useBookingStore';
import api from '@/services/api';
import type { Room } from '@/types';

const route = useRoute();
const router = useRouter();
const bookingStore = useBookingStore();
const loading = ref(true);
const error = ref<string | null>(null);
const room = ref<Room | null>(null);

const canCheck = computed(
  () => bookingStore.startDate && bookingStore.endDate && !bookingStore.loading
);

async function onConfirm() {
  await bookingStore.submitBooking();
  if (bookingStore.step === 'confirmed') {
    router.push('/booking/confirmation');
  }
}

onMounted(async () => {
  const roomId = Number(route.params.id);
  const hotelId = Number(route.query.hotel_id ?? 1);

  bookingStore.step = 'availability';

  try {
    const response = await api.get<Room>(`/rooms/${roomId}`, {
      params: { hotel_id: hotelId },
    });
    room.value = response.data;
    bookingStore.setRoom(response.data);
  } catch {
    error.value = 'Could not load room.';
  } finally {
    loading.value = false;
  }
});
</script>

<style scoped>
.content-section {
  max-width: 900px;
  margin: 0 auto;
  padding-bottom: 32px;
}

.hero-image-wrapper {
  width: 100%;
  aspect-ratio: 16 / 9;
  overflow: hidden;
  border-radius: 12px;
  margin: 16px 0;
  padding: 0 16px;
  box-sizing: border-box;
}

.hero-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
  border-radius: 12px;
}

.room-info {
  padding: 0 16px;
}

.room-name {
  font-size: 1.75rem;
  font-weight: 700;
  margin: 8px 0 4px;
  color: var(--ion-text-color);
}

.room-description {
  font-size: 1rem;
  line-height: 1.6;
  color: var(--ion-color-medium-shade);
  margin-bottom: 20px;
}

.detail-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 16px;
  margin-bottom: 24px;
}

.detail-item {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 16px;
  background: var(--ion-color-light);
  border-radius: 10px;
}

.detail-icon {
  font-size: 1.6rem;
  color: var(--ion-color-primary);
  flex-shrink: 0;
}

.detail-label {
  display: block;
  font-size: 0.8rem;
  text-transform: uppercase;
  letter-spacing: 0.5px;
  color: var(--ion-color-medium);
}

.detail-value {
  display: block;
  font-size: 1.15rem;
  font-weight: 600;
  color: var(--ion-text-color);
}

.features-section {
  margin-bottom: 24px;
}

.section-heading {
  font-size: 1.1rem;
  font-weight: 600;
  margin-bottom: 10px;
  color: var(--ion-text-color);
}

.features-list {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}

.booking-section {
  margin-top: 8px;
  padding: 0 16px;
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
  text-align: center;
}
</style>
