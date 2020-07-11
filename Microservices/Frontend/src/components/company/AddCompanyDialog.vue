<template>
  <div class="text-center">
    <v-dialog v-model="dialog1" max-width="750px">
      <template #activator="{ on: dialog1 }">
        <v-tooltip bottom color="black">
          <template v-slot:activator="{ on: tooltip }">
            <v-btn
              absolute
              dark
              fab
              medium
              bottom
              right
              color="primary"
              v-on="{ ...tooltip, ...dialog1 }"
            >
              <v-icon>add</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">Add new company</span>
        </v-tooltip>
      </template>

      <div class="detailsBorderColor">
        <v-card>
          <v-card-title>
            <span class="primary--text font-italic headline" primary-title>Add new company</span>
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialog1 =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form">
                <v-text-field
                  label="Company name*"
                  color="black"
                  v-model="company.name"
                  required
                  :rules="requiredRules"
                ></v-text-field>
                <v-text-field
                  label="Company username*"
                  color="black"
                  v-model="company.username"
                  required
                  :rules="requiredRules"
                ></v-text-field>
                <v-text-field
                  label="Company address*"
                  color="black"
                  v-model="company.address"
                  required
                  :rules="requiredRules"
                ></v-text-field>
                <v-text-field
                  label="Company number*"
                  color="black"
                  v-model="company.company_number"
                  required
                  :rules="requiredRules"
                ></v-text-field>
                <v-text-field
                  color="black"
                  label="Password*"
                  v-model="company.password"
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
            <v-btn color="primary" @click="register()">Register</v-btn>
          </v-card-actions>
        </v-card>
      </div>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    dialog1: false,
    company: {
      name: "",
      username: "",
      adrress: "",
      company_number: "",
      password: "",
      phone_number: "0",
      city: "Novi Sad",
      email: "company@gmail.com"
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
        this.company.password === this.confirmation || "Passwords must match";
    }
  },
  methods: {
    register() {
      if (this.$refs.form.validate()) {
        axios
          .post("/user-service/register/company", this.company)
          .then(response => {
            this.$emit("registered");
            this.$emit("getcompanies");
            this.dialog1 = false;
            this.$refs.form.reset();
            console.log(response.data);
          })
          .catch(error => {
            console.log(error);
            this.$emit("notRegistered");
          });
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

<style>
.cardBorderColor {
  border-left: 1px solid #fbc02d;
  border-top: 1px solid #fbc02d;
  border-right: 1px solid #fbc02d;
  border-bottom: 1px solid #fbc02d;
}

.detailsBorderColor {
  border-left: 1.5px solid #fbc02d;
  border-top: 1.5px solid #fbc02d;
  border-right: 1.5px solid #fbc02d;
  border-bottom: 1.5px solid #fbc02d;
}
</style>