import React from 'react';
import { connect } from 'react-redux';

import { getProfile } from './profile/actions/get-profile';
import { logout } from './login/actions/logout';


class App extends React.Component {
    constructor(props) {
        super(props);

        this.handleLogout = this.handleLogout.bind(this);
    }

    componentDidMount() {
        this.props.onLoadProfile();
    }

    handleLogout(event) {
        event.preventDefault();

        this.props.onLogout(() => {
            this.props.onLoadProfile();
            this.props.router.push('/home');
        });
    }

    render() {
        let menuItems;
        if (this.props.profile.name) {
            menuItems = <div className="ui-panel-fieldset ui-panel-active">
                <div className="ui-panel-element-container">
                    <a href="/#/home" className="ui-header-btn">
                        <span>Home</span>
                    </a>
                </div>
                <div className="ui-panel-element-container">
                    <a href="/#/track-list" className="ui-header-btn">
                        <span>Track list</span>
                    </a>
                </div>
                <div className="ui-panel-element-container">
                    <a href="/#/add-track" className="ui-header-btn">
                        <span>Add track</span>
                    </a>
                </div>
                <div className="ui-panel-element-container">
                    <a href="/" className="ui-header-btn" onClick={this.handleLogout}>
                        <span>Logout</span>
                    </a>
                </div>
            </div>
        } else {
            menuItems = <div className="ui-panel-fieldset ui-panel-active">
                <div className="ui-panel-element-container">
                    <a href="/#/login" className="ui-header-btn">
                        <span>Login</span>
                    </a>
                </div>
                <div className="ui-panel-element-container">
                    <a href="/#/registration" className="ui-header-btn">
                        <span>Registration</span>
                    </a>
                </div>
            </div>
        }
        return (
            <div>
                <header className="ui-header">
                    <div className="ui-panel ui-scroll">
                        <div className="ui-panel-fieldset">
                            <div className="ui-panel-toggle-mobile">
                                <div className="ui-header-element-container ui-header-logo-conteiner">
                                    <a href="/" className="ui-header-btn ui-header-logo">
                                        I love music
                                    </a>
                                </div>
                            </div>
                        </div>

                        {menuItems}
                    </div>

                    <div className="ui-header-general">
                        <div className="ui-header-element-container">
                            <div className="ui-panel-toggle-btn">
                                <i className="ui-icon fa fa-bars"></i>
                            </div>
                        </div>
                        <div className="ui-header-element-container ui-header-logo-conteiner">
                            <a href="/" className="ui-header-btn ui-header-logo">
                                I love music
                            </a>
                        </div>

                        <div className="ui-header-element-container ui-icon-right">
                            <div className="ui-open-submenu-btn" data-sub-menu="settings">
                                <i className="ui-icon ui-icon-setting"></i>
                            </div>
                        </div>
                    </div>

                    <div className="ui-header-element-container ui-mobile-toggle">
                        <div className="ui-mobile-toggle-btn">
                            <i className="ui-icon fa fa-bars"></i>
                        </div>
                    </div>
                </header>

                <div className="ui-container">
                    {this.props.children}
                </div>
            </div>
        )
    }
}


export default connect(state => ({
        profile: state.profile
    }), dispatch => ({
        onLoadProfile: () => {
            dispatch(getProfile());
        },
        onLogout: (callback) => {
            dispatch(logout(callback));
        }
    })
)(App);