<template>
    <section>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :model="filters">
                <el-form-item>
                    <el-input v-model="filters.id" placeholder="物资ID"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.user" placeholder="住户账号"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="filters.content" placeholder="内容"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" v-on:click="getGoods">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
                <el-form-item>
                    <el-upload class="upload-demo" :action="importUrl">
                        <el-button type="primary" plain>导入文件<i class="el-icon-upload el-icon--right"></i></el-button>
                        <!-- <div slot="tip" class="el-upload__tip">只能上传xls/xlsx</div> -->
                    </el-upload>
                </el-form-item>
            </el-form>
        </el-col>

        <!--列表-->
        <el-table :data="goods" highlight-current-row v-loading="listLoading" @selection-change="selsChange" style="width: 100%;">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="packageId" label="物资ID" width="200" sortable>
            </el-table-column>
            <el-table-column prop="packageUser" label="住户账号" width="150" sortable>
            </el-table-column>
            <el-table-column prop="packageContent" label="内容" width="450" sortable>
            </el-table-column>
            <el-table-column label="操作" width="150">
                <template slot-scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--工具条-->
        <el-col :span="24" class="toolbar">
            <el-button type="danger" @click="batchRemove" :disabled="this.sels.length===0">批量删除</el-button>
            <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10" :total="total" style="float:right;">
            </el-pagination>
        </el-col>

        <!--编辑界面-->
        <el-dialog title="编辑" v-model="editFormVisible" :close-on-click-modal="false">
            <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
                <el-form-item label="物主账号">
                    <el-input v-model="editForm.packageUser" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="editForm.packageContent" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="editFormVisible = false">取消</el-button>
                <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
            </div>
        </el-dialog>

        <!--新增界面-->
        <el-dialog title="新增" v-model="addFormVisible" :close-on-click-modal="false">
            <el-form :model="addForm" label-width="80px" :rules="addFormRules" ref="addForm">
                <el-form-item label="物主账号">
                    <el-input v-model="addForm.packageUser" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="addForm.packageContent" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="addFormVisible = false">取消</el-button>
                <el-button type="primary" @click.native="addSubmit" :loading="addLoading">提交</el-button>
            </div>
        </el-dialog>
    </section>
</template>

<script>
    import util from '../../common/js/util'
    //import NProgress from 'nprogress'
    import { getGoodsListPage, removeGoods, batchRemoveGoods, editGoods, addGoods, getGoodsImportUrl } from '../../api/api';

    export default {
        data() {
            return {
                filters: {
                    id: "",
                    user: "",
                    content: '',
                },
                goods: [],
                total: 0,
                page: 1,
                listLoading: false,
                sels: [],//列表选中列

                importUrl: '',

                editFormVisible: false,//编辑界面是否显示
                editLoading: false,
                editFormRules: {
                    user: [
                        { required: true, message: '请输入姓名', trigger: 'blur' }
                    ],
                },
                //编辑界面数据
                editForm: {
                    pakageId: '',
                    packageUser: '',
                    packageContent: '',
                },

                addFormVisible: false,//新增界面是否显示
                addLoading: false,
                addFormRules: {
                    user: [
                        { required: true, message: '请输入姓名', trigger: 'blur' }
                    ]
                },
                //新增界面数据
                addForm: {
                    packageUser: '',
                    packageContent: '',
                },

            }
        },
        methods: {
            handleCurrentChange(val) {
                this.page = val;
                this.getGoods();
            },
            //获取用户列表
            getGoods() {
                let para = {
                    page: this.page,
                    id: this.filters.id,
                    user: this.filters.user,
                    content: this.filters.content,
                };
                this.listLoading = true;
                //NProgress.start();
                getGoodsListPage(para).then((res) => {
                    this.total = res.data.total;
                    this.goods = res.data.content;
                    this.listLoading = false;
                    //NProgress.done();
                });
            },
            //删除
            handleDel: function (index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    //NProgress.start();
                    let para = { id: row.packageId };
                    removeGoods(para).then((res) => {
                        this.listLoading = false;
                        //NProgress.done();
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                        this.getGoods();
                    });
                }).catch(() => {

                });
            },
            //显示编辑界面
            handleEdit: function (index, row) {
                this.editFormVisible = true;
                this.editForm = Object.assign({}, row);
            },
            //显示新增界面
            handleAdd: function () {
                this.addFormVisible = true;
                this.addForm = {
                    packageUser: "",
                    packageContent: "",
                };
            },
            //编辑
            editSubmit: function () {
                this.$refs.editForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            this.editLoading = true;
                            //NProgress.start();
                            let para = Object.assign({}, this.editForm);
                            debugger;
                            editGoods(para).then((res) => {
                                this.editLoading = false;
                                //NProgress.done();
                                this.$message({
                                    message: '提交成功',
                                    type: 'success'
                                });
                                this.$refs['editForm'].resetFields();
                                this.editFormVisible = false;
                                this.getGoods();
                            });
                        });
                    }
                });
            },
            //新增
            addSubmit: function () {
                this.$refs.addForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交吗？', '提示', {}).then(() => {
                            this.addLoading = true;
                            //NProgress.start();
                            let para = Object.assign({}, this.addForm);
                            addGoods(para).then((res) => {
                                debugger;
                                this.addLoading = false;
                                //NProgress.done();
                                this.$message({
                                    message: '提交成功',
                                    type: 'success'
                                });
                                this.$refs['addForm'].resetFields();
                                this.addFormVisible = false;
                                this.getGoods();
                            });
                        });
                    }
                });
            },
            selsChange: function (sels) {
                this.sels = sels;
            },
            //批量删除
            batchRemove: function () {
                var ids = this.sels.map(item => item.packageId).toString();
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    this.listLoading = true;
                    let para = { ids: ids };
                    batchRemoveGoods(para).then((res) => {
                        this.listLoading = false;
                        this.$message({
                            message: '删除成功',
                            type: 'success'
                        });
                        this.getGoods();
                    });
                }).catch(() => {

                });
            }
        },
        mounted() {
            this.getGoods();
            this.importUrl = getGoodsImportUrl();
        }
    }

</script>

<style scoped>

</style>