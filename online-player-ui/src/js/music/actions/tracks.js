import axios from 'axios';

export const getTracks = () => dispatch => {
    axios.get("/api/tracks")
        .then((response) => {
            dispatch({type: 'FETCH_TRACKS_SUCCESS', payload: response.data.content});
        }).catch((err) => {
            dispatch({type: 'FETCH_TRACKS_ERROR', payload: err});
        });
};