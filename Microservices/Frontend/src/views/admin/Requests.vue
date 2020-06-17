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
    <v-container class="pt-12 mt-12">
      <v-row align="center">
        <v-expansion-panels :popout="true" :multiple="true" :focusable="true">
          <v-expansion-panel
            v-for="request in requests"
            :key="request.id"
            class="detailsBorderColor"
          >
            <v-expansion-panel-header>Request {{request.id}} - {{request.status}}</v-expansion-panel-header>
            <v-expansion-panel-content>
              <v-expansion-panels>
                <v-expansion-panel
                  v-for="purchase in request.purchaseDTOS"
                  :key="purchase.id"
                  class="cardBorderColor"
                >
                  <v-expansion-panel-header>
                    <v-row no-gutters>
                      <v-col
                        cols="4"
                        class="primary--text"
                      >Car {{purchase.id_add}} - {{purchase.brand_model}}</v-col>
                      <v-col cols="8" class="text--secondary">
                        <v-fade-transition leave-absolute>
                          <v-row no-gutters style="width: 100%">
                            <v-col cols="6">Start date: {{purchase.date_from}}</v-col>
                            <v-col cols="6">End date: {{purchase.date_to}}</v-col>
                          </v-row>
                        </v-fade-transition>
                      </v-col>
                    </v-row>
                  </v-expansion-panel-header>
                  <v-expansion-panel-content>
                    <v-row no-gutters>
                      <v-col cols="4"></v-col>
                      <v-col cols="8" class="text--secondary">
                        <v-fade-transition leave-absolute>
                          <v-row no-gutters style="width: 100%">
                            <v-col cols="6">Owner: {{purchase.owner}}</v-col>
                            <v-col cols="6">Client: {{purchase.client}}</v-col>
                          </v-row>
                        </v-fade-transition>
                      </v-col>
                    </v-row>
                  </v-expansion-panel-content>
                </v-expansion-panel>
                <v-container fluid v-if="request.status=='PENDING'">
                  <v-row>
                    <v-col cols="10"></v-col>
                    <v-col cols="1">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn icon v-on="on" color="green" @click="acceptRequest(request.id)">
                            <v-icon>mdi-check</v-icon>
                          </v-btn>
                        </template>
                        <span class="green--text">Accept</span>
                      </v-tooltip>
                    </v-col>
                    <v-col cols="1">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn icon v-on="on" color="red" @click="declineRequest(request.id)">
                            <v-icon>mdi-close</v-icon>
                          </v-btn>
                        </template>
                        <span class="red--text">Decline</span>
                      </v-tooltip>
                    </v-col>
                  </v-row>
                </v-container>
              </v-expansion-panels>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      requests: [],
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: ""
    };
  },
  methods: {
    acceptRequest(id) {
      axios
        .put("/rent-service/request/" + id)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Request is accepted!";
          console.log(response);
          this.getRequests();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    declineRequest(id) {
      axios
        .put("/rent-service/request/decline/" + id)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Request is canceled!";
          console.log(response);
          this.getRequests();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    getRequests() {
      axios
        .get("/rent-service/request/to/" + this.$store.state.user.username)
        .then(requests => {
          this.requests = requests.data;
          console.log(this.requests);
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.getRequests();
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
