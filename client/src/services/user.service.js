import axios from 'axios';
import authHeader from './auth-header';
import { userServiceHost } from './server';

const SERVER_URL = userServiceHost + '/api/users/';

class UserService {
  getAll() {
    return axios.get(SERVER_URL, {
        headers: authHeader()
    });
  }
}

export default new UserService();
