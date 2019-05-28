import {Component} from "react";
import React from "react";
import {Link} from "react-router-dom";

class CourseList extends Component {

    render() {
        return (
            <div>
                <h1>This is the course list.</h1>
                <div>
                    <Link to="/course">Course 1</Link>
                </div>
            </div>
        );
    }

}

export default CourseList;