

<script setup>
import { getUserLogin } from '../api/home'
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useAllDataStore } from '../stores/index'
const router = useRouter()
const store = useAllDataStore()

const formData = ref({})
const handleLogin = async () => {
    const response = await getUserLogin(formData.value)
    if(response.length !== 0){
        store.loginData = response.menuList
        sessionStorage.setItem('menuList',JSON.stringify(response.menuList))
        router.push('/home')
    }
}

</script>

<template>
  <div class="form_layoute">
    <el-form :model="formData">
        <el-form-item label="账号">
            <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="formData.password" />
        </el-form-item>
        <el-button @click="handleLogin">登录</el-button>
    </el-form>
  </div>
</template>

<style scoped>
.form_layoute {
    display: flex;
    align-items: center;
    padding: 20px;
    margin: 300px auto;
    height: 500px;
    width: 500px;
    border-radius: 50px;
    background-image: linear-gradient(to top, #50cc7f 0%, #f5d100 100%);
    .el-input {
        width: 480px;
    }
    .el-button {
        margin-left: 120px;
        width: 280px;
    }
}

</style>
