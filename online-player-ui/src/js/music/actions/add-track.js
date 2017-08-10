import axios from 'axios';

export const addTrack = (track, callback) => dispatch => {
    axios.post("/api/tracks", track)
        .then((response) => {
            dispatch({type: 'ADD_TRACKS_SUCCESS', payload: response.data.content});

            if (callback) {
                callback();
            }
        }).catch((err) => {
            dispatch({type: 'ADD_TRACKS_ERROR', payload: err});
        });
};