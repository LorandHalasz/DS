import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"

import * as API_CAREGIVERS from "./api/caregiver-api"
import {withRouter} from "react-router-dom";

const columns = [
    {
        Header:  'Medication Name',
        accessor: 'medicationName',
    },
    {
        Header:  'Dosage',
        accessor: 'dosage',
    },
    {
        Header:  'Medication Plan ID',
        accessor: 'medicationPlanId',
    },
    {
        Header:  'Treatment Start Time',
        accessor: 'treatmentStartTime',
    },
    {
        Header:  'Treatment End Time',
        accessor: 'treatmentEndTime',
    },
    {
        Header: 'Remarks',
        accessor: 'remarks',
    },
    {
        Header: 'Patient name',
        accessor: 'patientName',
    }
];

const filters = [
    {
        accessor: 'medicationName',
    },
    {
        accessor: 'dosage',
    },
    {
        accessor: 'medicationPlanId',
    },
    {
        accessor: 'treatmentStartTime',
    },
    {
        accessor: 'treatmentEndTime',
    },
    {
        accessor: 'doctorName',
    },
    {
        accessor: 'patientName',
    }
];

class CaregiverPlans extends React.Component {

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
        if(JSON.parse(loggedUser).role !== "caregiver") {
            this.props.history.push('/error');
        }
        else
            this.fetchCaregivers();
    }

    fetchCaregivers() {

        return API_CAREGIVERS.getPlans( (result, status, err) => {
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        medicationName: x.medicationName,
                        dosage: x.dosage,
                        medicationPlanId: x.medicationPlanId,
                        treatmentStartTime: x.treatmentStartTime,
                        treatmentEndTime: x.treatmentEndTime,
                        remarks: x.remarks,
                        patientName: x.patientName
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

                {this.state.errorStatus > 0 &&
                <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>}

            </div>
        );
    };

}

export default withRouter(CaregiverPlans);
