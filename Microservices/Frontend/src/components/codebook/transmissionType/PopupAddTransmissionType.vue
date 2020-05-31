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
              v-model="transmissionType.transmission_type_name"
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
    transmissionTypeItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      transmissionType: {
        transmission_type_name: ""
      },
      flagDuplicateTransmissionTypes: false
    };
  },
  methods: {
    postTransmissionType() {
      if (this.transmissionType.transmission_type_name == "") {
        this.$emit("emptyTransmissionType");
      } else {
        axios
          .post("/transmission_type", this.transmissionType)
          .then(() => {
            this.$emit("addedTransmissionType");
            this.$emit("getTransmissionTypes");
            this.transmissionType.transmission_type_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notAddedTransmissionType");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.transmissionTypeItems.length; i++) {
        if (
          this.transmissionTypeItems[i].transmission_type_name ==
          this.transmissionType.transmission_type_name
        ) {
          this.s = true;
          break;
        }
      }
      if (!this.s) {
        this.postTransmissionType();
      } else {
        this.$emit("duplicateTransmissionType");
        this.s = false;
        this.transmissionType.transmission_type_name = "";
      }
    }
  }
};
</script>

