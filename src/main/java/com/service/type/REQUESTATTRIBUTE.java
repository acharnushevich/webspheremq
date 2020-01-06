
package com.service.type;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for REQUEST_ATTRIBUTE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REQUEST_ATTRIBUTE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SYSTEM" type="{}SYSTEM_A"/>
 *         &lt;element name="DATA" type="{}DATA_A"/>
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
@XmlType(name = "REQUEST_ATTRIBUTE", propOrder = {
    "system",
    "data"
})
public class REQUESTATTRIBUTE {

    @XmlElement(name = "SYSTEM", required = true)
    protected SYSTEMA system;
    @XmlElement(name = "DATA", required = true)
    protected DATAA data;

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link SYSTEMA }
     *     
     */
    public SYSTEMA getSYSTEM() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link SYSTEMA }
     *     
     */
    public void setSYSTEM(SYSTEMA value) {
        this.system = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link DATAA }
     *     
     */
    public DATAA getDATA() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link DATAA }
     *     
     */
    public void setDATA(DATAA value) {
        this.data = value;
    }

}
