<template>
    <section>
        <el-tabs v-model="activeName">
            <el-tab-pane label="集群消息" name="first">
                <el-card v-if="communityMessage == null || communityMessage.length == 0">暂无消息</el-card>
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
                <el-card v-if="dealMessage == null || dealMessage.length == 0">暂无消息</el-card>
                <timeline :timeline="dealMessage">
                    <template v-slot:content="item">
                        <div>姓名：{{ item.packageEntity.userEntity.userName }}</div>
                        <div>物资号：{{ item.packageEntity.packageId }}</div>
                        <div>称述：{{ item.dealContent}}</div>
                    </template>
                    <template v-slot:buttons="item">
                        <el-button type="primary" size="large" @click="handleDeal(item)">处理</el-button>
                    </template>
                </timeline>
            </el-tab-pane>
            <el-tab-pane label="其他" name="third">
                <el-card>暂无消息</el-card>
                <!-- <timeline :timeline="timeline"></timeline> -->
            </el-tab-pane>
        </el-tabs>

        <!--特殊申请处理界面-->
        <el-dialog :model="dealForm" :title="dealForm.title" v-model="handleVisible" :close-on-click-modal="true">
            <el-form label-width="80px" ref="editForm">
                <el-form-item label="业主账号">
                    <span>{{ dealForm.packageEntity.userEntity.userId }}</span>
                </el-form-item>
                <el-form-item label="业主姓名">
                    <span>{{ dealForm.packageEntity.userEntity.userName }}</span>
                </el-form-item>
                <el-form-item label="业主门户">
                    <span>{{ dealForm.packageEntity.userEntity.userAddress }}</span>
                </el-form-item>
                <el-form-item label="物资账号">
                    <span>{{ dealForm.packageEntity.packageId }}</span>
                </el-form-item>
                <el-form-item label="物资内容">
                    <span>{{ dealForm.packageEntity.packageContent }}</span>
                </el-form-item>
                <el-form-item label="陈述">
                    <span>{{ dealForm.dealContent }}</span>
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
                    dealId: '',
                    timestamp: '',
                    title: '',
                    dealType: 0,
                    packageEntity: {
                        packageId: '', 
                        packageContent: '',
                        userEntity: {userName: '', userId:'', userAddress:''},
                    },
                    dealContent: '',
                    dealTime: '',
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
                    this.contentMapping_Enroll();
                });
                getDealMessage().then(res => {
                    this.dealMessage = res.data.content;
                    this.contentMapping_Deal();
                    debugger;
                });
            },
            contentMapping_Enroll() {
                this.communityMessage.forEach((item) => {
                    item.title = '入群请求';
                    item.timestamp = item.applicationTime;
                })
            },
            contentMapping_Deal() {
                this.dealMessage.forEach((item) => {
                    if(item.dealType == 0) {
                        item.title = '延时自提';
                    }else {
                        item.title = '送货上门';
                    }
                    item.timestamp = item.dealTime;
                })
            },
            enrollAdmit(item) {
                let para = { id: item.applicationId, admit: true };
                checkEnroll(para).then((res) => {
                    this.getMessage();

                    const h = this.$createElement;
                    this.$notify({
                        title: '已接受申请',
                        message: h('i', { style: 'color: teal'}, item.user.userName + " 加入居民集群")
                    });
                });
            },
            enrollRefuse(item) {
                let para = { id: item.applicationId, admit: false };
                checkEnroll(para).then((res) => {
                    this.getMessage();

                    const h = this.$createElement;
                    this.$notify({
                        title: '已拒绝申请',
                        message: h('i', { style: 'color: red'}, item.user.userName + " 的申请被拒")
                    });
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
                let para = { id: this.dealForm.dealId, admit: true, deal_response: this.dealForm.dealResponse };
                checkDeal(para).then((res) => {
                    debugger;
                    this.getMessage();
                    this.handleVisible = false;
                    this.handleLoading = false;

                    const h = this.$createElement;
                    this.$notify({
                        title: '已接受特殊申请',
                        message: h('i', { style: 'color: teal'},
                            "接受 " + this.dealForm.packageEntity.userEntity.userName + " 提出的 " + this.dealForm.title)
                    });
                });
            },
            handleRefuse() {
                this.handleLoading = true;
                let para = { id: this.dealForm.dealId, admit: false, deal_response: this.dealForm.dealResponse };
                checkDeal(para).then((res) => {
                    this.getMessage();
                    this.handleVisible = false;
                    this.handleLoading = false;

                    const h = this.$createElement;
                    this.$notify({
                        title: '已拒绝特殊申请',
                        message: h('i', { style: 'color: red'},
                            "拒绝 " + this.dealForm.packageEntity.userEntity.userName + " 提出的 " + this.dealForm.title)
                    });
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