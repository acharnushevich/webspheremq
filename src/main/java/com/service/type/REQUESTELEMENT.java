
package com.service.type;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for REQUEST_ELEMENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REQUEST_ELEMENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SYSTEM" type="{}SYSTEM_E"/>
 *         &lt;element name="DATA" type="{}DATA_E"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "REQUEST")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REQUEST_ELEMENT", propOrder = {
    "system",
    "data"
})
public class REQUESTELEMENT {

    @XmlElement(name = "SYSTEM", required = true)
    protected SYSTEME system;
    @XmlElement(name = "DATA", required = true)
    protected DATAE data;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link SYSTEME }
     *     
     */
    public SYSTEME getSYSTEM() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link SYSTEME }
     *     
     */
    public void setSYSTEM(SYSTEME value) {
        this.system = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link DATAE }
     *     
     */
    public DATAE getDATA() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link DATAE }
     *     
     */
    public void setDATA(DATAE value) {
        this.data = value;
    }

}
