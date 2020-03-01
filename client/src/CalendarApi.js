import axios from 'axios'

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    // (C)reate  
    createNew: (text, date, completed) => instance.post('calendarevents', {
        title: text,
        date: date,
        completed: completed
    }),
    // (R)ead  
    getAll: () => instance.get('calendarevents', {
        transformResponse: [function (data) {
            return data ? JSON.parse(data)._embedded.calendarevents : data;
        }]
    }),
    // (U)pdate  
    updateForId: (id, text, date, completed) => instance.put('calendarevents/' + id, {
        title: text,
        date: date,
        completed: completed
    }),
    // (D)elete  
    removeForId: (id) => instance.delete('calendarevents/' + id)
}