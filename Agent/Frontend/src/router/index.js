import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../views/HomePage.vue";
import Cart from "../views/user/Cart.vue";
import Codebook from "../views/admin/Codebook.vue";
import Requests from "../views/agent/Requests.vue";
import Statistics from "../views/agent/Statistics.vue";
import AddNewAddvertisment from "../views/agent/AddNewAddvertisment.vue";
import MyAddvertisments from "../views/agent/MyAddvertisments.vue";
import Chat from "../views/user/Chat.vue";

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
    path: "/statistics",
    name: "Statistics",
    component: Statistics,
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
  {
    path: "/chat",
    name: "Chat",
    component: Chat,
  }
];

const router = new VueRouter({
  //Da li je bolji hash ili history?
  mode: "history",
  routes,
});

export default router;
