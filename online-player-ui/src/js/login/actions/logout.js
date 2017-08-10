import axios from 'axios';

export const logout = (callback) => dispatch => {
    axios.get("/api/login")
        .then((response) => {
            dispatch({type: 'LOGOUT_SUCCESS', payload: response.data.content});
        }).catch((err) => {
            dispatch({type: 'LOGOUT_SUCCESS', payload: err});

            localStorage.removeItem('x-token');

            if (callback) {
                callback();
            }
        });
};