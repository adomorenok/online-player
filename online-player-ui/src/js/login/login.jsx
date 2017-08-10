import React from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';

import MdlInput from '../components/input.jsx';
import MdlButton from '../components/button.jsx';
import { login } from './actions/login';
import { getProfile } from '../profile/actions/get-profile';


class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        let user = {
            username: this.state.email,
            password: this.state.password
        };

        this.props.onLogin(user, () => {
            this.props.onLoadProfile();
            this.props.router.push('/track-list');
        });
    }

    handleInputChange(event) {
        const target = event.target;
        const name = target.name;
        this.setState({
            [name]: target.value
        });
    }

    render() {
        return (
            <div>
                <form className="add-track-form" onSubmit={this.handleSubmit}>
                    <h1>Login</h1>

                    <div className="ui-input-container">
                        <label className="ui-label">Email</label>
                        <MdlInput className="ui-input"
                                  type="text"
                                  name="email"
                                  value={this.state.email}
                                  onChange={this.handleInputChange}/>
                    </div>

                    <div className="ui-input-container">
                        <label className="ui-label">Password</label>
                        <MdlInput className="ui-input"
                                  type="password"
                                  name="password"
                                  value={this.state.password}
                                  onChange={this.handleInputChange}/>
                    </div>

                    <div className="ui-input-container right">
                        <MdlButton className="ui-btn">Login</MdlButton>
                    </div>
                </form>
            </div>
        )
    }
}

export default connect(state => ({}), dispatch => ({
        onLogin: (user, callback) => {
            dispatch(login(user, callback));
        },
        onLoadProfile: () => {
            dispatch(getProfile());
        }
    })
)(Login);