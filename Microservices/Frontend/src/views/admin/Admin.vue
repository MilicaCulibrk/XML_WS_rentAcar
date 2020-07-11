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
    <v-card max-width="600" class="mx-auto mt-12">
      <!-- toolbar -->
      <v-toolbar color="primary" dark>
        <v-icon large>people</v-icon>

        <v-toolbar-title class="ml-4">Users</v-toolbar-title>
      </v-toolbar>
      <!-- lista -->
      <v-list two-line subheader>
        <v-list-item v-for="user in users" :key="user.id">
          <!-- ako je aktivan -->

          <v-list-item-content class="mt-2" v-if="user.active">
            <v-list-item-title v-text="user.name + user.surname"></v-list-item-title>
            <v-list-item-subtitle v-text="user.email"></v-list-item-subtitle>
          </v-list-item-content>
          <v-list-item-content class="mt-2 danger" v-if="!user.active">
            <v-list-item-title v-text="user.name + user.surname"></v-list-item-title>
            <v-list-item-subtitle v-text="user.email"></v-list-item-subtitle>
          </v-list-item-content>
          <v-tooltip bottom color="black" >
            <template v-slot:activator="{ on }"  >
              <v-btn icon v-on="on" color="primary" @click="changeStatus(user)">
                <v-icon v-if="user.active">block</v-icon>
                <v-icon v-if="!user.active">toggle_on</v-icon>
              </v-btn>
            </template>
            <span v-if="user.active" class="primary--text">Block</span>
            <span v-if="!user.active" class="primary--text">Activate</span>
          </v-tooltip>
          <v-tooltip bottom color="black"  >
            <template v-slot:activator="{ on }" >
              <v-btn icon v-on="on" color="primary" @click="deleteUser(user)">
                <v-icon>delete</v-icon>
              </v-btn>
            </template>
            <span class="primary--text">Delete</span>
          </v-tooltip>
        </v-list-item>
      </v-list>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      users: [
      ],
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
    };
  },
   methods: {
    getUsers(){
      axios
        .get("/user-service/user")
        .then(response => {      
            this.users.length = 0;
            response.data.forEach(element => {
              if(element.active==null){
                element.active=true;
              }
              this.users.push(element);

            });
              
              console.log(response);
              console.log(response.data);

            }) 
        .catch(error => {
            console.log(error)
        })
    },
    changeStatus(user){
      if(user.active==true){
        user.active = false;
      } else {
        user.active = true;
      }
      axios
        .put("/user-service/user", user)
        .then(response=>{
          this.snackbarSuccess = true;
          this.snackbarSuccessText ="User's status is changed!";
          console.log(response);
          this.getUsers();
        })
        .catch(error => {
            this.snackbarDanger = true;
            this.snackbarDangerText ="Error";
            console.log(error)
        })
    },
    deleteUser(user){
      axios
        .delete("/user-service/user/"  + user.id)
        .then(response=>{
          this.snackbarSuccess = true;
          this.snackbarSuccessText ="User succesfully deleted!";
          console.log(response.data);
          this.getUsers();
          this.deleteAdds(user.username);
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText ="Error";
          console.log(error)
        })
    },
    deleteAdds(username){
      axios
        .delete("/addvertisment-service/addvertisment/from/"  + username)
        .then(response=>{
          this.snackbarSuccess = true;
          this.snackbarSuccessText ="User's adds succesfully deleted!";
          console.log(response.data);
          this.getUsers();
        })
        .catch(error => {
          this.snackbarDanger = true;
          this.snackbarDangerText ="Error";
          console.log(error)
        })
    }
  },
  mounted(){
    this.getUsers();
  }
};
</script>