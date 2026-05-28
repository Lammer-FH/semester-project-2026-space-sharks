<template>
  <div class="room-image-wrapper">
    <img :src="src" :alt="alt" class="room-image" />
  </div>
</template>

<script setup lang="ts">
defineProps<{
  src: string;
  alt: string;
}>();
</script>

<style scoped>
.room-image-wrapper {
  width: 100%;
  aspect-ratio: 16 / 10;
  overflow: hidden;
  border-radius: 8px 8px 0 0;
}

.room-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
}
</style>
