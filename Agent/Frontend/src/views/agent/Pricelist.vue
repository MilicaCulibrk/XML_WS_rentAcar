<template>
  <div class="text-center">
    <v-dialog v-model="dialog" height="700px" max-width="800" >
      <template #activator="{ on: dialog }">
            <v-btn  outlined color="grey"
                      style="width: 255px; height: 45px;"
                      class="text-capitalize" v-on="{ ...dialog }" >Pricelist {{selected.id}}
            </v-btn>

      </template>
   <v-card height="600px" width="780">
    <v-card-title class="primary white--text headline">
      Pricelists
        <v-spacer></v-spacer>
        <v-btn icon color="white" @click="dialog =  false" >
            <v-icon>cancel</v-icon>
        </v-btn>
    </v-card-title>
    <v-row
      class="pa-4"
      justify="space-between"
    >
      <v-col cols="4">
        <v-list-item-group style="height: 90%; position: relative" color="primary">

          <v-list-item
            v-for="(pricelist, i) in pricelists"
            :key="i"
            activatable
            open-on-click
            @click="select(pricelist)"
            :transition=true
          >
            Pricelist number {{pricelist.id}}
          </v-list-item>

        </v-list-item-group>
          <v-card-text style=" position: relative">
            <v-btn
              absolute
              dark
              fab
              bottom
              right
              color="green"
              @click="newPricelist()"
            >
              <v-icon>mdi-plus</v-icon>
            </v-btn>
          </v-card-text>
      </v-col>

      <v-divider vertical></v-divider>

      <v-col
        class="d-flex text-center"
      >
          <v-scroll-x-transition
            hide-on-leave
          >
          <div
            v-if="(this.selected)=='NONE'"
            class="title grey--text text--lighten-1 font-weight-light"
            style="align-self: center;"
          >
            Select a pricelist or make a new one.
          </div>
          <v-card
            v-else
            class="pt-6 mx-auto"
            flat
            max-width="700"
          >
            <v-card-text>
              <h3 class="headline mb-2">
                Pricelist number {{selected.id}}
              </h3>
            </v-card-text>
            <v-divider></v-divider>
            <v-row
              class="text-left"
              tag="v-card-text"
            >
                <v-col class="text-right mr-4 mb-2"  tag="strong" cols="6">Daily price:</v-col>
                <v-col  cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model=selected.dailyPrice
                    :disabled=!editable
                    placeholder="enter daily price"
                >
                </v-col>
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Overlimit price:</v-col>
                <v-col  cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model=selected.overlimitPrice
                    :disabled=!editable
                    placeholder="enter overlimit price"
                >
                </v-col>
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Cdw price:</v-col>
                <v-col  cols="5">
                <input 
                    v-model=selected.cdwPrice
                    :disabled=!editable
                    placeholder="enter cdw price"
                >
                </v-col>
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Discount:</v-col>
                <v-col  cols="5">
                <input 
                    v-model=selected.discount
                    :disabled=!editable
                    placeholder="enter discount"
                >
                </v-col>              
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Number of days for discount:</v-col>
                <v-col  cols="5">
                <input 
                    v-model=selected.numberOfDays
                    :disabled=!editable
                    placeholder="enter number of days"
                    outlined color="grey"
                >
                </v-col>              
                <v-col cols="7"></v-col>
                <v-col cols="2">
                    <v-btn @click="pick()" v-if=!editable>Pick this one</v-btn>
                    <v-btn @click="save()" v-if=editable>Save</v-btn>
                </v-col>
                <v-col cols="2">
                    <v-btn @click="cancel()" v-if=editable>Cancel</v-btn>
                </v-col>
            </v-row>
          </v-card>
          </v-scroll-x-transition>
      </v-col>
    </v-row>
  </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";

export default {
  props: {
    addvertisment: {
      default: ""
    }
  },
  data() {
    return {
        pricelists: [
            { id: 1, name: 'Foo' },
            { id: 2,name: 'Bar' }
        ],
              active: [],
      avatar: null,
      dialog: false,
      open: [],
      selected: 'NONE',
      editable: false,
    };
  },
  methods: {
      select(selected){
          this.selected = selected;
          this.editable = false;
      },
      pick(){
          this.addvertisment.daily_price = this.selected.dailyPrice;
          this.addvertisment.pricelist = this.selected;
          this.dialog = false;
      },
      newPricelist(){
          this.selected = '';
          this.editable = true;
      }, 
      save(){

      },
      cancel(){
          this.selected = 'NONE';
      },
      getPricelists(){
            axios
        .get("/pricelist")
        .then(pricelists => {
          this.pricelists = pricelists.data;
        })
        .catch(error => {
          console.log(error);
        });
      }
  },
  mounted(){
      this.getPricelists();
  }
};
</script>
