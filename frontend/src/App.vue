<template>
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </div>

  <div class="p-grid p-jc-center">
    <div class="p-col-12 p-md-6">
      <router-view />
    </div>
  </div>
</template>

<script>
import "primevue/resources/themes/saga-blue/theme.css"; //theme
import "primevue/resources/primevue.min.css"; //core css
import "primeicons/primeicons.css"; //icons
import "primeflex/primeflex.css";

export default {};
</script>

<style lang="scss">
body {
  background: linear-gradient(
    149deg,
    rgba(108, 189, 231, 1) 18%,
    rgba(23, 128, 8, 1) 100%,
    rgba(31, 30, 27, 1) 100%
  );
  min-height: 100vh;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #ffffff;
    }
  }
}
</style>
