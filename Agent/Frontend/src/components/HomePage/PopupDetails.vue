<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="400px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon  @click="getGrade" v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>zoom_in</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View Details</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            {{car.brand_name}} {{car.vehicle_model_name}} details
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-responsive class="pt-4 mx-4">
            <carousel :perPage="1">
              <slide  v-for="(image, index) in car.images" :key="index">
                <img :src="image.url" height="100px"  style="margin-left: 100px;" />
              </slide>
            </carousel>
        </v-responsive>          <v-card-text class="text-center-left">
            <div>{{ car.brand }} {{ car.model }}</div>
            <div class="secondary">Price: {{ car.daily_price }}</div>
            <div>CDW option: {{ carCDW }}</div>
            <div class="secondary">Class: {{ car.vehicle_class_name }}</div>
            <div>Mileage: {{ car.mileage }}</div>
            <div class="secondary">Mileage limit: {{ carMileageLimit }}</div>
            <div>Fuel type: {{ car.fuel_type_name }}</div>
            <div class="secondary">Transmission type: {{ car.transmission_type_name }}</div>
            <div>Number of child seats: {{ car.child_seats }}</div>
            <div class="secondary" >Grade: {{ average }}</div>
            <div>Owner: {{ car.owner }}</div>

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
    car: {
      default: ""
    }
  },
  data() {
    return {
      dialogDetails: false,
      carCDW: "",
      carMileageLimit: "",
      grades: 0,
      average: 0,
    };
  },
  methods: {
    getGrade() {
        axios
          .get("/grade/" + this.car.id)
          .then(grades => {
            this.grades = grades.data;
            var total=0;
            for(var i = 0; i<this.grades.length; i++){
              total += this.grades[i].number;
            }
            var avg = total/this.grades.length;
            this.average = avg;
            if(this.grades.length==0){
              this.average="still not rated";
            }
          })
          .catch(error => {
            console.log(error);
          });
      }
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

