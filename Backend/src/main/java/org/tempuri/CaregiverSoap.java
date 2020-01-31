
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CaregiverSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CaregiverSoap {


    /**
     * 
     * @param caregiverName
     * @return
     *     returns org.tempuri.ArrayOfRecommendation
     */
    @WebMethod(action = "http://tempuri.org/getRecommendations")
    @WebResult(name = "getRecommendationsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getRecommendations", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetRecommendations")
    @ResponseWrapper(localName = "getRecommendationsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetRecommendationsResponse")
    public ArrayOfRecommendation getRecommendations(
        @WebParam(name = "caregiverName", targetNamespace = "http://tempuri.org/")
        String caregiverName);

}
