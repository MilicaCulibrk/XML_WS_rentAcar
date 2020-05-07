<template>
  <div>
    <!-- donji toolbar -->
    <v-app-bar dark height="70" class="pt-4">
      <span class="mx-16"></span>
      <v-tooltip bottom color="black">
        <template v-slot:activator="{ on }">
          <v-app-bar-nav-icon
            class="pb-12"
            @click="drawerAdvancedSearch = !drawerAdvancedSearch"
            v-on="on"
          >
            <v-icon large color="deep-orange lighten-2">menu_open</v-icon>
          </v-app-bar-nav-icon>
        </template>
        <span class="primary--text">Advanced Search</span>
      </v-tooltip>
      <v-container>
        <v-row justify="space-between">
          <v-col cols="12" lg="4" md="4" sm="3" xs="3">
            <v-form ref="form">
              <v-text-field
                prepend-icon="place"
                label="Pickup location"
                class="ml-n4 mr-12"
                color="primary"
              ></v-text-field>
            </v-form>
          </v-col>
          <!-- start date -->
          <v-col cols="12" lg="3" md="3" sm="3" xs="3">
            <v-form>
              <v-layout row wrap>
                <v-menu
                  v-model="fromDateMenu"
                  :close-on-content-click="false"
                  :nudge-right="40"
                  lazy
                  transition="scale-transition"
                  offset-y
                  full-width
                  max-width="290px"
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      :value="formattedDateFrom"
                      slot="activator"
                      prepend-icon="date_range"
                      label="Start date"
                      readonly
                      class="ml-4 mr-12"
                      color="primary"
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    locale="en-in"
                    @input="fromDateMenu = false"
                    v-model="due"
                    color="primary"
                  ></v-date-picker>
                </v-menu>
              </v-layout>
            </v-form>
          </v-col>
          <!--end date -->
          <v-col cols="12" lg="3" md="3" sm="3" xs="3">
            <v-form>
              <v-layout row wrap>
                <v-menu
                  v-model="toDateMenu"
                  :close-on-content-click="false"
                  :nudge-right="40"
                  lazy
                  transition="scale-transition"
                  offset-y
                  full-width
                  max-width="290px"
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      :value="formattedDateTo"
                      slot="activator"
                      prepend-icon="date_range"
                      label="End date"
                      readonly
                      class="ml-12"
                      color="primary"
                      v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    locale="en-in"
                    @input="toDateMenu = false"
                    v-model="to"
                    color="primary"
                  ></v-date-picker>
                </v-menu>
              </v-layout>
            </v-form>
          </v-col>
          <!-- search button  -->
          <v-spacer></v-spacer>
          <v-col class="mr-n3">
            <v-btn rounded class="primary white--text">
              <v-icon left>search</v-icon>
              <span>search</span>
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-app-bar>

    <!-- navigation drawer -->
    <v-navigation-drawer v-model="drawerAdvancedSearch" clipped app floating width="350"></v-navigation-drawer>

    <!-- cards -->

    <!-- sort -->
    <v-container class="my-5">
      <v-layout row wrap>
        <v-btn medium elevation="0" color="white primary--text ml-4" @click="sortBy('price')">
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

      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg4 v-for="car in cars" :key="car.id">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
              <v-responsive class="pt-4">image goes here</v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div class="primary--text font-weight-bold headline">{{ car.brand }} {{ car.model }}</div>
                <div>Price: {{ car.price }}</div>
              </v-card-text>

              <v-card-actions>
                <!-- komponenta -->
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
                        <v-card-title
                          class="primary--text font-italic headline"
                          primary-title
                        >Car Details</v-card-title>

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
                <v-spacer></v-spacer>
                <!-- komponenta -->
                <PopupRatings />
                <!-- komponenta -->
                <PopupComments />
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on" color="primary">
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
//import PopupDetails from "@/components/PopupDetails";
import PopupRatings from "@/components/PopupRatings";
import PopupComments from "@/components/PopupComments";
//import format from "date-fns/format";
export default {
  name: "HomePage",
  components: { PopupRatings, PopupComments },
  data() {
    return {
      drawerAdvancedSearch: false,
      dialogDetails: false,
      fromDateMenu: false,
      toDateMenu: false,
      due: null,
      to: null,
      cars: [
        { id: "1", brand: "Mercedes", model: "G500", price: "100.000" },
        { id: "2", brand: "Suzuki", model: "Vitara", price: "30.000" },
        { id: "3", brand: "BMW", model: "X6", price: "60.000" },
        { id: "4", brand: "BMW", model: "X4", price: "70.000" },
        { id: "5", brand: "BMW", model: "X4", price: "70.000" },
        { id: "6", brand: "VW", model: "Polo Mk4", price: "20.000" },
        { id: "7", brand: "Mercedes", model: "Maybach", price: "150.000" },
        { id: "8", brand: "Audi", model: "A5 Coupe", price: "50.000" }
      ]
    };
  },
  methods: {
    exitDetails() {
      console.log("uso");
      this.dialogDetails = false;
    },
    sortBy(sortProp) {
      if (sortProp == "price") {
        this.cars.sort((a, b) =>
          parseFloat(a[sortProp]) < parseFloat(b[sortProp]) ? -1 : 1
        );
      }
    }
  },
  computed: {
    formattedDateFrom() {
      return this.due;
    },
    formattedDateTo() {
      return this.to;
    }
  }
};
</script>

<style>
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
