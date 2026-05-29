<template>
  <PageLayout title="Boutique Hotel Technikum">
    <div class="hero">
      <div class="hero-overlay">
        <h1>Boutique Hotel Technikum</h1>
        <p class="hero-subtitle">Your exclusive home in the heart of Vienna</p>
        <AppButton color="secondary" router-link="/rooms">
          Discover Rooms
        </AppButton>
      </div>
    </div>

    <div class="content-section">
      <SectionTitle
        title="Welcome"
        subtitle="Experience Viennese hospitality redefined"
      />
      <p class="intro-text">
        Boutique Hotel Technikum combines modern comfort with the charm of Viennese tradition.
        Centrally located, we offer you the perfect starting point to discover the city's
        sights, culture, and culinary delights.
      </p>
    </div>

    <div class="content-section">
      <SectionTitle title="Our Highlights" />
      <ion-grid>
        <ion-row>
          <ion-col size="12" size-md="4">
            <InfoCard title="Central Location">
              Just a short walk from Vienna's city centre, public transport,
              and the most famous landmarks.
            </InfoCard>
          </ion-col>
          <ion-col size="12" size-md="4">
            <InfoCard title="Modern Comfort">
              All rooms are equipped with premium interiors, free Wi-Fi,
              and air conditioning.
            </InfoCard>
          </ion-col>
          <ion-col size="12" size-md="4">
            <InfoCard title="Breakfast">
              Start your day with our rich breakfast buffet —
              regional and freshly prepared.
            </InfoCard>
          </ion-col>
        </ion-row>
      </ion-grid>
    </div>

    <div class="content-section cta-section">
      <SectionTitle
        title="Ready for your stay?"
        subtitle="Find the perfect room for your visit to Vienna"
      />
      <AppButton expand="block" color="primary" router-link="/rooms">
        Browse Rooms
      </AppButton>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import { IonGrid, IonRow, IonCol } from '@ionic/vue';
import PageLayout from '@/components/templates/PageLayout.vue';
import AppButton from '@/components/atoms/AppButton.vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';
import InfoCard from '@/components/molecules/InfoCard.vue';
</script>

<style scoped>
.hero {
  background: var(--ion-color-primary);
  min-height: 280px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  padding: 32px 16px;
}

.hero-overlay h1 {
  color: #ffffff;
  font-size: 1.8rem;
  font-weight: 700;
  margin: 0 0 8px 0;
}

.hero-subtitle {
  color: rgba(255, 255, 255, 0.85);
  font-size: 1.05rem;
  margin: 0 0 24px 0;
}

.content-section {
  padding: 24px 16px;
  max-width: 900px;
  margin: 0 auto;
}

.intro-text {
  text-align: center;
  font-size: 1rem;
  line-height: 1.6;
  color: var(--ion-text-color);
}

.cta-section {
  padding-bottom: 48px;
}
</style>
