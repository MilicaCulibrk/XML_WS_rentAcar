    <template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="450px">
      <template #activator="{ on: dialogDetails }">
        <div v-if="greenReport == false && greenReportTemp == false">
          <v-tooltip bottom color="black">
            <template #activator="{ on: tooltip }">
              <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
                <v-icon>description</v-icon>
              </v-btn>
            </template>
            <span class="primary--text">Add Report</span>
          </v-tooltip>
        </div>
        <div v-else>
          <v-tooltip bottom color="black">
            <template #activator="{ on: tooltip }">
              <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="green">
                <v-icon>description</v-icon>
              </v-btn>
            </template>
            <span class="green--text">Change Report</span>
          </v-tooltip>
        </div>
      </template>

      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            {{ purchase.brand_model }} report
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails = false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <div v-if="greenReport == false && greenReportTemp == false">
              <v-text-field
                v-model="report.kilometres_crossed"
                label="Kilometres crossed"
                color="primary"
                :rules="[
                  () => !!report.kilometres_crossed || 'This field is required',
                  () =>
                    /^[0-9]*$/.test(report.kilometres_crossed) ||
                    'Only numbers are allowed',
                ]"
              ></v-text-field>

              <v-textarea
                v-model="report.additional_information"
                :rules="rules"
                counter="100"
                label="Additional information"
                outlined
                class="mt-6"
              ></v-textarea>

              <v-row>
                <v-col cols="4"></v-col>
                <v-col cols="4"></v-col>
                <v-col cols="4">
                  <v-btn color="primary" class="ml-12" @click="saveReport()">Add</v-btn>
                </v-col>
              </v-row>
            </div>
            <div v-else>
              <div v-for="report in reportsList" :key="report.id">
                <div v-if="report.purchase_id == purchase.id">
                  <v-text-field
                    v-model="report.kilometres_crossed"
                    label="Kilometres crossed"
                    color="primary"
                    :rules="[
                      () =>
                        !!report.kilometres_crossed || 'This field is required',
                      () =>
                        /^[0-9]*$/.test(report.kilometres_crossed) ||
                        'Only numbers are allowed',
                    ]"
                  ></v-text-field>

                  <v-textarea
                    v-model="report.additional_information"
                    :rules="rules"
                    counter="100"
                    label="Additional information"
                    outlined
                    class="mt-6"
                  ></v-textarea>
                  <v-row>
                    <v-col cols="4"></v-col>
                    <v-col cols="4"></v-col>
                    <v-col cols="4">
                      <v-btn color="primary" class="ml-6" @click="changeReport(report)">Change</v-btn>
                    </v-col>
                  </v-row>
                </div>
              </div>
            </div>
          </v-card-text>
          <v-card-text class="text-center-left"></v-card-text>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  props: {
    purchase: {
      default: ""
    },
    greenReport: {},
    
  },
  data() {
    return {
      dialogDetails: false,
      report: {
        kilometres_crossed: "",
        additional_information: "",
        id_add: this.purchase.id_add
      },
      reportsList: [],
      greenReportTemp: false,
      rules: [v => v.length <= 100 || "Max 100 characters"],
      purchaseUser: {
        username: "",
        active: true,
      },
    };
  },
  methods: {
    saveReport() {
      console.log("add");
      if (this.report.kilometres_crossed == "") {
        this.$emit("emptyKilometres");
      } else {
        axios
          .post(
            "rent-service/purchase/" + this.purchase.id + "/report",
            this.report
          )
          .then(report => {
            this.report = report.data;
            this.$emit("addedReport", this.report.additionalPrice, this.purchase.client);
            this.greenReportTemp = true;
            this.dialogDetails = false;
            this.getReports();
            this.checkAddPrice();
          })
          .catch(error => {
            console.log(error);
          });
      }
    },
    checkAddPrice(){
      if(this.report.additionalPrice>0){
        this.purchaseUser.username = this.purchase.client;
        this.purchaseUser.active = null;
          axios
        .put("/user-service/user", this.purchaseUser)
        .then(response=>{
          console.log(response);
        })
        .catch(error => {
            console.log(error);
        })
      }
    },
    changeReport(report) {
      console.log("change");
      console.log(report.old_kilometres);
      console.log(report.kilometres_crossed);
      if (report.kilometres_crossed == "") {
        this.$emit("emptyKilometres");
      } else {
        axios
          .put("rent-service/purchase/" + this.purchase.id + "/report", report)
          .then(report => {
            this.report = report.data;
            this.$emit("changedReport", this.report.additionalPrice, this.purchase.client);
            this.greenReportTemp = true;
            this.dialogDetails = false;
            this.getReports();
            this.checkAddPrice();
          })
          .catch(error => {
            console.log(error);
          });
      }
    },
    getReports() {
      axios
        .get("rent-service/purchase/report")
        .then(reportsList => {
          this.reportsList = reportsList.data;
          this.getPurchases();
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.getReports();
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