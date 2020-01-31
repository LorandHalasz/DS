
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Recommendation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Recommendation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docRecommendation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Recommendation", propOrder = {
    "patient",
    "docRecommendation"
})
public class Recommendation {

    protected String patient;
    protected String docRecommendation;

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatient(String value) {
        this.patient = value;
    }

    /**
     * Gets the value of the docRecommendation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocRecommendation() {
        return docRecommendation;
    }

    /**
     * Sets the value of the docRecommendation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocRecommendation(String value) {
        this.docRecommendation = value;
    }

}
