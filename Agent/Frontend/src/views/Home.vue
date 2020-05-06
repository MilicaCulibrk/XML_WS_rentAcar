<template>
  <div>
    <!-- donji toolbar -->
    <v-app-bar dark flat height="60">
      <span class="mx-16"></span>
      <v-tooltip bottom color="black">
        <template v-slot:activator="{ on }">
          <v-app-bar-nav-icon @click="drawerAdvancedSearch = !drawerAdvancedSearch" v-on="on">
            <v-icon large color="deep-orange lighten-2">menu_open</v-icon>
          </v-app-bar-nav-icon>
        </template>
        <span class="primary--text">Advanced Search</span>
      </v-tooltip>
    </v-app-bar>

    <!-- navigation drawer -->
    <v-navigation-drawer v-model="drawerAdvancedSearch" clipped app floating></v-navigation-drawer>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      drawerAdvancedSearch: false
    };
  }
};
</script>
