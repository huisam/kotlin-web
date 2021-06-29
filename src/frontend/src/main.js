import {createApp} from 'vue'
import App from './App.vue'

// const boardComponent = {template: '<div>board</div>'}
//
// const routes = [
//     {path: '/board', component: boardComponent}
// ]
//
// const simpleRouter = {
//     data: () => ({
//         currentRoute: window.location.pathname
//     }),
//     computed: {
//         BoardComponent() {
//             return routes[this.currentRoute] || boardComponent
//         }
//     },
//     render() {
//         return h(this.BoardComponent)
//     }
// }

createApp(App).mount('#app')
// createApp(simpleRouter).mount('#app')
