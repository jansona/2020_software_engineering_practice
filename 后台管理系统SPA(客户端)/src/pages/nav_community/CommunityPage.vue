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
                <el-table-column min-width="300px" label="自提点">
                    <template slot-scope="{row}">
                    <template v-if="row.status!=0">
                        <el-input v-model="row.locationName" class="edit-input" size="small"/>
                    </template>
                    <span v-else>{{ row.locationName }}</span>
                    </template>
                </el-table-column>

                <el-table-column align="center" label="操作" width="170">
                    <template slot-scope="{row}">
                        <template v-if="row.status==0">
                            <el-button
                                type="primary"
                                size="small"
                                @click="editLocation(row)">
                                编辑
                            </el-button>
                            <el-button
                                type="danger"
                                size="small"
                                @click="removeLocation(row)">
                                移除
                            </el-button>
                        </template>
                        <template v-if="row.status==1">
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
                        <template v-if="row.status==2">
                            <el-button
                                type="success"
                                size="small"
                                @click="addLocation(row)">
                                新增
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
            locationData: []
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
                this.locationData = [];
                res.data.content.forEach((item) => {
                    item.status = 0;
                    this.locationData.push(item);
                    // this.locationData.push({
                    //     locationId: item.locationId,
                    //     locationName: item.locationName, 
                    //     status: 0});
                });
                this.locationData.push({locationName: '', status: 2})
            });
        },
        cancelEdit(row) {
            row.locationName = row.locationNameBackName;
            row.status = 0;
            this.$message({
                message: '放弃修改自提点',
                type: 'warning'
            })
        },
        confirmEdit(row) {
            row.status = 0;
            setCommunityLocation(row).then((res) => {
                this.getLocations();
                this.$message({
                    message: '自提点修改成功',
                    type: 'success'
                })
            })
        },
        editLocation(row) {
            row.status = 1;
            row.locationNameBackName = row.locationName;
        },
        removeLocation(row) {
            removeCommunityLocation({id: String(row.locationId)}).then(() => {
                this.getLocations();
                this.$message({
                    message: '删除自提点',
                    type: 'success'
                })
            })
        },
        addLocation(row) {
            addCommunityLocation({name: row.locationName}).then((res => {
                this.getLocations();
                this.$message({
                    message: '新增自提点',
                    type: 'success'
                })
            }))
        },
    },
    mounted() {
        this.getAllNums();
        this.getDetail();
        this.getLocations();
    }
}
</script>