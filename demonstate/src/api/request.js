/**
 * Created by nnie on 2018/1/10.
 **/
import axios from 'axios'

const basicUrl = 'http://127.0.0.1:8082'
const http = axios.create({
  baseURL: basicUrl,
  timeout: 50000,
})

http.interceptors.request.use(config => {
  config.headers
  return config
}, error => {
  return Promise.reject(error)
})

http.interceptors.response.use(response => {
  return response
}, error => {
  return Promise.reject(error)
})

export default http
