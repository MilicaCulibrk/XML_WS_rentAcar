<template  >
  <v-row justify="center" >
    <v-dialog v-model="LoginDialog" max-width="600px" v-if="(this.$store.state.user.role)=='NONE'">
      <template v-slot:activator="{ on }" >
        <v-btn class="mx-1" text color="primary"  v-on="on">
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
                v-model="user.email"
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
    </v-dialog>
  </v-row>
</template>

<script>
import axios from "axios";
import AppVue from '../../App.vue';
export default {
  data: () => ({
    LoginDialog: false,
    passwordRules: [v => !!v || "Password is required"],
    user:{
      email: "",
      password: "",
    },
    
    emailRules: [
      v => !!v || "E-mail is required",
      //v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ]
  }),
  methods: {
    login() {
      if (this.$refs.form.validate()) {
        console.log(this.user.password + " " + this.user.email);
        axios
        .post("/user-service/login", this.user)
        .then(response => {      
            console.log( "nesto i od mene: " + this.$store.state.user.role);
            alert("Uspesno ste se logovali!");
            localStorage.setItem("loggedUser", JSON.stringify(response.data));
            this.$store.state.user = JSON.parse(localStorage.getItem("loggedUser"));
            console.log( this.$store.state.user.role);
            this.LoginDialog = false;
            AppVue.data.logged = true;
            console.log(response.data)         
            }) 
        .catch(error => {
            console.log(error)
            alert("Pogresan email ili lozinka!");
        })
 
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
  border-left: 2px solid #fbc02d;
  border-top: 2px solid #fbc02d;
  border-right: 2px solid #fbc02d;
  border-bottom: 2px solid #fbc02d;
}
</style>