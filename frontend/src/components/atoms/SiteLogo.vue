<!-- components/Logo.vue -->
<template>
  <router-link to="/" class="logo-link">
    <div class="logo-container">
      <svg class="logo-svg" viewBox="35 0 200 60" xmlns="http://www.w3.org/2000/svg">
        <circle cx="60" cy="32" r="12" fill="none" stroke="#ffffff" stroke-width="2.5"/>
        <circle cx="60" cy="32" r="4" fill="#ffffff"/>
        <line x1="68" y1="38" x2="76" y2="46" stroke="#ffffff" stroke-width="2.5"/>
        
        <!-- Текст -->
        <text x="85" y="30" font-family="Arial, sans-serif" font-weight="bold" font-size="16" fill="#ffffff">
          BOUTIQUE HOTEL
        </text>
        <text x="85" y="46" font-family="Arial, sans-serif" font-weight="600" font-size="12" fill="#ffffff" opacity="0.8">
          TECHNIKUM
        </text>
      </svg>
    </div>
  </router-link>
</template>

<style scoped>
.logo-link {
  text-decoration: none;
  cursor: pointer;
  display: inline-block;
}

.logo-container {
  display: flex;
  align-items: center;
  height: 56px;
}

.logo-svg {
  height: 48px;
  width: auto;
}

@media (max-width: 768px) {
  .logo-svg {
    height: 40px;
  }
}
</style>