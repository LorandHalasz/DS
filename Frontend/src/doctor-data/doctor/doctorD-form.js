import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import axios from "axios";
import {HOST} from "../../commons/hosts";


class PatientDForm extends React.Component{

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);

        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

            formControls : {

                deleteUsername: {
                    value: '',
                    placeholder: 'Patient Username',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                }

            }

        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {

    }

    handleChange = event => {

        const name = event.target.name;
        const value = event.target.value;

        const updatedControls = {
            ...this.state.formControls
        };

        const updatedFormElement = {
            ...updatedControls[name]
        };

        updatedFormElement.value = value;
        updatedFormElement.touched = true;
        updatedFormElement.valid = validate(value, updatedFormElement.validationRules);

        console.log("Element: " +  name + " validated: " + updatedFormElement.valid);

        updatedControls[name] = updatedFormElement;

        let formIsValid = true;
        for (let updatedFormElementName in updatedControls) {
            formIsValid = updatedControls[updatedFormElementName].valid && formIsValid;
        }

        this.setState({
            formControls: updatedControls,
            formIsValid: formIsValid
        });
    };

    handleSubmit(){

        console.log("Patient data:");
        console.log("Username: " + this.state.formControls.deleteUsername.value);

        let username = this.state.formControls.deleteUsername.value;


        axios.delete(HOST.backend_api + "/patient/deletePatient/" + username)
            .then(response => {
                window.location = "/doctors";
            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong username!")
            });
        window.location = "/doctors";

    }

    render() {
        return (
                <form onSubmit={this.handleSubmit}>

                    <h1>Delete patient</h1>

                    <p> Username: </p>

                    <TextInput name="deleteUsername"
                               placeholder={this.state.formControls.deleteUsername.placeholder}
                               value={this.state.formControls.deleteUsername.value}
                               onChange={this.handleChange}
                               touched={this.state.formControls.deleteUsername.touched}
                               valid={this.state.formControls.deleteUsername.valid}
                    />
                    {this.state.formControls.deleteUsername.touched && !this.state.formControls.deleteUsername.valid &&
                    <div className={"error-message"}> * Patient name must be specified!</div>}

                    <p></p>

                    <Button variant="success"
                            type={"submit"}
                            disabled={!this.state.formIsValid}>
                        Delete
                    </Button>

                    {this.state.errorStatus > 0 &&
                    <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}

                </form>

        );
    }
}

export default PatientDForm;
