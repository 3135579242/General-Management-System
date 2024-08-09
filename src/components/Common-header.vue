<script setup>
import { ref, computed } from 'vue'


// 菜单列表
const menuList = ref([
    {
        path: '/home',
        name: 'home',
        label: '首页',
        icon: 'location',
        url: ''
    },
    {
        path: '/nohome',
        name: 'nohome',
        label: '不是主页',
        icon: 'location',
        url: ''
    },
    {
        path: '/other',
        label: '其他',
        icon: 'location',
        children: [
            {
                path: '/other1',
                name: 'other1',
                label: '其他页面1',
                icon: 'location',
                url: ''
            },
            {
                path: '/other2',
                name: 'other2',
                label: '其他页面2',
                icon: 'location',
                url: ''
            }
        ]
    }
])

// 监听菜单列表
const noChildrenArr = computed(() => {
    return menuList.value.filter((item) => {
        return !item.children
    })
})
const hasChildrenArr = computed(() => {
    return menuList.value.filter((item) => {
        return item.children
    })
})
// 设置折叠菜单的状态
import { useAllDataStore } from '../stores/index.js'
const store = useAllDataStore()

const handleIsCallapse = () => {
    store.isCollapse = !store.isCollapse
}

</script>


<template>
    <div>
        <!-- 顶部布局 -->
        <div class="header-layout" >
            <!-- 左边 -->
            <div class="left-header">
                <!-- 折叠菜单按钮 -->
                <el-button type="primary" @click="handleIsCallapse">
                    <el-icon>
                        <component is="location" ></component>
                    </el-icon>
                </el-button>
                <div>
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
                        <el-breadcrumb-item>s
                            <a href="/">promotion management</a>
                        </el-breadcrumb-item>
                        <el-breadcrumb-item>promotion list</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
            </div>
            <!-- 右边 -->
            <div class="right-header">
                <el-dropdown>
                    <span>
                        <img src="@/assets/vue.svg" alt="">
                    </span>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item>Action 1</el-dropdown-item>
                            <el-dropdown-item>Action 2</el-dropdown-item>
                            <el-dropdown-item>Action 3</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>

            </div>
        </div>
    </div>
</template>


<style scoped>

/* 头整体 */
.header-layout {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #E4E4E1;
    background-image: radial-gradient(at top center, rgba(255,255,255,0.03) 0%, rgba(0,0,0,0.03) 100%), linear-gradient(to top, rgba(255,255,255,0.1) 0%, rgba(143,152,157,0.60) 100%);
 	background-blend-mode: normal, multiply;
}
/* 头左部 */
.left-header {
    display: flex;
    align-items: center;
}
/* 按钮 */
.el-button {
    margin: 20px;
}

img {
    margin: 20px;
    width: 40px;
    height: 40px;
    border-radius: 20px;
    cursor: pointer;
}

</style>