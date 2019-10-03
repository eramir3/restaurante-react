import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://react-my-burger-f1afe.firebaseio.com/'
});

export default instance;