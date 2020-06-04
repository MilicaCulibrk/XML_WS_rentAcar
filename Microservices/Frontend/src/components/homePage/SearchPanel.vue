<template>
  <v-expansion-panels dark class="mt-4">
    <v-expansion-panel>
      <v-expansion-panel-header class="mt-n8 mb-n12">
        <!-- kontejner sa formama i poljima -->
        <v-container>
          <v-row justify="space-between">
            <!-- lokacija -->
            <v-col cols="12" lg="4" md="4" sm="3" xs="3">
              <v-form ref="form">
                <v-select
                  v-model="selectLocation"
                  :items="locationItems"
                  label="Pickup location"
                  multiple
                  outlined
                  dense
                  clearable
                  small-chips
                  rounded
                  deletable-chips
                  prepend-inner-icon="place"
                  class="pt-4"
                  color="primary"
                  @click.native.stop
                  @click="consoleLocation()"
                ></v-select>
                <!-- <v-text-field
                  prepend-icon="place"
                  label="Pickup location"
                  class="ml-n4 mr-12"
                  color="primary"
                  @click.native.stop
                ></v-text-field>-->
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
                        label="Pickup date"
                        readonly
                        class="ml-8 mt-2"
                        color="primary"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      locale="en-in"
                      @input="fromDateMenu = false"
                      v-model="due"
                      color="primary"
                      :min="nowDate"
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
                        label="Return date"
                        readonly
                        class="ml-12 mt-2"
                        color="primary"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      locale="en-in"
                      @input="toDateMenu = false"
                      v-model="to"
                      color="primary"
                      :min="nowDate"
                    ></v-date-picker>
                  </v-menu>
                </v-layout>
              </v-form>
            </v-col>
            <!-- search button  -->
            <v-spacer></v-spacer>
            <v-col class="mr-n3 mt-3">
              <v-btn rounded class="primary white--text mt-2" @click.native.stop>
                <v-icon left>search</v-icon>
                <span>search</span>
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-expansion-panel-header>
      <!-- napredna pretraga -->
      <v-expansion-panel-content>
        <!-- prvi red -->
        <v-row>
          <!-- brend -->
          <v-col cols="4">
            <v-select
              v-model="selectBrand"
              :items="brandItems"
              label="Brand"
              multiple
              outlined
              dense
              clearable
              rounded
              item-color="primary"
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- menjac -->
          <v-col cols="4">
            <v-select
              v-model="selectTransmission"
              :items="transmissionItems"
              label="Transmission type"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- cena -->
          <v-col cols="4">
            <v-select
              v-model="selectPrice"
              :items="priceItems"
              label="Daily price (RSD)"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
        </v-row>
        <!-- drugi red -->
        <v-row class="mt-n8">
          <!-- model -->
          <v-col cols="4">
            <v-select
              v-model="selectModel"
              :items="modelItems"
              label="Model"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- gas -->
          <v-col cols="4">
            <v-select
              v-model="selectGas"
              :items="gasItems"
              label="Gas type"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- sedista za decu -->
          <v-col cols="4">
            <v-select
              v-model="selectChildSeats"
              :items="childSeatsItems"
              label="Number of child seats"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
        </v-row>
        <!-- treci red -->
        <v-row class="mt-n8">
          <!-- klasa -->
          <v-col cols="4">
            <v-select
              v-model="selectClass"
              :items="classItems"
              label="Class"
              multiple
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- kilometraza -->
          <v-col cols="4">
            <v-select
              v-model="selectMileage"
              :items="mileageItems"
              label="Mileage (km)"
              multiple
              outlined
              dense
              rounded
              clearable
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- CDW -->
          <v-col cols="1">
            <v-checkbox label="CDW" class="mt-6" v-model="cdw" color="primary"></v-checkbox>
          </v-col>
          <!-- Mileage limit -->
          <v-col cols="1.5">
            <v-checkbox label="Mileage limit" class="mt-6" v-model="mileageLimit" color="primary"></v-checkbox>
          </v-col>
          <!-- Cancel search -->
          <v-col cols="1.5">
            <v-btn text color="primary" class="mt-6" @click="cancelSearch">cancel search</v-btn>
          </v-col>
        </v-row>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      nowDate: new Date().toISOString().slice(0, 10) + 2,
      fromDateMenu: false,
      toDateMenu: false,
      due: null,
      to: null,
      selectBrand: [],
      selectModel: [],
      selectClass: [],
      selectTransmission: [],
      selectGas: [],
      selectMileage: [],
      selectPrice: [],
      selectChildSeats: [],
      selectLocation: [],
      cdw: false,
      mileageLimit: false,
      brandItems: {},
      modelItems: {},
      classItems: {},
      transmissionItems: {},
      gasItems: {},
      cars: {},
      locationItems: [],
      mileageItems: [
        "< 100.000",
        "100.000 - 200.000",
        "200.000 - 300.000",
        "300.000 - 400.000",
        "> 500.000"
      ],
      priceItems: [
        "< 1.000",
        "1.000 - 2.000",
        "2.000 - 3.000",
        "3.000 - 4.000",
        "3.000 - 5.000",
        "> 5.000"
      ],
      childSeatsItems: ["0", "1", "2", "3", "4"],
      plannedToCrossRule: [
        v => /^[0-9]*$/.test(v) || "Only numbers are allowed"
      ]
    };
  },
  methods: {
    cancelSearch() {
      this.selectBrand = [];
      this.selectModel = [];
      this.selectClass = [];
      this.selectTransmission = [];
      this.selectGas = [];
      this.selectMileage = [];
      this.selectPrice = [];
      this.selectChildSeats = [];
      this.selectLocation = [];
      this.cdw = false;
      this.mileageLimit = false;
    },
    consoleLocation() {
      console.log(this.selectLocation.length);
    },
    getLocations() {
      var i = 0;
      for (i = 0; i < this.cars.length; i++) {
        this.locationItems.push(this.cars[i].location);
      }
    }
  },
  mounted() {
    //izlistavanje brendova
    axios
      .get("/search-service/brands")
      .then(brandItems => {
        this.brandItems = brandItems.data;
        console.log(this.brandItems);
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje modela
    axios
      .get("/search-service/models")
      .then(modelItems => {
        this.modelItems = modelItems.data;
        console.log(this.modelItems);
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje klasa
    axios
      .get("/search-service/vehicle_classes")
      .then(classItems => {
        this.classItems = classItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova goriva
    axios
      .get("/search-service/fuel_types")
      .then(gasItems => {
        this.gasItems = gasItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova prenosa
    axios
      .get("/search-service/transmission_types")
      .then(transmissionItems => {
        this.transmissionItems = transmissionItems.data;
      })
      .catch(error => {
        console.log(error);
      });

    //get cars
    axios
      .get("/search-service/search")
      .then(cars => {
        this.cars = cars.data;
        this.getLocations();
      })
      .catch(error => {
        console.log(error);
      });
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
