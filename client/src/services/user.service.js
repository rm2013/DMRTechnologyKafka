import axios from 'axios';
import authHeader from './auth-header';

const SERVER_URL = 'http://localhost:9000/api/users/';

class UserService {
  getAll() {
    return axios.get(SERVER_URL, {
        headers: authHeader()
    });
  }
}

export default new UserService();
