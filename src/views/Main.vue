

<script setup>
import CommonAside from '@/components/Common-aside.vue'
import CommonHeader from '@/components/Common-header.vue'
import CommonTag from '@/components/Common-tag.vue'

</script>

<template>
  <div class="common-layout">
    <el-container class="el-container">
        <!-- 左边的 菜单-->
        <CommonAside></CommonAside>  
        <!-- 右边的 主体内容 -->
        <el-container>
          <!-- 右边的上 头部 -->
          <el-header>
            <CommonHeader></CommonHeader>
          </el-header>
          <CommonTag></CommonTag>
          <!-- 右边的下 内容体 -->
          <el-main>
            <router-view></router-view>
          </el-main>
        </el-container>
    </el-container>    
  </div>
</template>

<style scoped>
.el-header {
  margin: 0;
  padding: 0;
  height: 82px;
}
.el-main {
  margin: 0;
  padding: 20px;
}

</style>
