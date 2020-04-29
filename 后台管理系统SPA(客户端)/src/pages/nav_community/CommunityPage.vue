<template>
    <section>
        <panel-group :userNum=userNum :messageNum=messageNum :arrangementNum=arrangementNum />

        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>社区基本属性</span>
                <el-button style="float: right; padding: 5px 0" type="text" @click="setCommunity">设置</el-button>
            </div>
            <div>
                <el-form :model="community" label-width="100px">
                    <el-form-item label="账号">
                        <el-input v-model="community.communityId" :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="名称">
                        <el-input v-model="community.communityName"></el-input>
                    </el-form-item>
                    <el-form-item label="地址">
                        <el-input v-model="community.communityAddress"></el-input>
                    </el-form-item>
                    <el-form-item label="最短自提间隔">
                        <el-input-number v-model="community.communityInterval" :min="0" label="最短自提间隔"></el-input-number>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </section>
</template>

<script>
import PanelGroup from '../../components/PanelGroup'
import { getUserNum, getMessageNum, getArrangementNum } from '../../api/api';
import { getCommunityDetail, setCommunityDetail } from '../../api/api';

export default {
    components: { PanelGroup },
    data() {
        return {
            userNum: 0,
            messageNum: 0,
            arrangementNum: 0,
            community: {
                communityId: 0,
                communityName: '',
                communityAddress: '',
                communityInterval: 0,
            }
        }
    },
    methods: {
        getAllNums() {
            getUserNum().then((res) => {
                this.userNum = res.data.content;
            });
            getMessageNum().then((res) => {
                this.messageNum = res.data.content;
            });
            getArrangementNum().then((res) => {
                this.arrangementNum = res.data.content;
            });
        },
        getDetail() {
            getCommunityDetail().then((res) => {
                this.community = res.data.content;
            });
        },
        setCommunity() {
            let para = Object.assign({}, this.community);
            setCommunityDetail(para).then((res) => {
                this.getDetail();

                const h = this.$createElement;

                this.$notify({
                    title: '社区属性修改成功',
                    // message: h('i', { style: 'color: teal'}, '社区属性修改成功')
                });
            })
        }
    },
    mounted() {
        this.getAllNums();
        this.getDetail();
    }
}
</script>