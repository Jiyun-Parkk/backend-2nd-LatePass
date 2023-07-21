import axios from "axios";

const axiosInstance = axios.create({
  // baseURL: "http://54.180.26.199/",
  baseURL: "http://localhost:8080",
  withCredentials: true,
  headers: {
    "Content-Type": "application/json",
  },
});

axiosInstance.interceptors.request.use(async function (config) {
  return config;
});
axiosInstance.interceptors.response.use(function (response) {
  return response;
});
export default axiosInstance;
