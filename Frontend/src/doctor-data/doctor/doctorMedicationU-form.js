import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import axios from "axios";
import {HOST} from "../../commons/hosts";


class MedicationFormUpdate extends React.Component{

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

                sideEffects: {
                    value: '',
                    placeholder: 'Side Effects',
                    valid: false,
                    touched: false
                },

                dosage: {
                    value: '',
                    placeholder: 'Dosage',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                }

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
                    sideEffects: {value: updateUser.sideEffects},
                    dosage: {value: updateUser.dosage}
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

    upMedication(medication){
        axios.put(HOST.backend_api + "/medication/updateMedication", medication)
            .then(response => {
                window.location = "/doctors_page3";

            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong data!")
            })
    }

    handleSubmit(){

        console.log("Medication data:");
        console.log("Name: " + this.state.formControls.name.value);
        console.log("Side Effects: " + this.state.formControls.sideEffects.value);
        console.log("dosage: " + this.state.formControls.dosage.value);

        let medication = {
            name: this.state.formControls.name.value,
            sideEffects: this.state.formControls.sideEffects.value,
            dosage: this.state.formControls.dosage.value
        };

        this.upMedication(medication);

        this.props.history.push("/doctors_page3");
    }

    render() {
        return (
            <form>

                <h1>Update</h1>

                <p> Side Effects: </p>
                <TextInput name="sideEffects"
                           placeholder={this.state.formControls.sideEffects.placeholder}
                           value={this.state.formControls.sideEffects.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.sideEffects.touched}
                           valid={this.state.formControls.sideEffects.valid}
                />
                {this.state.formControls.sideEffects.touched && !this.state.formControls.sideEffects.valid &&
                <div className={"error-message"}> * Side Effects must have a valid format</div>}

                <p> Dosage: </p>
                <TextInput name="dosage"
                           placeholder={this.state.formControls.dosage.placeholder}
                           value={this.state.formControls.dosage.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.dosage.touched}
                           valid={this.state.formControls.dosage.valid}
                />
                {this.state.formControls.dosage.touched && !this.state.formControls.dosage.valid &&
                <div className={"error-message"}> * Dosage must not be empty !(</div>}


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

export default MedicationFormUpdate;
