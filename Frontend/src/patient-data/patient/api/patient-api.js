import {HOST} from '../../../commons/hosts';
import RestApiClient from "../../../commons/api/rest-client";


const endpoint = {
    get_medications: '/medicationPerPlan/findAll/',
};

function getMedications(callback) {
    const loggedUser  = sessionStorage.getItem('loggedUser');
    let request = new Request(HOST.backend_api + endpoint.get_medications + JSON.parse(loggedUser).username, {
        method: 'GET',
    });
    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

export {
    getMedications
};
