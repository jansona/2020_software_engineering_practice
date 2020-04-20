<template>
    <section>
        
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="集群消息" name="first">
                <timeline :timeline="communityMessage">
                    <template v-slot:content="item">
                        <div>姓名：{{ item.user.userName }}</div>
                        <div>身份证：{{ item.user.userIdcard }}</div>
                        <div>地址：{{ item.user.userAddress }}</div>
                    </template>
                    <template v-slot:buttons="item">
                        <el-button type="success" @click="enrollAdmit(item)">接受</el-button>
                        <el-button type="danger" @click="enrollRefuse(item)">拒绝</el-button>
                    </template>
                </timeline>
            </el-tab-pane>
            <el-tab-pane label="特殊申请" name="second">
                <timeline :timeline="timeline"></timeline>
            </el-tab-pane>
            <el-tab-pane label="其他" name="third">
                <timeline :timeline="timeline"></timeline>
            </el-tab-pane>
        </el-tabs>
    </section>
</template>

<script>
    // import { getGoodsListPage, removeGoods, batchRemoveGoods, editGoods, addGoods } from '../../api/api';
    import Timeline from '../../components/Timeline'
    import { getEnrollQuitMessage, checkEnroll, checkQuit } from '../../api/api';

    export default {
        components: { Timeline },
        data() {
            return {
                activeName: 'first',
                communityMessage: [],
                timeline: [
                    {
                        timestamp: '2019/4/20 20:46',
                        title: '入群请求',
                        content: {name: '李宜泽', ID:'XXXXX', address:'1号楼 门牌号2'}
                    },
                    {
                        timestamp: '2019/4/21 20:46',
                        title: '退群消息',
                        content: {name: '李宜泽', ID:'XXXXX', address:'1号楼 门牌号2'}
                    },
                    {
                        timestamp: '2019/4/22 20:46',
                        title: '入群请求',
                        content: {name: '李宜泽', ID:'XXXXX', address:'1号楼 门牌号2'}
                    },
                    {
                        timestamp: '2019/4/23 20:46',
                        title: '退群消息',
                        content: {name: '李宜泽', ID:'XXXXX', address:'1号楼 门牌号2'}
                    }
                ]
            }
        },
        methods: {
            getEnrollQuitMessage() {
                sessionStorage.setItem('communityId', 1);
                getEnrollQuitMessage().then(res => {
                    debugger;
                    this.communityMessage = res.data.content;
                })
            },
            contentMapping() {
                this.communityMessage.forEach((item) => {
                    item.title = '入群请求';
                    item.timestamp = item.applicationTime;
                })
            },
            enrollAdmit(item) {
                let para = { id: item.applicationId, admit: true };
                checkEnroll(para).then((res) => {
                    this.getEnrollQuitMessage();
                });
            },
            enrollRefuse(item) {
                let para = { id: item.applicationId, admit: false };
                checkEnroll(para).then((res) => {
                    this.getEnrollQuitMessage();
                });
            },
            quitCheck(item) {
                let para = { id: item.content.id };
                checkQuit(para).then((res) => {
                    this.getEnrollQuitMessage();
                });
            },
        },
        mounted() {
            this.getEnrollQuitMessage();
        }
    }

</script>

<style scoped>

</style>