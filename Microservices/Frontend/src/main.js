import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import {store} from "./store/index";
import axios from "axios";
import vuetify from "./plugins/vuetify";
import "material-design-icons-iconfont/dist/material-design-icons.css";


axios.defaults.baseURL = "http://localhost:8662";

Vue.config.productionTip = false;


new Vue({
  router,
  store: store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
