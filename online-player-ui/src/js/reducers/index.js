import { combineReducers } from 'redux';

import tracks from '../music/reducers/tracks';
import profile from '../profile/reducers/profile';

export default combineReducers({
    profile,
    tracks
});
