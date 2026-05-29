<template>
  <PageLayout title="Legal Notice">
    <div class="content-section">
      <SectionTitle title="Legal Notice" />

      <h3>Operator</h3>
      <p>
        Boutique Hotel Technikum GmbH<br />
        Höchstädtplatz 6<br />
        1200 Vienna, Austria
      </p>

      <h3>Contact</h3>
      <p>
        Phone: +43 1 333 40 77-0<br />
        Email: info@hotel-technikum.at
      </p>

      <h3>Business Purpose</h3>
      <p>Hotel and accommodation services</p>

      <h3>VAT Number</h3>
      <p>ATU12345678</p>

      <h3>Company Register Number</h3>
      <p>FN 123456a, Commercial Court Vienna</p>

      <h3>Supervisory Authority</h3>
      <p>Municipal Authority of the City of Vienna</p>

      <h3>Disclaimer</h3>
      <p>
        Despite careful content review, we assume no liability for the content of external links.
        The operators of the linked pages are solely responsible for their content.
      </p>

      <h3>Copyright</h3>
      <p>
        The content and works on these pages created by the site operator are subject to Austrian
        copyright law. Reproduction, editing, distribution, and any form of use beyond the limits
        of copyright law require the written consent of the respective author or creator.
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
