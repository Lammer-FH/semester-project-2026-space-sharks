<template>
  <ion-header>
    <ion-toolbar color="primary" class="custom-toolbar">
      <!-- Mobile -->
      <div class="mobile-header">
        <ion-buttons slot="start">
          <ion-back-button v-if="backHref" :default-href="backHref" />
          <ion-menu-button v-else />
        </ion-buttons>
        
        <div class="mobile-logo">
          <router-link to="/" class="logo-link">
            <site-logo />
          </router-link>
        </div>
        
        <ion-buttons slot="end" style="visibility: hidden;">
          <ion-button>Placeholder</ion-button>
        </ion-buttons>
      </div>

      <!-- Desktop -->
      <div class="desktop-header">
        <div class="desktop-left">
          <ion-buttons v-if="backHref" class="desktop-back-button">
            <ion-back-button :default-href="backHref" />
          </ion-buttons>

          <router-link to="/" class="logo-link desktop-logo">
            <site-logo />
          </router-link>
        </div>

        <div class="desktop-center">
          <div class="nav-links">
            <a 
              v-for="item in app.menuItems" 
              :key="item.path"
              href="javascript:void(0)"
              @click="navigateTo(item.path)"
              class="nav-link"
              :class="{ 'active': route.path === item.path }"
            >
              {{ item.label }}
            </a>
          </div>
        </div>

        <div class="desktop-right"></div>
      </div>
    </ion-toolbar>
  </ion-header>
</template>

<script setup lang="ts">
import { IonHeader, IonToolbar, IonButtons, IonMenuButton, IonBackButton, IonButton } from '@ionic/vue';
import { useRouter, useRoute } from 'vue-router';
import SiteLogo from '../atoms/SiteLogo.vue';
import { app } from '@/constants';

defineProps<{
  title?: string;
  backHref?: string;
}>();

const router = useRouter();
const route = useRoute();

const navigateTo = (path: string) => {
  router.push(path);
};
</script>

<style scoped>
.custom-toolbar {
  --min-height: 56px;
  --background: var(--ion-color-primary);
  padding: 0;
}

.mobile-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  padding: 0 8px;
  min-height: 56px;
}

.mobile-logo {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}

.logo-link {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: white;
  cursor: pointer;
}

.desktop-header {
  display: none;
}

@media (min-width: 768px) {
  .mobile-header {
    display: none;
  }
  
  .desktop-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    padding: 0 16px;
    min-height: 56px;
  }
  
  .desktop-left {
    display: flex;
    align-items: center;
    gap: 12px;
    min-width: 200px;
  }
  
  .desktop-back-button,
  .desktop-menu-button {
    flex-shrink: 0;
  }
  
  .desktop-logo {
    flex-shrink: 0;
  }
  
  .desktop-center {
    flex: 1;
    display: flex;
    justify-content: center;
  }
  
  .nav-links {
    display: flex;
    gap: 0.5rem;
  }
  
  .nav-link {
    display: inline-block;
    color: white !important;
    text-decoration: none !important;
    font-weight: 500;
    padding: 8px 16px;
    border-radius: 6px;
    transition: background-color 0.2s;
    cursor: pointer;
    background: transparent;
    font-size: 1rem;
    white-space: nowrap;
  }
  
  .nav-link:hover {
    background-color: rgba(255, 255, 255, 0.15);
  }
  
  .nav-link.active {
    background-color: rgba(255, 255, 255, 0.25);
    font-weight: 600;
  }
  
  .desktop-right {
    min-width: 200px;
  }
  
  ion-back-button {
    --color: white;
    --background: transparent;
  }
  
  ion-menu-button {
    --color: white;
  }
}
</style>
