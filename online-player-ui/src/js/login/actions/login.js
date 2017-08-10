import axios from 'axios';

export const login = (user, callback) => dispatch => {
    axios.post("/api/login", user)
        .then((response) => {
            dispatch({type: 'LOGIN_SUCCESS', payload: response.data.content});

            localStorage.setItem('x-token', response.headers['x-token']);

            if (callback) {
                callback();
            }
        }).catch((err) => {
            dispatch({type: 'LOGIN_ERROR', payload: err});
        });
};