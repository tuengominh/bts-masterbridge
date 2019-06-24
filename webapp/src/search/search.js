import {Component} from "react";
import React from "react";
import SearchBar from "./searchFilters";
import CourseList from "../courseList/courseList";

class Search extends Component {

    render() {
        return (
            <div>
                <SearchBar />
                <CourseList />
            </div>
        );
    }

}

export default Search;