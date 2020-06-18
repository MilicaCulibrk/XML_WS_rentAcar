import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../views/HomePage.vue";
import Cart from "../views/user/Cart.vue";
import Codebook from "../views/admin/Codebook.vue";
import Requests from "../views/agent/Requests.vue";
import AddNewAddvertisment from "../views/agent/AddNewAddvertisment.vue";
import MyAddvertisments from "../views/agent/MyAddvertisments.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },
  {
    path: "/cart",
    name: "Cart",
    component: Cart,
  },
  {
    path: "/codebook",
    name: "Codebook",
    component: Codebook,
  },
  {
    path: "/requests",
    name: "Requests",
    component: Requests,
  },
  {
    path: "/addNewAddvertisment",
    name: "AddNewAddvertisment",
    component: AddNewAddvertisment,
  },
  {
    path: "/myAddvertisments",
    name: "MyAddvertisments",
    component: MyAddvertisments,
  },
];

const router = new VueRouter({
  //Da li je bolji hash ili history?
  mode: "history",
  routes,
});

export default router;
