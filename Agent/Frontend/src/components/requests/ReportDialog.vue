<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="450px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>description</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">Report</span>
        </v-tooltip>
      </template>

      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            {{purchase.brand_model}} report
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="report.kilometresCrossed"
              label="Kilometres crossed"
              color="primary"
              :rules="[() => !!report.kilometresCrossed || 'This field is required',
                                 () => /^[0-9]*$/.test(report.kilometresCrossed) || 'Only numbers are allowed']"
            ></v-text-field>

            <v-textarea
              v-model="report.additionalInformation"
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
                <v-btn color="primary" class="ml-8">Save</v-btn>
              </v-col>
            </v-row>
          </v-card-text>
          <v-card-text class="text-center-left"></v-card-text>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  props: {
    purchase: {
      default: ""
    }
  },
  data() {
    return {
      dialogDetails: false,
      report: {
        kilometresCrossed: "",
        additionalInformation: ""
      },
      rules: [v => v.length <= 100 || "Max 100 characters"]
    };
  },
  mounted() {
    //da li ima cdw
    if (this.car.cdw) {
      this.carCDW = "included";
    } else {
      this.carCDW = "not included";
    }

    //da li ima ogranicenje brzine
    if (this.car.mileage_limit != 0) {
      this.carMileageLimit = this.car.mileage_limit.toString();
    } else {
      this.carMileageLimit = "no limit";
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

