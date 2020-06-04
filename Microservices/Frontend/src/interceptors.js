import axios from 'axios';
//import store from "./store/index";
import {store} from "./store/index";

export default function setup() {
    axios.interceptors.request.use(function(config) {
        const token = store.state.user.email;
        if(token) {
            config.headers.email = `${token}`;
        }
        return config;
    }, function(err) {
        return Promise.reject(err);
    });
}