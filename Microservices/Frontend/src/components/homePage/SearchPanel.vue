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
                <v-text-field
                  prepend-icon="place"
                  label="Pickup location"
                  class="ml-n4 mr-12"
                  color="primary"
                  @click.native.stop
                ></v-text-field>
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
                        class="ml-4 mr-12"
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
                        class="ml-12"
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
              <v-btn rounded class="primary white--text" @click.native.stop>
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
            <v-combobox
              v-model="selectBrand"
              :items="brandItems"
              label="Brand"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- menjac -->
          <v-col cols="4">
            <v-combobox
              v-model="selectTransmission"
              :items="transmissionItems"
              label="Transmission type"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- cena -->
          <v-col cols="4">
            <v-combobox
              v-model="selectPrice"
              :items="priceItems"
              label="Price"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
        </v-row>
        <!-- drugi red -->
        <v-row class="mt-n8">
          <!-- model -->
          <v-col cols="4">
            <v-combobox
              v-model="selectModel"
              :items="modelItems"
              label="Model"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- gas -->
          <v-col cols="4">
            <v-combobox
              v-model="selectGas"
              :items="gasItems"
              label="Gas type"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- gas -->
          <v-col cols="4">
            <v-combobox
              v-model="selectChildSeats"
              :items="childSeatsItems"
              label="Number of child seats"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
        </v-row>
        <!-- treci red -->
        <v-row class="mt-n8">
          <!-- klasa -->
          <v-col cols="4">
            <v-combobox
              v-model="selectClass"
              :items="classItems"
              label="Class"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- kilometraza -->
          <v-col cols="4">
            <v-combobox
              v-model="selectMileage"
              :items="mileageItems"
              label="Mileage"
              multiple
              outlined
              dense
              class="pt-4"
              color="primary"
            ></v-combobox>
          </v-col>
          <!-- planirano da predje -->
          <v-col cols="2">
            <v-text-field label="Planned to cross(km)" :rules="plannedToCrossRule" color="primary"></v-text-field>
          </v-col>
          <!-- CDW -->
          <v-col cols="2">
            <v-checkbox label="CWD" :v-model="cdw" color="primary"></v-checkbox>
          </v-col>
        </v-row>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
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
      cdw: false,
      brandItems: ["BMW", "Audi", "Mercedes", "Tesla"],
      modelItems: ["M5", "R8", "X6"],
      classItems: ["SUV", "oldtimer", "city-car"],
      transmissionItems: ["manual", "automatic", "semi-automatic"],
      gasItems: ["gasoline", "gas", "diesel"],
      mileageItems: ["50.000-100.000", "100.000-200.000", "200.000-300.000"],
      priceItems: ["10.000-20.000", "20.000-30.000", "30.000-40.000"],
      childSeatsItems: ["0", "1", "2", "3", "4", "5"],
      plannedToCrossRule: [
        v => /^[0-9]*$/.test(v) || "Only numbers are allowed"
      ]
    };
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
