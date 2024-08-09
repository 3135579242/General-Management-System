

<script setup lang="ts">
import { getUserList, getUserByName,getPagesUsers,getDeleteUser,getSaveUser,getEditUser,getByIdUser } from '../api/home'

import { ref,onMounted, reactive } from 'vue'

const keyWord = ref('')
const tableData = reactive([])
const totalTemp = ref(0)
const reqUserList = async () => {
    const userData = await getUserList()
    tableData.value = userData.map(user => {
        return {
            ...user,
            gender: user.gender === 0 ? '女' : '男'
        }
    })
    totalTemp.value = tableData.value.length
}
// 搜索按钮
const handleSearch = async () => {
    const userData = await getUserByName(keyWord.value)
    tableData.value = userData.map(user => {
        return {
            ...user,
            gender: user.gender === 0 ? '女' : '男'
        }
    })
}
// 分页功能
const currentPage = ref(1)
const pageSize = ref(2)
const total = ref(totalTemp)

const reqPagesUsers = async (page,size) => {
    const response = await getPagesUsers(page,size)
    tableData.value = response.records.map((user) => {
        return {
            ...user,
            gender: user.gender === 0 ? '男' : '女'
        }
    })
    total.value = response.total
    console.log(response)
}
const currentChange = (page) => {
    currentPage.value = page
    reqPagesUsers(currentPage.value, pageSize.value)
}
// 用户删除
const handleDeleteFlag = ref(false)
// 当前条目的id
const itemId = ref()
const confirmDelete = (id) => {
    handleDeleteFlag.value = true
    itemId.value = id
}
// 点击确定删除后
const handleDelete = () => {
    handleDeleteFlag.value = false
    getDeleteUser(parseInt(itemId.value))
    window.location.reload()
}

// 新增数据功能
const addAndUpdateDialogFlag = ref(false)
const dialogTitle = ref('')
const addFormData = ref({})
const addDialog = () => {
    addAndUpdateDialogFlag.value = true
    dialogTitle.value = 'add'
    addFormData.value = {}
}
// 确定发送请求改数据
const handleAddUser = () => {
    getSaveUser(addFormData.value)
    addAndUpdateDialogFlag.value = false
    window.location.reload()
}

// 编辑数据功能
const updateUser = async (id) => {
    dialogTitle.value = ''
    addAndUpdateDialogFlag.value = true
    const response = await getByIdUser(id)
    Object.assign(response,{gender: response.gender === 0 ? '女' : '男'})
    addFormData.value = response
}
// 确定发送请求改数据
const handleEditUser = () => {
    Object.assign(addFormData.value,{gender: addFormData.value === '女' ? '0' : '1'})
    getEditUser(addFormData.value)
    addAndUpdateDialogFlag.value = false
    window.location.reload()
}

const handleAddAndEdit = () => {
    if(dialogTitle.value === 'add'){
        handleAddUser()
    }
    if(dialogTitle.value === ''){
        handleEditUser()
    }
}


onMounted(() => {
    reqUserList()
})

</script>


<template>
    <div>
        <div class="top">
            <div>
                <el-button type="primary" @click="addDialog" >新增</el-button>
                <el-dialog
                        v-model="addAndUpdateDialogFlag"
                        :title="dialogTitle === 'add' ? '新增' : '编辑'"
                        width="500"
                    >
                    <el-form :model="addFormData">
                        <el-form-item label="用户名">
                            <el-input v-model="addFormData.name"></el-input>
                        </el-form-item>
                        <el-form-item label="年龄">
                            <el-input v-model="addFormData.age"></el-input>
                        </el-form-item>
                        <el-form-item label="性别">
                            <el-select v-model="addFormData.gender" placeholder="请选择性别">
                                <el-option label="男" value="1" />
                                <el-option label="女" value="0" />
                            </el-select>
                        </el-form-item>
                        <el-form-item label="日期">
                            <el-date-picker
                                v-model="addFormData.birthDate"
                                type="date"
                                placeholder="请选择日期"
                                style="width: 100%"
                                />
                        </el-form-item>
                        <el-form-item label="地址">
                            <el-input v-model="addFormData.address"></el-input>
                        </el-form-item>
                    </el-form>

                    <template #footer>
                        <div>
                            <el-button @click="addAndUpdateDialogFlag = false">取消</el-button>
                            <el-button type="primary" @click="handleAddAndEdit">{{ dialogTitle === 'add' ? '添加' : '保存' }}</el-button>
                        </div>
                    </template>
                </el-dialog>
            </div>

            <div>
                请输入
                <el-input v-model="keyWord" style="width: 240px" placeholder="请输入用户名" />
                <el-button style="margin-left: 5px;" type="primary" @click="handleSearch">搜索</el-button>
            </div>
        </div>
        <div class="userList">
            <el-table :data="tableData.value" style="width: 100%">
                <el-table-column prop="name" label="姓名" width="180" />
                <el-table-column prop="age" label="年龄" width="180" />
                <el-table-column prop="gender" label="性别" />
                <el-table-column prop="birthDate" label="出生日期" />
                <el-table-column prop="address" label="地址" />
                <el-table-column label="操作" >
                    <template v-slot="scope" >
                        <el-button type="primary" @click="updateUser(scope.row.id)">编辑</el-button>
                        <el-button type="danger" @click="confirmDelete(scope.row.id)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-dialog
                    v-model="handleDeleteFlag"
                    title="删除该用户"
                    width="500"
                >
                <span>此操作不可回滚，请谨慎操作</span>
                <template #footer>
                    <div>
                        <el-button @click="handleDeleteFlag = false">取消</el-button>
                        <el-button type="primary" @click="handleDelete">确认</el-button>
                    </div>
                </template>
            </el-dialog>
            <el-pagination
                :current-page="currentPage"
                :page-size="pageSize"
                :total="total"
                @current-change="currentChange"
                size="small"
                background
                layout="prev, pager, next"
            />
        </div>
    </div>
</template>


<style scoped>

.el-form {
    display: flex;
    flex-wrap: wrap;
    .el-form-item {
        width: 200px;
        margin-left: 20px;
    }
}

.el-pagination {
    margin-top: 20px;
}

.top {
    display: flex;
    justify-content: space-between;
}

</style>


