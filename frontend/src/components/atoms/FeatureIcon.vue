<template>
  <ion-chip outline color="medium">
    <ion-icon :icon="resolvedIcon" />
    <ion-label>{{ name }}</ion-label>
  </ion-chip>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { IonChip, IonIcon, IonLabel } from '@ionic/vue';
import {
  wifiOutline,
  snowOutline,
  tvOutline,
  cafeOutline,
  carOutline,
  fitnessOutline,
  waterOutline,
  lockClosedOutline,
  desktopOutline,
  helpCircleOutline,
} from 'ionicons/icons';

const props = defineProps<{
  icon: string;
  name: string;
}>();

const iconMap: Record<string, string> = {
  wifi: wifiOutline,
  'thermometer-snow': snowOutline,
  snow: snowOutline,
  tv: tvOutline,
  cafe: cafeOutline,
  car: carOutline,
  fitness: fitnessOutline,
  water: waterOutline,
  'lock-closed': lockClosedOutline,
  desktop: desktopOutline,
};

const resolvedIcon = computed(() => iconMap[props.icon] || helpCircleOutline);
</script>
