<template  >
  <v-row justify="center">
    <v-dialog v-model="LoginDialog" max-width="600px" v-if="(this.$store.state.user.role)=='NONE'">
      <template v-slot:activator="{ on }">
        <v-btn class="mx-1" text color="primary" v-on="on">
          <span>Login</span>
          <v-icon right>lock_open</v-icon>
        </v-btn>
      </template>
      <div class="detailsBorderColor">
        <v-card>
          <v-card-title>
            <span class="primary--text font-italic headline" primary-title>Login</span>
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="LoginDialog =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form">
                <v-text-field
                  label="Username*"
                  color="black"
                  v-model="user.username"
                  required
                  :rules="emailRules"
                ></v-text-field>

                <v-text-field
                  color="black"
                  label="Password*"
                  v-model="user.password"
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
      </div>
    </v-dialog>
  </v-row>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    LoginDialog: false,
    passwordRules: [v => !!v || "Password is required"],
    user: {
      username: "",
      password: ""
    },
    emailRules: [
      v => !!v || "Username is required"
      //v => /.+@.+\..+/.test(v) || "Username must be valid"
    ]
  }),
  methods: {
    login() {
      if (this.$refs.form.validate()) {
        console.log(this.user.password + " " + this.user.username);
        axios
          .post("/login", this.user)
          .then(response => {
            localStorage.setItem("loggedUser", JSON.stringify(response.data));
           /* this.$store.state.user = JSON.parse(
              localStorage.getItem("loggedUser")
            );*/
            this.$store.commit( 'login', JSON.parse(
              localStorage.getItem("loggedUser")
            ));

            console.log("ROLE: " + this.$store.state.user.role);
            this.$emit("loggedIn");
            location.reload();
          })
          .catch(error => {
            console.log(error);
            this.$emit("notLoggedIn");
          });
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
  border-left: 1px solid #ff8a65;
  border-top: 1px solid #ff8a65;
  border-right: 1px solid #ff8a65;
  border-bottom: 1px solid #ff8a65;
}
.detailsBorderColor {
  border-left: 1.5px solid #ff8a65;
  border-top: 1.5px solid #ff8a65;
  border-right: 1.5px solid #ff8a65;
  border-bottom: 1.5px solid #ff8a65;
}
</style>