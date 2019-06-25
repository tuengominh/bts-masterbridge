import React, {Component} from 'react';
import background from "../img/calc.jpg";
import {Link} from "react-router-dom";

class Calculator extends Component {
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

export default Calculator;