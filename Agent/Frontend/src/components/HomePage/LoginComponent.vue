<template>
  <v-row justify="center">
    <v-dialog v-model="LoginDialog" max-width="600px">
      <template v-slot:activator="{ on }">
        <v-btn class="mx-1" text color="primary" v-on="on">
          <span>Login</span>
          <v-icon right>lock_open</v-icon>
        </v-btn>
      </template>
      <v-card class="cardBorderColor">
        <v-card-title>
          <span class="primary--text font-italic headline" primary-title>Login</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-form ref="form">
              <v-text-field
                label="Email*"
                color="black"
                v-model="email"
                required
                :rules="emailRules"
              ></v-text-field>

              <v-text-field
                color="black"
                label="Password*"
                v-model="password"
                type="password"
                required
                :rules="passwordRules"
              ></v-text-field>
            </v-form>
          </v-container>
        </v-card-text>
        <v-card-actions class="pr-10 pb-10">
          <v-spacer></v-spacer>
          <v-btn text color="primary" @click="close">Close</v-btn>
          <v-btn color="primary" @click="login">Login</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    LoginDialog: false,
    password: "",
    passwordRules: [v => !!v || "Password is required"],
    email: "",
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ]
  }),
  methods: {
    login() {
      if (this.$refs.form.validate()) {
        console.log(this.password + " " + this.email);
        if (this.email == "admin@gmail.com") {
          this.close();
          this.$emit("loggedIn");
          this.$router.push("/admin");
        } else if (this.email == "user@gmail.com") {
          this.$router.push("/user");
        } else if (this.email == "agent@gmail.com") {
          this.$router.push("/agent");
        } else {
          this.$emit("notLoggedIn");
          console.log("nije validno");
        }
      } else {
        console.log("nije validno");
      }
    },
    close() {
      this.LoginDialog = false;
      this.$refs.form.reset();
    }
  }
};
</script>

<style scoped>
.cardBorderColor {
  border-left: 1.5px solid #ff8a65;
  border-top: 1.5px solid #ff8a65;
  border-right: 1.5px solid #ff8a65;
  border-bottom: 1.5px solid #ff8a65;
}
</style>