import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import NavigationBar from './navigation-bar'
import NavigationBarWithMenu from './navigation-bar-with-menu'
import Home from './home/home';
import Doctors from './doctor-data/doctor/doctors'
import DocCaregivers from './doctor-data/doctor/docCaregivers'
import DocMedications from './doctor-data/doctor/docMedications'
import DocMedicationPlans from './doctor-data/doctor/docMedicationPlans'
import DocMedicationPerPlans from './doctor-data/doctor/docMedicationPerPlans'
import Patients from './patient-data/patient/patients'

import ErrorPage from './commons/errorhandling/error-page';
import styles from './commons/styles/project-style.css';
import Caregivers from "./caregiver-data/caregiver/caregiver";
import Activity from "./doctor-data/doctor/activity";
import PillDispenser from "./doctor-data/doctor/pillDispenser";
import Recommendation from "./caregiver-data/caregiver/recommendation";

let enums = require('./commons/constants/enums');

class App extends React.Component {


    render() {
        const loggedUser = sessionStorage.getItem("loggedUser");

        const a = <div className={styles.back}>
            <Router>
                <div>
                    <NavigationBar />
                    <Switch>

                        <Route
                            exact
                            path='/'
                            render={() => <Home/>}
                        />

                        <Route
                            exact
                            path='/doctors'
                            render={() => <Doctors/>}
                        />

                        <Route
                            exact
                            path='/doctors_page2'
                            render={() => <DocCaregivers/>}
                        />

                        <Route
                            exact
                            path='/doctors_page3'
                            render={() => <DocMedications/>}
                        />

                        <Route
                            exact
                            path='/doctors_page4'
                            render={() => <DocMedicationPlans/>}
                        />

                        <Route
                            exact
                            path='/doctors_page5'
                            render={() => <DocMedicationPerPlans/>}
                        />

                        <Route
                            exact
                            path='/patient'
                            render={() => <Patients/>}
                        />

                        <Route
                            exact
                            path='/caregiver'
                            render={() => <Caregivers/>}
                        />

                        <Route
                            exact
                            path='/activity'
                            render={() => <Activity/>}
                        />

                        <Route
                            exact
                            path='/activity'
                            render={() => <PillDispenser/>}
                        />

                        <Route
                            exact
                            path='/caregiver'
                            render={() => <Recommendation/>}
                        />

                        {/*Error*/}
                        <Route
                            exact
                            path='/error'
                            render={() => <ErrorPage/>}
                        />

                        <Route render={() =><ErrorPage/>} />
                    </Switch>
                </div>
            </Router>
        </div>;
        const b = <div className={styles.back}>
            <Router>
                <div>
                    <NavigationBarWithMenu />
                    <Switch>

                        <Route
                            exact
                            path='/'
                            render={() => <Home/>}
                        />

                        <Route
                            exact
                            path='/doctors'
                            render={() => <Doctors/>}
                        />

                        <Route
                            exact
                            path='/doctors_page2'
                            render={() => <DocCaregivers/>}
                        />

                        <Route
                            exact
                            path='/doctors_page3'
                            render={() => <DocMedications/>}
                        />

                        <Route
                            exact
                            path='/doctors_page4'
                            render={() => <DocMedicationPlans/>}
                        />

                        <Route
                            exact
                            path='/doctors_page5'
                            render={() => <DocMedicationPerPlans/>}
                        />

                        <Route
                            exact
                            path='/patient'
                            render={() => <Patients/>}
                        />

                        <Route
                            exact
                            path='/caregiver'
                            render={() => <Caregivers/>}
                        />

                        <Route
                            exact
                            path='/activity'
                            render={() => <Activity/>}
                        />

                        <Route
                            exact
                            path='/activity'
                            render={() => <PillDispenser/>}
                        />

                        <Route
                            exact
                            path='/caregiver'
                            render={() => <Recommendation/>}
                        />


                        {/*Error*/}
                        <Route
                            exact
                            path='/error'
                            render={() => <ErrorPage/>}
                        />

                        <Route render={() =><ErrorPage/>} />
                    </Switch>
                </div>
            </Router>
        </div>;
        //console.log(JSON.parse(loggedUser).role);
        if(loggedUser !== null && JSON.parse(loggedUser).role === "doctor") {
            return b;
        }
        else {
            return a;
        }
    };
}

export default App
