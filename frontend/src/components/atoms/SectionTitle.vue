<template>
  <div class="section-title">
    <h2>{{ title }}</h2>
    <p v-if="subtitle">{{ subtitle }}</p>
  </div>
</template>

<script setup lang="ts">
defineProps<{
  title: string;
  subtitle?: string;
}>();
</script>

<style scoped>
.section-title {
  text-align: center;
  padding: 16px 0;
}

.section-title h2 {
  font-size: 1.5rem;
  font-weight: 700;
  color: var(--ion-color-primary);
  margin: 0 0 4px 0;
}

.section-title p {
  font-size: 0.95rem;
  color: var(--ion-color-medium);
  margin: 0;
}
</style>
