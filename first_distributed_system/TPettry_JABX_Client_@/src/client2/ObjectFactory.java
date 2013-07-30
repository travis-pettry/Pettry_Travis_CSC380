package client2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Travis.junk package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Resturants_QNAME = new QName("", "resturants");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Travis.junk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Resturants }
     * 
     */
    public Resturants createResturants() {
        return new Resturants();
    }

    /**
     * Create an instance of {@link Resturant }
     * 
     */
    public Resturant createResturant() {
        return new Resturant();
    }

    /**
     * Create an instance of {@link MenuItem }
     * 
     */
    public MenuItem createMenuItem() {
        return new MenuItem();
    }

    /**
     * Create an instance of {@link Start2 }
     * 
     */
    public Start2 createStart() {
        return new Start2();
    }

    /**
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link Resturants }{@code >}}
//     * 
//     */
//    @XmlElementDecl(namespace = "", name = "resturants")
//    public JAXBElement<Resturants> createResturants(Resturants value) {
//        return new JAXBElement<Resturants>(_Resturants_QNAME, Resturants.class, null, value);
//    }

}
