import axios from 'axios'
import {
  Message, Loading
} from 'element-ui'
import _ from 'lodash'

const http = axios.create({
  baseURL: process.env.BASE_URL, //设置请求的base url
  timeout: 40000 //超时时长
});

//loading对象
let loading;

//当前正在请求的数量
let needLoadingRequestCount = 0;

//显示loading
function showLoading(target) {
  // 后面这个判断很重要，因为关闭时加了抖动，此时loading对象可能还存在，
  // 但needLoadingRequestCount已经变成0.避免这种情况下会重新创建个loading
  if (needLoadingRequestCount === 0 && !loading) {
    loading = Loading.service({
      lock: true,
      text: "Loading...",
      background: 'rgba(255, 255, 255, 0.5)',
      target: target || "body"
    });
  }
  needLoadingRequestCount++;
}

//隐藏loading
function hideLoading() {
  needLoadingRequestCount--;
  needLoadingRequestCount = Math.max(needLoadingRequestCount, 0); //做个保护
  if (needLoadingRequestCount === 0) {
    //关闭loading
    toHideLoading();
  }
}

//防抖：将 300ms 间隔内的关闭 loading 便合并为一次。防止连续请求时， loading闪烁的问题。
var toHideLoading = _.debounce(() => {
  loading.close();
  loading = null;
}, 300);

axios.interceptors.request.use(config => { // request拦截器
  //判断当前请求是否设置了不显示Loading
  if (config.headers.showLoading !== false) {
    showLoading(config.headers.loadingTarget);
  }
  return config
}, err => {
  //判断当前请求是否设置了不显示Loading
  if (config.headers.showLoading !== false) {
    hideLoading();
  }
  Message.error('请求超时!');
  return Promise.reject(err);
})

axios.interceptors.response.use(success => {
  //判断当前请求是否设置了不显示Loading（不显示自然无需隐藏）
  if (success.config.headers.showLoading !== false) {
    hideLoading();
  }
  if (success.status == 200) {
    return success.data;
  }
}, error => {
  //判断当前请求是否设置了不显示Loading（不显示自然无需隐藏）
  if (error.config.headers.showLoading !== false) {
    hideLoading();
  }
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

export const postJson = (url, params) => {
  return axios({
    method: 'post',
    data: params,
    url: `${base}${url}`,
    headers: {
      "Context-Type": "application/json"
    }
  });
}
