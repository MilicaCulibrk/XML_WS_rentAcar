<template>
  <nav>
    <!-- gornji toolbar -->
    <v-toolbar flat class="mx-12">
      <v-toolbar-title>
        <v-icon left large color="primary">directions_car</v-icon>
        <span color="orange-text">Rent-A-Car</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text color="primary">
        <span>Login</span>
        <v-icon right>lock_open</v-icon>
      </v-btn>
      <v-btn text color="primary">
        <span>Register</span>
        <v-icon right>person_pin</v-icon>
      </v-btn>
    </v-toolbar>
  </nav>
</template>

<script>
export default {};
</script>
