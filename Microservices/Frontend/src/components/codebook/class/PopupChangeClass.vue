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
            Change {{item}} "{{vehicleClassItem.vehicle_class_name
            }}"
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="vehicleClass.vehicle_class_name
              "
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
    vehicleClassItem: {
      default: ""
    },
    vehicleClassItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      vehicleClass: {
        id: this.vehicleClassItem.id,
        vehicle_class_name: ""
      },
      flagDuplicateVehicleClass: false
    };
  },
  methods: {
    changeVehicleClass() {
      if (this.vehicleClass.vehicle_class_name == "") {
        this.$emit("emptyVehicleClass");
        this.vehicleClass.vehicle_class_name = "";
        this.dialogDetails = false;
      } else {
        axios
          .put("/addvertisment-service/vehicle_class", this.vehicleClass)
          .then(() => {
            this.$emit("changedVehicleClass");
            this.$emit("getVehicleClasses");
            this.vehicleClass.vehicle_class_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notChangedVehicleClass");
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
        this.changeVehicleClass();
      } else {
        this.$emit("duplicateVehicleClass");
        this.flagDuplicateVehicleClass = false;
        this.vehicleClass.vehicle_class_name = "";
        this.dialogDetails = false;
      }
    }
  }
};
</script>

