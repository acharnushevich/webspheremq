
package com.service.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SYSTEM_E complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SYSTEM_E">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="REQUEST_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="REPLY_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SYSTEM_E", propOrder = {
    "requestid",
    "replyid"
})
public class SYSTEME {

    @XmlElement(name = "REQUEST_ID", required = true)
    protected String requestid;
    @XmlElement(name = "REPLY_ID", required = true)
    protected String replyid;

    /**
     * Gets the value of the requestid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREQUESTID() {
        return requestid;
    }

    /**
     * Sets the value of the requestid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREQUESTID(String value) {
        this.requestid = value;
    }

    /**
     * Gets the value of the replyid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPLYID() {
        return replyid;
    }

    /**
     * Sets the value of the replyid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPLYID(String value) {
        this.replyid = value;
    }

}
