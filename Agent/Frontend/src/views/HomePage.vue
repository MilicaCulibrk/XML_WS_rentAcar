<template>
  <div>
    <!-- pretraga -->
    <SearchPanel />

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
      <!-- kartice -->
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
                <!-- komponenta detalji o autu-->
                <PopupDetails v-bind:car="car"></PopupDetails>
                <v-spacer></v-spacer>
                <!-- komponenta ocene -->
                <PopupRatings />
                <!-- komponenta komentari -->
                <PopupComments />
                <v-tooltip bottom color="black">
                  <template v-slot:activator="{ on }">
                    <v-btn @click="addToBasket()"  icon v-on="on" color="primary">
                      <router-link  :to="{ name: 'add', params: {name: car.id}}"></router-link>
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
        <div>
      <h1 v-on:click="changeHeader">"nestoo" {{header}}</h1>
  </div>
  </div>

</template>

<script>
import PopupDetails from "@/components/homePage/PopupDetails";
import PopupComments from "@/components/homePage/PopupComments";
import PopupRatings from "@/components/homePage/PopupRatings";
import SearchPanel from "@/components/homePage/SearchPanel";
//import format from "date-fns/format";
export default {
  name: "HomePage",
  components: { PopupRatings, PopupComments, PopupDetails, SearchPanel },
  props: {
    header:{
        type: String
    } 
  },
  data() {
    return {
      dialogDetails: false,
      cars: [
        { id: "1", brand: "Mercedes", model: "G500", price: "100.000" },
        { id: "2", brand: "Suzuki", model: "Vitara", price: "30.000" },
        { id: "3", brand: "BMW", model: "X6", price: "60.000" },
        { id: "4", brand: "BMW", model: "X4", price: "70.000" },
        { id: "5", brand: "BMW", model: "X4", price: "70.000" },
        { id: "6", brand: "VW", model: "Polo Mk4", price: "20.000" },
        { id: "7", brand: "Mercedes", model: "Maybach", price: "150.000" },
        { id: "8", brand: "Audi", model: "A5 Coupe", price: "50.000" }
      ],
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
    },
    addToBasket(){
      this.$router.push("/cart");

    },
          changeHeader (){
          this.header = "changed header";
          this.$emit('changeIt', 'changed header');
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
