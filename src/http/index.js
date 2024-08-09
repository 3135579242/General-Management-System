import axios from 'axios'


const http = axios.create({
    baseURL: 'http://localhost:9999/',
    timeout: '10000'
})

http.interceptors.request.use(
    (config) => {
        return config
    },
    (eeror) => {
        Promise.reject(error)
    }
)

http.interceptors.response.use(
    (response) => {
        return response.data.data
    },
    (error) => {
        return Promise.reject(`响应错误: ${error}`)
    }
)

export default http
