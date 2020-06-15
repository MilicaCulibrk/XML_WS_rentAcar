import axios from 'axios';
import {store} from "./store/index";

export default function setup() {
    axios.interceptors.request.use(function(config) {
        const token = store.state.user.username;
        if(token) {
            config.headers.username = `${token}`;
        }
        return config;
    }, function(err) {
        return Promise.reject(err);
    });
}