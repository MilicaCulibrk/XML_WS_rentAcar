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

    <v-container class="mt-6">
      <v-row>
        <!-- meni  -->

        <v-col cols="3">
          <div>
            <v-list rounded>
              <v-list-item-group color="primary">
                <v-list-item
                  v-for="menuItem in menuItems"
                  :key="menuItem"
                  @click="sortCars(menuItem)"
                >
                  <v-list-item-content>
                    <v-list-item-title class="primary--text" v-text="menuItem"></v-list-item-title>
                  </v-list-item-content>

                  <v-list-item-icon>
                    <v-icon color="primary">play_arrow</v-icon>
                  </v-list-item-icon>
                </v-list-item>
              </v-list-item-group>
            </v-list>
          </div>
        </v-col>
        <!-- expand komponenta -->
        <v-col cols="7" class="shrink">
          <!-- Kilometraza -->
          <v-expand-x-transition>
            <div v-show="expandKilometres" elevation="20">
              <v-layout row wrap>
                <v-flex xs12 sm12 md12 lg12 v-for="car in cars" :key="car.id">
                  <v-card hover elevation="2" class="ma-1">
                    <div class="cardBorderColor">
                      <v-row>
                        <v-col cols="4">
                          <v-responsive class="pt-1 ml-2">
                           
                            <carousel :perPage="1">
                              <slide  v-for="(image, index) in car.images" :key="index">
                                <img :src="image.url" height="100px" />
                              </slide>
                            </carousel>
                        
                          </v-responsive>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div
                              class="primary--text"
                            >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                            <div>Price: {{ car.price }}</div>
                          </v-card-text>
                          <v-card-actions class="mt-n4">
                            <!-- komponenta detalji o autu-->
                            <PopupDetails v-bind:car="car"></PopupDetails>
                            <!-- komponenta ocene -->
                            <PopupRatings />
                            <!-- komponenta komentari -->
                            <PopupComments />
                            <!-- komponenta zahtevi -->
                            <PopupRequests v-bind:car="car"></PopupRequests>
                          </v-card-actions>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div
                              class="primary--text font-weight-bold headline mt-4"
                            >{{ car.mileage }} (km)</div>
                          </v-card-text>
                        </v-col>
                      </v-row>
                    </div>
                  </v-card>
                </v-flex>
              </v-layout>
            </div>
          </v-expand-x-transition>
          <!-- Komentari -->
          <v-expand-x-transition>
            <div v-show="expandComments" elevation="20">
              <v-layout row wrap>
                <v-flex xs12 sm12 md12 lg12 v-for="car in cars" :key="car.id">
                  <v-card hover elevation="2" class="ma-1">
                    <div class="cardBorderColor">
                      <v-row>
                        <v-col cols="4">
                          <v-responsive class="pt-1 ml-2">
                            <carousel :perPage="1">
                              <slide  v-for="(image, index) in car.images" :key="index">
                                <img :src="image.url" height="100px" />
                              </slide>
                            </carousel>
                        
                          </v-responsive>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div
                              class="primary--text"
                            >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                            <div>Price: {{ car.price }}</div>
                          </v-card-text>
                          <v-card-actions class="mt-n4">
                            <!-- komponenta detalji o autu-->
                            <PopupDetails v-bind:car="car"></PopupDetails>
                            <!-- komponenta ocene -->
                            <PopupRatings />
                            <!-- komponenta komentari -->
                            <PopupComments />
                            <!-- komponenta zahtevi -->
                            <PopupRequests v-bind:car="car"></PopupRequests>
                          </v-card-actions>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div v-if="car.number_of_comments != 1">
                              <div
                                class="primary--text font-weight-bold headline mt-4"
                              >{{ car.number_of_comments }} comments</div>
                            </div>
                            <div v-if="car.number_of_comments == 1">
                              <div
                                class="primary--text font-weight-bold headline mt-4"
                              >{{ car.number_of_comments }} comment</div>
                            </div>
                          </v-card-text>
                        </v-col>
                      </v-row>
                    </div>
                  </v-card>
                </v-flex>
              </v-layout>
            </div>
          </v-expand-x-transition>
          <!-- Ocene -->
          <v-expand-x-transition>
            <div v-show="expandGrades" elevation="20">
              <v-layout row wrap>
                <v-flex xs12 sm12 md12 lg12 v-for="car in cars" :key="car.id">
                  <v-card hover elevation="2" class="ma-1">
                    <div class="cardBorderColor">
                      <v-row>
                        <v-col cols="4">
                          <v-responsive class="pt-1 ml-2">
                            <carousel :perPage="1">
                              <slide  v-for="(image, index) in car.images" :key="index">
                                <img :src="image.url" height="100px" />
                              </slide>
                            </carousel>
                        
                          </v-responsive>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div
                              class="primary--text"
                            >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                            <div>Price: {{ car.price }}</div>
                          </v-card-text>
                          <v-card-actions class="mt-n4">
                            <!-- komponenta detalji o autu-->
                            <PopupDetails v-bind:car="car"></PopupDetails>
                            <!-- komponenta ocene -->
                            <PopupRatings />
                            <!-- komponenta komentari -->
                            <PopupComments />
                            <!-- komponenta zahtevi -->
                            <PopupRequests v-bind:car="car"></PopupRequests>
                          </v-card-actions>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div v-if="car.average_grade != 0">
                              <div class="primary--text font-weight-bold headline mt-4">
                                {{ car.average_grade }}
                                <v-icon color="primary">star</v-icon>
                              </div>
                            </div>
                            <div v-if="car.average_grade == 0">
                              <div class="primary--text font-weight-bold headline mt-4">Not graded</div>
                            </div>
                          </v-card-text>
                        </v-col>
                      </v-row>
                    </div>
                  </v-card>
                </v-flex>
              </v-layout>
            </div>
          </v-expand-x-transition>

          <!-- Zahtevi -->
          <v-expand-x-transition>
            <div v-show="expandRequests" elevation="20">
              <v-layout row wrap>
                <v-flex xs12 sm12 md12 lg12 v-for="car in cars" :key="car.id-100">
                  <v-card hover elevation="2" class="ma-1">
                    <div class="cardBorderColor">
                      <v-row>
                        <v-col cols="4">
                          <v-responsive class="pt-1 ml-2">
                            <carousel :perPage="1">
                              <slide  v-for="(image, index) in car.images" :key="index">
                                <img :src="image.url" height="100px" />
                              </slide>
                            </carousel>
                        
                          </v-responsive>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div
                              class="primary--text"
                            >{{ car.brand_name }} {{ car.vehicle_model_name }}</div>
                            <div>Price: {{ car.daily_price }}</div>
                          </v-card-text>
                          <v-card-actions class="mt-n4">
                            <!-- komponenta detalji o autu-->
                            <PopupDetails v-bind:car="car"></PopupDetails>
                            <!-- komponenta ocene -->
                            <PopupRatings />
                            <!-- komponenta komentari -->
                            <PopupComments />
                            <!-- komponenta zahtevi -->
                            <PopupRequests v-bind:car="car"></PopupRequests>
                          </v-card-actions>
                        </v-col>
                        <v-col cols="4">
                          <v-card-text>
                            <div v-if="car.number_of_purchases != 1">
                              <div
                                class="primary--text font-weight-bold headline mt-4"
                              >{{ car.number_of_purchases }} requests</div>
                            </div>
                            <div v-else>
                              <div
                                class="primary--text font-weight-bold headline mt-4"
                              >{{ car.number_of_purchases }} request</div>
                            </div>
                          </v-card-text>
                        </v-col>
                      </v-row>
                    </div>
                  </v-card>
                </v-flex>
              </v-layout>
            </div>
          </v-expand-x-transition>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";
