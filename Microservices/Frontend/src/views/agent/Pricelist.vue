<template>
  <div class="text-center">
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>
    <v-dialog v-model="dialog" height="800px" max-width="800" >
      <template #activator="{ on: dialog }">
            <v-btn v-if="addvertisment.pricelist==''" @click="editable=false" outlined color="grey"
                      style="width: 255px; height: 45px;"
                      class="text-capitalize" v-on="{ ...dialog }" >Pick a pricelist 
            </v-btn>
            <v-btn v-else outlined color="green"
                      style="width: 255px; height: 45px;"
                      class="text-capitalize" v-on="{ ...dialog }" >Pricelist choosen
            </v-btn>
      </template>
   <v-card height="650px" width="770">
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
        <v-list-item-group style="height: 400px; position: relative" color="primary">

          <v-list-item
            v-for="pricelist in pricelists"
            :key="pricelist.id"
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
            v-if="selected=='NONE'"
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
            <v-card-text style=" position: relative">
              <h3 class="headline mb-2">
                Pricelist number {{pricelist.id}}
              </h3>
                <v-row justify="center">
                <v-dialog v-model="dialogDelete" persistent max-width="290">
                <template v-slot:activator="{ on, attrs }">
                <v-btn
                  absolute
                  dark
                  fab
                  small
                  top
                  right
                  color="red"
                  v-bind="attrs"
                  v-on="on"
                >
                  <v-icon>mdi-delete</v-icon>
                </v-btn>
                </template>
                <v-card>
                  <v-card-title class="headline">Are you sure about removing this pricelist?</v-card-title>
                  <v-card-text>Removing can cause deleting addvertisments with this pricelist.</v-card-text>
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="green darken-1" text @click="dialogDelete = false">Disagree</v-btn>
                    <v-btn color="green darken-1" text @click="deletePricelist(pricelist.id)">Agree</v-btn>
                  </v-card-actions>
                </v-card>
                </v-dialog>
                </v-row>
                <v-btn
                  absolute
                  dark
                  fab
                  small
                  bottom
                  right
                  color="yellow"

                  @click="editable=true"
                >
                  <v-icon>mdi-pencil</v-icon>
                </v-btn>
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
                    v-model="pricelist.dailyPrice"
                    :disabled=!editable
                    placeholder="enter daily price"
                >
                </v-col>
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Overlimit price:</v-col>
                <v-col  cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model="pricelist.overlimitPrice"
                    :disabled=!editable
                    placeholder="enter overlimit price"
                >
                </v-col>
                <v-col class="text-right mr-4 mb-2" tag="strong" cols="6">Cdw price:</v-col>
                <v-col  cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model="pricelist.cdwPrice"
                    :disabled=!editable
                    placeholder="enter cdw price"
                >
                </v-col>
                <v-col v-if="(this.$store.state.user.role)!='USER'" class="text-right mr-4 mb-2" tag="strong" cols="6">Discount:</v-col>
                <v-col v-if="(this.$store.state.user.role)!='USER'"  cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model="pricelist.discount"
                    :disabled=!editable
                    placeholder="enter discount"
                >
                </v-col>              
                <v-col v-if="(this.$store.state.user.role)!='USER'" class="text-right mr-4 mb-2" tag="strong" cols="6">Number of days for discount:</v-col>
                <v-col  v-if="(this.$store.state.user.role)!='USER'" cols="5">
                <input 
                    type="text"
                    class="form-control"
                    v-model="pricelist.numberOfDays"
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
      pricelists: [],
      dialog: false,
      dialogDelete: false,
      selected: 'NONE',
      pricelist: { },
      editable: false,
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
    };
  },
  methods: {
      select(selected){
          this.pricelist = selected;
          this.selected = selected;
          this.editable = false;
      },
      pick(){
          this.addvertisment.price = this.selected.dailyPrice;
          this.addvertisment.pricelist = this.selected;
          this.dialog = false;
      },
      newPricelist(){
          this.selected = '';
          this.pricelist.dailyPrice = '' ;
          this.pricelist.cdwPrice = '' ;
          this.pricelist.overlimitPrice = '';
          this.pricelist.discount = '';
          this.pricelist.numberOfDays ='';
          this.pricelist.id ='';
          this.editable = true;
      }, 
      save(){
        this.pricelist.username = this.$store.state.user.username;

        if (
          this.pricelist.dailyPrice === "" ||
          this.pricelist.cdwPrice === "" ||
          this.pricelist.overlimitPrice === ""       
        ) {
          this.snackbarDanger = true;
          this.snackbarDangerText = "You need to fill all fileds!";
          return;
        }
            axios
        .post("/addvertisment-service/pricelist", this.pricelist)
        .then(response => {
          this.checkOwner(response.data);
          this.editable = false;
          this.snackbarSuccess = true;
          if(this.pricelist.id=='')
            this.snackbarSuccessText = "Pricelist is added";
          else
            this.snackbarSuccessText = "Pricelist is changed";

        })
        .catch(error => {
          console.log(error);
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
        });
      },
      cancel(){
          this.selected = 'NONE';
          this.getPricelists();
      },
      getPricelists(){
            axios
        .get("/addvertisment-service/pricelist")
        .then(response => {
          this.checkOwner(response.data);
        })
        .catch(error => {
          console.log(error);
        });
      },
      checkOwner(items){
        this.pricelists.length = 0;
        items.forEach(item => {
            if (item.username === (this.$store.state.user.username)) {
              this.pricelists.push(item);
            }
          });
      },
      deletePricelist(id){
          axios
        .delete("/addvertisment-service/pricelist/" + id)
        .then(response => {
          this.selected = 'NONE';
          this.checkOwner(response.data);
          this.editable = false;
          this.dialogDelete = false;
        })
        .catch(error => {
          console.log(error);
        });
      },

  },
  mounted(){
      this.getPricelists();
  }
};
</script>
