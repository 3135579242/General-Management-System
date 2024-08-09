
<script setup lang="ts">
import { computed, reactive } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { useAllDataStore } from '@/stores/index.js'
const router =  useRouter()
const route =  useRoute()
const store = useAllDataStore()
const tags = computed(() => store.tags)
const handleMenu = (tag) => {
    router.push(tag.path)
    store.selectMenu(tag)
}
const handleTagClose = (tag,index) => {

    store.updateTags(tag)
    if(tag.name !== route.name) return

    console.log(store.tags.length)
    console.log(index)
    if(index === store.tags.length) {
        store.selectMenu(tags.value[index - 1])
        router.push(tags.value[index - 1].name)
    } else {
        store.selectMenu(tags.value[index])
        router.push(tags.value[index].name)
    }

}
</script>

<template>
    <div>
        <el-tag 
        v-for="(tag,index) in tags" 
        :key="tag.name" 
        type="primary"
        size="large"
        :closable="tag.name !== 'Home'"
        :effect="route.name === tag.name ? 'dark' : 'plain'"
        @click="handleMenu(tag)"
        @close="handleTagClose(tag, index)"
        >
            {{ tag.label }}
        </el-tag>
    </div>
</template>


<style scoped>
.el-tag  {
    margin-top: 20px;
    margin-left: 20px;
}
</style>


















