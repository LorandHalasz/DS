import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import {withRouter} from "react-router-dom";

import * as API_PATIENTS from "./api/patient-api"

const columns = [
    {
        Header:  'Medication Plan Id',
        accessor: 'medicationPlanId',
    },
    {
        Header:  'Medication Name',
        accessor: 'medicationName',
    },
    {
        Header: 'Dosage',
        accessor: 'dosage',
    },
    {
        Header: 'Doctor Name',
        accessor: 'doctorName',
    },
    {
        Header: 'Treatment Start Time',
        accessor: 'treatmentStartTime',
    },
    {
        Header: 'Treatment End Time',
        accessor: 'treatmentEndTime',
    },
    {
        Header: 'Remarks',
        accessor: 'remarks',
    },
];

const filters = [
    {
        accessor: 'medicationPlanId',
    },
    {
        accessor: 'medicationName',
    },
    {
        accessor: 'dosage',
    },
    {
        accessor: 'doctorName',
    },
    {
        accessor: 'treatmentStartTime',
    },
    {
        accessor: 'treatmentEndTime',
    },
    {
        accessor: 'remarks',
    },
];

class Patients extends React.Component {

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
            if(JSON.parse(loggedUser).role !== "patient") {
                this.props.history.push('/error');
            }
            else
                this.fetchMedications();
    }

    fetchMedications() {

        return API_PATIENTS.getMedications( (result, status, err) => {
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        medicationPlanId: x.medicationPlanId,
                        medicationName: x.medicationName,
                        dosage: x.dosage,
                        doctorName: x.doctorName,
                        treatmentStartTime: x.treatmentStartTime,
                        treatmentEndTime: x.treatmentEndTime,
                        remarks: x.remarks,
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
        let loggedUser = JSON.parse(sessionStorage.getItem('loggedUser'));
        return (
            <div>
                <div style={{"margin-top":"10px","margin-left":"20px"}}>
                    <p>Patient's details:</p>
                    <ul>
                        <li>
                            Name: {loggedUser.name}
                        </li>
                        <li>
                            Username: {loggedUser.username}
                        </li>
                        <li>
                            Birthdate: {loggedUser.birthdate}
                        </li>
                        <li>
                            Email: {loggedUser.email}
                        </li>
                        <li>
                            Gender: {loggedUser.gender}
                        </li>
                        <li>
                            Address: {loggedUser.address}
                        </li>
                    </ul>
                </div>
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

                {this.state.errorStatus > 0 &&
                <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}

            </div>
        );
    };

}

export default withRouter(Patients);
