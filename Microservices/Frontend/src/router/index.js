import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../views/HomePage.vue";
import Admin from "../views/admin/Admin.vue";
import User from "../views/user/User.vue";
import Agent from "../views/agent/Agent.vue";
import Cart from "../views/user/Cart.vue";
import Codebook from "../views/admin/Codebook.vue";
import AddNewAddvertisment from "../views/user/AddNewAddvertisment.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin,
  },
  {
    path: "/user",
    name: "User",
    component: User,
  },
  {
    path: "/agent",
    name: "Agent",
    component: Agent,
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
    path: "/addNewAddvertisment",
    name: "AddNewAddvertisment",
    component: AddNewAddvertisment,
  }
];

const router = new VueRouter({
  //Da li je bolji hash ili history?
  mode: "hash",
  routes,
});

export default router;
