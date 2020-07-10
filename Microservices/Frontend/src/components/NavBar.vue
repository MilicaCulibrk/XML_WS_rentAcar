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
      <v-toolbar-title @click="openHomePage()">
        <v-icon left large color="primary">directions_car</v-icon>
        <span class="font-italic font-weight-bold">Rent-A-CaR</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        color="primary"
        @click="openUsers()"
        v-if="(this.$store.state.user.role)=='ADMINISTRATOR'"
      >
        <span>Users</span>
        <v-icon right>person_pin</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openCodebook()"
        v-if="(this.$store.state.user.role)=='ADMINISTRATOR'"
      >
        <span>Codebook</span>
        <v-icon right>list_alt</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openStatistics()"
        v-if="(this.$store.state.user.role)=='COMPANY'"
      >
        <span>Statistics</span>
        <v-icon right>bar_chart</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openRequests()"
        v-if="(this.$store.state.user.role)=='COMPANY' || (this.$store.state.user.role)=='USER'"
      >
        <span>Requests</span>
        <v-icon right>check_box</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openPurchases()"
        v-if="(this.$store.state.user.role)=='USER'"
      >
        <span>My purchases</span>
        <v-icon right>list_alt</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openComments()"
        v-if="(this.$store.state.user.role)=='ADMINISTRATOR'"
      >
        <span>Comments</span>
        <v-icon right>mode_comment</v-icon>
      </v-btn>
      <v-btn text color="primary" @click="openCart()" v-if="(this.$store.state.user.role)=='USER'">
        <span>Cart</span>
        <v-icon right>shopping_cart</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        @click="openAddNewAddvertisment()"
        v-if="(this.$store.state.user.role)!='NONE' && (this.$store.state.user.role)!='ADMINISTRATOR'"
      >
        <span>New Add</span>
        <v-icon right>add</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        v-if="(this.$store.state.user.role)!='NONE' && (this.$store.state.user.role)!='ADMINISTRATOR'"
      >
        <span @click="openMyAddvertisments()">My Adds</span>
        <v-icon right>list</v-icon>
      </v-btn>
      <v-btn
        text
        color="primary"
        v-if="(this.$store.state.user.role)!='NONE' && (this.$store.state.user.role)!='ADMINISTRATOR'"
      >
        <span @click="openChat()">Chat</span>
        <v-icon right>sms</v-icon>
      </v-btn>
      <div class="mx-2">
        <LoginComponent
          @loggedIn="snackbarSuccess = true; snackbarSuccessText='You are logged in!'"
          @notLoggedIn="snackbarDanger = true; snackbarDangerText='Can not log in. There is no such user!'"
          @cantLoggedIn="snackbarDanger = true; snackbarDangerText='Can not log in. We are sorry but your account is blocked.'"
        />
      </div>
      <div class="mx-2">
        <RegistrationComponent
          @registered="snackbarSuccess = true; snackbarSuccessText='You are registered! Please login.'"
          @notRegistered="snackbarDanger = true; snackbarDangerText='Can not register.'"
        />
      </div>
      <v-btn text color="primary" v-if="(this.$store.state.user.role)!='NONE'">
        <span @click="logout()">Logout</span>
        <v-icon right>logout</v-icon>
      </v-btn>
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
    openHomePage() {
      this.$router.push("/");
    },
    openUsers() {
      this.$router.push("/admin");
    },
    openCart() {
      this.$router.push("/cart");
    },
    openAddNewAddvertisment() {
      this.$router.push("/addNewAddvertisment");
    },
    openMyAddvertisments() {
      this.$router.push("/myAddvertisments");
    },
    openCodebook() {
      this.$router.push("/codebook");
    },
    openRequests() {
      this.$router.push("/requests");
    },
    openPurchases() {
      this.$router.push("/purchases");
    },
    openComments() {
      this.$router.push("/comments");
    },
    openChat() {
      this.$router.push("/chat");
    },
    openStatistics() {
      this.$router.push("/statistics");
    },
    logout() {
      localStorage.removeItem("loggedUser");
      this.$store.state.user = {};
      this.$store.state.user.role = "NONE";
      this.$store.state.loggedUser = false;
      this.snackbarSuccess = true;
      this.snackbarSuccessText = "You are logged out";
      this.LoginDialog = false;
      this.$router.push("/");
    }
  }
};
</script>
