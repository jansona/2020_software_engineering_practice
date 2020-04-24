<template>
    <section>
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="集群消息" name="first">
                <timeline :timeline="communityMessage">
                    <template v-slot:content="item">
                        <div>姓名：{{ item.user.userName }}</div>
                        <div>身份证：{{ item.user.userIdcard }}</div>
                        <div>住址：{{ item.user.userAddress }}</div>
                    </template>
                    <template v-slot:buttons="item">
                        <el-button type="success" @click="enrollAdmit(item)">接受</el-button>
                        <el-button type="danger" @click="enrollRefuse(item)">拒绝</el-button>
                    </template>
                </timeline>
            </el-tab-pane>
            <el-tab-pane label="特殊申请" name="second">
                <timeline :timeline="timeline">
                    <template v-slot:content="item">
                        <div>姓名：{{ item.user.userName }}</div>
                        <div>物资号：{{ item.package.packageId }}</div>
                        <div>称述：{{ item.content}}</div>
                    </template>
                    <template v-slot:buttons="item">
                        <el-button type="primary" size="large" @click="handleDeal(item)">处理</el-button>
                    </template>
                </timeline>
            </el-tab-pane>
            <el-tab-pane label="其他" name="third">
                <timeline :timeline="timeline"></timeline>
            </el-tab-pane>
        </el-tabs>

        <!--特殊申请处理界面-->
        <el-dialog :model="dealForm" :title="dealForm.title" v-model="handleVisible" :close-on-click-modal="true">
            <el-form label-width="80px" ref="editForm">
                <el-form-item label="业主账号">
                    <span>{{ dealForm.user.userId }}</span>
                </el-form-item>
                <el-form-item label="业主姓名">
                    <span>{{ dealForm.user.userName }}</span>
                </el-form-item>
                <el-form-item label="业主门户">
                    <span>{{ dealForm.user.userAddress }}</span>
                </el-form-item>
                <el-form-item label="物资账号">
                    <span>{{ dealForm.package.packageId }}</span>
                </el-form-item>
                <el-form-item label="物资内容">
                    <span>{{ dealForm.package.packageContent }}</span>
                </el-form-item>
                <el-form-item v-if="dealForm.dealType===0" label="推迟至">
                    <span>{{ dealForm.dealTime }}</span>
                </el-form-item>
                <el-form-item label="陈述">
                    <span>{{ dealForm.content }}</span>
                </el-form-item>
                <el-form-item label="答复消息">
                    <el-input v-model="dealForm.dealResponse" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="success" @click.native="handleAccept" :loading="handleLoading">接受</el-button>
                <el-button type="danger" @click.native="handleRefuse" :loading="handleLoading">拒绝</el-button>
            </div>
        </el-dialog>
    </section>
</template>

<script>
    // import { getGoodsListPage, removeGoods, batchRemoveGoods, editGoods, addGoods } from '../../api/api';
    import Timeline from '../../components/Timeline'
    import { getEnrollQuitMessage, checkEnroll, checkQuit } from '../../api/api';
    import { getDealMessage, checkDeal } from '../../api/api';

    export default {
        components: { Timeline },
        data() {
            return {
                activeName: 'first',
                communityMessage: [],
                dealMessage: [],
                handleLoading: false,
                handleVisible: false,
                dealForm: {
                        timestamp: '2019/4/20 20:46',
                        title: '延时自提',
                        dealType: 0,
                        user: {userName: '李宜泽', userId:'XXXXX', userAddress:'1号楼 门牌号2'},
                        package: {packageId: '1', packageContent: 'XXX'},
                        content: 'nothing2say',
                        dealTime: '2020-04-24 06:18:27',
                        dealResponse: '',
                    },
                timeline: [
                    {
                        timestamp: '2019/4/20 20:46',
                        title: '延时自提',
                        dealType: 0,
                        user: {userName: '李宜泽', userId:'XXXXX', userAddress:'1号楼 门牌号2'},
                        package: {packageId: '1', packageContent: 'XXX'},
                        content: 'nothing2say',
                        dealTime: '2020-04-24 06:18:27',
                        dealResponse: '',
                    },
                    {
                        timestamp: '2019/4/20 20:46',
                        title: '送货上门',
                        dealType: 1,
                        user: {userName: '李宜泽', userId:'XXXXX', userAddress:'1号楼 门牌号2'},
                        package: {packageId: '1', packageContent: 'XXX'},
                        content: 'nothing2say',
                        dealTime: '2020-04-24 06:18:27',
                        dealResponse: '',
                    },
                    {
                        timestamp: '2019/4/20 20:46',
                        title: '延时自提',
                        dealType: 0,
                        user: {userName: '李宜泽', userId:'XXXXX', userAddress:'1号楼 门牌号2'},
                        package: {packageId: '1', packageContent: 'XXX'},
                        content: 'nothing2say',
                        dealTime: '2020-04-24 06:18:27',
                        dealResponse: '',
                    },
                ]
            }
        },
        methods: {
            getMessage() {
                // sessionStorage.setItem('communityId', 1);
                getEnrollQuitMessage().then(res => {
                    this.communityMessage = res.data.content;
                });
                getDealMessage().then(res => {
                    this.dealMessage = res.data.content;
                });
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
                    this.getMessage();
                });
            },
            enrollRefuse(item) {
                let para = { id: item.applicationId, admit: false };
                checkEnroll(para).then((res) => {
                    this.getMessage();
                });
            },
            quitCheck(item) {
                let para = { id: item.content.id };
                checkQuit(para).then((res) => {
                    this.getMessage();
                });
            },

            handleDeal(item) {
                this.dealForm = item;
                this.handleVisible = true;
            },
            handleAccept() {
                this.handleLoading = true;
                let para = { id: dealForm.dealId, admit: true, deal_response: dealForm.dealResponse };
                checkDeal(para).then((res) => {
                    this.getMessage();
                    this.handleVisible = false;
                    this.handleLoading = false;
                });
            },
            handleRefuse() {
                this.handleLoading = true;
                let para = { id: dealForm.dealId, admit: false, deal_response: dealForm.dealResponse };
                checkDeal(para).then((res) => {
                    this.getMessage();
                    this.handleVisible = false;
                    this.handleLoading = false;
                });
            },
        },
        mounted() {
            this.getMessage();
        }
    }

</script>

<style scoped>

</style>