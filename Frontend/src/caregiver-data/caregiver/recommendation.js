import React from 'react';
import {Card, Col, Row} from 'reactstrap';
import Table from "../../commons/tables/table"
import {withRouter} from "react-router-dom";

import * as API_USERS from "./api/caregiver-api"

const columns = [
    {
        Header:  'Patient',
        accessor: 'patient',
    },
    {
        Header:  'Recommendation',
        accessor: 'docRecommendation',
    }
];

const filters = [
    {
        accessor: 'patient',
    },
    {
        accessor: 'docRecommendation',
    }
];

let ok = 0;

class Recommendation extends React.Component {

    constructor(props){
        super(props);
        this.fetchRecommendation = this.fetchRecommendation.bind(this);
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
        if(ok === 0)
            this.fetchRecommendation(JSON.parse(loggedUser).name);
        ok = 1;
    }

    fetchRecommendation(name) {
        return API_USERS.getRecommendation(name, (result, status, err) => {
            console.log(result);
            if(result !== null && status === 200) {
                result.forEach( x => {
                    this.tableData.push({
                        patient: x.patient,
                        docRecommendation: x.docRecommendation
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
            </div>
        );
    };
}

export default withRouter(Recommendation);