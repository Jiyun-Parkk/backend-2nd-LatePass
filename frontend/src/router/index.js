// Composables
import { createRouter, createWebHistory } from "vue-router";
import Login from "@/views/Login.vue";
import MyPage from "@/views/MyPage.vue";
import Admin from "@/views/Admin.vue";
import QuizList from "@/views/QuizList.vue";
import Quiz from "@/views/Quiz.vue";
// import CreateAndEditQuiz from "@/views/createAndEditQuiz.vue";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "Home",
        component: () =>
          import(/* webpackChunkName: "home" */ "@/views/Home.vue"),
      },
      {
        path: "/login",
        name: "Login",
        component: Login,
      },
      {
        path: "/mypage",
        name: "mypage",
        component: MyPage,
      },
      {
        path: "/admin",
        name: "admin",
        component: Admin,
      },
      {
        path: "/quizList",
        name: "quizList",
        component: QuizList,
      },
      {
        path: "/quiz",
        name: "quiz",
        component: Quiz,
      },
      // {
      //   path: "/createAndEditQuiz",
      //   name: "createAndEditQuiz",
      //   component: CreateAndEditQuiz,
      // },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
