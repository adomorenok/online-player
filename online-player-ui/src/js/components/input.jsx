import React from 'react';
import uiLite from "ui-lite";

export default class MdlInput extends React.Component {
    componentDidMount() {
        new ui.input(this.input);
    };

    render() {
        return (
            <input ref={(currentInput) => { this.input = currentInput; }} { ...this.props } />
        )
    };
}