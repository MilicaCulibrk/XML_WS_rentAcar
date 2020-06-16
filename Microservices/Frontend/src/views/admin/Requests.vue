<template>
<v-row align="center">

    <v-expansion-panels
      :popout=true
      :multiple=true
    >
      <v-expansion-panel
        v-for="request in requests"
        :key="request.id"
      >
        <v-expansion-panel-header>Request {{request.id}} - {{request.status}}</v-expansion-panel-header>
        <v-expansion-panel-content>
          <v-expansion-panels>
            <v-expansion-panel
              v-for="purchase in request.purchaseDTOS"
              :key="purchase.id"
            >
              <v-expansion-panel-header>
                <v-row no-gutters>
                  <v-col cols="4">Car {{purchase.id_add}}</v-col>
                  <v-col
                    cols="8"
                    class="text--secondary"
                  >
                    <v-fade-transition leave-absolute>
                      <v-row
                        no-gutters
                        style="width: 100%"
                      >
                        <v-col cols="6">Start date: {{purchase.date_from}}</v-col>
                        <v-col cols="6">End date: {{purchase.date_to}}</v-col>
                      </v-row>
                    </v-fade-transition>
                  </v-col>
                </v-row>
              </v-expansion-panel-header>
              <v-expansion-panel-content>
              </v-expansion-panel-content>
            </v-expansion-panel>
            <v-container fluid>
              <v-row>
                <v-col cols="10"></v-col>
                <v-col cols="1">
                  <v-tooltip bottom color="white">
                    <template v-slot:activator="{ on }">
                      <v-btn icon v-on="on" color="green">
                        <v-icon>mdi-check</v-icon>
                      </v-btn>
                    </template>
                    <span class="green--text">Accept</span>
                  </v-tooltip>
                </v-col>
                <v-col cols="1">
                  <v-tooltip bottom color="white">
                    <template v-slot:activator="{ on }">
                      <v-btn icon v-on="on" color="red">
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
</template>

<script>
import axios from "axios";

export default {

  data() {
    return {
        requests: [],
    };
  },
  methods: {
  
  },
  mounted() {
      axios
    .get("/rent-service/request/")
    .then(requests => {
      this.requests = requests.data;
      console.log( this.requests);
    })
    .catch(error => {
      console.log(error);
    });
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
</style>
