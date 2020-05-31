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
            Change {{item}} "{{brandItem.brand_name}}"
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialogDetails =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text class="text-center-left">
            <v-text-field v-model="brand.brand_name" color="primary" prepend-inner-icon="sync"></v-text-field>
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
      flagDuplicateBrand: false
    };
  },
  methods: {
    changebrand() {
      if (this.brand.brand_name == "") {
        this.$emit("emptyBrand");
      } else {
        console.log(this.brand);
        axios
          .put("/brand", this.brand)
          .then(() => {
            this.$emit("changedBrand");
            this.$emit("getBrands");
            this.brand.brand_name = "";
            this.dialogDetails = false;
          })
          .catch(error => {
            this.$emit("notChangedBrand");
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
        this.changebrand();
      } else {
        this.$emit("duplicateBrand");
        this.flagDuplicateBrand = false;
      }
    }
  }
};
</script>

