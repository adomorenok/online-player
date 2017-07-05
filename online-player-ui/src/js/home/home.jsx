import React from 'react';
import { Link } from 'react-router'

import MdlLink from '../components/link.jsx';

export default class Home extends React.Component {
    render() {
        return (
            <div className="start-button-container">
                <MdlLink href="#/track-list" className="ui-btn start-button">Start</MdlLink>
            </div>
        )
    }
}