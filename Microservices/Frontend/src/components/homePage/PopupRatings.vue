<template>
  <div class="text-center">
    <v-dialog v-model="dialog" max-width="600px">
      <template #activator="{ on: dialog }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog }" @click="viewRating()" color="primary">
              <v-icon>star</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View ratings</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-card-title class="headline grey lighten-2" primary-title>{{average}}</v-card-title>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";

export default {
  props: {
    car: {
      default: ""
    }
  },
  data() {
    return {
      dialog: false,
      grades: "",
      average: "",
    };
  },
  methods: {
      viewRating() {
        console.log(this.car.id);
        axios
          .get("/addvertisment-service/grade/" + this.car.id)
          .then(grades => {
            this.grades = grades.data;
            var total=0;
            for(var i = 0; i<this.grades.length; i++){
              total += this.grades[i].number;
            }
            var avg = total/this.grades.length;
            this.average = avg;
          })
          .catch(error => {
            console.log(error);
          });
      }
  },
};
</script>
