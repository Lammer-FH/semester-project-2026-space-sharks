<template>
  <PageLayout title="About Us">
    <div class="content-section">
      <SectionTitle
          title="About Boutique Hotel Technikum"
          subtitle="Tradition Meets Modernity"
      />

      <p>
        Boutique Hotel Technikum is located in the heart of Vienna and has been offering
        travellers from around the world a stylish and comfortable home away from home since
        its founding. Our house combines contemporary design with the warmth of traditional
        Viennese hospitality.
      </p>

      <p>
        Each of our rooms has been individually designed and furnished with premium
        amenities — from free high-speed Wi-Fi and air conditioning to first-class
        care products.
      </p>
    </div>

    <div class="content-section">
      <SectionTitle title="Our Services"/>
      <ion-list>
        <ion-item>
          <ion-icon :icon="restaurantOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Breakfast Buffet</h3>
            <p>Fresh regional products daily</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="wifiOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Free Wi-Fi</h3>
            <p>High-speed internet throughout the hotel</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="mapOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Central Location</h3>
            <p>Excellent connections to public transport</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="timeOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>24h Reception</h3>
            <p>We are here for you around the clock</p>
          </ion-label>
        </ion-item>
      </ion-list>
    </div>

    <div class="content-section">
      <SectionTitle title="Contact"/>
      <ion-list>
        <ion-item>
          <ion-icon :icon="locationOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>Address</h3>
            <p>Höchstädtplatz 6, 1200 Vienna, Austria</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="callOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>Phone</h3>
            <p>+43 1 333 40 77-0</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="mailOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>Email</h3>
            <p>info@hotel-technikum.at</p>
          </ion-label>
        </ion-item>
      </ion-list>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import {IonList, IonItem, IonIcon, IonLabel} from '@ionic/vue';
import {
  restaurantOutline,
  wifiOutline,
  mapOutline,
  timeOutline,
  locationOutline,
  callOutline,
  mailOutline,
} from 'ionicons/icons';
import PageLayout from '@/components/templates/PageLayout.vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';
</script>

<style scoped>
.content-section {
  padding: 24px 16px;
  max-width: 700px;
  margin: 0 auto;
}

.content-section p {
  font-size: 1rem;
  line-height: 1.6;
  color: var(--ion-text-color);
}
</style>
