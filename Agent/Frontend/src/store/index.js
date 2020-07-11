import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store({
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
  },
  actions: {},
  modules: {},
});
