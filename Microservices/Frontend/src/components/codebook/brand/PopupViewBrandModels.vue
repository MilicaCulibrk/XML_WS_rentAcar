<template>
  <div>
    <!-- Snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>

    <v-dialog v-model="dialogDetails" max-width="600px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialogDetails }" color="primary">
              <v-icon>zoom_in</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View Models</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            Models of {{item}} {{brandItem.brand_name}}
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text>
            <v-list>
              <v-list-item v-for="modelItem in modelItems" :key="modelItem.vehicle_model_name">
                <v-list-item-content>
                  <v-list-item-title class="primary--text" v-text="modelItem.vehicle_model_name"></v-list-item-title>
                </v-list-item-content>
                <!-- Dijalog za promenu modela -->
                <PopupChangeModel
                  v-bind:brandItem="brandItem"
                  v-bind:modelItem="modelItem"
                  v-bind:modelItems="modelItems"
                  @changedModel="snackbarSuccess = true; snackbarSuccessText='You changed the model!'"
                  @notChangedModel="snackbarDanger = true; snackbarDangerText='Model not changed, something went wrong!'"
                  @emptyModel="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                  @duplicateModel="snackbarDanger = true; snackbarDangerText='This model already exists!'"
                  @getModels="getModels()"
                ></PopupChangeModel>
                <!-- Dijalog za brisanje modela -->
                <PopupDeleteModel
                  v-bind:brandItem="brandItem"
                  v-bind:modelItem="modelItem"
                  v-bind:modelItems="modelItems"
                  @deletedModel="snackbarSuccess = true; snackbarSuccessText='You deleted the model!'"
                  @notDeletedModel="snackbarDanger = true; snackbarDangerText='Model not changed, something went wrong!'"
                  @hasAddsModel="snackbarDanger = true; snackbarDangerText='Cars with this model type exist. You can not delete it!'"
                  @getModels="getModels()"
                ></PopupDeleteModel>
              </v-list-item>
              <v-list-item>
                <v-spacer></v-spacer>
                <!-- Dijalog za dodavanje modela -->
                <PopupAddModel
                  v-bind:brandItem="brandItem"
                  v-bind:modelItems="modelItems"
                  @addedModel="snackbarSuccess = true; snackbarSuccessText='You added the model!'"
                  @notAddedModel="snackbarDanger = true; snackbarDangerText='Model not added, something went wrong!'"
                  @emptyModel="snackbarDanger = true; snackbarDangerText='You can not add an empty string!'"
                  @duplicateModel="snackbarDanger = true; snackbarDangerText='This model already exists!'"
                  @getModels="getModels()"
                ></PopupAddModel>
              </v-list-item>
            </v-list>
          </v-card-text>
        </div>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
import PopupAddModel from "../model/PopupAddModel";
import PopupChangeModel from "../model/PopupChangeModel";
import PopupDeleteModel from "../model/PopupDeleteModel";
export default {
  components: {
    PopupAddModel,
    PopupChangeModel,
    PopupDeleteModel
  },
  props: {
    item: {
      default: ""
    },
    brandItem: {
      default: ""
    }
  },
  data() {
    return {
      dialogDetails: false,
      modelItems: {},
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: ""
    };
  },
  methods: {
    getModels() {
      axios
        .get("/addvertisment-service/brand/" + this.brandItem.id + "/model")
        .then(modelItems => {
          this.modelItems = modelItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    axios
      .get("/addvertisment-service/brand/" + this.brandItem.id + "/model")
      .then(modelItems => {
        this.modelItems = modelItems.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

