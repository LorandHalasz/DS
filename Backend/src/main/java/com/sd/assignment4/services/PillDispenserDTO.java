
package com.sd.assignment4.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pillDispenserDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pillDispenserDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dosage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intakeInterval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pillDispenserID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="taken" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pillDispenserDTO", propOrder = {
    "date",
    "dosage",
    "intakeInterval",
    "medication",
    "patient",
    "pillDispenserID",
    "taken"
})
public class PillDispenserDTO {

    protected String date;
    protected String dosage;
    protected String intakeInterval;
    protected String medication;
    protected String patient;
    protected Integer pillDispenserID;
    protected Integer taken;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the dosage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Sets the value of the dosage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDosage(String value) {
        this.dosage = value;
    }

    /**
     * Gets the value of the intakeInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntakeInterval() {
        return intakeInterval;
    }

    /**
     * Sets the value of the intakeInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntakeInterval(String value) {
        this.intakeInterval = value;
    }

    /**
     * Gets the value of the medication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedication() {
        return medication;
    }

    /**
     * Sets the value of the medication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedication(String value) {
        this.medication = value;
    }

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
     * Gets the value of the pillDispenserID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPillDispenserID() {
        return pillDispenserID;
    }

    /**
     * Sets the value of the pillDispenserID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPillDispenserID(Integer value) {
        this.pillDispenserID = value;
    }

    /**
     * Gets the value of the taken property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaken() {
        return taken;
    }

    /**
     * Sets the value of the taken property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaken(Integer value) {
        this.taken = value;
    }

}
