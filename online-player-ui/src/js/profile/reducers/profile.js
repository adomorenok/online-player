import { browserHistory } from 'react-router';

const initialState = {};

export default function profile(state = initialState, action = {}) {
    if (action.type === 'FETCH_PROFILE_SUCCESS') {
        return action.payload;
    } else if (action.type === 'FETCH_PROFILE_ERROR') {
        return action.payload;
    } else if (action.type == 'CLEAR_PROFILE_SUCCESS') {
        return initialState;
    }

    return state;
}
