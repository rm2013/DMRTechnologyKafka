<template>
  <div class="container">
    <header class="jumbotron">
      <h3>{{content}}</h3>
    </header>
    <CalendarList />
  </div>
  
</template>

<script>
import UserService from '../services/user.service';
import CalendarList from '../components/CalendarList';

export default {
  name: 'Home',
  components: {
      CalendarList
    },
  data() {
    return {
      content: ''
    };
  },
  mounted() {
    UserService.getPublicContent().then(
      response => {
        this.content = response.data;
      },
      error => {
        this.content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString();
      }
    );
  }
};
</script>
