import axios from 'axios';

let base = 'http://localhost:8443';

export const requestLogin = params => { return axios.post(`/login`, params).then(res => res.data); };

export const getUserList = params => { return axios.get(`${base}/user/list`, { params: params }); };

export const getUserListPage = params => { return axios.get(`${base}/user/listpage`, { params: params }); };

export const removeUser = params => { return axios.get(`${base}/user/remove`, { params: params }); };

export const batchRemoveUser = params => { return axios.get(`${base}/user/batchremove`, { params: params }); };

export const editUser = params => { return axios.get(`${base}/user/edit`, { params: params }); };

export const addUser = params => { return axios.get(`${base}/user/add`, { params: params }); };

export const getArrangementListPage = params => { return axios.get(`${base}/arrangement/listpage`, { params: params }); };

export const removeArrangement = params => { return axios.get(`${base}/arrangement/remove`, { params: params }); };

export const batchRemoveArrangement = params => { return axios.get(`${base}/arrangement/batchremove`, { params: params }); };

export const getGoodsListPage = params => { return axios.get(`${base}/package/listpage`, { params: params }); };

export const removeGoods = params => { return axios.get(`${base}/package/remove`, { params: params }); };

export const batchRemoveGoods = params => { return axios.get(`${base}/package/batchremove`, { params: params }); };

export const editGoods = params => { return axios.post(`${base}/package/edit`, { params: params }); };

export const addGoods = params => { return axios.post(`${base}/package/add`, { p: {params: params} }); };

export const getUsersListPage = params => { return axios.get(`${base}/users/listpage`, { params: params }); };
