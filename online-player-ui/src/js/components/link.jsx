import React from 'react';
import uiLite from "ui-lite";

export default class MdlLink extends React.Component {
    componentDidMount() {
        new ui.button(this.link);
    };

    render() {
        return (
            <a ref={ (lnk) => { this.link = lnk; } } { ...this.props }>
                { this.props.children }
            </a>
        )
    };
}