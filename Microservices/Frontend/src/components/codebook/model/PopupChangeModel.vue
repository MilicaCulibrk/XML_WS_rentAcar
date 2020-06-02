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
            Change model "{{modelItem.vehicle_model_name}}"
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="model.vehicle_model_name"
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
    modelItem: {
      default: ""
    },
    brandItem: {
      default: ""
    },
    modelItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      model: {
        id: this.modelItem.id,
        vehicle_model_name: "",
        brand_id: this.brandItem.id
      },
      flagDuplicateModel: false
    };
  },
  methods: {
    changeModel() {
      if (this.model.model_name == "") {
        this.$emit("emptyModel");
        this.dialogDetails = false;
        this.model.vehicle_model_name = "";
      } else {
        axios
          .put(
            "/addvertisment-service/brand/" + this.brandItem.id + "/model",
            this.model
          )
          .then(() => {
            this.$emit("changedModel");
            this.$emit("getModels");
            this.model.vehicle_model_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notChangedModel");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.modelItems.length; i++) {
        if (
          this.modelItems[i].vehicle_model_name == this.model.vehicle_model_name
        ) {
          this.flagDuplicateModel = true;
          break;
        }
      }

      if (!this.flagDuplicateModel) {
        this.changeModel();
      } else {
        this.$emit("duplicateModel");
        this.flagDuplicateModel = false;
        this.dialogDetails = false;
        this.model.vehicle_model_name = "";
      }
    }
  }
};
</script>

