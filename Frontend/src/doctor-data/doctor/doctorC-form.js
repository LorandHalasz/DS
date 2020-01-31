import React from 'react';
import validate from "./validators/doctor-validators";
import TextInput from "./fields/TextInput";
import './fields/fields.css';
import Button from "react-bootstrap/Button";
import * as API_USERS from "./api/doctor-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";


class PatientCForm extends React.Component{

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

               medicalRecord: {
                   value: '',
                   placeholder: 'Medical Record',
                   valid: false,
                   touched: false,
                   validationRules: {
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

               password: {
                   value: '',
                   placeholder: 'Password',
                   valid: false,
                   touched: false,
                   validationRules: {
                       minLength: 8,
                       isRequired: true,
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

               caregiverName: {
                   value: '',
                   placeholder: 'Caregiver Name',
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

    registerPerson(doctor){
        return API_USERS.postPatient(doctor, (result, status, error) => {
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
        console.log("Email: " + this.state.formControls.email.value);
        console.log("medicalRecord: " + this.state.formControls.medicalRecord.value);
        console.log("username: " + this.state.formControls.username.value);
        console.log("email: " + this.state.formControls.email.value);
        console.log("birthdate: " + this.state.formControls.birthdate.value);
        console.log("gender: " + this.state.formControls.gender.value);
        console.log("address: " + this.state.formControls.address.value);
        console.log("caregiverName: " + this.state.formControls.caregiverName.value);

        let doctor = {
            name: this.state.formControls.name.value,
            medicalRecord : this.state.formControls.medicalRecord.value,
            username: this.state.formControls.username.value,
            password: this.state.formControls.password.value,
            email: this.state.formControls.email.value,
            birthdate: this.state.formControls.birthdate.value,
            gender: this.state.formControls.gender.value,
            address: this.state.formControls.address.value,
            caregiverName: this.state.formControls.caregiverName.value
        };

        this.registerPerson(doctor);

        this.props.history.push("/doctors");
    }

    render() {
        return (
          <form onSubmit={this.handleSubmit}>

              <h1>Insert new patient</h1>

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

              <p> Medical Record: </p>

              <TextInput name="medicalRecord"
                         placeholder={this.state.formControls.medicalRecord.placeholder}
                         value={this.state.formControls.medicalRecord.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.medicalRecord.touched}
                         valid={this.state.formControls.medicalRecord.valid}
              />
              {this.state.formControls.medicalRecord.touched && !this.state.formControls.medicalRecord.valid &&
              <div className={"error-message row"}> * Name must have at least 3 characters </div>}

              <p> Username: </p>
              <TextInput name="username"
                         placeholder={this.state.formControls.username.placeholder}
                         value={this.state.formControls.username.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.username.touched}
                         valid={this.state.formControls.username.valid}
              />
              {this.state.formControls.username.touched && !this.state.formControls.username.valid &&
              <div className={"error-message"}> * Username must have a valid format</div>}

              <p> Password: </p>
              <TextInput type={"password"}
                         name="password"
                         placeholder={this.state.formControls.password.placeholder}
                         value={this.state.formControls.password.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.password.touched}
                         valid={this.state.formControls.password.valid}
              />
              {this.state.formControls.password.touched && !this.state.formControls.password.valid &&
              <div className={"error-message"}> * Password must have a valid format (must contain at least 8
                  characters - at least 1 number, lowercase, uppercase and special character (!@#$%^&*_) (</div>}

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

              <p> Caregiver Name: </p>
              <TextInput name="caregiverName"
                         placeholder={this.state.formControls.caregiverName.placeholder}
                         value={this.state.formControls.caregiverName.value}
                         onChange={this.handleChange}
                         touched={this.state.formControls.caregiverName.touched}
                         valid={this.state.formControls.caregiverName.valid}
              />
              {this.state.formControls.caregiverName.touched && !this.state.formControls.caregiverName.valid &&
              <div className={"error-message"}> * Caregiver must be specified!</div>}


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

export default PatientCForm;
