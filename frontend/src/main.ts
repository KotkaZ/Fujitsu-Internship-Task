import "./plugins/axios";
import { createApp } from "vue";
import App from "./App.vue";
import PrimeVue from "primevue/config";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";

createApp(App)
  .use(store)
  .use(router)
  .use(PrimeVue)
  .mount("#app");
