<template>
  <div>
    <v-app-bar dark height="70" class="pt-4">
      <span class="mx-16"></span>
      <v-tooltip bottom color="black">
        <template v-slot:activator="{ on }">
          <v-app-bar-nav-icon
            class="pb-12"
            @click="drawerAdvancedSearch = !drawerAdvancedSearch"
            v-on="on"
          >
            <v-icon large color="deep-orange lighten-2">menu_open</v-icon>
          </v-app-bar-nav-icon>
        </template>
        <span class="primary--text">Advanced Search</span>
      </v-tooltip>
      <v-container>
        <v-row justify="space-between">
          <v-col cols="12" lg="4" md="4" sm="3" xs="3">
            <v-form ref="form">
              <v-text-field
                prepend-icon="place"
                label="Pickup location"
                class="ml-n4 mr-12"
                color="primary"
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
                  ></v-date-picker>
                </v-menu>
              </v-layout>
            </v-form>
          </v-col>
          <!-- search button  -->
          <v-spacer></v-spacer>
          <v-col class="mr-n3">
            <v-btn rounded class="primary white--text">
              <v-icon left>search</v-icon>
              <span>search</span>
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-app-bar>

    <!-- fioka napredna pretraga -->
    <AdvancedSearch v-bind:drawerAdvancedSearch="drawerAdvancedSearch"></AdvancedSearch>
  </div>
</template>

<script>
import AdvancedSearch from "./AdvancedSearch";
export default {
  components: { AdvancedSearch },
  data() {
    return {
      drawerAdvancedSearch: false,
      fromDateMenu: false,
      toDateMenu: false,
      due: null,
      to: null
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
