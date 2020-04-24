<template>
    <section>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :model="filters">
                <el-form-item>
                    <el-input v-model="filters.name" placeholder="住户"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.location" placeholder="住址"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" v-on:click="getUsers">查询</el-button>
                </el-form-item>
            </el-form>
        </el-col>

        <!--列表-->
        <el-table :data="users" highlight-current-row v-loading="listLoading" @selection-change="selsChange" style="width: 100%;">
            <!-- <el-table-column type="selection" width="55">
            </el-table-column> -->
            <!-- <el-table-column type="index" width="60">
            </el-table-column> -->
            <el-table-column prop="userId" label="账号" width="70" sortable>
            </el-table-column>
            <el-table-column prop="userName" label="姓名" width="100" sortable>
            </el-table-column>
            <el-table-column prop="userIdcard" label="身份证号" width="200" sortable>
            </el-table-column>
            <el-table-column prop="userAddress" label="住址" width="500" sortable>
            </el-table-column>
            <el-table-column label="操作" width="100">
                <template slot-scope="scope">
                    <!-- <el-button size="small" @click="handleEdit(scope.$index, scope.row)">check</el-button> -->
                    <el-button type="info" size="medium" @click="showDetail(scope.row)">详情</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--工具条-->
        <el-col :span="24" class="toolbar">
            <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10" :total="total" style="float:right;">
            </el-pagination>
        </el-col>

        <!--详情页面-->
        <el-dialog title="用户详情" v-model="detailShow" :close-on-click-modal="true">
            <el-form :model="detailForm" label-width="80px" ref="editForm">
                <el-form-item label="账号">
                    <span>{{ detailForm.userId }}</span>
                </el-form-item>
                <el-form-item label="姓名">
                    <span>{{ detailForm.userName }}</span>
                </el-form-item>
                <el-form-item label="身份证号">
                    <span>{{ detailForm.userIdcard }}</span>
                </el-form-item>
                <el-form-item label="门户">
                    <span>{{ detailForm.userAddress }}</span>
                </el-form-item>
                <el-form-item label="联系方式">
                    <span>{{ detailForm.userPhone }}</span>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button size="large" @click.native="detailShow = false">确定</el-button>
            </div>
        </el-dialog>
    </section>
</template>

<script>
    import util from '../../common/js/util'
    import { getUsersListPage } from '../../api/api';

    export default {
        data() {
            return {
                filters: {
                    name: '',
                    room: '',
                },
                detailShow: false,
                detailForm: {
                    userAddress: '',
                    userFavoriteStarttime: '',
                    userId: '',
                    userIdcard: '',
                    userName: '',
                    userPhone: '',
                    userTimeStay: '',
                },
                users: [],
                total: 0,
                page: 1,
                listLoading: false,
                sels: [],//列表选中列
            }
        },
        methods: {
            handleCurrentChange(val) {
                this.page = val;
                this.getUsers();
            },
            //获取用户列表
            getUsers() {
                let para = {
                    page: this.page,
                    id: '',
                    name: this.filters.name,
                    room: this.filters.room,
                };
                this.listLoading = true;
                getUsersListPage(para).then((res) => {
                    this.total = res.data.total;
                    this.users = res.data.content;
                    debugger;
                    this.listLoading = false;
                });
            },

            selsChange: function (sels) {
                this.sels = sels;
            },
            showDetail(item) {
                this.detailForm = item;
                this.detailShow = true;
            },
        },
        mounted() {
            this.getUsers();
        }
    }

</script>

<style scoped>

</style>