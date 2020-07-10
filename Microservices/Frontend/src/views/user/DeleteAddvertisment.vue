

<template>
    <div>
         <!-- Snackbar -->
         <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
            <span>{{snackbarSuccessText}}</span>
            <v-btn text @click="snackbarSuccess = false">Close</v-btn>
          </v-snackbar>
          <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
            <span>{{snackbarDangerText}}</span>
            <v-btn text @click="snackbarDanger = false">Close</v-btn>
          </v-snackbar>
          <v-dialog v-model="deleteDialog" max-width="1200px">
            <template #activator="{ on: deleteDialog }">
                <v-tooltip bottom color="black">
                    <template #activator="{ on: tooltip }">
                    <v-btn icon v-on="{ ...tooltip, ...deleteDialog}" 
                    absolute
                    dark
                    fab
                    small
                    top
                    right
                    color="#fbc02d"
                    style="margin-top: 90px;">
                    <v-icon >mdi-delete</v-icon>
                    </v-btn>
                    </template>
                    <span class="primary--text">Delete addvertisment</span>
                </v-tooltip>
            </template>
            <v-card>
                <v-card-title class="primary--text font-italic" primary-title>
                    Are you sure you want to delete this addvertisment?
                     <v-spacer></v-spacer>
                     <v-btn icon color="primary" @click="deleteDialog =  false">
                       <v-icon>cancel</v-icon>
                     </v-btn>
                   </v-card-title>
        
                   <v-card-actions class="pr-10 pb-10">
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="quit">Quit</v-btn>
                    <v-btn color="primary" @click="deleteAdd">Yes, delete</v-btn>
                  </v-card-actions>
            </v-card>
          </v-dialog>
    </div>
</template>
<script>
     import axios from "axios";
     export default {
            props: {
        addvertisment: {
          default: ""
        },
    },
          data() {
            return {
                deleteDialog: false,
                snackbarSuccess: false,
              snackbarSuccessText: "",
              snackbarDanger: false,
              snackbarDangerText: "",
            }
          },
     
     methods: {
        quit(){
                this.deleteDialog= false;
              },
        deleteAdd(){

            axios
            .delete("/addvertisment-service/addvertisment/" + this.addvertisment.id)
            .then(response => {
            console.log(response);
            this.snackbarSuccess=true;
            this.snackbarSuccessText="Addvertisment deleted!";
            this.deleteDialog=false;
            this.$emit("loadAddvertisments");

            })
            .catch(error => {
            console.log(error);
            this.snackbarDanger=true;
            this.snackbarDangerText="Can not delete addvertisment!";
            });

            },
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

    .image-div {
  display: flex;
  margin: 25px;
}
.image {
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp {
  position: relative;
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp span.delete-img {
  position: absolute;
  top: -14px;
  left: -2px;
}
.img-wrapp span.delete-img:hover {
  cursor: pointer;
}
    </style>