import axios from 'axios'
import {
  Message
} from 'element-ui'

axios.interceptors.request.use(config => { // request拦截器
  return config
}, err => {
  return Promise.reject(err);
})

axios.interceptors.response.use(success => {
  if (success.status == 200) {
    return success.data;
  }
}, error => {
  if (error.response.status == 504 || error.response.status == 404) {
    Message.error({
      message: "去不了你想要去的地方喔！"
    });
  } else if (error.response.status == 403) {
    Message.error({
      message: "权限不足，请联系小熊~"
    });
  } else if (error.response.status == 401) {
    Message.error({
      message: "请先登录~"
    });
  } else {
    if (error.response.data.msg) {
      Message.error({
        message: error.response.data.msg
      });
    } else {
      Message.error({
        message: "请求失败，请稍后重试！"
      });
    }
  }
  return;
})

let base = '';

export const post = (url, params) => {
  return axios({
    method: 'post',
    data: params,
    url: `${base}${url}`,
    transformRequest: [function (e) {
      let r = '';
      for (let i in e) {
        r += encodeURIComponent(i) + '=' + encodeURIComponent(e[i]) + '&'
      }
      return r;
    }],
    headers: {
      "Context-Type": "application/x-www-form-urlencoded"
    }
  });
}
