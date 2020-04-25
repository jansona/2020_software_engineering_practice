<template>
    <section>
        <panel-group :userNum=userNum :messageNum=messageNum :arrangementNum=arrangementNum />

        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>社区基本属性</span>
                <el-button style="float: right; padding: 5px 0" type="text">设置</el-button>
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
                        <el-input-number v-model="community.communityInternal" :min="0" label="最短自提间隔"></el-input-number>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </section>
</template>

<script>
import PanelGroup from '../../components/PanelGroup'
import { getUserNum, getMessageNum, getArrangementNum } from '../../api/api';
import getCommunity from '../../api/api';

export default {
    components: { PanelGroup },
    data() {
        return {
            userNum: 0,
            messageNum: 0,
            arrangementNum: 0,
            community: {
                communityId: 1,
                communityName: '第1小区',
                communityAddress: '湖北省武汉市第1大街1号',
                communityInternal: 3600,
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
        }
    },
    mounted() {
        this.getAllNums();
        getCommunity().then((res) => {
            this.community = res.data.content;
        })
    }
}
</script>