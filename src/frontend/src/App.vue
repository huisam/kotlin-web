<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <div class="menu">
    <a v-for="menu in menus" :key="menu">{{ menu }}</a>
  </div>
  <div>
    원룸샵
    <h4 :style='style'>xxx 원룸</h4>
    <p>50 만원</p>
    <button @click="increase">허위매물신고</button>
    <span>신고수 : {{ clicks }}</span>
  </div>
  <div>
    <h4>xxx 원룸</h4>
    <p>60 만원</p>
  </div>
</template>

<script>
import request from "request";

export default {
  name: 'App',
  data() {
    return {
      style: 'color: blue',
      clicks: 0,
      menus: ['Home', 'Shop', 'About'],
      products: ['역삼동 원룸', '천호동 원룸',]
    }
  },
  methods: {
    increase() {
      this.clicks += 1;
    }
  },
  components: {},
  mounted() {
    request('http://localhost:8080/board/hello', (error, response, body) => {
      window.console.log('error : ', error)
      window.console.log('statusCode : ', response.statusCode)
      window.console.log('body : ', body)
    })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
}
</style>
