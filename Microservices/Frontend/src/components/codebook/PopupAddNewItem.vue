<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="400px">
      <template #activator="{ on: dialogDetails }">
        <v-btn con v-on="{ ...dialogDetails }" color="primary">
          <v-icon>add</v-icon>
          <span>add new</span>
        </v-btn>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            Add new {{item}}
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="fuelType.fuel_type_name"
              color="primary"
              prepend-inner-icon="add"
            ></v-text-field>
            <v-row>
              <v-col cols="4"></v-col>
              <v-col cols="4"></v-col>
              <v-col cols="4">
                <v-btn color="primary" class="ml-8" @click="checkIfDuplicate()">Add</v-btn>
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
    fuelTypeItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      fuelType: {
        fuel_type_name: ""
      },
      flagDuplicateFuelType: false
    };
  },
  methods: {
    postFuelType() {
      if (this.fuelType.fuel_type_name == "") {
        this.$emit("emptyFuelType");
      } else {
        axios
          .post("/addvertisment-service/fuel_type", this.fuelType)
          .then(() => {
            this.$emit("addedFuelType");
            this.$emit("getFuelTypes");
            this.fuelType.fuel_type_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notAddedFuelType");
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
        this.postFuelType();
      } else {
        this.$emit("duplicateFuelType");
        this.flagDuplicateFuelType = false;
      }
    }
  }
};
</script>

