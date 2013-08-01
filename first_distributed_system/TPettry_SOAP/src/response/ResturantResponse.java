
package response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.example.org/stock}resturants"/>
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
    "resturants"
})
@XmlRootElement(name = "resturantResponse", namespace = "http://www.example.org/stock")
public class ResturantResponse {

    @XmlElement(namespace = "http://www.example.org/stock", required = true)
    protected Resturants resturants;

    /**
     * Gets the value of the resturants property.
     * 
     * @return
     *     possible object is
     *     {@link Resturants }
     *     
     */
    public Resturants getResturants() {
        return resturants;
    }

    /**
     * Sets the value of the resturants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Resturants }
     *     
     */
    public void setResturants(Resturants value) {
        this.resturants = value;
    }

}
