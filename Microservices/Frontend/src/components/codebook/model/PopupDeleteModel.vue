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
            Are you sure you want to delete {{item}} "{{modelItem.vehicle_model_name}}" ?
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
    deleteModel() {
      axios
        .delete("/brand/" + this.brandItem.id + "/model/" + this.model.id)
        .then(() => {
          this.$emit("deletedModel");
          this.$emit("getModels");
          this.model.vehicle_model_name = "";
        })
        .catch(error => {
          this.$emit("notDeletedModel");
          console.log(error);
        });
    },
    checkIfHasAdds() {
      console.log(this.flagHasAdds);
      var i = 0;
      for (i = 0; i < this.addvertisments.length; i++) {
        if (this.addvertisments[i].vehicle_model_id == this.model.id) {
          this.flagHasAdds = true;
          break;
        }
      }

      if (!this.flagHasAdds) {
        this.deleteModel();
      } else {
        console.log(this.flagHasAdds);
        this.$emit("hasAddsModel");
        this.flagHasAdds = false;
        this.dialogDetails = false;
        this.model.vehicle_model_name = "";
      }
    }
  },
  mounted() {
    //izlistavanje advertismenta
    axios
      .get("/addvertisment")
      .then(addvertisments => {
        this.addvertisments = addvertisments.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

