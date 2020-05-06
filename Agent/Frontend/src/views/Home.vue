<template>
  <div>
    <!-- donji toolbar -->
    <v-app-bar dark flat height="60">
      <span class="mx-16"></span>
      <v-tooltip bottom color="black">
        <template v-slot:activator="{ on }">
          <v-app-bar-nav-icon @click="drawerAdvancedSearch = !drawerAdvancedSearch" v-on="on">
            <v-icon large color="deep-orange lighten-2">menu_open</v-icon>
          </v-app-bar-nav-icon>
        </template>
        <span class="primary--text">Advanced Search</span>
      </v-tooltip>
    </v-app-bar>

    <!-- navigation drawer -->
    <v-navigation-drawer v-model="drawerAdvancedSearch" clipped app floating></v-navigation-drawer>

    <!-- cards -->
    <v-container class="my-5">
      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg4 v-for="car in cars" :key="car.brand + car.model">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
              <v-responsive class="pt-4">image goes here</v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div class="primary--text font-weight-bold headline">{{car.brand}} {{car.model}}</div>
                <div class>Cena: {{car.price}}</div>
              </v-card-text>
              <v-card-actions>
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on" color="primary">
                      <v-icon>zoom_in</v-icon>
                    </v-btn>
                  </template>
                  <span class="primary--text">View details</span>
                </v-tooltip>
                <v-spacer></v-spacer>
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on" color="primary">
                      <v-icon>grade</v-icon>
                    </v-btn>
                  </template>
                  <span class="primary--text">View ratings</span>
                </v-tooltip>
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn icon v-on="on" color="primary">
                      <v-icon>mode_comment</v-icon>
                    </v-btn>
                  </template>
                  <span class="primary--text">View comments</span>
                </v-tooltip>
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
export default {
  name: "Home",
  data() {
    return {
      drawerAdvancedSearch: false,
      cars: [
        { brand: "Mercedes", model: "G500", price: "100.000$" },
        { brand: "Suzuki", model: "Vitara", price: "30.000$" },
        { brand: "BMW", model: "X6", price: "60.000$" },
        { brand: "BMW", model: "X4", price: "70.000$" },
        { brand: "BMW", model: "X4", price: "70.000$" },
        { brand: "Volkswagen", model: "Polo Mk4", price: "20.000$" },
        { brand: "Mercedes", model: "Maybach", price: "150.000$" },
        { brand: "Audi", model: "A5 Coupe", price: "50.000$" }
      ]
    };
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
</style>
