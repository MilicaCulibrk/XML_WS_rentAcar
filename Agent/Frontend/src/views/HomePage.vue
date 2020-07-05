<template>
  <div>
    <!-- Snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>

    <!-- pretraga -->
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
              <v-responsive class="pt-4">
                <img :src="car.images[0].url" height="130px" />
              </v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div
                  class="primary--text font-weight-bold headline"
                >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                <div>Price: {{ car.daily_price }}</div>
              </v-card-text>
              <v-card-actions>
                <!-- komponenta detalji o autu -->
                <PopupDetails v-bind:car="car"></PopupDetails>
                <v-spacer></v-spacer>
                <!-- komponenta ocene -->
                <PopupRatings v-bind:car="car"></PopupRatings>
                <!-- komponenta komentari -->
                <PopupComments v-bind:car="car"></PopupComments>
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
import PopupDetails from "@/components/HomePage/PopupDetails";
import PopupComments from "@/components/HomePage/PopupComments";
import PopupRatings from "@/components/HomePage/PopupRatings";
import SearchPanel from "@/components/HomePage/SearchPanel";
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
      date_from: "",
      date_to: "",
      dialogDetails: false,
      cars: {},
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      startDateGreater: false,
      dateList: {
        arrayEvents: []
      }
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
      carForChart.date_from = this.date_from;
      carForChart.date_to = this.date_to;
      return carForChart;
    },
    addToBasket(car) {
      if (this.$store.state.user.role == "NONE") {
        console.log("usao");
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
    search(searchItem, startDate, endDate) {
      this.date_from = startDate;
      this.date_to = endDate;
      this.getDates(startDate, endDate);

      searchItem.dates = this.dateList.arrayEvents;

      if (
        ((searchItem.selectMinPrice == null &&
          searchItem.selectMaxPrice == null) ||
          (searchItem.selectMinPrice != null &&
            searchItem.selectMaxPrice != null)) &&
        ((searchItem.selectMinMileage == null &&
          searchItem.selectMaxMileage == null) ||
          (searchItem.selectMinMileage != null &&
            searchItem.selectMaxMileage != null)) &&
        startDate != null &&
        endDate != null &&
        searchItem.selectLocation != "" &&
        this.startDateGreater == false
      ) {
        this.doSearch(searchItem);
      } else {
        this.errorMessage(searchItem, startDate, endDate);
      }
    },
    doSearch(searchItem) {
      axios
        .post("/search-service/search", searchItem)
        .then(cars => {
          this.cars = cars.data;
          console.log(searchItem);
        })
        .catch(error => {
          console.log(error);
        });
    },
    errorMessage(searchItem, startDate, endDate) {
      if (
        startDate == null ||
        endDate == null ||
        searchItem.selectLocation == ""
      ) {
        this.snackbarDanger = true;
        this.snackbarDangerText = "Location and dates musn't be empty!";
      } else {
        if (this.startDateGreater == true) {
          this.snackbarDanger = true;
          this.snackbarDangerText = "End date must be greater than start date!";
        } else {
          if (
            (searchItem.selectMinPrice == null ||
              searchItem.selectMaxPrice == null) &&
            ((searchItem.selectMinMileage == null &&
              searchItem.selectMaxMileage == null) ||
              (searchItem.selectMinMileage != null &&
                searchItem.selectMaxMileage != null))
          ) {
            this.snackbarDanger = true;
            this.snackbarDangerText = "You can't search by only one price!";
          } else if (
            (searchItem.selectMinMileage == null ||
              searchItem.selectMaxMileage == null) &&
            ((searchItem.selectMinPrice == null &&
              searchItem.selectMaxPrice == null) ||
              (searchItem.selectMinPrice != null &&
                searchItem.selectMaxPrice != null))
          ) {
            this.snackbarDanger = true;
            this.snackbarDangerText =
              "You can't search by only max or only min mileage!";
          } else {
            this.snackbarDanger = true;
            this.snackbarDangerText =
              "You can't search by only one price or mileage!!";
          }
        }
      }
    },
    getDates(startDate, endDate) {
      var arr = new Array();
      var dt = new Date(startDate);
      var edt = new Date(endDate);
      //var date = new Date(dt).toISOString().substr(0, 10);

      if (dt <= edt) {
        this.startDateGreater = false;
        while (dt <= edt) {
          console.log("uso");
          arr.push(new Date(dt).toISOString().substr(0, 10));
          dt.setDate(dt.getDate() + 1);
        }
      } else {
        this.snackbarDanger = true;
        this.snackbarDangerText = "End date must be greater than start date!";
        this.startDateGreater = true;
      }

      for (const d in arr) {
        this.dateList.arrayEvents.push(arr[d]);
      }
    }
  },
  mounted() {
    //get cars
    axios
      .get("/addvertisment")
      .then(cars => {
        this.cars = cars.data;
      })
      .catch(error => {
        console.log(error);
      });
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
