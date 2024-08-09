import { createWebHistory, createRouter } from 'vue-router'

import Main from '../views/Main.vue'
import Home from '../views/Home.vue'
import User from '../views/User.vue'
import Mall from '../views/Mall.vue'
import Login from '../views/Login.vue'


const routes = [
    {
        path: '/',
        name: 'Main',
        redirect: '/home',
        component: Main,
        children: [
            {
                path: 'home',
                name: 'Home',
                component: Home
            },
            {
                path: 'user',
                name: 'User',
                component: User
            },
            {
                path: 'mall',
                name: 'Mall',
                component: Mall
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    }

]

export const router = createRouter({
    history: createWebHistory(),
    routes
})