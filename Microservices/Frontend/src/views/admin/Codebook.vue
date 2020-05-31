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

    <v-container class="pt-12 mt-12">
      <v-row>
        <!-- meni  -->
        <v-col cols="1"></v-col>
        <v-col cols="4">
          <div>
            <v-list rounded>
              <v-list-item-group color="primary">
                <v-list-item
                  v-for="menuItem in menuItems"
                  :key="menuItem"
                  @click="expandMenuItem(menuItem)"
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
        <v-col cols="6" class="shrink">
          <!-- Brend -->
          <v-expand-x-transition>
            <v-card v-show="expandBrand" elevation="20">
              <div class="cardBorderColor shrink">
                <v-list>
                  <v-list-item v-for="brandItem in brandItems" :key="brandItem.brand_name">
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="brandItem.brand_name"></v-list-item-title>
                    </v-list-item-content>
                    <!-- Dijalog za izlistavanje modela -->
                    <PopupViewBrandModels v-bind:item="item" v-bind:brandItem="brandItem"></PopupViewBrandModels>
                    <!-- Dijalog za promenu brenda -->
                    <PopupChangeBrand
                      v-bind:item="item"
                      v-bind:brandItem="brandItem"
                      v-bind:brandItems="brandItems"
                      @changedBrand="snackbarSuccess = true; snackbarSuccessText='You changed the brand!'"
                      @notChangedBrand="snackbarDanger = true; snackbarDangerText='Brand not changed, something went wrong!'"
                      @emptyBrand="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateBrand="snackbarDanger = true; snackbarDangerText='This brand already exists!'"
                      @getBrands="getBrands()"
                    ></PopupChangeBrand>
                    <!-- Dijalog za brisanje brenda -->
                    <PopupDeleteBrand
                      v-bind:item="item"
                      v-bind:brandItem="brandItem"
                      v-bind:brandItems="brandItems"
                      @deletedBrand="snackbarSuccess = true; snackbarSuccessText='You deleted the brand!'"
                      @notDeletedBrand="snackbarDanger = true; snackbarDangerText='Brand not deleted, something went wrong!'"
                      @hasAddsBrand="snackbarDanger = true; snackbarDangerText='Cars with this brand exist. You can not delete it!'"
                      @hasModelsBrand="snackbarDanger = true; snackbarDangerText='Models of this brand exist. You can not delete it!'"
                      @getBrands="getBrands()"
                    ></PopupDeleteBrand>
                  </v-list-item>
                  <v-list-item>
                    <v-spacer></v-spacer>
                    <!-- Dijalog za dodavanje novog brenda -->
                    <PopupAddBrand
                      v-bind:item="item"
                      v-bind:brandItems="brandItems"
                      @addedBrand="snackbarSuccess = true; snackbarSuccessText='You added a new brand!'"
                      @notAddedBrand="snackbarDanger = true; snackbarDangerText='Brand not added, something went wrong!'"
                      @emptyBrand="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateBrand="snackbarDanger = true; snackbarDangerText='This brand already exists!'"
                      @getBrands="getBrands()"
                    ></PopupAddBrand>
                  </v-list-item>
                </v-list>
              </div>
            </v-card>
          </v-expand-x-transition>
          <!-- Class -->
          <v-expand-x-transition>
            <v-card v-show="expandClass" elevation="20">
              <div class="cardBorderColor">
                <v-list>
                  <v-list-item
                    v-for="vehicleClassItem in vehicleClassItems"
                    :key="vehicleClassItem.vehicle_class_name"
                  >
                    <v-list-item-content>
                      <v-list-item-title
                        class="primary--text"
                        v-text="vehicleClassItem.vehicle_class_name"
                      ></v-list-item-title>
                    </v-list-item-content>
                    <v-tooltip bottom color="black">
                      <template v-slot:activator="{ on }">
                        <v-btn icon v-on="on" color="primary">
                          <v-icon>sync</v-icon>
                        </v-btn>
                      </template>
                      <span class="primary--text">Change</span>
                    </v-tooltip>
                    <v-tooltip bottom color="black">
                      <template v-slot:activator="{ on }">
                        <v-btn icon v-on="on" color="primary">
                          <v-icon>delete</v-icon>
                        </v-btn>
                      </template>
                      <span class="primary--text">Delete</span>
                    </v-tooltip>
                  </v-list-item>
                  <v-list-item>
                    <v-spacer></v-spacer>
                    <!-- Dijalog za dodavanje nove klase vozila -->
                    <PopupAddClass
                      v-bind:item="item"
                      v-bind:vehicleClassItems="vehicleClassItems"
                      @addedVehicleClass="snackbarSuccess = true; snackbarSuccessText='You added a new class!'"
                      @notAddedVehicleClass="snackbarDanger = true; snackbarDangerText='Class not added, something went wrong!'"
                      @emptyVehicleClass="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateVehicleClass="snackbarDanger = true; snackbarDangerText='This class already exists!'"
                      @getVehicleClasses="getVehicleClasses()"
                    ></PopupAddClass>
                  </v-list-item>
                </v-list>
              </div>
            </v-card>
          </v-expand-x-transition>
          <!-- Transmission -->
          <v-expand-x-transition>
            <v-card v-show="expandTransmission" elevation="20">
              <div class="cardBorderColor">
                <v-list>
                  <v-list-item
                    v-for="transmissionTypeItem in transmissionTypeItems"
                    :key="transmissionTypeItem.transmission_type_name"
                  >
                    <v-list-item-content>
                      <v-list-item-title
                        class="primary--text"
                        v-text="transmissionTypeItem.transmission_type_name"
                      ></v-list-item-title>
                    </v-list-item-content>
                    <v-tooltip bottom color="black">
                      <template v-slot:activator="{ on }">
                        <v-btn icon v-on="on" color="primary">
                          <v-icon>sync</v-icon>
                        </v-btn>
                      </template>
                      <span class="primary--text">Change</span>
                    </v-tooltip>
                    <v-tooltip bottom color="black">
                      <template v-slot:activator="{ on }">
                        <v-btn icon v-on="on" color="primary">
                          <v-icon>delete</v-icon>
                        </v-btn>
                      </template>
                      <span class="primary--text">Delete</span>
                    </v-tooltip>
                  </v-list-item>
                  <v-list-item>
                    <v-spacer></v-spacer>
                    <!-- Dijalog za dodavanje novog tipa goriva -->
                    <PopupAddTransmissionType
                      v-bind:item="item"
                      v-bind:transmissionTypeItems="transmissionTypeItems"
                      @addedTransmissionType="snackbarSuccess = true; snackbarSuccessText='You added a new transmission type!'"
                      @notAddedTransmissionType="snackbarDanger = true; snackbarDangerText='Transmission type not added, something went wrong!'"
                      @emptyTransmissionType="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateTransmissionType="snackbarDanger = true; snackbarDangerText='This transmission type already exists!'"
                      @getTransmissionTypes="getTransmissionTypes()"
                    ></PopupAddTransmissionType>
                  </v-list-item>
                </v-list>
              </div>
            </v-card>
          </v-expand-x-transition>
          <!-- FuelType -->
          <v-expand-x-transition>
            <v-card v-show="expandFuelType" elevation="20">
              <div class="cardBorderColor">
                <v-list>
                  <v-list-item
                    v-for="fuelTypeItem in fuelTypeItems"
                    :key="fuelTypeItem.fuel_type_name"
                  >
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="fuelTypeItem.fuel_type_name"></v-list-item-title>
                    </v-list-item-content>
                    <!-- Dijalog za promenu tipa goriva -->
                    <PopupChangeFuelType
                      v-bind:item="item"
                      v-bind:fuelTypeItem="fuelTypeItem"
                      v-bind:fuelTypeItems="fuelTypeItems"
                      @changedFuelType="snackbarSuccess = true; snackbarSuccessText='You changed the fuel type!'"
                      @notChangedFuelType="snackbarDanger = true; snackbarDangerText='Fuel type not changed, something went wrong!'"
                      @emptyFuelType="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateFuelType="snackbarDanger = true; snackbarDangerText='This fuel type already exists!'"
                      @getFuelTypes="getFuelTypes()"
                    ></PopupChangeFuelType>
                    <!-- Dijalog za brisanje tipa goriva -->
                    <PopupDeleteFuelType
                      v-bind:item="item"
                      v-bind:fuelTypeItem="fuelTypeItem"
                      v-bind:fuelTypeItems="fuelTypeItems"
                      @deletedFuelType="snackbarSuccess = true; snackbarSuccessText='You deleted the fuel type!'"
                      @notDeletedFuelType="snackbarDanger = true; snackbarDangerText='Fuel type not deleted, something went wrong!'"
                      @hasAddsFuelType="snackbarDanger = true; snackbarDangerText='Cars with this fuel type exist. You can not delete it!'"
                      @getFuelTypes="getFuelTypes()"
                    ></PopupDeleteFuelType>
                  </v-list-item>
                  <v-list-item>
                    <v-spacer></v-spacer>
                    <!-- Dijalog za dodavanje novog tipa goriva -->
                    <PopupAddFuelType
                      v-bind:item="item"
                      v-bind:fuelTypeItems="fuelTypeItems"
                      @addedFuelType="snackbarSuccess = true; snackbarSuccessText='You added a new fuel type!'"
                      @notAddedFuelType="snackbarDanger = true; snackbarDangerText='Fuel type not added, something went wrong!'"
                      @emptyFuelType="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                      @duplicateFuelType="snackbarDanger = true; snackbarDangerText='This fuel type already exists!'"
                      @getFuelTypes="getFuelTypes()"
                    ></PopupAddFuelType>
                  </v-list-item>
                </v-list>
              </div>
            </v-card>
          </v-expand-x-transition>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";
