import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";


class MedicationCForm extends React.Component{

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

    registerMedication(medication){
        return API_USERS.postMedication(medication, (result, status, error) => {
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

        console.log("New patient data:");
        console.log("Name: " + this.state.formControls.name.value);
        console.log("sideEffects: " + this.state.formControls.sideEffects.value);
        console.log("dosage: " + this.state.formControls.dosage.value);


        let doctor = {
            name: this.state.formControls.name.value,
            sideEffects: this.state.formControls.sideEffects.value,
            dosage: this.state.formControls.dosage.value
        };

        this.registerMedication(doctor);

        this.props.history.push("/doctors_page3");

    }

    render() {
        return (
          <form onSubmit={this.handleSubmit}>

              <h1>Insert new medication</h1>

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

              <p> Side Effects: </p>
              <TextInput name="sideEffects"
                         placeholder={this.state.formControls.sideEffects.placeholder}
                         value={this.state.formControls.sideEffects.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.sideEffects.touched}
                         valid={this.state.formControls.sideEffects.valid}
              />


              <p> Dosage: </p>
              <TextInput name="dosage"
                         placeholder={this.state.formControls.dosage.placeholder}
                         value={this.state.formControls.dosage.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.dosage.touched}
                         valid={this.state.formControls.dosage.valid}
              />
              {this.state.formControls.sideEffects.touched && !this.state.formControls.sideEffects.valid &&
              <div className={"error-message"}> * sideEffects must have a valid format (ex: 1990-10-10)!</div>}

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

export default MedicationCForm;
