
<script setup lang="ts">

import { onBeforeUnmount, onMounted, reactive, ref } from 'vue'
import { getBuyList, getOrderList, getEchartsList } from '../api/home'
// Echarts
import * as echarts from 'echarts';


const tableLabel = ref({
    name: '课程',
    todayBuy: '今天购买',
    monthBuy: '本月购买',
    totalBuy: '总购买'
})

const tableDataExis = ref([
    {
        name: 'Java',
        todayBuy: 100,
        monthBuy: 300,
        totalBuy: 400
    },
    {
        name: 'Mysql',
        todayBuy: 200,
        monthBuy: 300,
        totalBuy: 500
    }
])

// 表数据
const tableData = ref<any[]>([])
const reqtableData = async () => {
    try {
        const data = await getBuyList()
        tableData.value = data
    }catch (e){
        console.log(`home请求错误: ${e}`)
    }
}

// 卡片数据
const cardData = ref<any[]>([])
const reqCardData = async () => {
    const data = await getOrderList()
    cardData.value = data
}

// 接收数据的类型
interface Date {
    str: String
}

interface Data {
    [key: string]: number
}

interface VideoData {
    name: String,
    price: number
}

interface UserData {
    date: String,
    news: number,
    active: number
}

interface Response {
    data: {
        date: String[],
        data: Data[],
        videoData: VideoData[],
        userData: UserData[]
    }
}

const ResponseData = reactive<Response>({
    data: {},
    date: {},
    videoData: {},
    userData: {}
})


// 折线图
const lineChart = ref(null)
const initChart = async () => {
    const response = await getEchartsList()
    ResponseData.data = response.data
    ResponseData.date = response.date
    ResponseData.videoData = response.videoData
    ResponseData.userData = response.userData
    // 绘制图表
    const option = reactive(
        {
            tooltip: {},
            legend: {},
            xAxis: {},
            yAxis: {},
            series: [
                {
                    name: 'aaa',
                    type: 'line',
                    data: [11,22,33]
                }
            ]
        }
    );
    option.xAxis.data = ResponseData.date
    option.series = Object.keys(ResponseData.data[0]).map((value) => {
        return {
            name: value,
            data: ResponseData.data.map((item) => {
               return item[value]
            }),
            type: 'line'
        }
    })
    const chartInstance = echarts.init(lineChart.value)
    chartInstance.setOption(option)
}
// 柱状图
const barChart = ref(null)
const initBarChart = async () => {
    const response = await getEchartsList()
    ResponseData.videoData = response.videoData
    ResponseData.userData = response.userData
    const option = {
        xAxis: {
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {},
        series: [
            {
                type: 'bar',
                data: [23, 24, 18, 25, 27, 28, 25]
            }
        ]
    };
    option.xAxis.data = ResponseData.userData.map(item => item.date)
    option.series = ResponseData.userData.map((item) => {
        return {
            type: 'bar',
            data: ResponseData.userData.map(m => m.active)
        }
    })
    const barChartInstance = echarts.init(barChart.value)
    barChartInstance.setOption(option)
}
// 饼图
const pieChart = ref(null)

const initPieChart = async () => {
    const response = await getEchartsList()
    ResponseData.videoData = response.videoData

    const option = {
        series: [
            {
            type: 'pie',
            data: [
                {
                    value: 335,
                    name: '直接访问'
                },
                {
                    value: 234,
                    name: '联盟广告'
                },
                {
                    value: 1548,
                    name: '搜索引擎'
                }
            ]
            }
        ]     
    }
    option.series = ResponseData.videoData.map(item => {
        return {
            type: 'pie',
            data: ResponseData.videoData.map(e => {
                return {
                    value: e.price,
                    name: e.name
                }
            })
        }
    })
    const pieChartInstance = echarts.init(pieChart.value)
    pieChartInstance.setOption(option)
}


// 生命钩子函数
onMounted(() => {
    reqtableData()
    reqCardData()
    initChart()
    initBarChart()
    initPieChart()
})


</script>

<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="7">
                <div>
                    <el-card
                        shadow="hover"
                    >
                        <div class="user-info">
                            <div class="user-info-details">
                                <img class="user-info-img" src="@/assets/av.jpg" alt="">
                                <div class="user-info-account">
                                    <p>Admin</p>
                                    <p class="font-size-info">管理员</p>
                                </div>
                            </div>
                            <div class="user-info-location">
                                <p class="font-size-info">上次登录时间: <span>2024-08-07</span></p>
                                <p class="font-size-info">上次登录地址: <span>中国广东</span></p>
                            </div>
                        </div>
                    </el-card>
                    <el-card
                        class="user-buy" 
                        shadow="hover"
                    >
                        <el-table :data="tableData">
                            <el-table-column prop="name" :label="tableLabel.name" > </el-table-column>
                            <el-table-column prop="todayBuy" :label="tableLabel.todayBuy" > </el-table-column>
                            <el-table-column prop="monthBuy" :label="tableLabel.monthBuy" > </el-table-column>
                            <el-table-column prop="totalBuy" :label="tableLabel.totalBuy" > </el-table-column>
                        </el-table>
                    </el-card>
                </div>
            </el-col>
            <el-col :span="17" >
                <div class="order-total">
                    <el-card shadow="hover" v-for="item in cardData">
                        <div class="card-item">
                            <div>
                                <el-icon :style="{color: item.color}"  >
                                    <component :is="item.icon" ></component>
                                </el-icon>
                            </div>
                            <div class="details">
                                <p>{{ item.orderTotal }}</p>
                                <p class="font-size-info">{{ item.name }}</p>
                            </div>
                        </div>
                    </el-card>
                </div>
                <div>
                    <!-- 折叠图 -->
                    <el-card shadow="hover" >
                        <div ref="lineChart" style="height: 300px;"></div>
                    </el-card>
                </div>
                <!-- 下面柱状和饼图 -->
                <div class="bar-pie">
                    <!-- 柱状图 -->
                    <el-card class="barChart" shadow="hover">
                        <div ref="barChart" style="height: 300px; width: 100%;"></div>
                     </el-card>
                     <!-- 饼图 -->
                     <el-card shadow="hover">
                        <div ref="pieChart" style="height: 300px;  width: 100%;"></div>
                     </el-card>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<style scoped>

.bar-pie {
    display: flex;
    margin-top: 20px;
    .barChart {
        margin-right: 20px
    }
    .el-card {
        flex: 1;
    }
}

.order-total {
    /* padding: 0; */
    display: flex;
    flex-wrap: wrap;
    width: 1270px;
    .el-card {
        margin-right: 10px;
        margin-bottom: 10px;
        width: 412px;
        .card-item {
            display: flex;
            align-items: center;
            .details {
                margin-left: 30px;
                font-size: 32px;
            }
        }
    }
}

/* 用户信息 */
.user-info {

    /* 用户详细 */
    .user-info-details {
        display: flex;
        align-items: center;
        height: 200px;
        border-bottom: 1px solid #666;
        /* 用户账号 */
        .user-info-account {
            margin-left: 30px;
            font-size: 32px;
        }
    }
    /* 用户头像 */
    .user-info-img {
        width: 160px;
        height: 160px;
        border-radius: 80px;
    }
    /* 用户地理位置和时间 */
    .user-info-location {
        p {
            margin-top: 20px;
        }
    }

}
/* 用户购买信息卡片 */
.user-buy {
    margin-top: 20px;
    height: 580px;
}

/* 公共样式字体 */
.font-size-info {
    font-size: 18px;
    color: #666;
}
</style>
