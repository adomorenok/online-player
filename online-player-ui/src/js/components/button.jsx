import React from 'react';
import uiLite from "ui-lite";

export default class MdlButton extends React.Component {
    componentDidMount() {
        new ui.button(this.btn);
    };

    render() {
        return (
            <button ref={ (button) => { this.btn = button; } } { ...this.props }>
                { this.props.children }
            </button>
        )
    };
}