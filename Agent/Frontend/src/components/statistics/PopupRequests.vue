<template>
  <div class="text-center">
    <v-dialog v-model="dialog1" max-width="750px">
      <template #activator="{ on: dialog1 }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog1 }" color="primary">
              <v-icon>check_box</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View requests</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            {{car.brand_name}} {{car.vehicle_model_name}} requests
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialog1 =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="pl-12 pr-12">
            <v-container>
              <v-row align="center">
                <v-expansion-panels :popout="true" :multiple="true" :focusable="true">
                  <v-expansion-panel
                    v-for="request in companyRequests"
                    :key="request.id"
                    class="cardBorderColor"
                  >
                    <v-expansion-panel-header>
                      Request {{ request.id }} -
                      {{ request.status }}
                    </v-expansion-panel-header>
                    <v-expansion-panel-content>
                      <v-expansion-panels>
                        <v-expansion-panel
                          v-for="purchase in request.purchaseDTOS"
                          :key="purchase.id"
                          class="cardBorderColor"
                        >
                          <v-expansion-panel-header>
                            <v-row no-gutters>
                              <v-col cols="4" class="primary--text">
                                Car {{ purchase.id_add }} -
                                {{ purchase.brand_model }}
                              </v-col>
                              <v-col cols="8" class="text--secondary">
                                <v-fade-transition leave-absolute>
                                  <v-row no-gutters style="width: 100%">
                                    <v-col cols="6">Start date: {{ purchase.date_from }}</v-col>
                                    <v-col cols="6">End date: {{ purchase.date_to }}</v-col>
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
                                    <v-col cols="6">Owner: {{ purchase.owner }}</v-col>
                                    <v-col cols="6">Client: {{ purchase.client }}</v-col>
                                  </v-row>
                                </v-fade-transition>
                              </v-col>
                            </v-row>
                          </v-expansion-panel-content>
                        </v-expansion-panel>
                      </v-expansion-panels>
                    </v-expansion-panel-content>
                  </v-expansion-panel>
                </v-expansion-panels>
              </v-row>
            </v-container>
          </v-card-text>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  props: {
    car: {}
  },
  data() {
    return {
      dialog1: false,
      requests: {},
      companyRequests: []
    };
  },
  methods: {
    getRequests() {
      axios
        .get("/request/from/" + this.$store.state.user.username)
        .then(requests => {
          this.requests = requests.data;
          this.getCompanyRequests();
        })
        .catch(error => {
          console.log(error);
        });
    },
    getCompanyRequests() {
      var i = 0;
      for (i = 0; i < this.requests.length; i++) {
        var j = 0;
        for (j = 0; j < this.requests[i].purchaseDTOS.length; j++) {
          if (this.requests[i].purchaseDTOS[j].id_add == this.car.id) {
            this.companyRequests.push(this.requests[i]);
          }
        }
      }
    }
  },
  mounted() {
    this.getRequests();
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
