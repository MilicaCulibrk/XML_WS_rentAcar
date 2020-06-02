<template>
  <div>
    <v-dialog v-model="dialogDetails" max-width="700px">
      <template #activator="{ on: dialogDetails }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn
              icon
              v-on="{ ...tooltip, ...dialogDetails }"
              @click="getModels()"
              color="primary"
            >
              <v-icon>delete</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">Delete</span>
        </v-tooltip>
      </template>
      <v-card>
        <div class="detailsBorderColor">
          <v-card-title class="primary--text font-italic" primary-title>
            Are you sure you want to delete {{item}} "{{brandItem.brand_name}}" ?
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
    brandItem: {
      default: ""
    },
    brandItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      brand: {
        id: this.brandItem.id,
        brand_name: ""
      },
      addvertisments: {},
      models: {},
      flagHasAdds: false,
      flagHasModels: false
    };
  },
  methods: {
    deleteBrand() {
      if (this.models.length == 0) {
        axios
          .delete("/addvertisment-service/brand/" + this.brand.id)
          .then(() => {
            this.$emit("deletedBrand");
            this.$emit("getBrands");
            this.brand.brand_name = "";
          })
          .catch(error => {
            this.$emit("notDeletedBrand");
            console.log(error);
          });
      } else {
        this.$emit("hasModelsBrand");
        this.dialogDetails = false;
      }
    },
    checkIfHasAdds() {
      var i = 0;
      for (i = 0; i < this.addvertisments.length; i++) {
        if (this.addvertisments[i].brand_id == this.brand.id) {
          this.flagHasAdds = true;
          break;
        }
      }

      if (!this.flagHasAdds) {
        this.deleteBrand();
      } else {
        this.$emit("hasAddsBrand");
        this.flagHasAdds = false;
        this.dialogDetails = false;
      }
    },
    getModels() {
      axios
        .get("/addvertisment-service/brand/" + this.brand.id + "/model")
        .then(models => {
          this.models = models.data;
        })
        .catch(error => {
          console.log(error);
        });
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

