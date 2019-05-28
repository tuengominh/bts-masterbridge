import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import './App.css';
import Home from "./Home";
import Hello from "./Hello";
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
                </Router>
            </div>
        );
    }
}

export default Main;