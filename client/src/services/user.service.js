import axios from 'axios';
import authHeader from './auth-header';
import { host } from './server';

const SERVER_URL = host + '/api/users/';

class UserService {
  getAll() {
    return axios.get(SERVER_URL, {
        headers: authHeader()
    });
  }
}

export default new UserService();
