import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import Button from "react-bootstrap/Button";

const columns = [
    {
        Header:  'Patient',
        accessor: 'patient',
    },
    {
        Header:  'Medication',
        accessor: 'medication',
    },
    {
        Header: 'Date',
        accessor: 'date',
    },
    {
        Header: 'Dosage',
        accessor: 'dosage',
    },
    {
        Header: 'Intake Interval',
        accessor: 'intakeInterval',
    },
    {
        Header: 'Taken',
        accessor: 'taken',
    },
];

const filters = [
    {
        accessor: 'patient',
    },
    {
        accessor: 'medication',
    },
    {
        accessor: 'date',
    },
    {
        accessor: 'dosage',
    },
    {
        accessor: 'intakeInterval',
    },
    {
        accessor: 'taken',
    },
];

class PillDispenser extends React.Component {

    constructor(props){
        super(props);
        this.takeField = this.takeField.bind(this);
        this.fetchPillDispenser = this.fetchPillDispenser.bind(this);
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
        const activityUser  = sessionStorage.getItem('activityUser');
        const date = sessionStorage.getItem('date');
        console.log(loggedUser);
        if(date !== null)
            this.fetchPillDispenser(JSON.parse(activityUser).username, date);
    }

    fetchPillDispenser(username, date) {
        return API_USERS.getPillDispenser(username, date, (result, status, err) => {
            console.log(result);
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        patient: x.patient,
                        medication: x.medication,
                        date: x.date,
                        dosage: x.dosage,
                        intakeInterval: x.intakeInterval,
                        taken: x.taken.toString() === '0' ? 'false' : 'true',
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

    takeField = event => {
        const name = event.target.name;
        const value = event.target.value;

        sessionStorage.setItem(name, value);

        console.log(this.state);
    };

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
            </div>
        );
    };

}

export default withRouter(PillDispenser);