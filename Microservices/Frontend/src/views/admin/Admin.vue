<template>
  <div>
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
          <v-tooltip bottom color="black">
            <template v-slot:activator="{ on }" v-if="user.active">
              <v-btn icon v-on="on" color="primary">
                <v-icon>block</v-icon>
              </v-btn>
            </template>
            <span class="primary--text">Block</span>
          </v-tooltip>
          <v-tooltip bottom color="black">
            <template v-slot:activator="{ on }" v-if="user.active">
              <v-btn icon v-on="on" color="primary">
                <v-icon>delete</v-icon>
              </v-btn>
            </template>
            <span class="primary--text">Delete</span>
          </v-tooltip>
          <!-- ako je blokiran -->
          <v-list-item-content class="mt-2 danger" v-if="!user.active">
            <v-list-item-title v-text="user.name + user.surname"></v-list-item-title>
            <v-list-item-subtitle v-text="user.email"></v-list-item-subtitle>
          </v-list-item-content>
          <v-tooltip bottom color="black" v-if="!user.active">
            <template v-slot:activator="{ on }">
              <v-btn icon v-on="on" color="primary">
                <v-icon>toggle_on</v-icon>
              </v-btn>
            </template>
            <span class="primary--text">Activate</span>
          </v-tooltip>
          <v-tooltip bottom color="black">
            <template v-slot:activator="{ on }" v-if="!user.active">
              <v-btn icon v-on="on" color="primary">
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
      ]
    };
  },
   methods: {
    getUsers(){
      axios
        .get("/user-service/user/nes")
        .then(response => {      
              this.users = response.data;
              console.log(response);
                            console.log(response.data);

            }) 
        .catch(error => {
            console.log(error)
        })
    }
  },
  mounted(){
    this.getUsers();
  }
};
</script>