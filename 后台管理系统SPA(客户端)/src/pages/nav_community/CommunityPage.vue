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
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>高级属性</span>
            </div>
            <div>
                <el-table :data="locationData" border fit highlight-current-row style="width: 100%">
                <el-table-column min-width="300px" label="Title">
                    <template slot-scope="{row}">
                    <template v-if="row.edit">
                        <el-input v-model="row.locationName" class="edit-input" size="small"/>
                    </template>
                    <span v-else>{{ row.locationName }}</span>
                    </template>
                </el-table-column>

                <el-table-column align="center" label="Actions" width="170">
                    <template slot-scope="{row}">
                        <template v-if="row.edit">
                            <el-button
                                type="success"
                                size="small"
                                @click="confirmEdit(row)">
                                确定
                            </el-button>
                            <el-button
                                class="cancel-btn"
                                size="small"
                                type="warning"
                                @click="cancelEdit(row)">
                                取消
                            </el-button>
                        </template>
                        <template v-else>
                            <el-button
                                type="primary"
                                size="small"
                                @click="row.edit=!row.edit">
                                编辑
                            </el-button>
                            <el-button
                                type="danger"
                                size="small"
                                @click="row.edit=!row.edit">
                                移除
                            </el-button>
                        </template>
                    </template>
                </el-table-column>
                </el-table>
            </div>
        </el-card>
    </section>
</template>

<script>
import PanelGroup from '../../components/PanelGroup'
import { getUserNum, getMessageNum, getArrangementNum } from '../../api/api';
import { getCommunityDetail, setCommunityDetail } from '../../api/api';
import { getCommunityLocations, addCommunityLocation, removeCommunityLocation, setCommunityLocation } from '../../api/api';

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
            },
            locationData: [{
                locationName: '1hao',
                edit: false,
            }]
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
        },
        getLocations() {
            getCommunityLocations().then((res) => {
                debugger;
                this.locationData = res.data.content;
            });
        },
        cancelEdit(row) {
        row.title = row.originalTitle
        row.edit = false
        this.$message({
            message: '放弃修改自提点',
            type: 'warning'
        })
        },
        confirmEdit(row) {
        row.edit = false
        row.originalTitle = row.title
        this.$message({
            message: '自提点修改成功',
            type: 'success'
        })
        },
    },
    mounted() {
        this.getAllNums();
        this.getDetail();
        this.getLocations();
    }
}
</script>