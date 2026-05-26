<template>
  <PageLayout title="Boutique Hotel Technikum">
    <div class="hero">
      <div class="hero-overlay">
        <h1>Boutique Hotel Technikum</h1>
        <p class="hero-subtitle">Ihr exklusives Zuhause im Herzen von Wien</p>
        <AppButton color="secondary" router-link="/rooms">
          Zimmer entdecken
        </AppButton>
      </div>
    </div>

    <div class="content-section">
      <SectionTitle
        title="Willkommen"
        subtitle="Erleben Sie Wiener Gastfreundschaft neu"
      />
      <p class="intro-text">
        Das Boutique Hotel Technikum verbindet modernen Komfort mit dem Charme der Wiener
        Tradition. Zentral gelegen, bieten wir Ihnen den perfekten Ausgangspunkt, um die
        Sehenswürdigkeiten, Kultur und Kulinarik der Stadt zu entdecken.
      </p>
    </div>

    <div class="content-section">
      <SectionTitle title="Unsere Highlights" />
      <ion-grid>
        <ion-row>
          <ion-col size="12" size-md="4">
            <InfoCard title="Zentrale Lage">
              Nur wenige Gehminuten von der Wiener Innenstadt, öffentlichen Verkehrsmitteln
              und den bekanntesten Sehenswürdigkeiten entfernt.
            </InfoCard>
          </ion-col>
          <ion-col size="12" size-md="4">
            <InfoCard title="Moderner Komfort">
              Alle Zimmer sind mit hochwertigem Interieur, kostenlosem WLAN und
              Klimaanlage ausgestattet.
            </InfoCard>
          </ion-col>
          <ion-col size="12" size-md="4">
            <InfoCard title="Frühstück">
              Starten Sie Ihren Tag mit unserem reichhaltigen Frühstücksbuffet —
              regional und frisch zubereitet.
            </InfoCard>
          </ion-col>
        </ion-row>
      </ion-grid>
    </div>

    <div class="content-section cta-section">
      <SectionTitle
        title="Bereit für Ihren Aufenthalt?"
        subtitle="Finden Sie das perfekte Zimmer für Ihren Wien-Besuch"
      />
      <AppButton expand="block" color="primary" router-link="/rooms">
        Jetzt Zimmer ansehen
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
