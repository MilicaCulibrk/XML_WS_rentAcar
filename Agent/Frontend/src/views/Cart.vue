<template>
 <v-layout row wrap>
   <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
        <v-flex v-for="agent in agents" :key="agent">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
                <v-card-title  class="headline">Agent {{agent}}</v-card-title>

                <!-- cards in card-->
                <v-flex xs12 sm10 md10 lg10 v-for="car in cars" :key="car.id" >
                    <v-card hover elevation="2" class="text-center ma-6" v-if="car.agent==agent">
                        <div class="cardBorderColor">                            
                        <v-list-item three-line>
                            <v-list-item-avatar tile size="80" color="grey" src="mercedes.jpg">
                            </v-list-item-avatar>
                            <v-list-item-content>
                                <v-list-item-title class="headline mb-1">{{car.brand}} {{car.model}}</v-list-item-title>
                                <v-list-item-subtitle>Price: {{car.price}}</v-list-item-subtitle>
                            </v-list-item-content>
                            <v-card-actions>               
                                <v-tooltip bottom color="black">
                                <template v-slot:activator="{ on }">
                                    <v-btn icon v-on="on" color="primary">
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
                <v-card-actions>               
                </v-card-actions>
                <v-checkbox :value="agent" v-model="checkList" class="text-center ma-6"  :label="`Order just in case all of them are available`"></v-checkbox>

            </div>
          </v-card>
        </v-flex>
    </div>
    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
        <v-card hover elevation="2" class="text-center ma-6">
        <div class="cardBorderColor">
        <v-card-title class="primary--text font-weight-bold headline">Order summary</v-card-title>
        <v-card-text>Total price:</v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn class="primary" large="true" @click="order">Order</v-btn>
        </v-card-actions>
        </div>
        </v-card>
    </div>
    </v-layout>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      cars: [
        { id: "1", brand: "Mercedes", model: "G500", price: "100.000" , agent:"1", boundle:"false"},
        { id: "2", brand: "Suzuki", model: "Vitara", price: "30.000", agent:"3" , boundle:"false"},
        { id: "3", brand: "BMW", model: "X6", price: "60.000", agent:"2" , boundle:"false"},
        { id: "6", brand: "VW", model: "Polo Mk4", price: "20.000", agent:"2" , boundle:"false"},
        { id: "7", brand: "Mercedes", model: "Maybach", price: "150.000", agent:"2" , boundle:"false"},
        { id: "8", brand: "Audi", model: "A5 Coupe", price: "50.000", agent:"1" , boundle:"false"}
      ],
      agents:[],
      checkList:[],
      boundleOrder:[],
      singleOrders:[],
    };
  },

  methods: {
      getAgents(){
        this.cars.forEach(car => {
          if(!this.agents.includes(car.agent)){
              this.agents.push(car.agent);
          }
        });
        return this.agents;
      },
      order(){
        this.agents.forEach(agent => {
          this.boundleOrder=[];
          if(this.checkList.includes(agent)){
            this.cars.forEach(car => {
              if(car.agent==agent){
                this.boundleOrder.push(car);
              }
            });
            // sada saljemo zahtev sa listom boundleOrder
              axios
            .post("/nesto/boundle", this.boundleOrder)
            .then()
            .catch(error => {
                console.log(error)
            });
            console.log(this.boundleOrder);
          }
          else{
            this.cars.forEach(car => {
              if(car.agent==agent){
                this.singleOrders.push(car);
              }
            });
          }
        });
        //saljemo zahtev sa listom pojedinacnih zahteva
          axios
        .post("/nesto/single", this.singleOrders)
        .then()
        .catch(
        );
        console.log(this.singleOrders);
      }

  },
  mounted(){
      this.getAgents()
  }
}
</script>

<style>

</style>