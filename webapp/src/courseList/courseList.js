import {Component} from "react";
import React from "react";
import {Link} from "react-router-dom";

class CourseList extends Component {

    render() {
        return (
            <div>
                <h1>This is the course list.</h1>
                <div>
                    <Link to="/course/5cd8687c1c9d440000d7f7a3">Course 1</Link>
                </div>
            </div>
        );
    }
}

export default CourseList;

