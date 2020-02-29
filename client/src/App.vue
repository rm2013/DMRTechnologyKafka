<template>
  <div id="app">
    <CalendarList />
    <footer class="info">
      <p>DMR Technology Calendar for GOTO Chicago</p>
    </footer>
  </div>
</template>

<script>
  import CalendarList from './components/CalendarList'
  // app Vue instance
  const app = {
    name: 'app',
    components: {
      CalendarList
    },
    // app initial state
    data: () => {
      return {
      }
    }
  }

  export default app
</script>

<style>
  [v-cloak] { display: none; }
</style>