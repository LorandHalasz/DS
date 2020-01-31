
package com.sd.assignment4.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sd.assignment4.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllActivitiesResponse_QNAME = new QName("http://services.assignment4.sd.com/", "getAllActivitiesResponse");
    private final static QName _SaveRecommendationResponse_QNAME = new QName("http://services.assignment4.sd.com/", "saveRecommendationResponse");
    private final static QName _GetAllActivities_QNAME = new QName("http://services.assignment4.sd.com/", "getAllActivities");
    private final static QName _SaveActivity_QNAME = new QName("http://services.assignment4.sd.com/", "saveActivity");
    private final static QName _GetMapResponse_QNAME = new QName("http://services.assignment4.sd.com/", "getMapResponse");
    private final static QName _SaveActivityResponse_QNAME = new QName("http://services.assignment4.sd.com/", "saveActivityResponse");
    private final static QName _GetAllPillDispenserResponse_QNAME = new QName("http://services.assignment4.sd.com/", "getAllPillDispenserResponse");
    private final static QName _GetAllPillDispenser_QNAME = new QName("http://services.assignment4.sd.com/", "getAllPillDispenser");
    private final static QName _SaveRecommendation_QNAME = new QName("http://services.assignment4.sd.com/", "saveRecommendation");
    private final static QName _GetMap_QNAME = new QName("http://services.assignment4.sd.com/", "getMap");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sd.assignment4.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MapDTO }
     * 
     */
    public MapDTO createMapDTO() {
        return new MapDTO();
    }

    /**
     * Create an instance of {@link MapDTO.Map }
     * 
     */
    public MapDTO.Map createMapDTOMap() {
        return new MapDTO.Map();
    }

    /**
     * Create an instance of {@link MapDTO.ActivityMap }
     * 
     */
    public MapDTO.ActivityMap createMapDTOActivityMap() {
        return new MapDTO.ActivityMap();
    }

    /**
     * Create an instance of {@link GetAllActivitiesResponse }
     * 
     */
    public GetAllActivitiesResponse createGetAllActivitiesResponse() {
        return new GetAllActivitiesResponse();
    }

    /**
     * Create an instance of {@link SaveRecommendationResponse }
     * 
     */
    public SaveRecommendationResponse createSaveRecommendationResponse() {
        return new SaveRecommendationResponse();
    }

    /**
     * Create an instance of {@link GetAllActivities }
     * 
     */
    public GetAllActivities createGetAllActivities() {
        return new GetAllActivities();
    }

    /**
     * Create an instance of {@link SaveActivity }
     * 
     */
    public SaveActivity createSaveActivity() {
        return new SaveActivity();
    }

    /**
     * Create an instance of {@link GetAllPillDispenserResponse }
     * 
     */
    public GetAllPillDispenserResponse createGetAllPillDispenserResponse() {
        return new GetAllPillDispenserResponse();
    }

    /**
     * Create an instance of {@link GetMapResponse }
     * 
     */
    public GetMapResponse createGetMapResponse() {
        return new GetMapResponse();
    }

    /**
     * Create an instance of {@link SaveActivityResponse }
     * 
     */
    public SaveActivityResponse createSaveActivityResponse() {
        return new SaveActivityResponse();
    }

    /**
     * Create an instance of {@link GetAllPillDispenser }
     * 
     */
    public GetAllPillDispenser createGetAllPillDispenser() {
        return new GetAllPillDispenser();
    }

    /**
     * Create an instance of {@link GetMap }
     * 
     */
    public GetMap createGetMap() {
        return new GetMap();
    }

    /**
     * Create an instance of {@link SaveRecommendation }
     * 
     */
    public SaveRecommendation createSaveRecommendation() {
        return new SaveRecommendation();
    }

    /**
     * Create an instance of {@link ActivityDTO }
     * 
     */
    public ActivityDTO createActivityDTO() {
        return new ActivityDTO();
    }

    /**
     * Create an instance of {@link PillDispenserDTO }
     * 
     */
    public PillDispenserDTO createPillDispenserDTO() {
        return new PillDispenserDTO();
    }

    /**
     * Create an instance of {@link MapDTO.Map.Entry }
     * 
     */
    public MapDTO.Map.Entry createMapDTOMapEntry() {
        return new MapDTO.Map.Entry();
    }

    /**
     * Create an instance of {@link MapDTO.ActivityMap.Entry }
     * 
     */
    public MapDTO.ActivityMap.Entry createMapDTOActivityMapEntry() {
        return new MapDTO.ActivityMap.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllActivitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getAllActivitiesResponse")
    public JAXBElement<GetAllActivitiesResponse> createGetAllActivitiesResponse(GetAllActivitiesResponse value) {
        return new JAXBElement<GetAllActivitiesResponse>(_GetAllActivitiesResponse_QNAME, GetAllActivitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRecommendationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "saveRecommendationResponse")
    public JAXBElement<SaveRecommendationResponse> createSaveRecommendationResponse(SaveRecommendationResponse value) {
        return new JAXBElement<SaveRecommendationResponse>(_SaveRecommendationResponse_QNAME, SaveRecommendationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllActivities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getAllActivities")
    public JAXBElement<GetAllActivities> createGetAllActivities(GetAllActivities value) {
        return new JAXBElement<GetAllActivities>(_GetAllActivities_QNAME, GetAllActivities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "saveActivity")
    public JAXBElement<SaveActivity> createSaveActivity(SaveActivity value) {
        return new JAXBElement<SaveActivity>(_SaveActivity_QNAME, SaveActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getMapResponse")
    public JAXBElement<GetMapResponse> createGetMapResponse(GetMapResponse value) {
        return new JAXBElement<GetMapResponse>(_GetMapResponse_QNAME, GetMapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "saveActivityResponse")
    public JAXBElement<SaveActivityResponse> createSaveActivityResponse(SaveActivityResponse value) {
        return new JAXBElement<SaveActivityResponse>(_SaveActivityResponse_QNAME, SaveActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPillDispenserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getAllPillDispenserResponse")
    public JAXBElement<GetAllPillDispenserResponse> createGetAllPillDispenserResponse(GetAllPillDispenserResponse value) {
        return new JAXBElement<GetAllPillDispenserResponse>(_GetAllPillDispenserResponse_QNAME, GetAllPillDispenserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPillDispenser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getAllPillDispenser")
    public JAXBElement<GetAllPillDispenser> createGetAllPillDispenser(GetAllPillDispenser value) {
        return new JAXBElement<GetAllPillDispenser>(_GetAllPillDispenser_QNAME, GetAllPillDispenser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRecommendation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "saveRecommendation")
    public JAXBElement<SaveRecommendation> createSaveRecommendation(SaveRecommendation value) {
        return new JAXBElement<SaveRecommendation>(_SaveRecommendation_QNAME, SaveRecommendation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.assignment4.sd.com/", name = "getMap")
    public JAXBElement<GetMap> createGetMap(GetMap value) {
        return new JAXBElement<GetMap>(_GetMap_QNAME, GetMap.class, null, value);
    }

}
