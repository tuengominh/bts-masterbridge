import React, {Component} from 'react';
import axios from 'axios';
import logo from './logo.png';
import './App.css';

class App extends Component {

    constructor(props) {
        super();
        this.state = {
            message: "" ,
            courses: [{
                name: "",
                country: "",
                city: "",
                tuition: 0,
                //TODO: attendance & duration
                fieldOfStudy: [""]
            }],
            courseSearch: {
                country: "",
                city: "",
                tuition: 0,
                fieldOfStudy: [""]
            }
        }
    }

    componentDidMount() {
        setInterval(this.hello, 250);
        this.findCourse();
        this.getAll();
    }

    hello = () => {
        fetch('/api/hello')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    getAll() {
        fetch("/api/courses")
            .then(response => {
                this.setState(
                    { courses: response.data }
                );
            });
    }

    findCourse() {
        axios.post("/api/courses/find", this.state.courseSearch)
            .then(response => {
                const queriedCourses = response.data;
                this.setState(
                    { courses: queriedCourses }
                );
            });
    }

    updateField(event, property) {
        const value = event.target.value;
        this.setState( (currentState) => {
            if (property === "fieldOfStudy") {
                currentState.courseSearch[property] = [value]; //TODO: select many fields of study
            } else {
                currentState.courseSearch[property] = value;
            }
            return currentState;
        } );
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">{this.state.message}</h1>
                </header>
                <div className="App-body row">
                    <div className="col-md-6">Find your course: <input value={this.state.courseSearch.fieldOfStudy[0]} onChange={(event) => this.updateField(event, "fieldOfStudy")} type="text"/></div>
                </div>
                <div className="App-body row">
                    <div className="col-md-6">Location: <input value={this.state.courseSearch.country} onChange={(event) => this.updateField(event, "country")} type="text"/></div>
                </div>
                <div className="App-body row">
                    <div className="col-md-12"><button className="findBtn" onClick={(event) => this.findCourse()}>Search</button></div>
                </div>
            </div>
        );
    }
}

export default App;
