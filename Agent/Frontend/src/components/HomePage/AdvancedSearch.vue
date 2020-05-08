<template>
  <v-navigation-drawer v-model="drawerAdvancedSearch" clipped app floating width="350"></v-navigation-drawer>
</template>

<script>
export default {
  props: {
    drawerAdvancedSearch: {
      default: ""
    }
  }
};
</script>
