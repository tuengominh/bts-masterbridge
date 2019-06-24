import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import './app.css';
import Home from "./home/home";
import Hello from "./hello/hello";
import HelloName from "./hello/helloName";
import Navbar from "./layout/navbar";
import Search from "./search/search";
import Footer from "./layout/footer";
import Course from "./course/course";
import Login from "./layout/login";
import Calculator from "./calculator/landing";

class Routes extends Component {

    render() {
        return (
            <div className="App">
                <Router>
                    <header className="App-header">
                        <Navbar/>
                    </header>

                    <Route path={"/"} exact component={Home} />
                    <Route path={"/calculator"} exact component={Calculator} />
                    <Route path={"/search"} exact component={Search} />
                    <Route path={"/login"} exact component={Login} />
                    <Route path={"/hello"} exact component={Hello} />

                    <Route path={"/hello/:name"} render={props => <HelloName name={props.match.params.name}/>} />

                    <Route path={"/course"} exact component={Course} />
                    <Route path={"/course/:id"} render={props => <Course id={props.match.params.id}/>} />

                    <footer>
                        <Footer/>
                    </footer>
                </Router>
            </div>
        );
    }
}

export default Routes;