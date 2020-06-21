<template>
  <div>
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>
    <v-container class="pt-12 mt-12">
      <v-row align="center">
        <v-expansion-panels :popout="true" :multiple="true" :focusable="true">
          <v-expansion-panel
            v-for="comment in comments"
            :key="comment.id"
            class="detailsBorderColor"
          >
            <v-expansion-panel-header>#{{comment.id}}. Title: {{comment.title}}
                <template v-slot:actions >
                    <v-icon color="teal" v-if="comment.accepted==true">mdi-check</v-icon>
                    <v-icon color="error" v-if="comment.accepted==false">mdi-alert-circle</v-icon>
                    <v-icon v-if="comment.accepted==null">mdi-dots-horizontal</v-icon>
                </template>

            </v-expansion-panel-header>
            <v-expansion-panel-content>
                    <v-row no-gutters>
                      <v-col cols="10">Text: {{comment.text}}</v-col>
                      <v-col cols="10">Client: {{comment.user_username}}</v-col>
                   <v-col cols="1" v-if="comment.accepted==null">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn icon v-on="on" color="green" @click="acceptRequest(comment)">
                            <v-icon>mdi-check</v-icon>
                          </v-btn>
                        </template>
                        <span class="green--text">Accept</span>
                      </v-tooltip>
                    </v-col>
                    <v-col cols="1" v-if="comment.accepted==null">
                      <v-tooltip bottom color="white">
                        <template v-slot:activator="{ on }">
                          <v-btn icon v-on="on" color="red" @click="declineRequest(comment)">
                            <v-icon>mdi-close</v-icon>
                          </v-btn>
                        </template>
                        <span class="red--text">Decline</span>
                      </v-tooltip>
                    </v-col>
                    </v-row>
                    <v-row>
                    <v-col cols="10"></v-col>
 
                  </v-row>
            </v-expansion-panel-content>
        </v-expansion-panel>
        </v-expansion-panels>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";

export default {

  data() {
    return {
      comments: [],
      comment: {
          user_id: "",
          text: "",
          add_id: "",
          accepted: "",
      },
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: ""
    };
  },
  methods: {
    acceptRequest(comment) {
        comment.accepted = "true";
        console.log(comment.accepted);
      axios
        .put("/addvertisment-service/comment", comment)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Comment is accepted!";
          console.log(response);
          this.getComments();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    declineRequest(comment) {
        comment.accepted = "false";
      axios
        .put("/addvertisment-service/comment", comment)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Comment is declined!";
          console.log(response);
          this.getComments();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    getComments() {
      axios
        .get("/addvertisment-service/comment")
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
    this.getComments();
  }
};
</script>

<style>
.cardBorderColor {
  border-left: 1px solid #fbc02d;
  border-top: 1px solid #fbc02d;
  border-right: 1px solid #fbc02d;
  border-bottom: 1px solid #fbc02d;
}

.detailsBorderColor {
  border-left: 1.5px solid #fbc02d;
  border-top: 1.5px solid #fbc02d;
  border-right: 1.5px solid #fbc02d;
  border-bottom: 1.5px solid #fbc02d;
}
</style>
