<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="400px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>zoom_in</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View Details</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic headline" primary-title>Car Details</v-card-title>

          <v-responsive class="pt-4 mx-4">images go here</v-responsive>
          <v-card-text class="text-center-left">
            <div class="primary--text title">{{ car.brand }} {{ car.model }}</div>
            <div>Price: {{ car.price }}</div>
            <div>CDW:</div>
            <div>Class:</div>
            <div>Mileage:</div>
            <div>Gas type:</div>
            <div>Transmission type:</div>
            <div>Number of child seats:</div>
          </v-card-text>
          <v-btn icon red @click="exitDetails()">
            <v-icon>close</v-icon>
          </v-btn>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  props: {
    car: {
      default: ""
    }
  }
};
</script>

