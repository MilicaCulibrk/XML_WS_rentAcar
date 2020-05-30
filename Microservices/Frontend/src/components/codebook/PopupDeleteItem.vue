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
            Are you sure you want to delete {{item}} "{{fuelTypeItem.fuel_type_name}}" ?
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
      addvertisments: {},
      flagHasAdds: false
    };
  },
  methods: {
    deleteFuelType() {
      axios
        .delete("/addvertisment-service/fuel_type/" + this.fuelType.id)
        .then(() => {
          this.fuelType.fuel_type_name = "";
          this.$emit("deletedFuelType");
          this.$emit("getFuelTypes");
          this.fuelType.fuel_type_name = "";
        })
        .catch(error => {
          this.$emit("notDeletedFuelType");
          console.log(error);
        });
    },
    checkIfHasAdds() {
      console.log(this.flagHasAdds);
      var i = 0;
      for (i = 0; i < this.addvertisments.length; i++) {
        if (this.addvertisments[i].fuelTypeId == this.fuelType.id) {
          this.flagHasAdds = true;
          break;
        }
      }

      if (!this.flagHasAdds) {
        this.deleteFuelType();
      } else {
        console.log(this.flagHasAdds);
        this.$emit("hasAddsFuelType");
        this.flagHasAdds = false;
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

