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
            Add a new {{ brandItem.brand_name }} model
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="model.vehicle_model_name"
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
    brandItem: {
      default: ""
    },
    modelItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      model: {
        vehicle_model_name: "",
        brand_id: this.brandItem.id
      },
      flagDuplicateModel: false
    };
  },
  methods: {
    postModel() {
      if (this.model.vehicle_model_name == "") {
        this.$emit("emptyModel");
      } else {
        axios
          .post("/brand/" + this.brandItem.id + "/model", this.model)
          .then(() => {
            this.$emit("addedModel");
            this.$emit("getModels");
            this.model.vehicle_model_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notAddedmodel");
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
        this.postModel();
      } else {
        this.$emit("duplicateModel");
        this.flagDuplicateModel = false;
        this.model.vehicle_model_name = "";
        this.dialogDetails = false;
      }
    }
  }
};
</script>

