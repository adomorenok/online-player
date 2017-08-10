import axios from 'axios';

export const registration = (user, callback) => dispatch => {
    axios.post("/api/users", user)
        .then((response) => {
            dispatch({type: 'REGISTRATION_SUCCESS', payload: response.data.content});

            if (callback) {
                callback();
            }
        }).catch((err) => {
            dispatch({type: 'REGISTRATION_ERROR', payload: err});
        });
};