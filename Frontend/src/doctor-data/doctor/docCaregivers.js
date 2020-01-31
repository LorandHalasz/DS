import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import CaregiverCForm from "./doctorCaregiverC-form";
import CaregiverFormUpdate from "./doctorCaregiverU-form";
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import CaregiverDForm from "./doctorCaregiverD-form";

const columns = [
    {
        Header:  'Name',
        accessor: 'name',
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
        Header: '',
        accessor: 'update',
    }
];

const filters = [
    {
        accessor: 'name',
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
];

class DocCaregivers extends React.Component {

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
        return API_USERS.getCaregivers((result, status, err) => {
            console.log(result);
           if(result !== null && status === 200) {
               result.forEach( x => {
                   let user = {name: x.name,
                       username: x.username,
                       email: x.email,
                       birthdate: x.birthdate,
                       gender: x.gender,
                       address: x.address
                   };
                   this.tableData.push({
                       name: x.name,
                       username: x.username,
                       email: x.email,
                       birthdate: x.birthdate,
                       gender: x.gender,
                       address: x.address,
                       update : <div><button type={'button'} onClick={ () => { sessionStorage.setItem('updateUser',JSON.stringify(user)); window.location = '/doctors_page2'}}>Select Caregiver</button></div>
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
                                <CaregiverCForm registerPerson={this.refresh}>
                                </CaregiverCForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <CaregiverDForm deletePatient={this.refresh}>
                                </CaregiverDForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <CaregiverFormUpdate upPatient={this.refresh}>
                                </CaregiverFormUpdate>
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

export default withRouter(DocCaregivers);
