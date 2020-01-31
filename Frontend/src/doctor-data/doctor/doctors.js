import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import PatientCForm from "./doctorC-form";
import PatientFormUpdate from "./doctorU-form";
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import PatientDForm from "./doctorD-form";

const columns = [
    {
        Header:  'Name',
        accessor: 'name',
    },
    {
        Header:  'Medical Record',
        accessor: 'medicalRecord',
    },
    {
        Header: 'Username',
        accessor: 'username',
    },
    {
        Header: 'Email',
        accessor: 'email',
    },
    {
        Header: 'Birthdate',
        accessor: 'birthdate',
    },
    {
        Header: 'Gender',
        accessor: 'gender',
    },
    {
        Header: 'Address',
        accessor: 'address',
    },
    {
        Header: 'Caregiver Name',
        accessor: 'caregiverName',
    },
    {
        Header: '',
        accessor: 'update',
    },
    {
        Header: '',
        accessor: 'activity',
    }
];

const filters = [
    {
        accessor: 'name',
    },
    {
        accessor: 'medicalRecord',
    },
    {
        accessor: 'username',
    },
    {
        accessor: 'email',
    },
    {
        accessor: 'birthdate',
    },
    {
        accessor: 'gender',
    },
    {
        accessor: 'address',
    },
    {
        accessor: 'caregiverName',
    }
];

class Doctors extends React.Component {

    constructor(props){
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
        this.state = {
            collapseForm: true,
            loadPage: false,
            errorStatus: 0,
            error: null
        };

        this.tableData = [];
    }

    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }

    componentDidMount() {

        const loggedUser  = sessionStorage.getItem('loggedUser');
        console.log(loggedUser);
        if(loggedUser === null) {
            this.props.history.push('/error');
        }
        else
            if(JSON.parse(loggedUser).role !== "doctor") {
                this.props.history.push('/error');
            }
            else
                this.fetchPatients();
    }

    fetchPatients() {
        return API_USERS.getPatients((result, status, err) => {
            console.log(result);
           if(result !== null && status === 200) {
               result.forEach( x => {
                   let user = {name: x.name,
                       medicalRecord: x.medicalRecord,
                       username: x.username,
                       email: x.email,
                       birthdate: x.birthdate,
                       gender: x.gender,
                       address: x.address,
                       caregiverName: x.caregiverName
                   };
                   this.tableData.push({
                       name: x.name,
                       medicalRecord: x.medicalRecord,
                       username: x.username,
                       email: x.email,
                       birthdate: x.birthdate,
                       gender: x.gender,
                       address: x.address,
                       caregiverName: x.caregiverName,
                       update : <div><button type={'button'} onClick={ () => { sessionStorage.setItem('updateUser',JSON.stringify(user)); window.location = '/doctors'}}>Select Patient</button></div>,
                       activity : <div><button type={'button'} onClick={ () => { sessionStorage.setItem('activityUser',JSON.stringify(user)); window.location = '/activity';}}>View Details</button></div>
                   });
               });
               this.forceUpdate();
           } else {
               console.log("Am prins o eroare!!!");
               this.state.errorStatus = status;
               this.state.error = err;
               this.forceUpdate();
           }
        });
    }

    refresh(){
        this.forceUpdate()
    }

    render() {
        let pageSize = 5;
        return (
            <div>
                <Row>
                    <Col>
                        <Card body>
                            <Table
                                data={this.tableData}
                                columns={columns}
                                search={filters}
                                pageSize={pageSize}
                            />
                        </Card>
                    </Col>
                </Row>

                <Row>
                    <Col>
                        <Card body>
                            <div>
                                <PatientCForm registerPerson={this.refresh}>
                                </PatientCForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <PatientDForm deletePatient={this.refresh}>
                                </PatientDForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <PatientFormUpdate upPatient={this.refresh}>
                                </PatientFormUpdate>
                            </div>
                        </Card>
                    </Col>
                </Row>

                {this.state.errorStatus > 0 &&
                <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}
            </div>
        );
    };

}

export default withRouter(Doctors);
