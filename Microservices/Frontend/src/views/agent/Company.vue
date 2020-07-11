<template>
  <div>
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>

    <v-card max-width="600" class="mx-auto mt-12">
      <!-- toolbar -->

      <v-toolbar color="primary" dark>
        <v-icon large>business</v-icon>

        <v-toolbar-title class="ml-4">Companies</v-toolbar-title>
      </v-toolbar>
      <!-- lista -->
      <v-list two-line subheader>
        <v-list-item v-for="company in companies" :key="company.id">
          <v-list-item-content class="mt-2">
            <v-list-item-title v-text="company.name"></v-list-item-title>
            <v-list-item-subtitle v-text="company.username"></v-list-item-subtitle>
            <v-list-item-subtitle v-text="company.address"></v-list-item-subtitle>
            <v-list-item-subtitle v-text="company.company_number"></v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <AddCompanyDialog
        @registered="snackbarSuccess = true; snackbarSuccessText='You are registered! Please login.'"
        @notRegistered="snackbarDanger = true; snackbarDangerText='Can not register.'"
        @getcompanies="getcompanies()"
      ></AddCompanyDialog>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import AddCompanyDialog from "@/components/company/AddCompanyDialog";
export default {
  components: { AddCompanyDialog },
  data() {
    return {
      companies: [],
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: ""
    };
  },
  methods: {
    getcompanies() {
      axios
        .get("/user-service/company")
        .then(response => {
          this.companies = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.getcompanies();
  }
};
</script>