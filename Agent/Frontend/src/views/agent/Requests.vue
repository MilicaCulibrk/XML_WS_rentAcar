<template>
  <div>
    <!-- Snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{ snackbarSuccessText }}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{ snackbarDangerText }}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>
    <v-container class="mt-12 pt-12">
      <v-row align="center">
        <v-expansion-panels :popout="true" :multiple="true" :focusable="true">
          <v-expansion-panel
            v-for="request in requests"
            :key="request.id"
            class="detailsBorderColor"
          >
            <v-expansion-panel-header
              >Request {{ request.id }} -
              {{ request.status }}</v-expansion-panel-header
            >
            <v-expansion-panel-content>
              <v-expansion-panels>
                <v-expansion-panel
                  v-for="purchase in request.purchaseDTOS"
                  :key="purchase.id"
                  class="cardBorderColor"
                >
                  <v-expansion-panel-header>
                    <v-row no-gutters>
                      <v-col cols="4" class="primary--text"
                        >Car {{ purchase.id_add }} -
                        {{ purchase.brand_model }}</v-col
                      >
                      <v-col cols="8" class="text--secondary">
                        <v-fade-transition leave-absolute>
                          <v-row no-gutters style="width: 100%">
                            <v-col cols="6"
                              >Start date: {{ purchase.date_from }}</v-col
                            >
                            <v-col cols="6"
                              >End date: {{ purchase.date_to }}</v-col
                            >
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
                            <v-col cols="6"
                              >Client: {{ purchase.client }}</v-col
                            >
                          </v-row>
                        </v-fade-transition>
                      </v-col>
                    </v-row>
                  </v-expansion-panel-content>
                  <v-row>
                    <v-col cols="2"></v-col>
                    <v-col cols="2"></v-col>
                    <v-col cols="2"></v-col>
                    <v-col cols="2"></v-col>
                    <v-col cols="2"></v-col>
                    <v-col cols="2">
                      <div
                        v-if="
                          request.status == 'PAID' &&
                            purchase.date_to <
                              new Date().toISOString().slice(0, 10) + 2
                        "
                      >
                        <div
                          v-for="(purchaseId, idx) in purchaseIds"
                          :key="idx"
                        >
                          <div v-if="purchaseId == purchase.id">
                            <ReportDialog
                              v-bind:purchase="purchase"
                              v-bind:greenReport="true"
                              @addedReport="
                                snackbarSuccess = true;
                                snackbarSuccessText = 'You added the report!';
                              "
                              @changedReport="
                                snackbarSuccess = true;
                                snackbarSuccessText = 'You changed the report!';
                              "
                              @notAddedReport="
                                snackbarDanger = true;
                                snackbarDangerText =
                                  'Report not added, something went wrong!';
                              "
                              @notChangedReport="
                                snackbarDanger = true;
                                snackbarDangerText =
                                  'Report not changed, something went wrong!';
                              "
                              @emptyKilometres="
                                snackbarDanger = true;
                                snackbarDangerText = 'You must add kilometres!';
                              "
                            ></ReportDialog>
                          </div>
                        </div>
                        <div
                          v-for="(redId, index) in redIds"
                          :key="index - 100"
                        >
                          <div v-if="redId == purchase.id">
                            <ReportDialog
                              v-bind:purchase="purchase"
                              v-bind:greenReport="false"
                              @addedReport="
                                snackbarSuccess = true;
                                snackbarSuccessText = 'You added the report!';
                              "
                              @changedReport="
                                snackbarSuccess = true;
                                snackbarSuccessText = 'You changed the report!';
                              "
                              @notAddedReport="
                                snackbarDanger = true;
                                snackbarDangerText =
                                  'Report not added, something went wrong!';
                              "
                              @notChangedReport="
                                snackbarDanger = true;
                                snackbarDangerText =
                                  'Report not changed, something went wrong!';
                              "
                              @emptyKilometres="
                                snackbarDanger = true;
                                snackbarDangerText = 'You must add kilometres!';
                              "
                            ></ReportDialog>
                          </div>
                        </div>
                      </div>
                    </v-col>
                  </v-row>
                </v-expansion-panel>
                <v-container fluid v-if="request.status == 'PENDING'">
                  <v-row>
                    <v-col cols="10"></v-col>
                    <v-col cols="1">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn
                            icon
                            v-on="on"
                            color="green"
                            @click="acceptRequest(request.id)"
                          >
                            <v-icon>mdi-check</v-icon>
                          </v-btn>
                        </template>
                        <span class="green--text">Accept</span>
                      </v-tooltip>
                    </v-col>
                    <v-col cols="1">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn
                            icon
                            v-on="on"
                            color="red"
                            @click="declineRequest(request.id)"
                          >
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
import ReportDialog from "@/components/requests/ReportDialog";
export default {
  components: { ReportDialog },
  data() {
    return {
      requests: [],
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      reportsList: [],
      purchaseList: [],
      purchaseIds: [],
      redIds: [],
      greenReport: true,
      greenReportFalse: false,
    };
  },
  methods: {
    acceptRequest(id) {
      axios
        .put("/request/" + id)
        .then((response) => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Request is accepted!";
          console.log(response);
          this.getRequests();
        })
        .catch((error) => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    declineRequest(id) {
      axios
        .put("/request/decline/" + id)
        .then((response) => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Request is canceled!";
          console.log(response);
          this.getRequests();
        })
        .catch((error) => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    getRequests() {
      axios
        .get("/request/to/" + this.$store.state.user.username)
        .then((requests) => {
          this.requests = requests.data;
          console.log(this.requests);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getPurchases() {
      axios
        .get("/purchase")
        .then((purchaseList) => {
          this.purchaseList = purchaseList.data;
          this.searchPurchases();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getReports() {
      axios
        .get("/purchase/report")
        .then((reportsList) => {
          this.reportsList = reportsList.data;
          this.getPurchases();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    searchPurchases() {
      var i = 0;
      for (i = 0; i < this.reportsList.length; i++) {
        this.purchaseIds.push(this.reportsList[i].purchase_id);
      }

      this.setRedIds();
    },
    setRedIds() {
      var i = 0;
      for (i = 0; i < this.purchaseList.length; i++) {
        var j = 0;
        var flag = 0;
        for (j = 0; j < this.purchaseIds.length; j++) {
          if (this.purchaseList[i].id == this.purchaseIds[j]) {
            flag = 1;
          }
        }

        if (flag == 0) {
          this.redIds.push(this.purchaseList[i].id);
        }
      }
    },
  },
  mounted() {
    this.getReports();
    this.getRequests();
  },
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
