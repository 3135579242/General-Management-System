<script setup>
import { ref, computed, Transition } from 'vue'
import { useRouter,useRoute } from 'vue-router'
import { useAllDataStore } from '../stores/index.js'
const router = useRouter()
const route = useRoute()
const store = useAllDataStore()
// 菜单列表
const menuList = store.loginData
const menuListSessionStorage = JSON.parse(sessionStorage.getItem('menuList'))
console.log('menuListSessionStorage ', menuListSessionStorage)
// [
//     {
//         path: '/home',
//         name: 'Home',
//         label: '首页',
//         icon: 'location',
//         url: ''
//     },
//     {
//         path: '/user',
//         name: 'User',
//         label: '用户管理',
//         icon: 'location',
//         url: ''
//     },
//     {
//         path: '/mall',
//         name: 'Mall',
//         label: '商品',
//         icon: 'location',
//         url: ''
//     },
//     {
//         path: '/other',
//         label: '其他',
//         icon: 'location',
//         children: [
//             {
//                 path: '/other1',
//                 name: 'Other1',
//                 label: '其他页面1',
//                 icon: 'location',
//                 url: ''
//             },
//             {
//                 path: '/other2',
//                 name: 'Other2',
//                 label: '其他页面2',
//                 icon: 'location',
//                 url: ''
//             }
//         ]
//     }
// ])

// 监听菜单列表
const noChildrenArr = computed(() => {
    return menuListSessionStorage.filter((item) => {
        if(item.childrenItem.length === 0){
            return item
        }
    })
})


const hasChildrenArr = computed(() => {
    return menuListSessionStorage.filter((item) => {
        if(item.childrenItem.length !== 0){
            return item
        }
        // return item.childrenItem
    })
})

// 折叠面板属性
// 设置折叠菜单的状态
const isCollapse = computed(() => {
    return store.isCollapse
})
const width = computed(() => (
    {
        width: !store.isCollapse ? '260px' : '80px',
    }
))
const handleMenu = (item) => {
    // {
    // "path": "/user",
    // "name": "user",
    // "label": "用户管理",
    // "icon": "location",
    // "url": ""
    // }
    router.push(item.path)
    store.selectMenu(item)
}
const active = computed(() => route.path)

</script>


<template>
    <div>

        <el-menu
            :collapse="isCollapse"
            :collapse-transition="false"
            :style="width"
            :default-active="active"
            >
            <h1 v-show="!isCollapse">极品管理系统</h1>
            <h1 v-show="isCollapse">系统</h1>
            <!-- 没有子菜单的一级菜单 -->
            <el-menu-item v-for="item in noChildrenArr" :key="item.path" :index="item.path" @click="handleMenu(item)" >
                <el-icon>
                    <component :is="item.icon"></component>
                </el-icon>
                <span>{{ item.label }}</span>
            </el-menu-item>

            <!-- 可以展开的菜单 -->
            <el-sub-menu v-for="item in hasChildrenArr" :key="item.path" :index="item.path">
                <!-- 展开菜单的一级菜单 -->
                <template #title>
                    <el-icon>
                        <location />
                    </el-icon>
                    <span>{{ item.label }}</span>
                </template>
                <!-- 展开菜单的二级菜单 -->
                <el-menu-item v-for="itemChildren in item.childrenItem" :key="itemChildren.path" :index="itemChildren.path" @click="handleMenu(item)" >
                    <el-icon>
                        <component :is="itemChildren.icon"></component>
                    </el-icon>
                    <span>{{ itemChildren.label }}</span>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>


    </div>
</template>


<style scoped>
.el-menu {
    height: 1060px;
    border-right: none;
    background-color: #E4E4E1;
    h1 {
        background-color: #E4E4E1;
        text-align: center;
        padding: 26px;
    }
}
.el-menu-item {
    background-color: #E4E4E1;
}

</style>