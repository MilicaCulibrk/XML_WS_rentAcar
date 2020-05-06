// src/plugins/vuetify.js

import Vue from "vue";
import Vuetify from "vuetify/lib";

Vue.use(Vuetify);

//theme colors
const vuetify = new Vuetify({
  theme: {
    themes: {
      light: {
        primary: "#FF8A65", //svetlo narandzasta
        secondary: "#F5F5F5", //svetlo siva
      },
    },
  },
});

export default vuetify;
