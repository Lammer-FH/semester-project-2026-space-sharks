<template>
  <div class="date-range-picker">
    <ion-item button @click="showStart = true">
      <ion-label>Check-In</ion-label>
      <ion-text slot="end">{{ startDate || 'Select date' }}</ion-text>
    </ion-item>
    <ion-popover :is-open="showStart" @didDismiss="showStart = false">
      <ion-datetime
        presentation="date"
        :min="minDate"
        :value="startDate"
        @ionChange="onStartChange"
      />
    </ion-popover>

    <ion-item button @click="showEnd = true">
      <ion-label>Check-Out</ion-label>
      <ion-text slot="end">{{ endDate || 'Select date' }}</ion-text>
    </ion-item>
    <ion-popover :is-open="showEnd" @didDismiss="showEnd = false">
      <ion-datetime
        presentation="date"
        :min="endMinDate"
        :value="endDate"
        @ionChange="onEndChange"
      />
    </ion-popover>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { IonItem, IonLabel, IonText, IonDatetime, IonPopover } from '@ionic/vue';

const props = defineProps<{
  startDate: string;
  endDate: string;
}>();

const emit = defineEmits<{
  (e: 'update:startDate', value: string): void;
  (e: 'update:endDate', value: string): void;
}>();

const showStart = ref(false);
const showEnd = ref(false);

const minDate = new Date().toISOString().split('T')[0];

const endMinDate = computed(() => {
  if (!props.startDate) return minDate;
  const next = new Date(props.startDate);
  next.setDate(next.getDate() + 1);
  return next.toISOString().split('T')[0];
});

function onStartChange(event: CustomEvent) {
  const value = (event.detail.value as string).split('T')[0];
  emit('update:startDate', value);
  showStart.value = false;
  if (props.endDate && value >= props.endDate) {
    const next = new Date(value);
    next.setDate(next.getDate() + 1);
    emit('update:endDate', next.toISOString().split('T')[0]);
  }
}

function onEndChange(event: CustomEvent) {
  const value = (event.detail.value as string).split('T')[0];
  emit('update:endDate', value);
  showEnd.value = false;
}
</script>

<style scoped>
.date-range-picker {
  display: flex;
  flex-direction: column;
  gap: 8px;
}
</style>
