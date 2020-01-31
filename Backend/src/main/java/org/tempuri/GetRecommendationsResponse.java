
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getRecommendationsResult" type="{http://tempuri.org/}ArrayOfRecommendation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getRecommendationsResult"
})
@XmlRootElement(name = "getRecommendationsResponse")
public class GetRecommendationsResponse {

    protected ArrayOfRecommendation getRecommendationsResult;

    /**
     * Gets the value of the getRecommendationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRecommendation }
     *     
     */
    public ArrayOfRecommendation getGetRecommendationsResult() {
        return getRecommendationsResult;
    }

    /**
     * Sets the value of the getRecommendationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRecommendation }
     *     
     */
    public void setGetRecommendationsResult(ArrayOfRecommendation value) {
        this.getRecommendationsResult = value;
    }

}
