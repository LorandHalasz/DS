import {HOST} from '../../../commons/hosts';
import RestApiClient from "../../../commons/api/rest-client";


const endpoint = {
    get_caregivers: '/user/findAllCaregivers',
    get_medications: '/medication/findAll',
    post_patient: "/patient/insertPatient",
    post_caregiver: "/user/insertCaregiver",
    post_medication: "/medication/insertMedication",
    post_medicationPlan: "/medicationPlan/insertMedicationPlan",
    post_medicationPerPlan: "/medicationPerPlan/insertMedicationPerPlan",
    get_patients: "/patient/findAll",
    get_medications_plan: "/medicationPlan/findAll",
    get_medications_per_plan: "/medicationPerPlan/findAll",
    update_patient: "/patient/updatePatient",
    activity_for_pacient: "/soap/getAllActivities",
    activity_for_chart: "/soap/getAllActivitiesForChart",
    pill_dispenser_for_pacient: "/soap/getAllPillDispenser"
};

function getCaregivers(callback) {
    let request = new Request(HOST.backend_api + endpoint.get_caregivers, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getMedications(callback) {
    let request = new Request(HOST.backend_api + endpoint.get_medications, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getPersonById(params, callback){
    let request = new Request(HOST.backend_api + endpoint.get_persons + params.id, {
       method: 'GET'
    });

    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function postPatient(patient, callback){
    let request = new Request(HOST.backend_api + endpoint.post_patient , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(patient)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function postCaregiver(caregiver, callback){
    let request = new Request(HOST.backend_api + endpoint.post_caregiver , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(caregiver)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function postMedication(caregiver, callback){
    let request = new Request(HOST.backend_api + endpoint.post_medication , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(caregiver)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function postMedicationPlan(medicationPlan, callback){
    let request = new Request(HOST.backend_api + endpoint.post_medicationPlan , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(medicationPlan)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function postMedicationPerPlan(medicationPerPlan, callback){
    let request = new Request(HOST.backend_api + endpoint.post_medicationPerPlan , {
        method: 'POST',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(medicationPerPlan)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function updatePatient(patient, callback){
    let request = new Request(HOST.backend_api + endpoint.update_patient , {
        method: 'UPDATE',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(patient)
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function getPatients(callback) {
    const loggedUser  = sessionStorage.getItem('loggedUser');
    let request = new Request(HOST.backend_api + endpoint.get_patients, {
        method: 'GET',
    });

    console.log(request.url);

    RestApiClient.performRequest(request, callback);
}

function getMedicationPlans(callback) {
    let request = new Request(HOST.backend_api + endpoint.get_medications_plan, {
        method: 'GET',
    });

    console.log(request.url);

    RestApiClient.performRequest(request, callback);
}

function getMedicationPerPlans(callback) {
    let request = new Request(HOST.backend_api + endpoint.get_medications_per_plan, {
        method: 'GET',
    });

    console.log(request.url);

    RestApiClient.performRequest(request, callback);
}

function getActivities(username, date, callback) {
    let request = new Request(HOST.backend_api + endpoint.activity_for_pacient +'?patientUsername=' + username + '&date=' + date , {
        method: 'GET',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function getActivitiesForChart(username, date, callback) {
    let request = new Request(HOST.backend_api + endpoint.activity_for_chart +'?patientUsername=' + username + '&date=' + date , {
        method: 'GET',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}

function getPillDispenser(username, date, callback) {
    let request = new Request(HOST.backend_api + endpoint.pill_dispenser_for_pacient +'?patientUsername=' + username + '&date=' + date , {
        method: 'GET',
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    });

    console.log("URL: " + request.url);

    RestApiClient.performRequest(request, callback);
}


export {
    getCaregivers,
    getPersonById,
    postPatient,
    getPatients,
    updatePatient,
    postCaregiver,
    postMedication,
    postMedicationPlan,
    postMedicationPerPlan,
    getMedications,
    getMedicationPlans,
    getMedicationPerPlans,
    getActivities,
    getActivitiesForChart,
    getPillDispenser
};
