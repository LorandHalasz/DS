import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import MedicationCForm from "./doctorMedicationC-form";
import MedicationFormUpdate from "./doctorMedicationU-form";
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import MedicationDForm from "./doctorMedicationD-form";

const columns = [
    {
        Header:  'Name',
        accessor: 'name',
    },
    {
        Header: 'Side Effects',
        accessor: 'sideEffects',
    },
    {
        Header: 'Dosage',
        accessor: 'dosage',
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
        accessor: 'sideEffects',
    },
    {
        accessor: 'dosage',
    }
];

class DocMedications extends React.Component {

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
        return API_USERS.getMedications((result, status, err) => {
            console.log(result);
           if(result !== null && status === 200) {
               result.forEach( x => {
                   let user = {name: x.name,
                       sideEffects: x.sideEffects,
                       dosage: x.dosage
                   };
                   this.tableData.push({
                       name: x.name,
                       sideEffects: x.sideEffects,
                       dosage: x.dosage,
                       update : <div><button type={'button'} onClick={ () => { sessionStorage.setItem('updateUser',JSON.stringify(user)); window.location = '/doctors_page3'}}>Select Medication</button></div>
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
                                <MedicationCForm registerPerson={this.refresh}>
                                </MedicationCForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <MedicationDForm deletePatient={this.refresh}>
                                </MedicationDForm>
                                <hr style={{size:"3px", color:"black"}}/>
                                <MedicationFormUpdate upPatient={this.refresh}>
                                </MedicationFormUpdate>
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

export default withRouter(DocMedications);
