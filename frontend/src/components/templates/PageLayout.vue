<template>
  <ion-page>
    <AppHeader :title="title" :back-href="backHref" />
    <ion-content :fullscreen="true">
      <slot />
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent } from '@ionic/vue';
import AppHeader from '@/components/organisms/AppHeader.vue';

defineProps<{
  title: string;
  backHref?: string;
}>();
</script>
