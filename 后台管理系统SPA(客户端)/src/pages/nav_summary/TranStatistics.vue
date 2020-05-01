<template>
    <section class="chart-container">
        <el-row>
            <el-col :span="12">
                <div id="arrangementDistribution" style="width:120%; height:400px;"></div>
            </el-col>
            <el-col :span="12">
                <div id="chartPie" style="width:80%; height:400px;"></div>
            </el-col>
        </el-row>
    </section>
</template>

<script>
    import echarts from 'echarts'
    import { getArrangementTimeDistribution, getArrangementUserDistribution } from '../../api/api';

    export default {
        data() {
            return {
                chartColumn: null,
                chartPie: null,

                barData: [0, 0, 0, 0, 0, 5, 20, 36, 10, 10, 20],

                pieData: [{ value: 335, name: '用户1' },
                                { value: 310, name: '用户2' },
                                { value: 234, name: '用户3' },
                                { value: 135, name: '用户4' },
                                { value: 1548, name: '用户5' }],
                
            }
        },

        methods: {
            drawColumnChart() {
                this.chartColumn = echarts.init(document.getElementById('arrangementDistribution'));

                let times = [];
                for(let i=1; i<25; i++) {
                    times.push(i);
                }

                this.chartColumn.setOption({
                  title: { text: '自提工作安排分布' },
                  tooltip: {},
                  xAxis: {
                      data: times,
                      name: "时间/h",
                    //   type: 'category',
                  },
                  yAxis: {
                      name: "订单数目/个",
                    //   type: 'value',
                  },
                  tooltip: {
                        trigger: 'item',
                        formatter: "{a} : {c}"
                    },
                  series: [{
                      name: '订单数',
                      type: 'bar',
                      data: this.barData
                    }]
                });
            },
            drawPieChart() {
                this.chartPie = echarts.init(document.getElementById('chartPie'));
                this.chartPie.setOption({
                    title: {
                        text: '住户订单分布',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    series: [
                        {
                            name: '用户订单',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '50%'],
                            data: this.pieData,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                });
            },
            drawCharts() {
                getArrangementTimeDistribution().then((res) => {
                    this.barData = res.data.content;
                    this.drawColumnChart()
                });
                getArrangementUserDistribution().then((res) => {
                    this.pieData = res.data.content;
                    this.drawPieChart()
                })
            },
        },

        mounted: function () {
            // this.drawCharts()
            this.drawColumnChart();
            this.drawPieChart();
        },
        updated: function () {
            this.drawCharts()
        }
    }
</script>

<style scoped>
    .chart-container {
        width: 100%;
        float: left;
    }
    /*.chart div {
        height: 400px;
        float: left;
    }*/

    .el-col {
        padding: 30px 20px;
    }
</style>
