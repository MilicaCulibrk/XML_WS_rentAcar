<template>
  <div class="text-center">
    <v-dialog v-model="dialog1" max-width="600px">
      <template #activator="{ on: dialog1 }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn
              icon
              v-on="{ ...tooltip, ...dialog1 }"
              color="primary"
              @click="getComments()"
            >
              <v-icon>mode_comment</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View comments</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-list two-line>
          <v-subheader class="primary--text font-weight-bold headline"
            >Comments
            <v-spacer></v-spacer>
            <v-btn icon color="primary" @click="dialog1 =  false">
              <v-icon>cancel</v-icon>
            </v-btn>
            </v-subheader
          >
          <template v-for="item in comments">
            <v-divider :key="item.header"></v-divider>
            <v-list-item :key="item.title">
              <v-list-item-content>
                <v-list-item-title> {{ item.title }} </v-list-item-title>
                <v-list-item-subtitle> {{ item.text }} </v-list-item-subtitle>
                <v-list-item-subtitle style="text-align:right;"
                  ><span class="font-weight-bold"
                    >by {{ item.user_username }}</span
                  ></v-list-item-subtitle
                >
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
      default: "",
    },
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
        .get("/comment/" + this.car.id + "/comments")
        .then((comments) => {
          this.comments = comments.data;
          console.log(this.comments);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {},
};
</script>
<style scoped>
  .cardBorderColor {
    border-left: 1px solid #ff8a65;
    border-top: 1px solid #ff8a65;
    border-right: 1px solid #ff8a65;
    border-bottom: 1px solid #ff8a65;
  }
  .detailsBorderColor {
    border-left: 1.5px solid #ff8a65;
    border-top: 1.5px solid #ff8a65;
    border-right: 1.5px solid #ff8a65;
    border-bottom: 1.5px solid #ff8a65;
  }
  </style>
