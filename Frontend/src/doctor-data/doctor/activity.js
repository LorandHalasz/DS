import React from 'react';
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/doctor-api"
import Button from "react-bootstrap/Button";
import axios from "axios";
import {HOST} from "../../commons/hosts";
import PillDispenser from "./pillDispenser";
import Chart from "react-google-charts";


const columns = [
    {
        Header:  'Activity Name',
        accessor: 'activityName',
    },
    {
        Header:  'Start',
        accessor: 'start',
    },
    {
        Header: 'End',
        accessor: 'end',
    },
    {
        Header: 'Anomalous',
        accessor: 'anomalous',
    },
    {
        accessor: 'setNotAnomalous',
    }
];

const filters = [
    {
        accessor: 'activityName',
    },
    {
        accessor: 'start',
    },
    {
        accessor: 'end',
    },
    {
        accessor: 'anomalous'
    }
];

let data = [['Activity', 'Time']]
;

class Activity extends React.Component {

    constructor(props){
        super(props);
        this.takeField = this.takeField.bind(this);
        this.takeRecommendation = this.takeRecommendation.bind(this);
        this.fetchActivities = this.fetchActivities.bind(this);
        this.toggleForm = this.toggleForm.bind(this);
        this.updateActivity = this.updateActivity.bind(this);
        this.saveRecommendation = this.saveRecommendation.bind(this);
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
        const activityID = sessionStorage.getItem('activityID');
        const recommendation = sessionStorage.getItem('recommendation');
        console.log(loggedUser);
        if(date !== null) {
            this.fetchActivities(JSON.parse(activityUser).username, date);
            this.getAllActivitiesForChart(JSON.parse(activityUser).username, date);
        }
        if(activityID !== null) {
            this.updateActivity(activityID);
            sessionStorage.removeItem('activityID');
        }
        if(recommendation !== null) {
            this.saveRecommendation(JSON.parse(activityUser).username, recommendation);
            sessionStorage.removeItem('recommendation');
        }
    }

    updateActivity(activityID){
        const url = HOST.backend_api + "/soap/saveActivity" + '?activityID=' + activityID;
        axios.post(url)
            .then( () => {
                window.location = '/activity'
            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong data!")
            })
    }

    saveRecommendation(username, recommendation){
        const url = HOST.backend_api + "/soap/saveRecommendation" +'?patientUsername=' + username + '&recommendation=' + recommendation;
        axios.post(url)
            .then( () => {
                window.location = '/activity'
            })
            .catch(error => {
                console.log(error);
                window.alert("Wrong data!")
            })
    }

    fetchActivities(username, date) {
        return API_USERS.getActivities(username, date, (result, status, err) => {
            console.log(result);
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        activityID: x.activityID,
                        activityName: x.name,
                        start: x.start,
                        end: x.end,
                        anomalous: x.anomalous.toString(),
                        setNotAnomalous : <div><button type={'button'} onClick={() => {sessionStorage.setItem('activityID', x.activityID.toString()); window.location = '/activity' }}>No Anomalous</button></div>
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

    getAllActivitiesForChart(username, date) {
        return API_USERS.getActivitiesForChart(username, date, (result, status, err) => {
            console.log(result);
            if(result !== null && status === 200) {
                for(let {key, value} of result.entry) {
                    data.push([key, value / 60000]);
                }
                console.log("DDDDDDDDDD" + data.toString())
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

    takeRecommendation = event => {
        const value = event.target.value;

        sessionStorage.setItem("recommendation", value);

        console.log(this.state);
    };

    render() {
        let pageSize = 5;
        return (
            <div>
                <Row>
                    <Col>
                        <Card body>
                            <input type={"date"} placeholder={"Date"}
                                   name={"date"} onChange={this.takeField}
                            />
                            <Button onClick={() => {window.location = '/activity';}}>Get Activities</Button>
                        </Card>
                    </Col>
                </Row>

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
                                <hr style={{size:"3px", color:"black"}}/>
                                <PillDispenser/>
                                <hr style={{size:"3px", color:"black"}}/>
                                <input placeholder={"Recommendation"}
                                       name={"recommendation"} onChange={this.takeRecommendation}
                                />
                                <Button onClick={() => {window.location = '/activity';}}>Set Recommendation</Button>
                                <hr style={{size:"3px", color:"black"}}/>
                                <Chart
                                    width={'500px'}
                                    height={'300px'}
                                    chartType="Bar"
                                    loader={<div>Loading Chart</div>}
                                    data={data}
                                    options={{
                                        // Material design options
                                        chart: {
                                            title: 'Statistics',
                                            subtitle: 'Activities',
                                        },
                                    }}
                                    // For tests
                                    rootProps={{ 'data-testid': '2' }}
                                />
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

export default withRouter(Activity);