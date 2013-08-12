
package jaxb.restaurant.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setBus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setBus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bus" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setBus", propOrder = {
    "bus"
})
public class SetBus {

    protected Object bus;

    /**
     * Gets the value of the bus property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBus() {
        return bus;
    }

    /**
     * Sets the value of the bus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBus(Object value) {
        this.bus = value;
    }

}
