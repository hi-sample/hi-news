import { createRouter, createWebHistory } from 'vue-router'
import NewsList from '@/views/NewsList.vue'
import NewsView from "@/views/NewsView.vue";
import NewsEdit from "@/views/NewsEdit.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: NewsList
    },
    {
      path: '/view/:id',
      name: 'view',
      component: NewsView,
      props: true
    },
    {
      path: '/add',
      name: 'add',
      component: NewsEdit
    },
    {
      path: '/edit/:id',
      name: 'edit',
      component: NewsEdit,
      props: true
    }
  ]
})

export default router
