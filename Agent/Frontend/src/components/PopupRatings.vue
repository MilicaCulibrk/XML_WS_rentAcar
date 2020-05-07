<template>
  <div class="text-center">
    <v-dialog v-model="dialog" max-width="600px">
      <template #activator="{ on: dialog }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog }" color="primary">
              <v-icon>star</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View ratings</span>
        </v-tooltip>
      </template>
      <v-card>
        <v-card-title class="headline grey lighten-2" primary-title>jaa</v-card-title>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialog: false
    };
  }
};
</script>
