import { createRouter, createWebHistory } from "vue-router";

import Login from "../components/pages/Login.vue";
import AddTicket from "../components/pages/AddTicket.vue";
import LeadershipAssign from "../components/pages/LeadershipAssign.vue";

const routes = [
    {
        path: '/',
        redirect: '/login',
    },
    {
        path: '/login',
        component: Login,
    },
    {
        path: '/add-ticket/:id',
        name: 'add-ticket',
        component: AddTicket,
    },
    {
        path: '/assign-ticket/:id',
        name: 'assign-ticket',
        component: LeadershipAssign,
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router