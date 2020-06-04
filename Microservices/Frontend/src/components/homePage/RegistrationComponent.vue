<template>
  <v-row justify="center">
    <v-dialog v-model="RegisterDialog" max-width="600px" v-if="(this.$store.state.user.role)=='NONE'">
      <template v-slot:activator="{ on }">
        <v-btn text color="primary" v-on="on">
          <span>Register</span>
          <v-icon right>person_pin</v-icon>
        </v-btn>
      </template>
      <v-card class="cardBorderColor">
        <v-card-title>
          <span class="primary--text font-italic headline" primary-title>Registration</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-form ref="form">
              <v-text-field
                label="Name*"
                color="black"
                v-model="user.name"
                required
                :rules="requiredRules"
              ></v-text-field>
              <v-text-field
                label="Surname*"
                color="black"
                v-model="user.surname"
                required
                :rules="requiredRules"
              ></v-text-field>
              <v-text-field
                label="Phone number*"
                color="black"
                v-model="user.phone_number"
                required
                :rules="requiredRules"
              ></v-text-field>
              <v-text-field
                label="Address*"
                color="black"
                v-model="user.address"
                required
                :rules="requiredRules"
              ></v-text-field>
              <v-text-field
                label="City*"
                color="black"
                v-model="user.city"
                required
                :rules="requiredRules"
              ></v-text-field>
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
                :rules="requiredRules"
              ></v-text-field>
              <v-text-field
                color="black"
                label="Confirm password*"
                v-model="confirmation"
                type="password"
                required
                :rules="[passwordConfirmationRule]"
              ></v-text-field>
            </v-form>
          </v-container>
        </v-card-text>
        <v-card-actions class="pr-10 pb-10">
          <v-spacer></v-spacer>
          <v-btn text color="primary" @click="close">Close</v-btn>
          <v-btn color="primary" @click="register">Register</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    RegisterDialog: false,
    user: {
      name: "",
      surname: "",
      phone_number: "",
      adrress: "",
      city: "",
      email: "",
      password: ""
    },
    confirmation: "",
    requiredRules: [v => !!v || "This field is required"],
    passwordRules: [
      v => !!v || "This is required",
      v => v == this.confirmation || "Passwords do not match"
    ],
    emailRules: [
      v => !!v || "This field is required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ]
  }),
  computed: {
    passwordConfirmationRule() {
      return () =>
        this.user.password === this.confirmation || "Passwords must match";
    }
  },
  methods: {
    register() {
      if (this.$refs.form.validate()) {
        console.log(this.user.email);
       axios
        .post("/user-service/register", this.user)
        .then(response => {      
            this.$emit("registered");
            console.log(response.data)         
            }) 
        .catch(error => {
            console.log(error)
            this.$emit("notRegistered");
        })        
      } else {
        console.log("nije validno");
      }
    },
    close() {
      this.RegisterDialog = false;
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

.detailsBorderColor {
  border-left: 1.5px solid #fbc02d;
  border-top: 1.5px solid #fbc02d;
  border-right: 1.5px solid #fbc02d;
  border-bottom: 1.5px solid #fbc02d;
}
</style>