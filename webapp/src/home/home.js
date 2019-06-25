import React, {Component} from 'react';
import {Link} from "react-router-dom";
import background from "../img/background.jpeg";

class Home extends Component {
    render() {
        return (
            <div className="App-background" style={{
                backgroundImage: `url(${background})`,
                backgroundPosition: 'top',
                backgroundOrigin: 'border-box',
                backgroundSize: 'cover',
                backgroundRepeat: 'no-repeat',
            }}>
                <div>
                    <Link to="search">Search something</Link>
                </div>
            </div>
        );
    }
}

export default Home;
