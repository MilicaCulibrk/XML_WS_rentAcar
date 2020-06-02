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
            Change {{item}} "{{transmissionTypeItem.transmission_type_name}}"
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field
              v-model="tranmissionType.transmission_type_name"
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
    transmissionTypeItem: {
      default: ""
    },
    transmissionTypeItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      tranmissionType: {
        id: this.transmissionTypeItem.id,
        transmission_type_name: ""
      },
      flagDuplicateTranmissionType: false
    };
  },
  methods: {
    changeTranmissionType() {
      if (this.tranmissionType.transmission_type_name == "") {
        this.$emit("emptyTransmissionType");
        this.tranmissionType.transmission_type_name = "";
        this.dialogDetails = false;
      } else {
        axios
          .put("/addvertisment-service/transmission_type", this.tranmissionType)
          .then(() => {
            this.$emit("changedTranmissionType");
            this.$emit("getTransmissionTypes");
            this.tranmissionType.transmission_type_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notChangedTransmissionType");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.transmissionTypeItems.length; i++) {
        if (
          this.transmissionTypeItems[i].transmission_type_name ==
          this.tranmissionType.transmission_type_name
        ) {
          this.flagDuplicateTranmissionType = true;
          break;
        }
      }

      if (!this.flagDuplicateTranmissionType) {
        this.changeTranmissionType();
      } else {
        this.$emit("duplicateTransmissionType");
        this.flagDuplicateTranmissionType = false;
        this.tranmissionType.transmission_type_name = "";
        this.dialogDetails = false;
      }
    }
  }
};
</script>

