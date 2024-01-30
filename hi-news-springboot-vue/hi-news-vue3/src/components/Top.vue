<script setup>
defineProps({
  title: {
    type: String,
    required: true
  },
  addBtnEnable: {
    type: Boolean,
    required: false,
    default: false
  },
  backBtnEnable: {
    type: Boolean,
    required: false,
    default: false
  }
})
</script>

<template>
  <h1 class="green">{{ title }}</h1>
  <router-link to="/add">
    <button v-if="addBtnEnable">添加新闻</button>
  </router-link>
  <router-link to="/">
    <button v-if="backBtnEnable">返回</button>
  </router-link>
</template>

<style scoped>

</style>
