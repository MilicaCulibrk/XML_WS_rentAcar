<template>
  <div>
    <!-- Snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="4000" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="4000" top color="danger">
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
                  <v-list-item v-for="brandItem in brandItems" :key="brandItem">
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="brandItem"></v-list-item-title>
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
                    <v-btn color="primary">
                      <v-icon>add</v-icon>
                      <span>add new</span>
                    </v-btn>
                  </v-list-item>
                </v-list>
              </div>
            </v-card>
          </v-expand-x-transition>
          <!-- Model -->
          <v-expand-x-transition>
            <v-card v-show="expandModel" elevation="20">
              <div class="cardBorderColor shrink">
                <v-list>
                  <v-list-item v-for="modelItem in modelItems" :key="modelItem">
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="modelItem"></v-list-item-title>
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
                    <v-btn color="primary">
                      <v-icon>add</v-icon>
                      <span>add new</span>
                    </v-btn>
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
                  <v-list-item v-for="classItem in classItems" :key="classItem">
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="classItem"></v-list-item-title>
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
                    <v-btn color="primary">
                      <v-icon>add</v-icon>
                      <span>add new</span>
                    </v-btn>
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
                    v-for="transmissionItem in transmissionItems"
                    :key="transmissionItem"
                  >
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="transmissionItem"></v-list-item-title>
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
                    <v-btn color="primary">
                      <v-icon>add</v-icon>
                      <span>add new</span>
                    </v-btn>
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
                    <PopupAddNewItem
                      v-bind:item="item"
                      @addedFuelType="snackbarSuccess = true; snackbarSuccessText='You added a new fuel type!'"
                      @notAddedFuelType="snackbarDanger = true; snackbarDangerText='Fuel type not added, it already exists!'"
                      @getFuelTypes="getFuelTypes()"
                    ></PopupAddNewItem>
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
import PopupAddNewItem from "@/components/codebook/PopupAddNewItem";
export default {
  components: { PopupAddNewItem },
  data() {
    return {
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      expandBrand: false,
      expandModel: false,
      expandClass: false,
      expandTransmission: false,
      expandFuelType: false,
      item: "",
      menuItems: ["Brand", "Model", "Class", "Transmission type", "Fuel type"],
      brandItems: ["BMW", "Audi", "Mercedes", "Tesla"],
      modelItems: ["(Citroen) M5", "(Audi) R8", "(BMW) X6"],
      classItems: ["SUV", "oldtimer", "city-car"],
      transmissionItems: ["manual", "automatic", "semi-automatic"],
      fuelTypeItems: {}
    };
  },
  methods: {
    expandMenuItem(menuItem) {
      if (menuItem == "Brand") {
        this.cancelOtherMenus(menuItem);
        this.expandBrand = !this.expandBrand;
        this.item = "brand";
      } else if (menuItem == "Model") {
        this.cancelOtherMenus(menuItem);
        this.expandModel = !this.expandModel;
        this.item = "model";
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
      if (menuItem != "Model") {
        this.expandModel = false;
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
    getFuelTypes() {
      axios
        .get("/addvertisment-service/fuel_type")
        .then(fuelTypeItems => {
          this.fuelTypeItems = fuelTypeItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    //izlistavanje tipova goriva
    axios
      .get("/addvertisment-service/fuel_type")
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
