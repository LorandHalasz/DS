import Button from "react-bootstrap/Button";
import React from "react";
import {withRouter} from "react-router-dom";
import {HOST} from "./commons/hosts";
import axios from "axios";

class Login extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: "",
            response: undefined,
        };

        this.takeField = this.takeField.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
        this.handleAPI = this.handleAPI.bind(this);
    }

    takeField = event => {
        const name = event.target.name;
        const value = event.target.value;

        this.setState({
            [name]: value
        });

        console.log(this.state);
    };


    handleRedirect(user) {
        switch (user.role) {
            case 'caregiver': {
                this.props.history.push('/caregiver');
                break;
            }
            case 'doctor': {
                this.props.history.push('/doctors');
                break;
            }
            case 'patient': {
                this.props.history.push('/patient');
                break;
            }
            default:
                break
        }
    }

    handleAPI(user){
        axios.post(HOST.backend_api + '/login', user)
            .then(response => {
                sessionStorage.setItem('loggedUser',JSON.stringify( response.data));
                const loggedUser  = sessionStorage.getItem('loggedUser');
                this.handleRedirect(JSON.parse(loggedUser));
                //console.log("SDDDDDDDDDDDDDD " + JSON.parse(loggedUser).username);
            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong username or password!")
            })
    }

    handleLogin() {
            let user = {
            username: this.state.username,
            password: this.state.password
        };
        this.handleAPI(user);
    }

    render() {

        const a = <div style={{padding:"5px"}}>
            <input placeholder={"Username"} name={"username"}
                   onChange={this.takeField}
            />
            <input type={"password"} placeholder={"Password"}
                   name={"password"} onChange={this.takeField}
            />
            <Button onClick={this.handleLogin}>Login</Button>
        </div>;

        const b = <div style={{padding:"5px"}}>
            <Button onClick={() => {this.props.history.push('/'); sessionStorage.removeItem("loggedUser")}}>Logout</Button>
        </div>;

        if(sessionStorage.getItem("loggedUser") === null)
            return a;
        else
            return b;
    }
}

export default withRouter(Login);
