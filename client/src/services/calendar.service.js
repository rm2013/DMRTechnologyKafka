import axios from 'axios'
import authHeader from './auth-header';
import { host } from './server';

const SERVER_URL = host + '/api/calendarevents/';


class CalendarService {
    // (C)reate  
    createNew(text, date, completed) {
        return axios.post(SERVER_URL, {
            title: text,
            date: date,
            completed: completed,
        }, {
            headers: authHeader()
        });
    }
    // (R)ead  
    getAll() {
        return axios.get(SERVER_URL, {
            headers: authHeader()
        });
    }
    // (U)pdate  
    updateForId(id, text, date, completed) {
        return axios.put(SERVER_URL + id, {
            title: text,
            date: date,
            completed: completed
        }, {
            headers: authHeader()
        });
    }
    // (D)elete  
    removeForId(id) {
        return axios.delete(SERVER_URL + id, {
            headers: authHeader()
        });
    }
}

export default new CalendarService();