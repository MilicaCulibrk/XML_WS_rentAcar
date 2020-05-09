<template>
  <div class="text-center">
    <v-dialog v-model="dialog1" max-width="600px">
      <template #activator="{ on: dialog1 }">
        <v-tooltip bottom color="black">
          <template #activator="{ on: tooltip }">
            <v-btn icon v-on="{ ...tooltip, ...dialog1 }" color="primary">
              <v-icon>mode_comment</v-icon>
            </v-btn>
          </template>
          <span class="primary--text">View comments</span>
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
      dialog1: false
    };
  }
};
</script>
