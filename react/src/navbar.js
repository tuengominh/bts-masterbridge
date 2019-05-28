import {Component} from "react";
import React from "react";
import {Link} from 'react-router-dom';
import logo from "./img/logo.png";

class Navbar extends Component {

    render() {
        return (
            <nav class="menu">
                <img src={logo} className="App-logo" alt="logo"/>
                <Link to="/">Home</Link>
                <Link to="search">Search something</Link>
            </nav>
        );
    }
}

export default Navbar;