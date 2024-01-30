<script setup>
import Top from "@/components/Top.vue";
import {onMounted, reactive} from "vue";
import request from "@/utils/axiosUtils.js";
import formatDate from "@/utils/DateUtils.js";

const props = defineProps({
  id: {
    type: String,
    required: true
  }
});

let state = reactive({
  loading: true,
  news: {}
});

onMounted(() => {
  console.log(props.id);
  if (props.id !== undefined) {
    request.get("/news/" + props.id).then(result => {
      if (result.model) {
        state.news = result.model;
        state.loading = false;
      }
    });
  }
});
</script>

<template>
  <Top title="新闻编辑" :back-btn-enable="true"/>
  <main v-if="!state.loading">
    <h2>{{ state.news.title }}</h2>
    <hr/>
    <p>{{ state.news.newsContent }}</p>
    <hr/>
    <p>发布者： {{ state.news.publisher }}</p>
    <p>发布时间： {{ formatDate(state.news.gmtCreate) }}</p>
    <p v-if="state.news.gmtModify">修改时间： {{ formatDate(state.news.gmtModify) }}</p>
  </main>
</template>
