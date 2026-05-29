<template>
  <div class="availability-result">
    <ion-card :color="available ? 'success' : 'danger'">
      <ion-card-content>
        <div class="result-content">
          <ion-icon :icon="available ? checkmarkCircleOutline : closeCircleOutline" />
          <div>
            <p class="result-text">
              {{ available ? 'Room is available!' : 'Unfortunately, the room is not available.' }}
            </p>
            <p v-if="available && nightCount > 0" class="price-text">
              {{ nightCount }} {{ nightCount === 1 ? 'night' : 'nights' }} · {{ totalPrice }} €
            </p>
          </div>
        </div>
      </ion-card-content>
    </ion-card>
  </div>
</template>

<script setup lang="ts">
import { IonCard, IonCardContent, IonIcon } from '@ionic/vue';
import { checkmarkCircleOutline, closeCircleOutline } from 'ionicons/icons';

defineProps<{
  available: boolean;
  nightCount: number;
  totalPrice: number;
}>();
</script>

<style scoped>
.result-content {
  display: flex;
  align-items: center;
  gap: 12px;
}

.result-content ion-icon {
  font-size: 32px;
  flex-shrink: 0;
}

.result-text {
  font-weight: 600;
  font-size: 1.05rem;
  margin: 0;
}

.price-text {
  margin: 4px 0 0;
  opacity: 0.9;
}
</style>
