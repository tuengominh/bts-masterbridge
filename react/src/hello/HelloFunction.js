import {Component} from "react";
import React from "react";

class HelloFunction extends Component {

    constructor(props) {
        super();
        this.state = {
            message: "" ,
            }
        }

    componentDidMount() {
        setInterval(this.hello, 250);
    }

    hello = () => {
        fetch('/api/hello')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    render() {
        return (
            <div><h1 className="App-title">{this.state.message}</h1></div>
        );
    }
}

export default HelloFunction;