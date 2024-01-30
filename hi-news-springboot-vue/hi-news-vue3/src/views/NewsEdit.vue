<script setup>
import {onMounted, reactive} from 'vue'
import Top from "@/components/Top.vue";
import request from "@/utils/axiosUtils.js";
import {useRouter} from 'vue-router';

const route = useRouter();

const props = defineProps({
  id: {
    type: String,
    required: false
  }
});

let state = reactive({
  isEdit: false,
  news: {}
});

onMounted(() => {
  console.log(props.id);
  if (props.id !== undefined) {
    request.get("/news/" + props.id).then(result => {
      state.news = result.model;
      state.isEdit = true;
    });
  }
});

const save = () => {
  if (state.isEdit) {
    request.patch("/news/" + props.id, state.news).then(result => {
      alert("保存成功");
      route.replace('/');
    });
  } else {
    request.post("/news", state.news).then(result => {
      alert("保存成功");
      route.replace('/');
    });
  }
};
</script>

<template>
  <Top title="新闻编辑" :back-btn-enable="true"/>
  <main>
    <form @submit.prevent="save">
      <div>
        <label for="title">标题:</label>
        <input type="text" id="title" name="title" required v-model="state.news.title"/>
      </div>

      <div>
        <label for="newsContent">内容:</label><br/>
        <textarea id="newsContent" name="newsContent" required v-model="state.news.newsContent"
                  style="width: 600px;height:300px;">{{state.news.newsContent}}</textarea>
      </div>

      <div>
        <label for="publisher">发布者:</label>
        <input type="text" id="publisher" name="publisher" required v-model="state.news.publisher"/>
      </div>
      <br/>
      <input type="submit" value="保存"/>
    </form>
  </main>
</template>
