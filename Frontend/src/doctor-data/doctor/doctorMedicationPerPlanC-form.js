import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";


class MedicationPerPlansCForm extends React.Component{

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);

        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

            formControls : {

                medicationName: {
                    value: '',
                    placeholder: 'Medication Name',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                dosage: {
                    value: '',
                    placeholder: 'Dosage',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                medicationPlanId: {
                    value: '',
                    placeholder: 'Medication Plan ID',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                treatmentStartTime: {
                    value: '',
                    placeholder: 'Treatment Start Time',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                treatmentEndTime: {
                    value: '',
                    placeholder: 'Treatment End Time',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
                },

                remarks: {
                    value: '',
                    placeholder: 'Remarks',
                    valid: false,
                    touched: false,
                    validationRules: {
                        isRequired: true
                    }
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

    registerPerson(medicationPerPlan){
        return API_USERS.postMedicationPerPlan(medicationPerPlan, (result, status, error) => {
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
        console.log("medicationName: " + this.state.formControls.medicationName.value);
        console.log("dosage: " + this.state.formControls.dosage.value);

        let medicationPerPlan = {
            medicationName: this.state.formControls.medicationName.value,
            dosage: this.state.formControls.dosage.value,
            medicationPlanId: this.state.formControls.medicationPlanId.value,
            treatmentStartTime: this.state.formControls.treatmentStartTime.value,
            treatmentEndTime: this.state.formControls.treatmentEndTime.value,
            remarks : this.state.formControls.remarks.value
        };

        this.registerPerson(medicationPerPlan);

        this.props.history.push("/doctors_page5");
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>

                <h1>Insert new medication per plan</h1>

                <p> Medication name: </p>

                <TextInput name="medicationName"
                           placeholder={this.state.formControls.medicationName.placeholder}
                           value={this.state.formControls.medicationName.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.medicationName.touched}
                           valid={this.state.formControls.medicationName.valid}
                />
                {this.state.formControls.medicationName.touched && !this.state.formControls.medicationName.valid &&
                <div className={"error-message row"}> * Medication name must not be empty </div>}

                <p> Dosage: </p>

                <TextInput name="dosage"
                           placeholder={this.state.formControls.dosage.placeholder}
                           value={this.state.formControls.dosage.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.dosage.touched}
                           valid={this.state.formControls.dosage.valid}
                />
                {this.state.formControls.dosage.touched && !this.state.formControls.dosage.valid &&
                <div className={"error-message row"}> * Dosage must not be empty </div>}

                <p> Medication Plan Id: </p>

                <TextInput name="medicationPlanId"
                           placeholder={this.state.formControls.medicationPlanId.placeholder}
                           value={this.state.formControls.medicationPlanId.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.medicationPlanId.touched}
                           valid={this.state.formControls.medicationPlanId.valid}
                />
                {this.state.formControls.medicationPlanId.touched && !this.state.formControls.medicationPlanId.valid &&
                <div className={"error-message row"}> * Medication Plan Id must not be empty </div>}

                <p> Treatment Start Time: </p>

                <TextInput name="treatmentStartTime"
                           placeholder={this.state.formControls.treatmentStartTime.placeholder}
                           value={this.state.formControls.treatmentStartTime.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.treatmentStartTime.touched}
                           valid={this.state.formControls.treatmentStartTime.valid}
                />
                {this.state.formControls.treatmentStartTime.touched && !this.state.formControls.treatmentStartTime.valid &&
                <div className={"error-message row"}> * Treatment Start Time must not be empty </div>}

                <p> Treatment End Time: </p>

                <TextInput name="treatmentEndTime"
                           placeholder={this.state.formControls.treatmentEndTime.placeholder}
                           value={this.state.formControls.treatmentEndTime.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.treatmentEndTime.touched}
                           valid={this.state.formControls.treatmentEndTime.valid}
                />
                {this.state.formControls.treatmentEndTime.touched && !this.state.formControls.treatmentEndTime.valid &&
                <div className={"error-message row"}> * Treatment End Time must not be empty </div>}

                <p> Remarks: </p>

                <TextInput name="remarks"
                           placeholder={this.state.formControls.remarks.placeholder}
                           value={this.state.formControls.remarks.value}
                           onChange={this.handleChange}
                           touched={this.state.formControls.remarks.touched}
                           valid={this.state.formControls.remarks.valid}
                />
                {this.state.formControls.remarks.touched && !this.state.formControls.remarks.valid &&
                <div className={"error-message row"}> * Remarks must not be empty </div>}

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

export default MedicationPerPlansCForm;
