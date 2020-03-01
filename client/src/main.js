import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

import VueLogger from 'vuejs-logger';
import VueDatePicker from '@mathieustan/vue-datepicker';

const options = {
  isEnabled: true,
  logLevel : 'debug',
  stringifyArguments : false,
  showLogLevel : true,
  showMethodName : false,
  separator: '|',
  showConsoleColors: true
};

Vue.use(VueLogger, options);

Vue.use(VueDatePicker)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  components: { App }
});