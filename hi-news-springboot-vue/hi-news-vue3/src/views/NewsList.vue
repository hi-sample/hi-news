<script setup>
import {onMounted, reactive} from 'vue'
import Top from "@/components/Top.vue";
import request from "@/utils/axiosUtils.js";
import { useRouter } from 'vue-router';
import formatDate from "@/utils/DateUtils.js";

const route = useRouter();

let state = reactive({
  loading: true,
  newsList: []
});

onMounted(() => {
  list();
});

const list = () => {
  state.loading = true;
  request.get("/news").then(result => {
    state.newsList = result.data;
    state.loading = false;
  })
}

const add = () => {
  route.push('/add');
}

const view = (id) => {
  route.push('/view/'+id);
}

const edit = (id) => {
  route.push('/edit/'+id);
}

const del = (id) => {
  let confirmDelete = confirm("是否删除该条新闻?");
  if (confirmDelete){
    request.delete("/news/"+id).then(result =>{
      console.log(result);
      alert("删除成功");
      list();
    });
  }
}


</script>

<template>
  <Top title="新闻列表" :addBtnEnable="true" />
  <main>
    <table v-if="!state.loading">
      <tr>
        <th>序号</th>
        <th>标题</th>
        <th>发布时间</th>
        <th>操作</th>
      </tr>
      <tr v-for="news in state.newsList" :key="news.id">
        <td>{{ news.id }}</td>
        <td>{{ news.title }}</td>
        <td>{{ formatDate(news.gmtCreate) }}</td>
        <td>
          &nbsp;
          <button @click="view(news.id)">查看</button>
          &nbsp;
          <button @click="edit(news.id)">编辑</button>
          &nbsp;
          <button @click="del(news.id)">删除</button>
        </td>
      </tr>
    </table>
  </main>
</template>

<style scoped>
</style>