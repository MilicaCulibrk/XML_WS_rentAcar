<template>
  <div>
    <!-- pretraga -->
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>
    <SearchPanel @search="search" @getCars="getCars()"></SearchPanel>

    <!-- cards -->
    <!-- sort -->
    <v-container class="my-5">
      <v-layout row wrap>
        <v-btn medium elevation="0" color="white primary--text ml-4" @click="sortBy('daily_price')">
          <v-icon left medium>attach_money</v-icon>
          <span class="caption text-lowercase">by price</span>
        </v-btn>
        <v-btn medium elevation="0" color="white primary--text ml-4">
          <v-icon left medium>star</v-icon>
          <span class="caption text-lowercase">by ratings</span>
        </v-btn>
        <v-btn medium elevation="0" color="white primary--text ml-4">
          <v-icon left medium>av_timer</v-icon>
          <span class="caption text-lowercase">by mileage</span>
        </v-btn>
      </v-layout>
      <!-- kartice -->
      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg4 v-for="car in cars" :key="car.id">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
              <v-responsive class="pt-4">image goes here</v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div
                  class="primary--text font-weight-bold headline"
                >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                <div>Price: {{ car.daily_price }}</div>
              </v-card-text>
              <v-card-actions>
                <!-- komponenta detalji o autu-->
                <PopupDetails v-bind:car="car"></PopupDetails>
                <v-spacer></v-spacer>
                <!-- komponenta ocene -->
                <PopupRatings />
                <!-- komponenta komentari -->
                <PopupComments />
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn @click="addToBasket(car)" icon v-on="on" color="primary">
                      <router-link :to="{ name: 'add', params: { name: car.id } }"></router-link>
                      <v-icon>shopping_cart</v-icon>
                    </v-btn>
                  </template>
                  <span class="primary--text">Add to basket</span>
                </v-tooltip>
              </v-card-actions>
            </div>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import PopupDetails from "@/components/homePage/PopupDetails";
import PopupComments from "@/components/homePage/PopupComments";
import PopupRatings from "@/components/homePage/PopupRatings";
import SearchPanel from "@/components/homePage/SearchPanel";
import axios from "axios";
//import format from "date-fns/format";
export default {
  name: "HomePage",
  components: { PopupRatings, PopupComments, PopupDetails, SearchPanel },
  props: {
    header: {
      type: String
    }
  },
  data() {
    return {
      snackbarDanger: false,
      snackbarDangerText: "",
      dialogDetails: false,
      cars: {}
    };
  },
  methods: {
    exitDetails() {
      this.dialogDetails = false;
    },
    sortBy(sortProp) {
      if (sortProp == "daily_price") {
        this.cars.sort((a, b) =>
          parseFloat(a[sortProp]) < parseFloat(b[sortProp]) ? -1 : 1
        );
      }
    },
    createCarForChart(car) {
      var carForChart = {
        id: "",
        brand: "",
        model: "",
        price: "",
        agent: "",
        date_from: "",
        date_to: ""
      };
      carForChart.id = car.id;
      carForChart.brand = car.brand_name;
      carForChart.model = car.vehicle_model_name;
      carForChart.price = car.daily_price;
      carForChart.agent = car.owner;
      carForChart.date_from = "24.06.2020";
      carForChart.date_to = "29.06.2020";
      return carForChart;
    },
    addToBasket(car) {
      if (this.$store.state.loggedUser == false) {
        this.snackbarDangerText = "You must log in to add the car to the cart";
        this.snackbarDanger = true;
        return;
      }
      this.$store.commit("addCarInCart", this.createCarForChart(car));
      console.log(this.$store.state.carsInCart);
    },
    getCars() {
      axios
        .get("/search-service/search")
        .then(cars => {
          this.cars = cars.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    search(searchItem) {
      axios
        .post("/search-service/search", searchItem)
        .then(cars => {
          this.cars = cars.data;
          console.log(this.cars.length);
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    //get cars
    axios
      .get("/search-service/search")
      .then(cars => {
        this.cars = cars.data;
        console.log(cars);
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

.detailsBorderColor {
  border-left: 1.5px solid #fbc02d;
  border-top: 1.5px solid #fbc02d;
  border-right: 1.5px solid #fbc02d;
  border-bottom: 1.5px solid #fbc02d;
}
</style>
