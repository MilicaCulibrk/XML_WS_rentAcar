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

    <!-- pretraga -->
    <SearchPanel @search="search" @getCars="getCars()" @clearDates="clearDates()"></SearchPanel>

    <!-- cards -->
    <!-- sort -->
    <v-container class="my-5">
      <v-layout row wrap>
        <v-btn medium elevation="0" color="white primary--text ml-4" @click="sortBy('daily_price')">
          <v-icon left medium>attach_money</v-icon>
          <span class="caption text-lowercase">by price</span>
        </v-btn>
        <v-btn medium elevation="0" color="white primary--text ml-4" @click="sortBy('mileage')">
          <v-icon left medium>av_timer</v-icon>
          <span class="caption text-lowercase">by mileage</span>
        </v-btn>
        <v-btn medium elevation="0" color="white primary--text ml-4" @click="sortBy('daily_price')">
          <v-icon left medium>star</v-icon>
          <span class="caption text-lowercase">by ratings</span>
        </v-btn>
      </v-layout>
      <!-- kartice -->
      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg4 v-for="car in cars" :key="car.id">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
              <v-responsive class="pt-4" style="height:190px;">
                <carousel :perPage="1">
                  <slide v-for="(image, index) in car.images" :key="index">
                    <img :src="image.url" height="100px" />
                  </slide>
                </carousel>
              </v-responsive>
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
                <PopupRatings v-bind:car="car"></PopupRatings>
                <!-- komponenta komentari -->
                <PopupComments v-bind:car="car"></PopupComments>
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }" v-if="$store.state.user.active == true">
                    <v-btn @click="addToBasket(car)" icon v-on="on" color="primary">
                      <router-link :to="{ name: 'add', params: { name: car.id } }"></router-link>
                      <v-icon>shopping_cart</v-icon>
                    </v-btn>
                  </template>
                  <span class="primary--text">Add to basket</span>
                </v-tooltip>
                <v-row v-if="$store.state.user.active == null">
                  <v-menu
                    :nudge-right="40"
                    lazy
                    center
                    transition="scale-transition"
                    offset-y
                    full-width
                    min-width="600px"
                    v-model="dialogsForbidden[car.id]"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn icon v-bind="attrs" v-on="on" color="primary" class="ml-12">
                        <v-icon>shopping_cart</v-icon>
                      </v-btn>
                    </template>

                    <v-card>
                      <v-card-title class="headline">
                        You can't rent until you settle your
                        debts.
                      </v-card-title>
                      <v-card-text>
                        You have exceeded the mileage limit. Please pay your
                        debts to continue.
                      </v-card-text>
                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn
                          color="green darken-1"
                          text
                          @click="dialogsForbidden[car.id] = false"
                        >Cancel</v-btn>
                        <v-btn color="green darken-1" text @click="payDebts()">Pay</v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-menu>
                </v-row>
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
      date_from: "",
      date_to: "",
      dialogDetails: false,
      cars: {},
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      startDateGreater: false,
      dialogsForbidden: [],
      grades: 0,
      average: 0,
      dateList: {
        arrayEvents: []
      },
      dialogForbbiden: false,
      user: {}
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
      if (sortProp == "mileage") {
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
        owner: "",
        date_from: "",
        date_to: "",
        image: ""
      };
      carForChart.id = car.id;
      carForChart.brand = car.brand_name;
      carForChart.model = car.vehicle_model_name;
      carForChart.price = car.daily_price;
      carForChart.owner = car.owner;
      carForChart.date_from = this.date_from;
      carForChart.date_to = this.date_to;
      carForChart.image = car.images[0].url;
      return carForChart;
    },
    clearDates() {
      this.date_to = "";
      this.date_from = "";
    },
    addToBasket(car) {
      if (
        this.$store.state.user.role == "COMPANY" ||
        this.$store.state.user.role == "ADMINISTRATOR"
      ) {
        this.snackbarDangerText = "Only users can add the car to the cart";
        this.snackbarDanger = true;
        return;
      }
      if (this.$store.state.user.role == "NONE") {
        this.snackbarDangerText = "You must log in to add the car to the cart";
        this.snackbarDanger = true;
        return;
      }
      if (this.date_from == "" || this.date_to == "") {
        this.snackbarDanger = true;
        this.snackbarDangerText =
          "You have to select location, start and end date!";
        return;
      }

      this.$store.commit("addCarInCart", this.createCarForChart(car));
      this.snackbarSuccess = true;
      this.snackbarSuccessText = "Car added to the cart.";
    },
    payDebts() {
      this.user.username = this.$store.state.user.username;
      this.user.active = true;
      axios
        .put("/user-service/user", this.user)
        .then((response) => {
          this.user=response.data;
          this.snackbarSuccess = true;
          this.snackbarSuccessText =
            "Thank you for the payment. Now you can rent a car.";

          var i = 0;
          for (i = 0; i < this.dialogsForbidden.length; i++) {
            this.dialogsForbidden[i] = false;
          }

          this.dialogForbbiden = false;
          console.log(response);
          this.$store.commit("setActive");
          location.reload();
        })
        .catch(error => {
          console.log(error);
        });
        
        location.reload();
    },
    getCars() {
      if (this.$store.state.user.role == "NONE") {
        axios
          .get("/search-service/search")
          .then(cars => {
            this.cars = cars.data;
            this.getLocations();
            var i = 0;
            for (i = 0; i < this.cars.length; i++) {
              this.dialogsForbidden.push("modal" + i);
              this.dialogsForbidden[i] = false;
            }
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        axios
          .get("/search-service/search/" + this.$store.state.user.username)
          .then(cars => {
            this.cars = cars.data;
            this.getLocations();
          })
          .catch(error => {
            console.log(error);
          });
      }
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
  computed: {
    getCars1() {
      return this.getCars();
    }
  },
  created: function() {
    this.getCars();
  },

  mounted() {
    if (this.$store.state.user.role == "NONE") {
      axios
        .get("/search-service/search")
        .then(cars => {
          this.cars = cars.data;
          this.getLocations();
          var i = 0;
          for (i = 0; i < this.cars.length; i++) {
            this.dialogsForbidden.push("modal" + i);
            this.dialogsForbidden[i] = false;
          }
        })
        .catch(error => {
          console.log(error);
        });
    } else {
      axios
        .get("/search-service/search/" + this.$store.state.user.username)
        .then(cars => {
          this.cars = cars.data;
          this.getLocations();
        })
        .catch(error => {
          console.log(error);
        });
    }
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
