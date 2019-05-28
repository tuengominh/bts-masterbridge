import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import './css/App.css';
import Home from "./home/Home";
import Hello from "./hello/Hello";
import HelloName from "./hello/HelloName";
import Navbar from "./Navbar";

class Main extends Component {

    render() {
        return (
            <div className="App">
                <Router>
                    <header className="App-header">
                        <Navbar/>
                    </header>

                    <Route path={"/"} exact component={Home} />
                    <Route path={"/hello"} exact component={Hello} />

                    <Route path={"/hello/:name"} render={props => <HelloName name={props.match.params.name}/>} />
                </Router>
            </div>
        );
    }
}

export default Main;