<template>
  <div class="pagination">
    <ion-button
      fill="outline"
      size="small"
      :disabled="currentPage === 0"
      @click="$emit('pageChange', currentPage - 1)"
    >
      Previous
    </ion-button>

    <ion-button
      v-for="page in pages"
      :key="page"
      :fill="page === currentPage ? 'solid' : 'outline'"
      size="small"
      @click="$emit('pageChange', page)"
    >
      {{ page + 1 }}
    </ion-button>

    <ion-button
      fill="outline"
      size="small"
      :disabled="currentPage >= totalPages - 1"
      @click="$emit('pageChange', currentPage + 1)"
    >
      Next
    </ion-button>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { IonButton } from '@ionic/vue';

const props = defineProps<{
  currentPage: number;
  totalPages: number;
}>();

defineEmits<{
  pageChange: [page: number];
}>();

const pages = computed(() =>
  Array.from({ length: props.totalPages }, (_, i) => i)
);
</script>

<style scoped>
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;
  padding: 16px 0;
  flex-wrap: wrap;
}
</style>
