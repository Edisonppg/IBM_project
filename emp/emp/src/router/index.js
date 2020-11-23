import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '../components/HelloWorld.vue'
import PersonAdd from '../views/PersonAdd.vue'
import PersonView from '../views/PersonView.vue'
import DepAdd from '../views/DepAdd.vue'
import DepView from '../views/DepView.vue'
import register from '../components/register.vue'
import login from '../components/login.vue'
import password from '../views/password.vue'
import Depcompile from '../views/Depcompile.vue'
import Personcompile from '../views/Personcompile.vue'
import Pview from '../views/Pview.vue'
import Dview from '../views/Dview.vue'
import index from '../components/index.vue'


Vue.use(VueRouter)

const routes = [{
        path: '/',
        redirect: '/login',
    }, {
        path: '/login',
        name: 'login',
        component: login,
    }, {
        path: '/HelloWorld',
        name: 'HelloWorld',
        component: HelloWorld,

        children: [

            {
                path: '/PersonView',
                name: 'PersonView',
                component: PersonView
            },
            {
                path: '/PersonAdd',
                name: 'PersonAdd',
                component: PersonAdd
            },
            {
                path: '/DepView',
                name: 'DepView',
                component: DepView
            },
            {
                path: '/DepAdd',
                name: 'DepAdd',
                component: DepAdd
            },
            {
                path: '/Depcompile',
                name: 'Depcompile',
                component: Depcompile
            },
            {
                path: '/Personcompile',
                name: 'Personcompile',
                component: Personcompile
            },
        ]

    }, {
        path: '/register',
        name: 'register',
        component: register
    },
    {
        path: '/index',
        name: 'index',
        component: index,

        children: [

            {
                path: '/Pview',
                name: 'Pview',
                component: Pview
            }, {
                path: '/Dview',
                name: 'Dview',
                component: Dview
            }, {
                path: '/password',
                name: 'password',
                component: password
            },

        ]

    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router