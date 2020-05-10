<template>
    <section class="chart-container">
        <el-row>
            <el-col :span="12">
                <div id="arrangementDistribution" style="width:130%; height:400px;"></div>
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="11">
                <div id="chartPie" style="width:100%; height:400px;"></div>
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
                      type: 'category',
                      axisTick: {
                        alignWithLabel: true
                    }
                  },
                  yAxis: {
                      name: "订单数目/个",
                      type: 'value',
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
                    debugger;
                    let pieData = [];
                    for(let k in res.data.content){
                        pieData.push({value: res.data.content[k], name: k});
                    }
                    pieData = pieData.sort((a,b) => { return b.value - a.value; });
                    let pieDataFiltered = [];
                    for(let i=0; i<10; i++){
                        pieDataFiltered.push(pieData[i]);
                    }
                    let otherValue = 0;
                    for(let i=10; i<pieData.length; i++){
                        otherValue += pieData[i].value;
                    }
                    if(otherValue > 0){
                        pieDataFiltered.push({name: '其他', value: otherValue});
                    }
                    this.pieData = pieDataFiltered;
                    this.drawPieChart()
                })
            },
        },

        mounted: function () {
            this.drawCharts()
            // this.drawColumnChart();
            // this.drawPieChart();
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
