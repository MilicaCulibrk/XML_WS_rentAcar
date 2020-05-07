<template>
  <div class="text-center">
    <v-dialog v-model="dialog" max-width="600px">
      <template #activator="{ on: dialog }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog }" color="primary">
              <v-icon>zoom_in</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View Details</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-card-title class="headline" primary-title>Car Details</v-card-title>
        <v-card-text>
          <div class="primary--text font-weight-bold headline">ana</div>
        </v-card-text>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {};
</script>

