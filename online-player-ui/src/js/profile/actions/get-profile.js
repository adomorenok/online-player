import axios from 'axios';

export const getProfile = (track) => dispatch => {
    if (localStorage.getItem("x-token")) {
        axios.get("/api/user/current/profile")
            .then((response) => {
                dispatch({type: 'FETCH_PROFILE_SUCCESS', payload: response.data.content});
            }).catch((err) => {
                dispatch({type: 'FETCH_PROFILE_ERROR', payload: err});
            });
    } else {
        dispatch({type: 'CLEAR_PROFILE_SUCCESS', payload: {}});
    }
};