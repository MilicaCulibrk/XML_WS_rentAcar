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
            <v-text-field v-model="brand.brand_name" color="primary" prepend-inner-icon="add"></v-text-field>
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
    brandItems: {}
  },
  data() {
    return {
      dialogDetails: false,
      brand: {
        brand_name: ""
      },
      flagDuplicateBrand: false
    };
  },
  methods: {
    postBrand() {
      if (this.brand.brand_name == "") {
        this.$emit("emptyBrand");
      } else {
        axios
          .post("/brand", this.brand)
          .then(() => {
            this.$emit("addedBrand");
            this.$emit("getBrands");
            this.brand.brand_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notAddedBrand");
            console.log(error);
          });
      }
    },
    checkIfDuplicate() {
      var i = 0;
      for (i = 0; i < this.brandItems.length; i++) {
        if (this.brandItems[i].brand_name == this.brand.brand_name) {
          this.flagDuplicateBrand = true;
          break;
        }
      }

      if (!this.flagDuplicateBrand) {
        this.postBrand();
      } else {
        this.$emit("duplicateBrand");
        this.flagDuplicateBrand = false;
        this.brand.brand_name = "";
      }
    }
  }
};
</script>

