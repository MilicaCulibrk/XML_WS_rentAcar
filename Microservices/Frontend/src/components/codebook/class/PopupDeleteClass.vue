<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="700px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>delete</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">Delete</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            Are you sure you want to delete {{item}} "{{vehicleClassItem.vehicle_class_name
            }}" ?
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-row>
              <v-col cols="4"></v-col>
              <v-col cols="4">
                <v-btn text color="primary" @click="dialogDetails =  false">No</v-btn>
                <v-btn color="primary" @click="checkIfHasAdds()">Yes</v-btn>
              </v-col>
              <v-col cols="4"></v-col>
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
      addvertisments: {},
      flagHasAdds: false
    };
  },
  methods: {
    deleteVehicleClass() {
      axios
        .delete("/addvertisment-service/vehicle_class/" + this.vehicleClass.id)
        .then(() => {
          this.vehicleClass.vehicle_class_name = "";
          this.$emit("deletedVehicleClass");
          this.$emit("getVehicleClasses");
          this.vehicleClass.vehicle_class_name = "";
          this.dialogDetails = false;
        })
        .catch(error => {
          this.$emit("notDeletedVehicleClass");
          console.log(error);
        });
    },
    checkIfHasAdds() {
      var i = 0;
      for (i = 0; i < this.addvertisments.length; i++) {
        if (this.addvertisments[i].vehicle_class_id == this.vehicleClass.id) {
          this.flagHasAdds = true;
          break;
        }
      }

      if (!this.flagHasAdds) {
        this.deleteVehicleClass();
      } else {
        this.$emit("hasAddsVehicleClass");
        this.flagHasAdds = false;
        this.dialogDetails = false;
        this.vehicleClass.vehicle_class_name = "";
      }
    }
  },
  mounted() {
    //izlistavanje advertismenta
    axios
      .get("/addvertisment-service/addvertisment")
      .then(addvertisments => {
        this.addvertisments = addvertisments.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

