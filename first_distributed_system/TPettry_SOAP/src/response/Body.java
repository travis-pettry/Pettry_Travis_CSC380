
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
 *         &lt;element ref="{http://www.example.org/stock}resturantResponse"/>
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
    "resturantResponse"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(namespace = "http://www.example.org/stock", required = true)
    protected ResturantResponse resturantResponse;

    /**
     * Gets the value of the resturantResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResturantResponse }
     *     
     */
    public ResturantResponse getResturantResponse() {
        return resturantResponse;
    }

    /**
     * Sets the value of the resturantResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResturantResponse }
     *     
     */
    public void setResturantResponse(ResturantResponse value) {
        this.resturantResponse = value;
    }

}
