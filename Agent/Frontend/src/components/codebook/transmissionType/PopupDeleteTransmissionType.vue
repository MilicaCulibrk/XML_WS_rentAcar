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
            Are you sure you want to delete {{item}} "{{transmissionTypeItem.transmission_type_name}}" ?
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
    transmissionTypeItem: {
      default: ""
    },
    transmissionTypeItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      transmissionType: {
        id: this.transmissionTypeItem.id,
        transmission_type_name: ""
      },
      addvertisments: {},
      flagHasAdds: false
    };
  },
  methods: {
    deleteTransmissionType() {
      axios
        .delete(
          "/addvertisment-service/transmission_type/" + this.transmissionType.id
        )
        .then(() => {
          this.transmissionType.transmission_type_name = "";
          this.$emit("deletedTransmissionType");
          this.$emit("getTransmissionTypes");
          this.transmissionType.transmission_type_name = "";
          this.dialogDetails = false;
        })
        .catch(error => {
          this.$emit("notDeletedTransmissionType");
          console.log(error);
        });
    },
    checkIfHasAdds() {
      var i = 0;
      for (i = 0; i < this.addvertisments.length; i++) {
        if (
          this.addvertisments[i].transmission_type_id ==
          this.transmissionType.id
        ) {
          this.flagHasAdds = true;
          break;
        }
      }

      if (!this.flagHasAdds) {
        this.deleteTransmissionType();
      } else {
        this.$emit("hasAddsTransmissionType");
        this.flagHasAdds = false;
        this.dialogDetails = false;
        this.transmissionType.transmission_type_name = "";
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

