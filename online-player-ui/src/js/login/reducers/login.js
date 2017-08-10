const initialState = [];

export default function tracks(state = initialState, action = {}) {
    if (action.type === 'LOGIN_SUCCESS') {
        return action.payload;
    } else if (action.type === 'LOGIN_ERROR') {
        return action.payload;
    }

    return state;
}
