<template>
  <PageLayout title="Impressum">
    <div class="content-section">
      <SectionTitle title="Impressum" />

      <h3>Betreiber</h3>
      <p>
        Boutique Hotel Technikum GmbH<br />
        Höchstädtplatz 6<br />
        1200 Wien, Österreich
      </p>

      <h3>Kontakt</h3>
      <p>
        Telefon: +43 1 333 40 77-0<br />
        E-Mail: info@hotel-technikum.at
      </p>

      <h3>Unternehmensgegenstand</h3>
      <p>Hotellerie und Beherbergung</p>

      <h3>UID-Nummer</h3>
      <p>ATU12345678</p>

      <h3>Firmenbuchnummer</h3>
      <p>FN 123456a, Handelsgericht Wien</p>

      <h3>Aufsichtsbehörde</h3>
      <p>Magistrat der Stadt Wien</p>

      <h3>Haftungsausschluss</h3>
      <p>
        Trotz sorgfältiger inhaltlicher Kontrolle übernehmen wir keine Haftung für die Inhalte
        externer Links. Für den Inhalt der verlinkten Seiten sind ausschließlich deren Betreiber
        verantwortlich.
      </p>

      <h3>Urheberrecht</h3>
      <p>
        Die durch den Seitenbetreiber erstellten Inhalte und Werke auf diesen Seiten unterliegen
        dem österreichischen Urheberrecht. Die Vervielfältigung, Bearbeitung, Verbreitung und jede
        Art der Verwertung außerhalb der Grenzen des Urheberrechts bedürfen der schriftlichen
        Zustimmung des Autors bzw. Erstellers.
      </p>
    </div>
  </PageLayout>
</template>

<script setup lang="ts">
import PageLayout from '@/components/templates/PageLayout.vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';
</script>

<style scoped>
.content-section {
  padding: 24px 16px;
  max-width: 700px;
  margin: 0 auto;
}

.content-section h3 {
  font-size: 1.1rem;
  font-weight: 600;
  color: var(--ion-color-primary);
  margin: 20px 0 4px 0;
}

.content-section p {
  font-size: 1rem;
  line-height: 1.6;
  color: var(--ion-text-color);
  margin: 0 0 8px 0;
}
</style>