import PopupAddFuelType from "@/components/codebook/fuelType/PopupAddFuelType";
import PopupChangeFuelType from "@/components/codebook/fuelType/PopupChangeFuelType";
import PopupDeleteFuelType from "@/components/codebook/fuelType/PopupDeleteFuelType";
import PopupAddBrand from "@/components/codebook/brand/PopupAddBrand";
import PopupChangeBrand from "@/components/codebook/brand/PopupChangeBrand";
import PopupDeleteBrand from "@/components/codebook/brand/PopupDeleteBrand";
import PopupViewBrandModels from "@/components/codebook/brand/PopupViewBrandModels";
import PopupAddClass from "@/components/codebook/class/PopupAddClass";
import PopupAddTransmissionType from "@/components/codebook/transmissionType/PopupAddTransmissionType";
export default {
  components: {
    PopupAddFuelType,
    PopupChangeFuelType,
    PopupDeleteFuelType,
    PopupAddBrand,
    PopupChangeBrand,
    PopupDeleteBrand,
    PopupViewBrandModels,
    PopupAddClass,
    PopupAddTransmissionType
  },
  data() {
    return {
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      expandBrand: false,
      expandClass: false,
      expandTransmission: false,
      expandFuelType: false,
      item: "",
      menuItems: ["Brand", "Class", "Transmission type", "Fuel type"],
      brandItems: {},
      vehicleClassItems: {},
      transmissionTypeItems: {},
      fuelTypeItems: {}
    };
  },
  methods: {
    expandMenuItem(menuItem) {
      if (menuItem == "Brand") {
        this.cancelOtherMenus(menuItem);
        this.expandBrand = !this.expandBrand;
        this.item = "brand";
      } else if (menuItem == "Class") {
        this.cancelOtherMenus(menuItem);
        this.expandClass = !this.expandClass;
        this.item = "class";
      } else if (menuItem == "Transmission type") {
        this.cancelOtherMenus(menuItem);
        this.expandTransmission = !this.expandTransmission;
        this.item = "transmission type";
      } else if (menuItem == "Fuel type") {
        this.cancelOtherMenus(menuItem);
        this.expandFuelType = !this.expandFuelType;
        this.item = "fuel type";
      }
    },
    cancelOtherMenus(menuItem) {
      if (menuItem != "Brand") {
        this.expandBrand = false;
      }
      if (menuItem != "Class") {
        this.expandClass = false;
      }
      if (menuItem != "Transmission type") {
        this.expandTransmission = false;
      }
      if (menuItem != "Fuel type") {
        this.expandFuelType = false;
      }
    },
    getBrands() {
      axios
        .get("/brand")
        .then(brandItems => {
          this.brandItems = brandItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getVehicleClasses() {
      axios
        .get("/vehicle_class")
        .then(vehicleClassItems => {
          this.vehicleClassItems = vehicleClassItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getTransmissionTypes() {
      axios
        .get("/transmission_type")
        .then(transmissionTypeItems => {
          this.transmissionTypeItems = transmissionTypeItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getFuelTypes() {
      axios
        .get("/fuel_type")
        .then(fuelTypeItems => {
          this.fuelTypeItems = fuelTypeItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    //izlistavanje brendova
    axios
      .get("/brand")
      .then(brandItems => {
        this.brandItems = brandItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje klasa
    axios
      .get("/vehicle_class")
      .then(vehicleClassItems => {
        this.vehicleClassItems = vehicleClassItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova goriva
    axios
      .get("/transmission_type")
      .then(transmissionTypeItems => {
        this.transmissionTypeItems = transmissionTypeItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova goriva
    axios
      .get("/fuel_type")
      .then(fuelTypeItems => {
        this.fuelTypeItems = fuelTypeItems.data;
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
</style>
