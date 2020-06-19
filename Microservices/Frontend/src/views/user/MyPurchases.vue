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
            v-for="request in requests"
            :key="request.id"
            class="detailsBorderColor"
          >
            <v-expansion-panel-header>Request {{request.id}} - {{request.status}}</v-expansion-panel-header>
            <v-expansion-panel-content>
                <v-panel
                  v-for="purchase in request.purchaseDTOS"
                  :key="purchase.id"
                >
                  <v-panel-header>
                    <v-row >
                      <v-col
                        cols="3"
                        class="primary--text"
                      >Car {{purchase.id_add}} - {{purchase.brand_model}}</v-col>
                      <v-col cols="9" class="text--secondary">
                        <v-fade-transition leave-absolute>
                          <v-row no-gutters style="width: 100%">
                            <v-col cols="2">Owner: {{purchase.owner}}</v-col>
                            <v-col cols="3">Start date: {{purchase.date_from}}</v-col>
                            <v-col cols="5">End date: {{purchase.date_to}}</v-col>
                            <v-col cols="1" v-if="purchase.pass==true">
                                <v-dialog v-model="dialogRating" max-width="600px">
                                <template #activator="{ on: dialogRating }">
                                    <v-tooltip bottom color="black">
                                    <template #activator="{ on: tooltip }">
                                        <v-btn icon v-on="{ ...tooltip, ...dialogRating }" color="primary">
                                        <v-icon>star</v-icon>
                                        </v-btn>
                                    </template>
                                    <span class="primary--text">Rate</span>
                                    </v-tooltip>
                                </template>
                                    <v-card
                                    >
                                        <v-card-title
                                        class="headline"
                                        primary-title
                                        >
                                        Rate 
                                        </v-card-title>
                                        <v-card-text>
                                        Please take a few seconds to rate your experience with this addvertisment.

                                        <div class="text-center mt-12">
                                            <v-rating
                                            v-model="rating"
                                            color="yellow darken-3"
                                            background-color="grey darken-1"
                                            empty-icon="$ratingFull"
                                            hover
                                            ></v-rating>
                                        </div>
                                        </v-card-text>
                                        <v-divider></v-divider>
                                        <v-card-actions class="justify-space-between">
                                        <v-btn text @click="dialogRating =  false">No Thanks</v-btn>
                                        <v-btn
                                            color="primary"
                                            text
                                            @click="rate(purchase.id_add)"
                                        >
                                            Rate Now
                                        </v-btn>
                                        </v-card-actions>
                                    </v-card>
                                </v-dialog>

                            </v-col>
                            <v-col cols="1" v-if="purchase.pass==true">
                                <v-dialog v-model="dialogComment" max-width="600px">
                                <template #activator="{ on: dialogComment }">
                                    <v-tooltip bottom color="black">
                                    <template #activator="{ on: tooltip }">
                                        <v-btn icon v-on="{ ...tooltip, ...dialogComment }" color="primary">
                                        <v-icon>mode_comment</v-icon>
                                        </v-btn>
                                    </template>
                                    <span class="primary--text">Comment</span>
                                    </v-tooltip>
                                </template>
                                    <v-card
                                    >
                                        <v-card-title
                                        class="headline"
                                        primary-title
                                        >
                                        Comment 
                                        </v-card-title>
                                        <v-card-text>
                                        Please take a few seconds to leave your comment for this addvertisment.
                                        <v-text-field
                                            v-model="comment.title"
                                            placeholder="Title"
                                        ></v-text-field> 
                                        <v-textarea
                                            v-model="comment.text"
                                            solo
                                            placeholder="Text"
                                            name="input-7-4"
                                        ></v-textarea>  
                                        </v-card-text>
                                        <v-divider></v-divider>
                                        <v-card-actions class="justify-space-between">
                                        <v-btn text @click="dialogComment =  false">No Thanks</v-btn>
                                        <v-btn
                                            color="primary"
                                            text
                                            @click="commentAdd(purchase.id_add)"
                                        >
                                            Leave comment
                                        </v-btn>
                                        </v-card-actions>
                                    </v-card>
                                </v-dialog>
                            </v-col>
                        </v-row>
                        </v-fade-transition>
                      </v-col>
                    </v-row>
                  </v-panel-header>
                </v-panel>
 
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
      requests: [],
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      rating: "",
      dialogComment: false,
      dialogRating: false,
      comment: {
          user_id: "",
          user_username: "",
          text: "",
          title: "",
          add_id: "",
          accepted: "",
      },
    };
  },
  methods: {
    rate(id) {
      axios
        .put("/add-service/request/" + id)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Addvertisment is rated!";
          console.log(response);
          this.getRequests();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error in rating";
          console.log(error);
        });
    },
    commentAdd(id) {
        console.log(id);
        this.comment.add_id = id;
        this.comment.user_id = this.$store.state.user.id;
        this.comment.user_username = this.$store.state.user.username;
      axios
        .post("/addvertisment-service/comment", this.comment)
        .then(response => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Comment is added!";
          this.comment.title = "";
          this.comment.text = "";
          console.log(response);
          this.dialogComment = false;
          this.getRequests();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    getRequests() {
      axios
        .get("/rent-service/request/from/" + this.$store.state.user.username)
        .then(requests => {
            this.requests = requests.data;
            console.log(this.requests);
            this.requests.forEach(r => {
                r.purchaseDTOS.forEach(purchase => {
                    var endDate = new Date(purchase.date_to);
                    var today = new Date();
                    if(today>endDate){
                        purchase.pass = true;
                    }
                });

          });
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.getRequests();
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
