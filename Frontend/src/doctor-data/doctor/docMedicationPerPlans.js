import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import MedicationPerPlansCForm from "./doctorMedicationPerPlanC-form";
import MedicationFormUpdate from "./doctorMedicationU-form";
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import MedicationDForm from "./doctorMedicationD-form";

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
        Header:  'TreatmentStartTime',
        accessor: 'treatmentStartTime',
    },
    {
        Header:  'Treatment End Time',
        accessor: 'treatmentEndTime',
    },
    {
        Header: 'Remarks',
        accessor: 'remarks',
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
    }
];

class DocMedicationPerPlans extends React.Component {

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
        return false;
    }

    fetchPatients() {
        return API_USERS.getMedicationPerPlans((result, status, err) => {
            console.log(result);
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        medicationName: x.medicationName,
                        dosage: x.dosage,
                        medicationPlanId: x.medicationPlanId,
                        treatmentStartTime: x.treatmentStartTime,
                        treatmentEndTime: x.treatmentEndTime,
                        remarks: x.remarks
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
                                <MedicationPerPlansCForm registerPerson={this.refresh}>
                                </MedicationPerPlansCForm>
                                <hr style={{size:"3px", color:"black"}}/>
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

export default withRouter(DocMedicationPerPlans);
