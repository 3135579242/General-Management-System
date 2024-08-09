import http from '../http/index'

export const getBuyList = () => {
    return http.get('buy/list')
}

export const getOrderList = () => {
    return http.get('order/list')
}

export const getEchartsList = () => {
    return http.get('echarts/list')
}

export const getUserList = () => {
    return http.get('user/list')
}

export const getUserByName = (name) => {
    return http.get(`user/name/${name}`)
}

export const getPagesUsers = (page,size) => {
    return http.get(`user/pages`,{
        params: {
            page: page,
            size: size
        }
    })
}

export const getDeleteUser = (id) => {
    return http.delete(`user/${id}`)
}

export const getSaveUser = (user) => {
    return http.post('user',user)
}

export const getEditUser = (user) => {
    return http.put('user',user)
}

export const getByIdUser = (id) => {
    return http.get(`user/${id}`)
}



export const getUserLogin = (userLogin) => {
    return http.post('user/login',userLogin)
}





























