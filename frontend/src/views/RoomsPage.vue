<template>
  <PageLayout title="Zimmer">
    <div class="content-section">
      <SectionTitle
        title="Unsere Zimmer"
        subtitle="Wählen Sie Ihr perfektes Zimmer"
      />
      <p class="placeholder-text">
        Zimmerübersicht wird in Sprint 2 implementiert.
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
  max-width: 900px;
  margin: 0 auto;
}

.placeholder-text {
  text-align: center;
  color: var(--ion-color-medium);
}
</style>
