<template>
  <div class="hello">
    <el-avatar class="avatar" :size="48" :src="user.avatarUrl"></el-avatar>
  </div>
</template>

<script>
export default {
  name: 'Avatar',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
