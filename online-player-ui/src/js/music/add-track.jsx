import React from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';

import MdlInput from '../components/input.jsx';
import MdlButton from '../components/button.jsx';
import { addTrack } from './actions/add-track';

class AddTrack extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            authorName: '',
            albumName: '',
            name: ''
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();

        let track = {
            name: this.state.name,
            album: {
                name: this.state.albumName
            },
            author: {
                name: this.state.authorName,
                tags: []
            }
        };
        this.props.onAddTrack(track);

        setTimeout(() => {
            this.props.router.push('/track-list');
        }, 500);
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
                    <h1>Add track</h1>

                    <div className="ui-input-container">
                        <label className="ui-label">Author</label>
                        <MdlInput className="ui-input"
                                  type="text"
                                  name="authorName"
                                  value={this.state.authorName}
                                  onChange={this.handleInputChange}/>
                    </div>

                    <div className="ui-input-container">
                        <label className="ui-label">Album</label>
                        <MdlInput className="ui-input"
                                  type="text"
                                  name="albumName"
                                  value={this.state.albumName}
                                  onChange={this.handleInputChange}/>
                    </div>

                    <div className="ui-input-container">
                        <label className="ui-label">Track</label>
                        <MdlInput className="ui-input"
                                  type="text"
                                  name="name"
                                  value={this.state.name}
                                  onChange={this.handleInputChange}/>
                    </div>

                    <div className="ui-input-container right">
                        <MdlButton className="ui-btn">Add track</MdlButton>
                    </div>
                </form>

            </div>
        )
    }
}

export default connect(state => ({}), dispatch => ({
        onAddTrack: (track) => {
            dispatch(addTrack(track));
        }
    })
)(AddTrack);