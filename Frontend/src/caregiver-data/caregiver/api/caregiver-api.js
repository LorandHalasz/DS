import {HOST} from '../../../commons/hosts';
import RestApiClient from "../../../commons/api/rest-client";


const endpoint = {
    get_patients: '/patient/findAll/',
    get_medications_plan: '/medicationPerPlan/findAllPlans/',
    get_recommendation: '/tempuri/getRecommendation',
};

function getPatients(callback) {
    const loggedUser  = sessionStorage.getItem('loggedUser');
    let request = new Request(HOST.backend_api + endpoint.get_patients + JSON.parse(loggedUser).username, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getPlans(callback) {
    const loggedUser  = sessionStorage.getItem('loggedUser');
    let request = new Request(HOST.backend_api + endpoint.get_medications_plan + JSON.parse(loggedUser).username, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function getRecommendation(name, callback) {
    let request = new Request(HOST.backend_api + endpoint.get_recommendation +'?caregiverName=' + name, {
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
    getPatients,
    getPlans,
    getRecommendation
};
