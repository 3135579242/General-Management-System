import { defineStore } from 'pinia'
import { computed, ref } from 'vue'

export const useAllDataStore = defineStore('AllData', () => {
    const isCollapse = ref(false)
    const currentMenu = ref(null)
    const loginData = ref([])
    const tags = ref([
        {
            path: '/home',
            name: 'Home',
            label: '首页',
            icon: 'home'
        }
    ])

    function selectMenu(currentMenuItem) {
        // 如果你是首页
        if(currentMenuItem.name === 'Home'){
            currentMenu.value = null
        }else {
            //如果你不是首页就添加标签
            const index = tags.value.findIndex((item) => item.name === currentMenuItem.name)
            index === -1 ? tags.value.push(currentMenuItem) : ''
        }
    }

    function updateTags(tag) {
        const index = tags.value.findIndex((item) => item.name === tag.name)
        tags.value.splice(index,1)
    }

    return { isCollapse,tags,selectMenu,updateTags,loginData }

})








































