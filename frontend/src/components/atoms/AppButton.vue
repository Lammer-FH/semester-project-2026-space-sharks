<template>
  <ion-button :expand="expand" :fill="fill" :color="color" :router-link="routerLink">
    <slot />
  </ion-button>
</template>

<script setup lang="ts">
import { IonButton } from '@ionic/vue';

defineProps<{
  expand?: 'full' | 'block';
  fill?: 'clear' | 'outline' | 'solid' | 'default';
  color?: string;
  routerLink?: string;
}>();
</script>
