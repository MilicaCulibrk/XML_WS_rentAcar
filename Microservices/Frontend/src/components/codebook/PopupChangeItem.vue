<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="400px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>sync</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">Change</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            Change {{item}} "{{fuelTypeItem.fuel_type_name}}"
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="fuelType.fuel_type_name"
              color="primary"
              prepend-inner-icon="sync"
            ></v-text-field>
            <v-row>
              <v-col cols="4"></v-col>
              <v-col cols="4"></v-col>
              <v-col cols="4">
                <v-btn color="primary" class="ml-2" @click="checkIfDuplicate()">Change</v-btn>
              </v-col>
            </v-row>
          </v-card-text>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  props: {
    item: {
      default: ""
    },
    fuelTypeItem: {
      default: ""
    },
    fuelTypeItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      fuelType: {
        id: this.fuelTypeItem.id,
        fuel_type_name: ""
      },
      flagDuplicateFuelType: false
    };
  },
  methods: {
    changeFuelType() {
      if (this.fuelType.fuel_type_name == "") {
        this.$emit("emptyFuelType");
      } else {
        console.log(this.fuelType);
        axios
          .put("/addvertisment-service/fuel_type", this.fuelType)
          .then(() => {
            this.$emit("changedFuelType");
            this.$emit("getFuelTypes");
            this.fuelType.fuel_type_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notChangedFuelType");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.fuelTypeItems.length; i++) {
        if (
          this.fuelTypeItems[i].fuel_type_name == this.fuelType.fuel_type_name
        ) {
          this.flagDuplicateFuelType = true;
          break;
        }
      }

      if (!this.flagDuplicateFuelType) {
        this.changeFuelType();
      } else {
        this.$emit("duplicateFuelType");
        this.flagDuplicateFuelType = false;
      }
    }
  }
};
</script>

