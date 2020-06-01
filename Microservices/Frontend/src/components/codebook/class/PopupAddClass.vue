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
              v-model="vehicleClass.vehicle_class_name"
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
    vehicleClassItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      vehicleClass: {
        vehicle_class_name: ""
      },
      flagDuplicateVehicleClass: false
    };
  },
  methods: {
    postVehicleClass() {
      if (this.vehicleClass.vehicle_class_name == "") {
        this.$emit("emptyVehicleClass");
        this.dialogDetails = false;
        this.vehicleClass.vehicle_class_name = "";
      } else {
        axios
          .post("/addvertisment-service/vehicle_class", this.vehicleClass)
          .then(() => {
            this.$emit("addedVehicleClass");
            this.$emit("getVehicleClasses");
            this.vehicleClass.vehicle_class_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notAddedVehicleClass");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.vehicleClassItems.length; i++) {
        if (
          this.vehicleClassItems[i].vehicle_class_name ==
          this.vehicleClass.vehicle_class_name
        ) {
          this.flagDuplicateVehicleClass = true;
          break;
        }
      }

      if (!this.flagDuplicateVehicleClass) {
        this.postVehicleClass();
      } else {
        this.$emit("duplicateVehicleClass");
        this.flagDuplicateVehicleClass = false;
        this.dialogDetails = false;
        this.vehicleClass.vehicle_class_name = "";
      }
    }
  }
};
</script>

