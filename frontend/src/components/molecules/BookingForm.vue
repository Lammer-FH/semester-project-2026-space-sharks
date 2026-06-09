<template>
  <div class="booking-form">
    <SectionTitle
      title="Guest Information"
      subtitle="Please enter your details"
    />

    <ion-list>
      <ion-item :class="{ 'has-error': errors.firstName }">
        <ion-input
          label="First Name"
          label-placement="stacked"
          placeholder="John"
          :value="firstName"
          @ion-input="$emit('update:firstName', ($event.target as any).value)"
        />
      </ion-item>
      <p v-if="errors.firstName" class="field-error">{{ errors.firstName }}</p>

      <ion-item :class="{ 'has-error': errors.lastName }">
        <ion-input
          label="Last Name"
          label-placement="stacked"
          placeholder="Doe"
          :value="lastName"
          @ion-input="$emit('update:lastName', ($event.target as any).value)"
        />
      </ion-item>
      <p v-if="errors.lastName" class="field-error">{{ errors.lastName }}</p>

      <ion-item :class="{ 'has-error': errors.email }">
        <ion-input
          type="email"
          label="Email"
          label-placement="stacked"
          placeholder="john.doe@example.com"
          :value="email"
          @ion-input="$emit('update:email', ($event.target as any).value)"
        />
      </ion-item>
      <p v-if="errors.email" class="field-error">{{ errors.email }}</p>

      <ion-item :class="{ 'has-error': errors.confirmEmail }">
        <ion-input
          type="email"
          label="Confirm Email"
          label-placement="stacked"
          placeholder="john.doe@example.com"
          :value="confirmEmail"
          @ion-input="$emit('update:confirmEmail', ($event.target as any).value)"
        />
      </ion-item>
      <p v-if="errors.confirmEmail" class="field-error">{{ errors.confirmEmail }}</p>

      <ion-item>
        <ion-toggle
          :checked="breakfast"
          @ion-change="$emit('update:breakfast', ($event.detail as any).checked as boolean)"
        >
          Include breakfast
        </ion-toggle>
      </ion-item>
    </ion-list>

    <div class="form-actions">
      <ion-button expand="block" color="primary" @click="onContinue">
        Continue to Review
      </ion-button>
      <ion-button expand="block" fill="outline" color="medium" @click="$emit('back')">
        Back
      </ion-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { IonList, IonItem, IonInput, IonToggle, IonButton } from '@ionic/vue';
import SectionTitle from '@/components/atoms/SectionTitle.vue';

const props = defineProps<{
  firstName: string;
  lastName: string;
  email: string;
  confirmEmail: string;
  breakfast: boolean;
}>();

const emit = defineEmits<{
  'update:firstName': [value: string];
  'update:lastName': [value: string];
  'update:email': [value: string];
  'update:confirmEmail': [value: string];
  'update:breakfast': [value: boolean];
  continue: [];
  back: [];
}>();

const submitted = ref(false);

const errors = computed(() => {
  if (!submitted.value) return {};
  const e: Record<string, string> = {};
  if (!props.firstName.trim()) e.firstName = 'First name is required.';
  if (!props.lastName.trim()) e.lastName = 'Last name is required.';
  if (!props.email.trim()) {
    e.email = 'Email is required.';
  } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(props.email)) {
    e.email = 'Please enter a valid email address.';
  }
  if (!props.confirmEmail.trim()) {
    e.confirmEmail = 'Please confirm your email address.';
  } else if (props.confirmEmail !== props.email) {
    e.confirmEmail = 'Email addresses do not match.';
  }
  return e;
});

function onContinue() {
  submitted.value = true;
  if (Object.keys(errors.value).length === 0) {
    emit('continue');
  }
}
</script>

<style scoped>
.booking-form {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.has-error {
  --border-color: var(--ion-color-danger) !important;
}

.field-error {
  color: var(--ion-color-danger);
  font-size: 0.8rem;
  margin: 4px 16px 0;
  padding: 0;
}

.form-actions {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-top: 8px;
}
</style>
