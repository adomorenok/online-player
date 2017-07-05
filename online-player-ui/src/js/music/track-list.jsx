import React from 'react';
import { connect } from 'react-redux';

import { getTracks } from './actions/tracks';

class TrackList extends React.Component {
    componentDidMount() {
        this.props.onGetTracks();
    }

    render() {
        return (
            <div>
                <h1>Track list</h1>
                <table className="track-table">
                    <tbody>
                        <tr>
                            <td className="author">Author</td>
                            <td className="album">Album</td>
                            <td className="track">Track</td>
                        </tr>
                        {this.props.tracks.map((track, index) =>
                            <tr key={index}>
                                <td>{track.author.name}</td>
                                <td>{track.album.name}</td>
                                <td>{track.name}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default connect(state => ({
        tracks: state.tracks
    }), dispatch => ({
        onGetTracks: () => {
            dispatch(getTracks());
        }
    })
)(TrackList);