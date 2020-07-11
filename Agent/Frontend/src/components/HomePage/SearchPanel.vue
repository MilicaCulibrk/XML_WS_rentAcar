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
                  v-model="searchItem.selectLocation"
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
                        @click="findDate"
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
                        @click="findDate"
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
              <v-btn rounded class="primary white--text mt-2" @click.native.stop @click="search()">
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
              v-model="searchItem.selectBrand"
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
              v-model="searchItem.selectTransmission"
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
          <v-col cols="2">
            <v-select
              v-model="searchItem.selectMinPrice"
              :items="minPriceItems"
              label="Min daily price"
              outlined
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <v-col cols="2">
            <v-select
              v-model="searchItem.selectMaxPrice"
              :items="minPriceItems"
              label="Max daily price"
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
              v-model="searchItem.selectModel"
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
              v-model="searchItem.selectGas"
              :items="gasItems"
              label="Gas type"
              outlined
              multiple
              dense
              clearable
              rounded
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <!-- kilometraza -->
          <v-col cols="2">
            <v-select
              v-model="searchItem.selectMinMileage"
              :items="minMileageItems"
              label="Min mileage (km)"
              outlined
              dense
              rounded
              clearable
              class="pt-4"
              color="primary"
            ></v-select>
          </v-col>
          <v-col cols="2">
            <v-select
              v-model="searchItem.selectMaxMileage"
              :items="maxMileageItems"
              label="Max mileage (km)"
              outlined
              dense
              rounded
              clearable
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
              v-model="searchItem.selectClass"
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
          <!-- sedista za decu -->
          <v-col cols="4">
            <v-select
              v-model="searchItem.selectChildSeats"
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
          <!-- CDW -->
          <v-col cols="1">
            <v-checkbox label="CDW" class="mt-6" v-model="searchItem.cdw" color="primary"></v-checkbox>
          </v-col>
          <!-- Mileage limit -->
          <v-col cols="1.5">
            <v-checkbox
              label="Mileage limit"
              class="mt-6"
              v-model="searchItem.mileageLimit"
              color="primary"
            ></v-checkbox>
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
      brandItems: [],
      modelItems: [],
      classItems: [],
      transmissionItems: [],
      gasItems: [],
      cars: [],
      locationItems: [],
      searchItem: {
        selectBrand: [],
        selectModel: [],
        selectClass: [],
        selectTransmission: [],
        selectGas: [],
        selectLocation: [],
        cdw: false,
        mileageLimit: false,
        selectChildSeats: [],
        selectMinPrice: null,
        selectMaxPrice: null,
        selectMinMileage: null,
        selectMaxMileage: null,
        dates: []
      },
      minMileageItems: [
        "100000",
        "200000",
        "300000",
        "400000",
        "500000",
        "500000"
      ],
      maxMileageItems: [
        "100000",
        "200000",
        "300000",
        "400000",
        "500000",
        "500000"
      ],
      minPriceItems: ["1000", "2000", "3000", "4000", "5000", "5000"],
      maxPriceItems: ["1000", "2000", "3000", "4000", "5000", "5000"],
      childSeatsItems: ["0", "1", "2", "3", "4"],
      plannedToCrossRule: [
        v => /^[0-9]*$/.test(v) || "Only numbers are allowed"
      ]
    };
  },
  methods: {
    findDate() {
      var tomorrow = new Date();
      tomorrow.setDate(new Date().getDate() + 2);
      this.nowDate = tomorrow.toISOString().slice(0, 10) + 2;
    },
    cancelSearch() {
      this.searchItem.selectBrand = [];
      this.searchItem.selectModel = [];
      this.searchItem.selectClass = [];
      this.searchItem.selectTransmission = [];
      this.searchItem.selectGas = [];
      this.searchItem.selectMinMileage = null;
      this.searchItem.selectMaxMileage = null;
      this.searchItem.selectMinPrice = null;
      this.searchItem.selectMaxPrice = null;
      this.searchItem.selectChildSeats = [];
      this.searchItem.selectLocation = [];
      this.searchItem.cdw = false;
      this.searchItem.mileageLimit = false;
      this.due = null;
      this.to = null;
      this.$emit("getCars");
      this.$emit("clearDates");
    },
    clearDates() {},
    consoleLocation() {
      console.log(this.searchItem.selectLocation.length);
    },
    getLocations() {
      var i = 0;
      for (i = 0; i < this.cars.length; i++) {
        this.locationItems.push(this.cars[i].location);
      }
    },
    getCars() {
      axios
        .get("/addvertisment")
        .then(cars => {
          this.cars = cars.data;
          this.getLocations();
        })
        .catch(error => {
          console.log(error);
        });
    },
    search() {
      this.$emit("search", this.searchItem, this.due, this.to);
    }
  },
  mounted() {
    //izlistavanje brendova
    axios
      .get("/brand")
      .then(brandItems => {
        this.brands = brandItems.data;

        var i = 0;
        for (i = 0; i < this.brands.length; i++) {
          this.brandItems.push(this.brands[i].brand_name);
        }
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje modela
    axios
      .get("/brand/model")
      .then(modelItems => {
        this.modelItems = modelItems.data;
        console.log(this.modelItems);
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje klasa
    axios
      .get("/vehicle_class")
      .then(classItems => {
        this.calsses = classItems.data;

        var i = 0;
        for (i = 0; i < this.calsses.length; i++) {
          this.classItems.push(this.calsses[i].vehicle_class_name);
        }
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova goriva
    axios
      .get("/fuel_type")
      .then(gasItems => {
        this.fuelTypes = gasItems.data;

        var i = 0;
        for (i = 0; i < this.fuelTypes.length; i++) {
          this.gasItems.push(this.fuelTypes[i].fuel_type_name);
        }
      })
      .catch(error => {
        console.log(error);
      });

    //izlistavanje tipova prenosa
    axios
      .get("/transmission_type")
      .then(transmissionItems => {
        this.transmissionTypes = transmissionItems.data;

        var i = 0;
        for (i = 0; i < this.transmissionTypes.length; i++) {
          this.transmissionItems.push(
            this.transmissionTypes[i].transmission_type_name
          );
        }
      })
      .catch(error => {
        console.log(error);
      });

    //get cars
    axios
      .get("/addvertisment")
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
      console.log(this.due);
      return this.due;
    },
    formattedDateTo() {
      console.log(this.to);
      return this.to;
    }
  }
};
</script>