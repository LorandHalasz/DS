import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import CaregiverPlans from "./caregiver-plans"
import Recommendation from "./recommendation"
import * as API_CAREGIVERS from "./api/caregiver-api"
import {withRouter} from "react-router-dom";
import SockJsClient from 'react-stomp';
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
];

class Caregivers extends React.Component {

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

        return API_CAREGIVERS.getPatients( (result, status, err) => {
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        name: x.name,
                        medicalRecord: x.medicalRecord,
                        username: x.username,
                        email: x.email,
                        birthdate: x.birthdate,
                        gender: x.gender,
                        address: x.address,
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

    handleMess(mess){
        console.log(mess);
        const loggedUser  = sessionStorage.getItem('loggedUser');
        if(loggedUser === null) {
            this.props.history.push('/error');
        }
        else
        if(JSON.parse(loggedUser).userID === mess.caregiver) {
            window.alert(mess.message);
        }
        console.log(JSON.parse(loggedUser).userID);
        console.log("care " + mess.caregiver);
        return false;
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

                <CaregiverPlans> </CaregiverPlans>

                <SockJsClient url='http://localhost:8080/jsa-stomp-endpoint' topics={['/topic/sensor']}
                              onMessage={(msg) => { this.handleMess(msg); }}/>

                <hr style={{size:"3px", color:"black"}}/>

                <Recommendation> </Recommendation>

            </div>
        );
    };

}

export default withRouter(Caregivers);
