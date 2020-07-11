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
        <v-card-title
        class="headline"
        primary-title
        >
        Grade - {{ text }} 
        <v-spacer></v-spacer>
        <v-btn icon color="primary" @click="dialog =  false">
          <v-icon>cancel</v-icon>
        </v-btn>
        </v-card-title>
        <v-card-text>

        <div class="text-center mt-12">
            <v-rating
            v-model="average"
            color="yellow darken-3"
            background-color="grey darken-1"
            empty-icon="$ratingFull"
            half-increments
            hover
            readonly
            ></v-rating>
        </div>
        </v-card-text>
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
      grades: 0,
      average: 0,
      text: "",
    };
  },
  methods: {
      viewRating() {
        console.log(this.car.id);
        axios
          .get("/grade/" + this.car.id)
          .then(grades => {
            this.grades = grades.data;
            var total=0;
            for(var i = 0; i<this.grades.length; i++){
              total += this.grades[i].number;
            }
            var avg = total/this.grades.length;
            this.average = avg;
            if(this.grades.length==0){
              this.text="still not rated";
              this.average = avg;
            }else{
              this.text=avg;
              this.average = avg;
            }
          })
          .catch(error => {
            console.log(error);
          });
      }
  },
};
</script>
