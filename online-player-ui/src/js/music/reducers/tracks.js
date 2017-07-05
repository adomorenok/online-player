import { browserHistory } from 'react-router';

const initialState = [];

export default function tracks(state = initialState, action) {
    if (action.type === 'FETCH_TRACKS_SUCCESS') {
        return action.payload;
    } else if (action.type === 'ADD_TRACKS_SUCCESS') {
        return action.payload;
    }

    return state;
}
