import React, {Component} from 'react';
import axios from 'axios';
import logo from './logo.png';
import './App.css';

class App extends Component {

    constructor(props) {
        super();
        this.state = {
            message: "",
            courses: [{
                course_name: "",
                country: "",
                city: "",
                tuition: 0,
                //TODO: attendance & duration
                field: {
                    0: ""
                    //TODO: many tags?
                }
            }],
            courseSearches: [{
                country: "",
                city: "",
                tuition: 0,
                field: {
                    0: ""
                    //TODO: many tags?
                }
            }]
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
        const courseSearch = {
            country: this.state.courseSearches.country,
            city: this.state.courseSearches.city,
            tuition: this.state.courseSearches.tuition,
            field: this.state.courseSearches.field
        }

        axios.post("/api/find", courseSearch)
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
            if (property = "field") {
                currentState.courseSearches[property] = {0: value};
            } else {
                currentState.user[property] = value;
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
                <div>
                    <div>Find your course: <input onChange={(event) => this.updateField(event, "field")} type="text"/></div>
                    <div>Find your course: <input onChange={(event) => this.updateField(event, "country")} type="text"/></div>
                    <div><button className="findBtn" onClick={(event) => this.findCourse()}>Search</button></div>
                </div>
                <div>
                    <ul>
                        {this.state.courses.map(course => (
                            <li className="course">{course}</li>
                        ))}
                    </ul>
                </div>
            </div>
        );
    }
}

export default App;
