import Login from './pages/Login.vue'
import NotFound from './pages/404.vue'
import Home from './pages/Home.vue'
import Table from './pages/nav_transaction/Table.vue'
import Arrangements from './pages/nav_transaction/Arrangements.vue'
import Goods from './pages/nav_transaction/Goods.vue'
import Message from './pages/nav_message/Message.vue'
import Form from './pages/nav_transaction/Form.vue'
import user from './pages/nav_transaction/user.vue'
import Page4 from './pages/nav_community/Page4.vue'
import Page5 from './pages/nav_community/Page5.vue'
import Page6 from './pages/nav_message/Page6.vue'
import echarts from './pages/nav_summary/echarts.vue'
import UserTable from './pages/nav_community/UserTable.vue'

let routes = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    //{ path: '/main', component: Main },
    {
        path: '/',
        component: Home,
        name: '工作安排',
        iconCls: 'el-icon-message',//图标样式class
        children: [
            { path: '/arrangements', component: Arrangements, name: '物资配置进度表' },
            { path: '/form', component: Goods, name: '物资清单' },
            { path: '/user', component: user, name: '列表', hidden: true},
        ]
    },
    {
        path: '/',
        component: Home,
        name: '社区管理',
        iconCls: 'fa fa-id-card-o',
        children: [
            { path: '/page4', component: UserTable, name: '户主名单' },
            { path: '/page5', component: Page5, name: '小区/社区属性设置' }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '',
        iconCls: 'fa fa-address-card',
        leaf: true,//只有一个节点
        children: [
            { path: '/message', component: Message, name: '消息通知' }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '业务统计',
        iconCls: 'fa fa-bar-chart',
        children: [
            { path: '/echarts', component: echarts, name: '业务分布' },
        ]
    },
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];

export default routes;