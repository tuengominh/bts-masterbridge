import React, {Component} from 'react';
import axios from 'axios';

class Login extends Component {

    constructor(props) {
        super(props);

        this.state = {
            courseSearch: [],
            user: {
                email: "",
                password: "",
                id: "",
                username: ""
            }
        }
    }

    componentDidMount() {
        axios.get("/api/users/login").then(response => {
            this.setState({user: response.data});
        });
    }

    render() {
        return(
            <div>
                <div>
                    <div>Email: <input className={"email"} onChange={(event) => this.updateField(event, "email")} type="text"/></div>
                    <div>Password: <input onChange={(event) => this.updateField(event, "password")} type="password"/></div>
                    <div><button onClick={() => this.register()}>Sign Up</button></div>
                    <div><button onClick={() => this.login()}>Login</button></div>
                </div>
            </div>
        );
    }

    register() {
        axios.post("/api/users", this.state.user).then(response => {

        })
    }

    login() {
        axios.post("/api/users/login", this.state.user).then(response => {
            const validation = response.data;
            let text = "";

            if (validation) {
                text = document.createTextNode("Correct credentials");
            } else {
                text = document.createTextNode("Wrong password or email");
            }
        })
    }
    updateField(event, property) {
        const value = event.target.value;

        this.setState((currentState) => {
            currentState.user[property] = value;
            return currentState;
        });
    }
}

export default Login;

