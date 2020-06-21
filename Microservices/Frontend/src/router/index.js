import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../views/HomePage.vue";
import Admin from "../views/admin/Admin.vue";
import User from "../views/user/User.vue";
import Agent from "../views/agent/Agent.vue";
import Cart from "../views/user/Cart.vue";
import MyPurchases from "../views/user/MyPurchases.vue";
import Codebook from "../views/admin/Codebook.vue";
import Requests from "../views/admin/Requests.vue";
import Comments from "../views/admin/Comments.vue";
import Statistics from "../views/agent/Statistics.vue";
import AddNewAddvertisment from "../views/user/AddNewAddvertisment.vue";
import MyAddvertisments from "../views/user/MyAddvertisments.vue";
import Chat from "../views/user/Chat.vue";

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
    path: "/requests",
    name: "Requests",
    component: Requests,
  },
  {
    path: "/comments",
    name: "Comments",
    component: Comments,
  },
  {
    path: "/purchases",
    name: "MyPurchases",
    component: MyPurchases,
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
  },
];

const router = new VueRouter({
  //Da li je bolji hash ili history?
  mode: "history",
  routes,
});

export default router;
