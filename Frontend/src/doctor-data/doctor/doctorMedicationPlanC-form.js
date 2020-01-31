import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";


class MedicationPlansCForm extends React.Component{

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);

        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

            formControls : {

                patientName: {
                    value: '',
                    placeholder: 'Patient Name',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                doctorName: {
                    value: '',
                    placeholder: 'Doctor Name',
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

    registerPerson(medicationPlan){
        return API_USERS.postMedicationPlan(medicationPlan, (result, status, error) => {
            console.log(result);

            if(result !== null && (status === 200 || status ===201)){
                console.log("Successfully inserted patient with id: " + result);
                this.props.refresh();
            } else {
                this.state.errorStatus = status;
                this.error = error;
            }
        });
    }

    handleSubmit(){

        console.log("New medication plan data:");
        console.log("patientName: " + this.state.formControls.patientName.value);
        console.log("doctorName: " + this.state.formControls.doctorName.value);

        let doctor = {
            patientName: this.state.formControls.patientName.value,
            doctorName : this.state.formControls.doctorName.value
        };

        this.registerPerson(doctor);

        this.props.history.push("/doctors_page4");
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>

                <h1>Insert new medication plan</h1>

                <p> Patient name: </p>

                <TextInput name="patientName"
                           placeholder={this.state.formControls.patientName.placeholder}
                           value={this.state.formControls.patientName.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.patientName.touched}
                           valid={this.state.formControls.patientName.valid}
                />
                {this.state.formControls.patientName.touched && !this.state.formControls.patientName.valid &&
                <div className={"error-message row"}> * Name must have at least 3 characters </div>}

                <p> Doctor name: </p>

                <TextInput name="doctorName"
                           placeholder={this.state.formControls.doctorName.placeholder}
                           value={this.state.formControls.doctorName.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.doctorName.touched}
                           valid={this.state.formControls.doctorName.valid}
                />
                {this.state.formControls.doctorName.touched && !this.state.formControls.doctorName.valid &&
                <div className={"error-message row"}> * Name must have at least 3 characters </div>}

                <p></p>

                <Button style={{"margin-right":"10px"}}
                        variant="success"
                        type={"submit"}
                        disabled={!this.state.formIsValid}
                >
                    Insert
                </Button>

                {this.state.errorStatus > 0 &&
                <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}

            </form>

        );
    }
}

export default MedicationPlansCForm;
