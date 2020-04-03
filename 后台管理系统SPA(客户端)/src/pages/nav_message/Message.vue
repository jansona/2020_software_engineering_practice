<template>
    <section>
        
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="集群消息" name="first">
                <timeline :timeline="timeline"></timeline>
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

    export default {
        components: { Timeline },
        data() {
            return {
                activeName: 'first',
                timeline: [
                    {
                    timestamp: '2019/4/20',
                    title: 'Update Github template',
                    content: 'PanJiaChen committed 2019/4/20 20:46'
                    },
                    {
                    timestamp: '2019/4/21',
                    title: 'Update Github template',
                    content: 'PanJiaChen committed 2019/4/21 20:46'
                    },
                    {
                    timestamp: '2019/4/22',
                    title: 'Build Template',
                    content: 'PanJiaChen committed 2019/4/22 20:46'
                    },
                    {
                    timestamp: '2019/4/23',
                    title: 'Release New Version',
                    content: 'PanJiaChen committed 2019/4/23 20:46'
                    }
                ]
            }
        },
        methods: {
            
        },
        mounted() {
            
        }
    }

</script>

<style scoped>

</style>