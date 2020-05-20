<template>
  <div class="block">
    <el-timeline>
      <el-timeline-item v-for="(item, index) of timeline" :key="index" :timestamp="item.timestamp" placement="top">
        <el-card>
          <p><b>{{ item.title }}</b> {{ item.timestamp }}</p>
          <el-row>
            <el-col :span="20"><slot name="content" v-bind="item"></slot></el-col>
            <el-col :span="4"><slot name="buttons" v-bind="item"></slot></el-col>
          </el-row>
        </el-card>
      </el-timeline-item>
    </el-timeline>
  </div>
</template>

<script>
export default {
    name: 'Timeline',
    props: {
        timeline: [],
    },
    data() {
        return {
        }
    }
}
</script>
