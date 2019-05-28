import React, {Component} from 'react';
import {Link} from "react-router-dom";

class Home extends Component {
    render() {
        return (
            <div>
                <h1>Homepage is here</h1>
                <p>Some content here</p>
                <div>
                    <Link to="search">Search something</Link>
                </div>
            </div>
        );
    }
}

export default Home;
