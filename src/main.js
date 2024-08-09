import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
// 导入理由
import { router } from './router/index'
// 导入element plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 导入element plus icon图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
// 导入pinia
import { createPinia } from 'pinia'
const pinia = createPinia()

const app = createApp(App)

// ElementPlus挂载图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

// 挂载路由
app.use(router)

// 挂载ElementPlus
app.use(ElementPlus)

// 挂载pinia
app.use(pinia)

app.mount('#app')
