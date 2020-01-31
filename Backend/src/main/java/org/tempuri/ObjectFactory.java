
package org.tempuri;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecommendationsResponse }
     * 
     */
    public GetRecommendationsResponse createGetRecommendationsResponse() {
        return new GetRecommendationsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfRecommendation }
     * 
     */
    public ArrayOfRecommendation createArrayOfRecommendation() {
        return new ArrayOfRecommendation();
    }

    /**
     * Create an instance of {@link GetRecommendations }
     * 
     */
    public GetRecommendations createGetRecommendations() {
        return new GetRecommendations();
    }

    /**
     * Create an instance of {@link Recommendation }
     * 
     */
    public Recommendation createRecommendation() {
        return new Recommendation();
    }

}
