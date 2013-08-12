
package jaxb.restaurant.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for init1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="init1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filterConfig" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "init1", propOrder = {
    "filterConfig"
})
public class Init1 {

    protected Object filterConfig;

    /**
     * Gets the value of the filterConfig property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFilterConfig() {
        return filterConfig;
    }

    /**
     * Sets the value of the filterConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFilterConfig(Object value) {
        this.filterConfig = value;
    }

}
