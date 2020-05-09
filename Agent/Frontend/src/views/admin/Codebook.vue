<template>
  <div>
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
                          <v-icon>add_circle</v-icon>
                        </v-btn>
                      </template>
                      <span class="primary--text">Add new model</span>
                    </v-tooltip>
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
          <!-- Gas -->
          <v-expand-x-transition>
            <v-card v-show="expandGas" elevation="20">
              <div class="cardBorderColor">
                <v-list>
                  <v-list-item v-for="gasItem in gasItems" :key="gasItem">
                    <v-list-item-content>
                      <v-list-item-title class="primary--text" v-text="gasItem"></v-list-item-title>
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
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      expandBrand: false,
      expandClass: false,
      expandTransmission: false,
      expandGas: false,
      menuItems: ["Brand", "Class", "Transmission type", "Gas type"],
      brandItems: ["BMW", "Audi", "Mercedes", "Tesla"],
      modelItems: ["M5", "R8", "X6"],
      classItems: ["SUV", "oldtimer", "city-car"],
      transmissionItems: ["manual", "automatic", "semi-automatic"],
      gasItems: ["gasoline", "gas", "diesel"]
    };
  },
  methods: {
    expandMenuItem(menuItem) {
      if (menuItem == "Brand") {
        this.cancelOtherMenus(menuItem);
        this.expandBrand = !this.expandBrand;
      } else if (menuItem == "Class") {
        this.cancelOtherMenus(menuItem);
        this.expandClass = !this.expandClass;
      } else if (menuItem == "Transmission type") {
        this.cancelOtherMenus(menuItem);
        this.expandTransmission = !this.expandTransmission;
      } else if (menuItem == "Gas type") {
        this.cancelOtherMenus(menuItem);
        this.expandGas = !this.expandGas;
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
      if (menuItem != "Gas type") {
        this.expandGas = false;
      }
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
</style>
