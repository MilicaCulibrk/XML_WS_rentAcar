import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export const store = new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    user: {
      role: "NONE",
      active: true,
    },
    loggedUser: false,
    carsInCart: [],
    subtotal: 0,
  },
  mutations: {
    addCarInCart(state, carInCart) {
      // mutate state
      state.carsInCart.push(carInCart);
    },
    deleteCar(state, carInCart) {
      var index = state.carsInCart.findIndex((c) => c.id == carInCart.id);
      state.carsInCart.splice(index, 1);
    },
    deleteAll(state) {
      state.carsInCart = [];
    },
    subtotal(state) {
      state.subtotal = 0;
      state.carsInCart.forEach((car) => {
        state.subtotal = parseInt(state.subtotal) + parseInt(car.price);
      });
    },
    login(state, item) {
      state.user = item;
    },
    logout(state) {
      /* this.$store.state.user = {};
      this.$store.state.user.role = "NONE";
      this.$store.state.user.active = true;
      this.$store.state.loggedUser = false;*/

      state.user = {};
      state.user.role = "NONE";
      (state.user.active = true), (state.loggedUser = false);
    },
  },
  actions: {},
  modules: {},
});
