<template>
  <ion-menu content-id="main-content">
    <ion-header>
      <ion-toolbar color="primary">
        <ion-title>{{ app.title }}</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content>
      <ion-list>
        <ion-menu-toggle v-for="item in app.menuItems" :key="item.path" :auto-hide="false">
          <ion-item :router-link="item.path" router-direction="root" lines="none" :detail="false">
            <ion-icon :icon="item.icon" slot="start" />
            <ion-label>{{ item.label }}</ion-label>
          </ion-item>
        </ion-menu-toggle>
      </ion-list>
    </ion-content>
  </ion-menu>
</template>

<script setup lang="ts">
import {
  IonMenu,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonList,
  IonItem,
  IonIcon,
  IonLabel,
  IonMenuToggle,
} from '@ionic/vue';
import { app } from '../../constants';
</script>
