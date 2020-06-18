<template>
  <div class="text-center">
    <v-dialog v-model="dialog1" max-width="600px">
      <template #activator="{ on: dialog1 }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog1 }" color="primary" @click="getComments()">
              <v-icon>mode_comment</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View comments</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-list two-line>
          <template v-for="(item, index) in comments">
            <v-subheader v-if="item.header" :key="item.header">Comments</v-subheader>
            <v-divider :key="index" :inset="item.inset"></v-divider>
            <v-list-item :key="item.title" >
              <v-list-item-content>
                <v-list-item-title>{{item.title}} - {{item.user_username}}</v-list-item-title>
                <v-list-item-subtitle v-html="item.text"></v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </template>
        </v-list>
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
      dialog1: false,
      comments: "",

    };
  },
    methods: {
      getComments() {
        console.log(this.car.id);
        axios
          .get("/addvertisment-service/comment/" + this.car.id + "/comments")
          .then(comments => {
            this.comments = comments.data;
            console.log(this.comments);
          })
          .catch(error => {
            console.log(error);
          });
      }
  },
  mounted() {
  }
};
</script>
