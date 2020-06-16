<template>
  <v-layout row wrap>
    <div v-if="emptyBasket" class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <v-flex>
        <v-card hover elevation="2" class="text-center ma-6">
          <div class="cardBorderColor">
            <v-card-text style="align:center" class="headline">
              <h2>Your basket is empty</h2>
              <br />
              <router-link to="/">Find the right car</router-link>
            </v-card-text>
          </div>
        </v-card>
      </v-flex>
    </div>
    <v-snackbar v-model="snackbarSuccess" :timeout="4000" top color="success">
      <span>Rental request has been sent!</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <div v-if="!emptyBasket" class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
      <v-flex v-for="agent in agents" :key="agent">
        <v-card hover elevation="2" class="text-center ma-6">
          <div class="cardBorderColor">
            <v-card-title class="headline">Agent {{ agent }}</v-card-title>
            <!-- cards in card-->
            <v-flex xs12 sm10 md10 lg10 v-for="car in cars" :key="car.id">
              <v-card hover elevation="2" class="text-center ma-6" v-if="car.agent == agent">
                <div class="cardBorderColor">
                  <v-list-item three-line>
                    <v-list-item-avatar tile size="80" color="grey" src="/mercedes.jpg"></v-list-item-avatar>
                    <v-list-item-content>
                      <v-list-item-title class="headline mb-1">{{ car.brand }} {{ car.model }}</v-list-item-title>
                      <v-list-item-subtitle>Price: {{ car.price }}</v-list-item-subtitle>
                    </v-list-item-content>
                    <v-card-actions>
                      <v-tooltip bottom color="black">
                        <template v-slot:activator="{ on }">
                          <v-btn @click="deleteCar(car)" icon v-on="on" color="primary">
                            <v-icon>close</v-icon>
                          </v-btn>
                        </template>
                        <span class="primary--text">Remove car</span>
                      </v-tooltip>
                    </v-card-actions>
                  </v-list-item>
                </div>
              </v-card>
            </v-flex>
            <v-card-actions></v-card-actions>
            <v-checkbox
              @change="checkList.push(agent)"
              class="text-center ma-6"
              :label="`Order just in case all of them are available`"
            ></v-checkbox>
          </div>
        </v-card>
      </v-flex>
    </div>
    <div v-if="!emptyBasket" class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
      <v-card hover elevation="2" class="text-center ma-6">
        <div class="cardBorderColor">
          <v-card-title class="primary--text font-weight-bold headline">Summary</v-card-title>
          <v-card-text>Total price: {{ totalPrice }}</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn @click="orderCars()" class="primary">Order</v-btn>
          </v-card-actions>
        </div>
      </v-card>
    </div>
  </v-layout>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      emptyBasket: false,
      snackbarSuccess: false,
      agents: [],
      checkList: [],
      bundleOrder: [],
      singleOrders: []
    };
  },
  methods: {
    createOrderFromAdd(car) {
      var purchase = {
        client: "",
        id_add: "",
        date_from: "",
        date_to: "",
        owner: ""
      };
      purchase.client = this.$store.state.user.username;
      purchase.owner = car.agent;
      purchase.id_add = car.id;
      purchase.date_from = car.date_from;
      purchase.date_to = car.date_to;
      purchase.brand_model = car.brand + " " + car.model;
      return purchase;
    },
    getAgents() {
      this.cars.forEach(car => {
        if (!this.agents.includes(car.agent)) {
          this.agents.push(car.agent);
        }
      });
      return this.agents;
    },
    orderCars() {
      console.log("cek lista");
      console.log(this.checkList);
      this.agents.forEach(agent => {
        this.bundleOrder = [];
        if (this.checkList.includes(agent)) {
          this.cars.forEach(car => {
            if (car.agent == agent) {
              this.bundleOrder.push(this.createOrderFromAdd(car));
            }
          });
          console.log("bundle lista");
          console.log(this.bundleOrder);
          this.sendBundleRequest(this.bundleOrder);
        } else {
          this.cars.forEach(car => {
            if (car.agent == agent) {
              this.singleOrders.push(this.createOrderFromAdd(car));
            }
          });
        }
      });
      console.log("single lista");
      console.log(this.singleOrders);
      this.sendRequest(this.singleOrders);
    },
    deleteCar(car) {
      this.$store.commit("deleteCar", car);
      this.checkBasket();
    },
    sendRequest(singleOrders) {
      axios
        .post("/rent-service/request", singleOrders)
        .then(response => {
          console.log(response.data);
          this.snackbarSuccess = true;
          this.$store.commit("deleteAll");
          this.emptyBasket = true;
        })
        .catch(error => {
          console.log(error);
        });
    },
    sendBundleRequest(bundleOrder) {
      axios
        .post("/rent-service/request/bundle", bundleOrder)
        .then(response => {
          console.log(response.data);
          this.snackbarSuccess = true;
          this.$store.commit("deleteAll");
          this.emptyBasket = true;
        })
        .catch(error => {
          console.log(error);
        });
    },
    checkBasket() {
      console.log(this.$store.state.carsInCart.length);
      if (this.$store.state.carsInCart.length == 0) {
        this.emptyBasket = true;
      }
    }
  },
  mounted() {
    this.getAgents();
    this.checkBasket();
  },
  computed: {
    cars() {
      return this.$store.state.carsInCart;
    },
    totalPrice() {
      this.$store.commit("subtotal");
      return this.$store.state.subtotal;
    }
  }
};
</script>

<style></style>
