<template>
  <nav>
    <!-- snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="4000" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>

    <v-snackbar v-model="snackbarDanger" :timeout="4000" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>

    <!-- gornji toolbar -->
    <v-toolbar flat class="mx-12" height="50">
      <v-toolbar-title>
        <v-icon left large color="primary">directions_car</v-icon>
        <span class="font-italic font-weight-bold">Rent-A-CaR</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text color="primary">
        <span @click="openCodebook()">Codebook</span>
        <v-icon right>list_alt</v-icon>
      </v-btn>
      <v-btn text color="primary">
        <span @click="openCart()">Cart</span>
        <v-icon right>shopping_cart</v-icon>
      </v-btn>
      <v-btn text color="primary">
        <span @click="openAddNewAddvertisment()">New Addvertisement</span>
        <v-icon right>add</v-icon>
      </v-btn>
      <div class="mx-2">
        <LoginComponent
          @loggedIn="snackbarSuccess = true; snackbarSuccessText='You are logged in!'"
          @notLoggedIn="snackbarDanger = true; snackbarDangerText='Can not log in. There is no such user!'"
        />
      </div>
      <div class="mx-2">
        <RegistrationComponent />
      </div>
    </v-toolbar>
  </nav>
</template>

<script>
import LoginComponent from "@/components/homePage/LoginComponent.vue";
import RegistrationComponent from "@/components/homePage/RegistrationComponent.vue";

export default {
  components: {
    LoginComponent,
    RegistrationComponent
  },
  data() {
    return {
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: ""
    };
  },
  methods: {
    openCart() {
      this.$router.push("/cart");
    },
    openAddNewAddvertisment() {
      this.$router.push("/addNewAddvertisment");
    },
    openCodebook() {
      this.$router.push("/codebook");
    }
  }
};
</script>
