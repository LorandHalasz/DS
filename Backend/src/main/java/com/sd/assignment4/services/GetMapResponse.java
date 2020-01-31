
package com.sd.assignment4.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMapResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMapResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://services.assignment4.sd.com/}mapDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMapResponse", propOrder = {
    "_return"
})
public class GetMapResponse {

    @XmlElement(name = "return")
    protected MapDTO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link MapDTO }
     *     
     */
    public MapDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapDTO }
     *     
     */
    public void setReturn(MapDTO value) {
        this._return = value;
    }

}
