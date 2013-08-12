
package jaxb.restaurant.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for service complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="req" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="res" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "service", propOrder = {
    "req",
    "res"
})
public class Service {

    protected Object req;
    protected Object res;

    /**
     * Gets the value of the req property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getReq() {
        return req;
    }

    /**
     * Sets the value of the req property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setReq(Object value) {
        this.req = value;
    }

    /**
     * Gets the value of the res property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRes() {
        return res;
    }

    /**
     * Sets the value of the res property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRes(Object value) {
        this.res = value;
    }

}
