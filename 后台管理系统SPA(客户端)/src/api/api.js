import axios from 'axios';
import Qs from 'qs';
axios.defaults.withCredentials = true;

let base = '/api';

// 注册登录
export const requestLogin = params => { return axios.post(`${base}/login`, Qs.stringify(params) ); };
// export const requestLogin = params => { debugger; return axios({
//     method: 'POST',
//     url: `${base}/login`,
//     data: params,
//     headers: {'Content-Type': 'application/x-www-form-urlencoded'}
// }) };

export const requestRegister = params => { return axios.post(`${base}/register`, Qs.stringify(params) ); };

// 工作安排相关
export const getArrangementListPage = params => { return axios.get(`${base}/arrangement/listpage`, { params: params }); };

export const removeArrangement = params => { return axios.get(`${base}/arrangement/remove`, { params: params }); };

export const batchRemoveArrangement = params => { return axios.get(`${base}/arrangement/batchremove`, { params: params }); };

// 物资相关
export const getGoodsListPage = params => { return axios.get(`${base}/package/listpage`, { params: params }); };

export const removeGoods = params => { return axios.get(`${base}/package/remove`, { params: params }); };

export const batchRemoveGoods = params => { return axios.get(`${base}/package/batchremove`, { params: params }); };

export const editGoods = params => { return axios.post(`${base}/package/edit`, params); };

export const addGoods = params => { return axios.post(`${base}/package/add`, params); };

export const getGoodsImportUrl = () => { return `${base}/package/import`; };

// 用户相关
export const getUsersListPage = params => { return axios.get(`${base}/users/listpage`, { params: params }); };

// 入/退群相关消息及处理
export const getEnrollQuitMessage = () => { return axios.get(`${base}/application/community`)};

export const checkEnroll = params => { return axios.get(`${base}/application/check-enroll`, { params: params }); };

export const checkQuit = params => { return axios.get(`${base}/application/check-quit`, { params: params }); };

// 特殊申请消息及处理
export const getDealMessage = () => { return axios.get(`${base}/deal/community`)};

export const checkDeal = params => { return axios.get(`${base}/deal/check-deal`, { params: params }); };

// 社区属性配置面板
export const getUserNum = () => { return axios.get(`${base}/user/sum`)};

export const getMessageNum = () => { return axios.get(`${base}/message/sum`)};

export const getArrangementNum = () => { return axios.get(`${base}/arrangement/sum`)};

export const getCommunityDetail = () => { return axios.get(`${base}/community/detail`)};

export const setCommunityDetail = params => { return axios.post(`${base}/community/set`, params); };

export const getCommunityLocations = () => { return axios.get(`${base}/community/location/list`)};

export const addCommunityLocation = params => { return axios.post(`${base}/community/location/add`, params); };

export const removeCommunityLocation = params => { return axios.get(`${base}/community/location/remove`, { params: params })};

export const setCommunityLocation = params => { return axios.post(`${base}/community/location/modify`, params); };

// 业务统计
export const getArrangementTimeDistribution = () => { return axios.get(`${base}/arrangement/statistics/time`)};

export const getArrangementUserDistribution = () => { return axios.get(`${base}/package/statistics/user`)};
