
package jaxb.restaurant.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for init2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="init2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sc" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "init2", propOrder = {
    "sc"
})
public class Init2 {

    protected Object sc;

    /**
     * Gets the value of the sc property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSc() {
        return sc;
    }

    /**
     * Sets the value of the sc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSc(Object value) {
        this.sc = value;
    }

}
