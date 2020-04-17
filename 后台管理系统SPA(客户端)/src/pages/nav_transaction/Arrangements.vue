<template>
    <section>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :model="filters">
                <el-form-item>
                    <el-input v-model="filters.user" placeholder="住户"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.goods_id" placeholder="物资ID"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.location" placeholder="地点"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.time" placeholder="期限"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" v-on:click="getArrangements">查询</el-button>
                </el-form-item>
            </el-form>
        </el-col>

        <!--列表-->
        <el-table :data="arrangements" highlight-current-row v-loading="listLoading" @selection-change="selsChange" style="width: 100%;">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column type="index" width="60">
            </el-table-column>
            <el-table-column prop="user" label="住户" width="120" sortable>
            </el-table-column>
            <el-table-column prop="arrangementPackage" label="物资ID" width="200" sortable>
            </el-table-column>
            <el-table-column prop="arrangementLocation" label="住址" width="200" sortable>
            </el-table-column>
            <el-table-column prop="arrangementTime" label="期限" width="200" sortable>
            </el-table-column>
            <el-table-column label="操作" width="150">
                <template slot-scope="scope">
                    <!-- <el-button size="small" @click="handleEdit(scope.$index, scope.row)">check</el-button> -->
                    <el-button type="success" size="small" @click="handleDel(scope.$index, scope.row)">check</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--工具条-->
        <el-col :span="24" class="toolbar">
            <el-button type="success" @click="batchRemove" :disabled="this.sels.length===0">批量check</el-button>
            <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="20" :total="total" style="float:right;">
            </el-pagination>
        </el-col>
    </section>
</template>

<script>
    import util from '../../common/js/util'
    import { getArrangementListPage, removeArrangement, batchRemoveArrangement } from '../../api/api';

    export default {
        data() {
            return {
                filters: {
                    user: '',
                    goods_id: '',
                    location: '',
                    time: '',
                },
                arrangements: [],
                total: 0,
                page: 1,
                listLoading: false,
                sels: [],//列表选中列
            }
        },
        methods: {
            handleCurrentChange(val) {
                this.page = val;
                this.getArrangements();
            },
            //获取用户列表
            getArrangements() {
                let para = {
                    page: this.page,
                    id: '',
                    user: this.filters.user,
                    package_id: this.filters.goods_id,
                    location: this.filters.location,
                    time: this.filters.time,
                };
                this.listLoading = true;
                getArrangementListPage(para).then((res) => {
                    debugger;
                    this.total = res.data.total;
                    this.arrangements = res.data.content;
                    this.listLoading = false;
                });
            },
            //删除
            handleDel: function (index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    //NProgress.start();
                    let para = { id: row.id };
                    removeArrangement(para).then((res) => {
                        this.listLoading = false;
                        //NProgress.done();
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                        this.getArrangements();
                    });
                }).catch(() => {

                });
            },

            selsChange: function (sels) {
                this.sels = sels;
            },
            //批量删除
            batchRemove() {
                var ids = this.sels.map(item => item.id).toString();
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    let para = { ids: ids };
                    batchRemoveArrangement(para).then((res) => {
                        this.listLoading = false;
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                        this.getArrangements();
                    });
                }).catch(() => {

                });
            }
        },
        mounted() {
            this.getArrangements();
        }
    }

</script>

<style scoped>

</style>