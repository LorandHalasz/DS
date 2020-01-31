import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import axios from "axios";
import {HOST} from "../../commons/hosts";


class CaregiverFormUpdate extends React.Component{

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);

        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

            formControls : {

                name: {
                    value: '',
                    placeholder: 'Name',
                    valid: false,
                    touched: false,
                    validationRules: {
                        minLength: 3,
                        isRequired: true
                    }
                },

                username: {
                    value: '',
                    placeholder: 'Username',
                    valid: false,
                    touched: false,
                    validationRules: {
                        minLength: 5,
                        isRequired: true
                    }
                },

                email: {
                    value: '',
                    placeholder: 'ex. name@dom.com',
                    valid: false,
                    touched: false,
                    validationRules: {
                        emailValidator: true
                    }
                },

                birthdate: {
                    value: '',
                    placeholder: 'YYYY-MM-DD',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                gender: {
                    value: '',
                    placeholder: 'M/F',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true,
                        genderValidator: true
                    }
                },

                address: {
                    value: '',
                    placeholder: 'Str. X, nr. X, ...',
                    valid: false,
                    touched: false,
                },

            },
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {
        const updateUser  = JSON.parse(sessionStorage.getItem('updateUser'));

        if(updateUser !== null){

            this.setState({
                formControls: {
                    name: {value: updateUser.name},
                    username: {value: updateUser.username},
                    email: {value: updateUser.email},
                    birthdate: {value: updateUser.birthdate},
                    gender: {value: updateUser.gender},
                    address: {value: updateUser.address},
                }
            });
            sessionStorage.removeItem('updateUser');
        }
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

        console.log("Element: " + name + " validated: " + updatedFormElement.valid);

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

    upCaregiver(doctor){
        axios.put(HOST.backend_api + "/user/updateCaregiver", doctor)
            .then(response => {
                window.location = "/doctors_page2";

            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong data!")
            })
    }

    handleSubmit(){

        console.log("Caregiver data:");
        console.log("Name: " + this.state.formControls.name.value);
        console.log("Email: " + this.state.formControls.email.value);
        console.log("username: " + this.state.formControls.username.value);
        console.log("email: " + this.state.formControls.email.value);
        console.log("birthdate: " + this.state.formControls.birthdate.value);
        console.log("gender: " + this.state.formControls.gender.value);
        console.log("address: " + this.state.formControls.address.value);

        let caregiver = {
            name: this.state.formControls.name.value,
            username: this.state.formControls.username.value,
            email: this.state.formControls.email.value,
            birthdate: this.state.formControls.birthdate.value,
            gender: this.state.formControls.gender.value,
            address: this.state.formControls.address.value,
        };

        this.upCaregiver(caregiver);
        window.location = "/doctors_page2";
    }

    render() {
        return (
            <form>

                <h1>Update</h1>

                <p> Name: </p>

                <TextInput name="name"
                           placeholder={this.state.formControls.name.placeholder}
                           value={this.state.formControls.name.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.name.touched}
                           valid={this.state.formControls.name.valid}
                />
                {this.state.formControls.name.touched && !this.state.formControls.name.valid &&
                <div className={"error-message row"}> * Name must have at least 3 characters </div>}

                <p> Email: </p>
                <TextInput name="email"
                           placeholder={this.state.formControls.email.placeholder}
                           value={this.state.formControls.email.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.email.touched}
                           valid={this.state.formControls.email.valid}
                />
                {this.state.formControls.email.touched && !this.state.formControls.email.valid &&
                <div className={"error-message"}> * Email must have a valid format</div>}

                <p> Birthdate: </p>
                <TextInput name="birthdate"
                           placeholder={this.state.formControls.birthdate.placeholder}
                           value={this.state.formControls.birthdate.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.birthdate.touched}
                           valid={this.state.formControls.birthdate.valid}
                />
                {this.state.formControls.birthdate.touched && !this.state.formControls.birthdate.valid &&
                <div className={"error-message"}> * Birthdate must have a valid format (ex: 1990-10-10)!</div>}

                <p> Gender: </p>
                <TextInput name="gender"
                           placeholder={this.state.formControls.gender.placeholder}
                           value={this.state.formControls.gender.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.gender.touched}
                           valid={this.state.formControls.gender.valid}
                />
                {this.state.formControls.gender.touched && !this.state.formControls.gender.valid &&
                <div className={"error-message"}> * Gender must be M for male or F for female!(</div>}

                <p> Address: </p>
                <TextInput name="address"
                           placeholder={this.state.formControls.address.placeholder}
                           value={this.state.formControls.address.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.address.touched}
                           valid={this.state.formControls.address.valid}
                />


                <p></p>

                <Button variant="success"
                        type={"submit"}
                        onClick={this.handleSubmit}>
                    Update
                </Button>

                {this.state.errorStatus > 0 &&
                <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}

            </form>

        );
    }
}

export default CaregiverFormUpdate;
