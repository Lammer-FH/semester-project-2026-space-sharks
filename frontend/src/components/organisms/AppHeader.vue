<template>
  <ion-header>
    <ion-toolbar color="primary">
      <ion-buttons slot="start">
        <ion-back-button v-if="backHref" :default-href="backHref" />
        <ion-menu-button v-else />
      </ion-buttons>
      <ion-title>{{ title }}</ion-title>
    </ion-toolbar>
  </ion-header>
</template>

<script setup lang="ts">
import { IonHeader, IonToolbar, IonTitle, IonButtons, IonMenuButton, IonBackButton } from '@ionic/vue';

defineProps<{
  title: string;
  backHref?: string;
}>();
</script>
