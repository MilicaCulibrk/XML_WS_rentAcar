<template>
  <nav>
    <!-- gornji toolbar -->
    <v-toolbar flat class="mx-12" height="50">
      <v-toolbar-title>
        <v-icon left large color="primary">directions_car</v-icon>
        <span class="font-italic font-weight-bold">Rent-A-CaR</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text color="primary">
        <span @click="openCart()">Cart</span>
        <v-icon right>shopping_cart</v-icon>
      </v-btn>
      <div class="mx-2">
        <LoginComponent />
      </div>
      <div class="mx-2">
        <RegistrationComponent />
      </div>
    </v-toolbar>
  </nav>
</template>

<script>
import LoginComponent from "@/components/LoginComponent.vue";
import RegistrationComponent from "@/components/RegistrationComponent.vue";
  components: {
    LoginComponent,
    RegistrationComponent
  },
  methods: {
    openCart() {
      this.$router.push("/cart");
    }
  }
};
</script>
