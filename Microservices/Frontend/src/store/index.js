import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    user:{
      role: "NONE"
    },
    loggedUser: false,
    cars: [
      {
        id: "1",
        brand: "Mercedes",
        model: "G500",
        price: "100.000",
        agent: "1",
      },
      {
        id: "2",
        brand: "Suzuki",
        model: "Vitara",
        price: "30.000",
        agent: "1",
      },
      {
        id: "3",
        brand: "BMW",
        model: "X6",
        price: "60.000",
        agent: "1",
      },
      {
        id: "4",
        brand: "BMW",
        model: "X4",
        price: "70.000",
        agent: "2",
      },
      {
        id: "5",
        brand: "BMW",
        model: "X4",
        price: "70.000",
        agent: "2",
      },
      {
        id: "6",
        brand: "VW",
        model: "Polo Mk4",
        price: "20.000",
        agent: "2",
      },
      {
        id: "7",
        brand: "Mercedes",
        model: "Maybach",
        price: "150.000",
        agent: "1",
      },
      {
        id: "8",
        brand: "Audi",
        model: "A5 Coupe",
        price: "50.000",
        agent: "1",
      },
    ],
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
