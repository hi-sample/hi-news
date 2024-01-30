import axios from "axios";

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8088',
    timeout: 10000,
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    }
});

axiosInstance.interceptors.request.use(config => {
    // 在请求发送之前做些什么
    // 可以在此处添加认证信息、设置请求头等
    return config;
}, error => {
    console.log('request error: ' + error);
    return Promise.reject(error);
});

axiosInstance.interceptors.response.use(response => {
    let result = response.data;
    if (result.code !== 0) {
        alert('接口返回异常: ' + result.code + " " + result.msg);
        throw new Error('接口返回异常: ' + result.code + " " + result.msg);
    }
    return result;
}, error => {
    console.log('response error: ' + error);
    return Promise.reject(error);
});

const request = {
    get: (url, params) => axiosInstance.get(url, {params}),
    post: (url, data) => axiosInstance.post(url, data),
    put: (url, data) => axiosInstance.put(url, data),
    patch: (url, data) => axiosInstance.patch(url, data),
    delete: (url, params) => axiosInstance.delete(url, {params}),
};

export default request;