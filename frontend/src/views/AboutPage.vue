<template>
  <PageLayout title="Über uns">
    <div class="content-section">
      <SectionTitle
          title="Über das Boutique Hotel Technikum"
          subtitle="Tradition trifft Moderne"
      />

      <p>
        Das Boutique Hotel Technikum befindet sich im Herzen von Wien und bietet seit seiner
        Gründung Reisenden aus aller Welt ein stilvolles und komfortables Zuhause auf Zeit.
        Unser Haus vereint zeitgemäßes Design mit der Wärme traditioneller Wiener Gastfreundschaft.
      </p>

      <p>
        Jedes unserer Zimmer wurde individuell gestaltet und mit hochwertiger Ausstattung
        versehen — von kostenlosem Highspeed-WLAN über Klimaanlage bis hin zu
        erstklassigen Pflegeprodukten.
      </p>
    </div>

    <div class="content-section">
      <SectionTitle title="Unser Service"/>
      <ion-list>
        <ion-item>
          <ion-icon :icon="restaurantOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Frühstücksbuffet</h3>
            <p>Täglich frische regionale Produkte</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="wifiOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Kostenloses WLAN</h3>
            <p>Highspeed-Internet im gesamten Hotel</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="mapOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>Zentrale Lage</h3>
            <p>Optimale Anbindung an öffentliche Verkehrsmittel</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="timeOutline" slot="start" color="secondary"/>
          <ion-label>
            <h3>24h Rezeption</h3>
            <p>Wir sind jederzeit für Sie da</p>
          </ion-label>
        </ion-item>
      </ion-list>
    </div>

    <div class="content-section">
      <SectionTitle title="Kontakt"/>
      <ion-list>
        <ion-item>
          <ion-icon :icon="locationOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>Adresse</h3>
            <p>Höchstädtplatz 6, 1200 Wien, Österreich</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="callOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>Telefon</h3>
            <p>+43 1 333 40 77-0</p>
          </ion-label>
        </ion-item>
        <ion-item>
          <ion-icon :icon="mailOutline" slot="start" color="primary"/>
          <ion-label>
            <h3>E-Mail</h3>
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
