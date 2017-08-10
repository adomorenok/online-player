import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route, IndexRoute, hashHistory } from 'react-router'
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';

import App from './app.jsx';
import Home from './home/home.jsx';
import TrackList from './music/track-list.jsx';
import AddTrack from './music/add-track.jsx';
import Login from './login/login.jsx';
import Registration from './login/registration.jsx';

import reducer from './reducers';

import css from '../scss/app.scss';


const store = createStore(reducer, applyMiddleware(thunk));

ReactDOM.render((
    <Provider store={store}>
        <Router history={hashHistory}>
            <Route path="/" component={App}>
                <IndexRoute component={Home}/>
                <Route path="login" component={Login}/>
                <Route path="registration" component={Registration}/>
                <Route path="home" component={Home}/>
                <Route path="track-list" component={TrackList}/>
                <Route path="add-track" component={AddTrack}/>
            </Route>
        </Router>
    </Provider>
), document.getElementById('app'));
