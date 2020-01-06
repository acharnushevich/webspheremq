
package com.service.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DATA_E complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DATA_E">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MESSAGE">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PERSON_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TEXT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATA_E", propOrder = {
    "message"
})
public class DATAE {

    @XmlElement(name = "MESSAGE", required = true)
    protected DATAE.MESSAGE message;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link DATAE.MESSAGE }
     *     
     */
    public DATAE.MESSAGE getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link DATAE.MESSAGE }
     *     
     */
    public void setMESSAGE(DATAE.MESSAGE value) {
        this.message = value;
    }


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
     *         &lt;element name="PERSON_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TEXT" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "personid",
        "date",
        "text"
    })
    public static class MESSAGE {

        @XmlElement(name = "PERSON_ID", required = true)
        protected String personid;
        @XmlElement(name = "DATE", required = true)
        protected String date;
        @XmlElement(name = "TEXT", required = true)
        protected String text;

        /**
         * Gets the value of the personid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPERSONID() {
            return personid;
        }

        /**
         * Sets the value of the personid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPERSONID(String value) {
            this.personid = value;
        }

        /**
         * Gets the value of the date property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDATE() {
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
        public void setDATE(String value) {
            this.date = value;
        }

        /**
         * Gets the value of the text property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTEXT() {
            return text;
        }

        /**
         * Sets the value of the text property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTEXT(String value) {
            this.text = value;
        }

    }

}
