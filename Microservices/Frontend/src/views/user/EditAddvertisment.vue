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
    <v-dialog v-model="dialogEdit" max-width="1200px">
        <template #activator="{ on: dialogEdit }">
            <v-tooltip bottom color="black">
              <template #activator="{ on: tooltip }">
               
              <v-btn icon v-on="{ ...tooltip, ...dialogEdit } " @click="setSelectedFields(addvertisment)"
              dark
              fab
              style="margin-top: -590px; color: #fbc02d; " 
              >
                <v-icon>mdi-pencil</v-icon>
              </v-btn>
              </template>
              <span class="primary--text">Edit addvertisment</span>
            </v-tooltip>
          </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
           Edit Addvertisment
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogEdit =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            
              <v-form ref="form">
                <v-row>
                  <v-col cols="4">
                    <v-combobox
                      v-model="addvertisment.brand_name"
                      :items="brandItems"
                      item-value="brandItems"
                      item-text="brand_name"
                      label="Brand"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                      disabled
                    ></v-combobox>
                  </v-col>
                  <v-col cols="4">
                    <div >
                      <v-combobox
                        v-model="addvertisment.vehicle_model_name"
                        :items="modelItems"
                        item-value="modelItems"
                        item-text="vehicle_model_name"
                        label="Model"
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                        disabled
                      ></v-combobox>
                    </div>
                  </v-col>
                </v-row>
                <v-row class="mt-n8">
                  <v-col cols="4">
                    <v-combobox
                      v-model="addvertisment.transmission_type_name"
                      :items="transmissionTypeItems"
                      item-value="transmissionTypeItems"
                      item-text="transmission_type_name"
                      label="Transmission type"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                    ></v-combobox>
                  </v-col>
                  <v-col cols="4">
                    <v-combobox
                      v-model="addvertisment.fuel_type_name"
                      :items="fuelTypeItems"
                      item-value="fuelTypeItems"
                      item-text="fuel_type_name"
                      label="Gas type"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                    ></v-combobox>
                  </v-col>
                  <v-col cols="4">
                    <v-combobox
                      v-model="selectChildSeats"
                      :items="childSeatsItems"
                      label="Number of child seats"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                    ></v-combobox>
                  </v-col>
                </v-row>
                <v-row class="mt-n8">
                  <v-col cols="4">
                    <v-combobox
                      v-model="addvertisment.vehicle_class_name"
                      :items="vehicleClassItems"
                      item-value="vehicleClassItems"
                      item-text="vehicle_class_name"
                      label="Class"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                    ></v-combobox>
                  </v-col>
                  <v-col cols="4">
                    <v-text-field
                      label="Location*"
                      color="black"
                      v-model="selectLocation"
                      required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="4">
                    <v-checkbox
                      label="Do you want to include CDW option?"
                      v-model="selectCdw"
                      
                      color="primary"
                    ></v-checkbox>
                  </v-col>
                </v-row>
                <v-row class="mt-n8">
                  <v-col cols="4">
                    <v-text-field
                      label="Mileage*"
                      color="black"
                      v-model="selectMileage"
                      required
                      suffix="KM"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="4">
                    <v-text-field
                      label="Mileage Limit*"
                      color="black"
                      v-model="selectMileageLimit"
                      required
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-form>
            
          </v-card-text>

          <v-card-actions class="pr-10 pb-10">
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="quit">Quit</v-btn>
            <v-btn color="primary" @click="saveChanges">Save changes</v-btn>
          </v-card-actions>
        </div>
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
    },
 
  },
      data() {
        return {
            selectClass: {
                id:"",
                vehicle_class_name: "",
            },
            selectTransmission:{
                id:"",
                transmission_type_name: "",
            },
            selectFuelType:{
                id:"",
                fuel_type_name: "",
            },
            selectMileage: "",
            selectPrice: "",
            selectChildSeats: "",
            selectLocation: "",
            selectCdw: false,
            selectMileageLimit: "",
          modelItems: [],
          brandItems: [],
          vehicleClassItems: [],
          transmissionTypeItems: [],
          fuelTypeItems: [],
          childSeatsItems: ["0", "1", "2", "3", "4", "5"],
          dialogCalendar: false,
          addvertisments: {},
          modal: false,
          dialogEdit: false,
          addvertismentReal: {},
          snackbarSuccess: false,
          snackbarSuccessText: "",
          snackbarDanger: false,
          snackbarDangerText: "",
          addvertismentUpdate: {
            brand_id: "",
            fuel_type_id: "",
            vehicle_model_id: "",
            vehicle_class_id: "",
            transmission_type_id: "",
            mileage: "",
            mileage_limit: "",
            cdw: "",
            child_seats: "",
            location: "",
            price: "",
            images: [],
            arrayEvents: [],
            addvertiser_id: "",
            id: ""
      },
        };
      },
      methods: {
          quit(){
            this.dialogEdit= false;
          },
          saveChanges(){
            console.log(this.selectMileageLimit);
            
            
            if(this.addvertisment.vehicle_class_name==null || this.addvertisment.fuel_type_name==null || this.addvertisment.transmission_type_name==null || this.addvertisment.vehicle_class_name=="" || this.addvertisment.fuel_type_name=="" || this.addvertisment.transmission_type_name=="" || this.selectMileage=="" || this.selectChildSeats=="" || this.selectLocation=="" )
{
            this.snackbarDanger = true;
            this.snackbarDangerText="You can not leave fileds empty! ";
            return;
          }
            this.addvertismentUpdate.brand_id = this.addvertismentReal.brand_id;
            this.addvertismentUpdate.vehicle_model_id = this.addvertismentReal.vehicle_model_id;
            this.addvertismentUpdate.vehicle_class_id = this.addvertismentReal.vehicle_class_id;
            this.addvertismentUpdate.fuel_type_id = this.addvertismentReal.fuel_type_id;
            this.addvertismentUpdate.transmission_type_id = this.addvertismentReal.transmission_type_id;

            for(var i in this.vehicleClassItems){
                if(this.addvertisment.vehicle_class_name== this.vehicleClassItems[i].vehicle_class_name){
                    this.addvertismentUpdate.vehicle_class_id = this.vehicleClassItems[i].id;
                }
            }
           

            for(var i1 in this.fuelTypeItems){
                if(this.addvertisment.fuel_type_name==this.fuelTypeItems[i1].fuel_type_name){
                    this.addvertismentUpdate.fuel_type_id = this.fuelTypeItems[i1].id;
                }
            }
         
            
            for(var i2 in this.transmissionTypeItems){
                if(this.addvertisment.transmission_type_name.transmission_type_name==this.transmissionTypeItems[i2].transmission_type_name){
                    this.addvertismentUpdate.transmission_type_id = this.transmissionTypeItems[i2].id;
                }
            } 
          

            this.addvertismentUpdate.mileage = this.selectMileage;
            this.addvertismentUpdate.mileage_limit = this.selectMileageLimit;
            this.addvertismentUpdate.cdw = this.selectCdw;
            this.addvertismentUpdate.child_seats = this.selectChildSeats;
            this.addvertismentUpdate.location = this.selectLocation;
            this.addvertismentUpdate.addvertiser_id = this.addvertisment.addvertiser_id;
            this.addvertismentUpdate.images = this.addvertisment.images;
            this.addvertismentUpdate.arrayEvents = this.addvertisment.arrayEvents;
            this.addvertismentUpdate.id = this.addvertisment.id;
            this.addvertismentUpdate.price- this.addvertisment.price;

           console.log(this.addvertismentUpdate);
           
            axios
          .put("/addvertisment-service/addvertisment", this.addvertismentUpdate)
          .then(() => {
            this.dialogEdit = false;
           this.snackbarSuccess=true;
           this.snackbarSuccessText="Addvertisment changed!";
           this.selectClass= {
                id:"",
                vehicle_class_name: "",
            };
            this.selectTransmission={
                id:"",
                transmission_type_name: "",
            };
            this.selectFuelType={
                id:"",
                fuel_type_name: "",
            };
            this.selectMileage = "";
            this.selectMileageLimit = "";
            this.selectChildSeats = "";
            this.selectLocation = "";
            this.selectPrice = "";
            this.selectCdw = false;
            
          })
          .catch(error => {
            console.log(error);
          });
          },

        setSelectedFields(addvertisment){
             //izlistavanje brendova
         axios
          .get("/addvertisment-service/brand")
          .then(brandItems => {
            this.brandItems = brandItems.data;
          })
          .catch(error => {
            console.log(error);
          });
        //izlistavanje klasa
        axios
          .get("/addvertisment-service/vehicle_class")
          .then(vehicleClassItems => {
            this.vehicleClassItems = vehicleClassItems.data;            
          })
          .catch(error => {
            console.log(error);
          });
        //izlistavanje tipova menjaca
        axios
          .get("/addvertisment-service/transmission_type")
          .then(transmissionTypeItems => {
            this.transmissionTypeItems = transmissionTypeItems.data;
           
          })
          .catch(error => {
            console.log(error);
          });
        //izlistavanje tipova goriva
        axios
          .get("/addvertisment-service/fuel_type")
          .then(fuelTypeItems => {
            this.fuelTypeItems = fuelTypeItems.data;
           
          })
          .catch(error => {
            console.log(error);
          });

            axios
            .get(
                "/addvertisment-service/addvertisment/" + this.addvertisment.id
            )
            .then(addvertismentReal => {
                this.addvertismentReal = addvertismentReal.data;

                this.selectClass.vehicle_class_name=addvertisment.vehicle_class_name;
                this.selectClass.id=this.addvertismentReal.vehicle_class_id;
                this.selectTransmission.transmission_type_name=addvertisment.transmission_type_name;
                this.selectTransmission.id=this.addvertismentReal.transmission_type_id;
                this.selectFuelType.fuel_type_name=addvertisment.fuel_type_name;
                this.selectFuelType.id=this.addvertismentReal.fuel_type_id;
                this.selectMileage=this.addvertismentReal.mileage;
                this.selectPrice=this.addvertismentReal.price;
                this.selectChildSeats=this.addvertismentReal.child_seats;
                this.selectLocation=this.addvertismentReal.location;
                this.selectCdw=this.addvertismentReal.cdw;
                this.selectMileageLimit=this.addvertismentReal.mileage_limit;
                
            })
            .catch(error => {
                console.log(error);
            });

            

        },
      },
      mounted() {
    
      
        //izlistavanje oglasa
        axios
          .get(
            "/addvertisment-service/addvertisment/user/" + this.$store.state.user.username
          )
          .then(addvertisments => {
            this.addvertisments = addvertisments.data;
            
          })
          .catch(error => {
            console.log(error);
          });
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

    .image-div {
  display: flex;
  margin: 25px;
}
.image {
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp {
  position: relative;
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp span.delete-img {
  position: absolute;
  top: -14px;
  left: -2px;
}
.img-wrapp span.delete-img:hover {
  cursor: pointer;
}
    </style>