import PopupDetails from "@/components/homePage/PopupDetails";
import PopupComments from "@/components/homePage/PopupComments";
import PopupRatings from "@/components/homePage/PopupRatings";
import PopupRequests from "@/components/statistics/PopupRequests";
import { Carousel, Slide } from 'vue-carousel';
export default {
  components: { PopupRatings, PopupComments, PopupDetails, PopupRequests, Carousel, Slide},
  data() {
    return {
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      expandKilometres: false,
      expandComments: false,
      expandGrades: false,
      expandRequests: false,
      cars: [],
      carRequests: [],
      purchases: {},
      companyRequests: {},
      menuItems: [
        "Most kilometres crossed",
        "Most comments",
        "Best grades",
        "Most requests"
      ],
      kilometresCrossedItems: {},
      commentsItems: {},
      gradesItems: {},
      requestsItems: {}
    };
  },
  methods: {
    expandMenuItem(menuItem) {
      if (menuItem == "Most kilometres crossed") {
        this.cancelOtherMenus(menuItem);
        this.expandKilometres = !this.expandKilometres;
      } else if (menuItem == "Most comments") {
        this.cancelOtherMenus(menuItem);
        this.expandComments = !this.expandComments;
      } else if (menuItem == "Best grades") {
        this.cancelOtherMenus(menuItem);
        this.expandGrades = !this.expandGrades;
      } else if (menuItem == "Most requests") {
        this.cancelOtherMenus(menuItem);
        this.expandRequests = !this.expandRequests;
      }
    },
    cancelOtherMenus(menuItem) {
      if (menuItem != "Most kilometres crossed") {
        this.expandKilometres = false;
      }
      if (menuItem != "Most Comments") {
        this.expandComments = false;
      }
      if (menuItem != "Best grades") {
        this.expandGrades = false;
      }
      if (menuItem != "Most requests") {
        this.expandRequests = false;
      }
    },
    sortCars(item) {
      if (item == "Most kilometres crossed") {
        this.cars.sort((a, b) =>
          parseFloat(a["mileage"]) > parseFloat(b["mileage"]) ? -1 : 1
        );
        this.expandMenuItem(item);
      }
      if (item == "Most requests") {
        this.cars.sort((a, b) =>
          a["number_of_purchases"] > b["number_of_purchases"] ? -1 : 1
        );
        this.expandMenuItem(item);
      }
      if (item == "Most comments") {
        this.cars.sort((a, b) =>
          a["number_of_comments"] > b["number_of_comments"] ? -1 : 1
        );
        this.expandMenuItem(item);
      }

      if (item == "Best grades") {
        this.cars.sort((a, b) =>
          a["average_grade"] > b["average_grade"] ? -1 : 1
        );
        this.expandMenuItem(item);
      }
    },
    getPurchases() {
      axios
        .get("/rent-service/purchase")
        .then(purchases => {
          this.purchases = purchases.data;
          this.getNumberOfPurchases();
        })
        .catch(error => {
          console.log(error);
        });
    },
    getNumberOfPurchases() {
      console.log("ana");
      var i = 0;
      for (i = 0; i < this.cars.length; i++) {
        var j = 0;
        for (j = 0; j < this.purchases.length; j++) {
          if (this.purchases[j].id_add == this.cars[i].id) {
            this.cars[i].number_of_purchases =
              this.cars[i].number_of_purchases + 1;
          }
        }
      }
    },
    getCars() {
      axios
        .get(
          "/addvertisment-service/addvertisment/user/" +
            this.$store.state.user.username
        )
        .then(cars => {
          this.cars = cars.data;
          this.getPurchases();
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.getCars();
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