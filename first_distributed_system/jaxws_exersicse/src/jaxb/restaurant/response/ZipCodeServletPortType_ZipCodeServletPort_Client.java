
package jaxb.restaurant.response;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-11T23:34:10.355-06:00
 * Generated source version: 2.7.6
 * 
 */
public final class ZipCodeServletPortType_ZipCodeServletPort_Client {

    private static final QName SERVICE_NAME = new QName("http://Servlet/", "ZipCodeServlet");

    private ZipCodeServletPortType_ZipCodeServletPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ZipCodeServlet.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ZipCodeServlet ss = new ZipCodeServlet(wsdlURL, SERVICE_NAME);
        ZipCodeServletPortType port = ss.getZipCodeServletPort();  
        
        {
        System.out.println("Invoking getServletInfo...");
        java.lang.String _getServletInfo__return = port.getServletInfo();
        System.out.println("getServletInfo.result=" + _getServletInfo__return);


        }
        {
        System.out.println("Invoking getBus...");
        java.lang.Object _getBus__return = port.getBus();
        System.out.println("getBus.result=" + _getBus__return);


        }
        {
        System.out.println("Invoking getServletContext...");
        java.lang.Object _getServletContext__return = port.getServletContext();
        System.out.println("getServletContext.result=" + _getServletContext__return);


        }
        {
        System.out.println("Invoking init1...");
        java.lang.Object _init1_filterConfig = new java.lang.Object();
        try {
            port.init1(_init1_filterConfig);

        } catch (ServletException_Exception e) { 
            System.out.println("Expected exception: ServletException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking init...");
        try {
            port.init();

        } catch (ServletException_Exception e) { 
            System.out.println("Expected exception: ServletException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getServletName...");
        java.lang.String _getServletName__return = port.getServletName();
        System.out.println("getServletName.result=" + _getServletName__return);


        }
        {
        System.out.println("Invoking init2...");
        java.lang.Object _init2_sc = new java.lang.Object();
        try {
            port.init2(_init2_sc);

        } catch (ServletException_Exception e) { 
            System.out.println("Expected exception: ServletException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking setBus...");
        java.lang.Object _setBus_bus = new java.lang.Object();
        port.setBus(_setBus_bus);


        }
        {
        System.out.println("Invoking log1...");
        java.lang.String _log1_message = "";
        java.lang.Object _log1_t = new java.lang.Object();
        port.log1(_log1_message, _log1_t);


        }
        {
        System.out.println("Invoking service...");
        java.lang.Object _service_req = new java.lang.Object();
        java.lang.Object _service_res = new java.lang.Object();
        try {
            port.service(_service_req, _service_res);

        } catch (IOException_Exception e) { 
            System.out.println("Expected exception: IOException has occurred.");
            System.out.println(e.toString());
        } catch (ServletException_Exception e) { 
            System.out.println("Expected exception: ServletException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking destroyBus...");
        port.destroyBus();


        }
        {
        System.out.println("Invoking getInitParameter...");
        java.lang.String _getInitParameter_name = "";
        java.lang.String _getInitParameter__return = port.getInitParameter(_getInitParameter_name);
        System.out.println("getInitParameter.result=" + _getInitParameter__return);


        }
        {
        System.out.println("Invoking log...");
        java.lang.String _log_msg = "";
        port.log(_log_msg);


        }
        {
        System.out.println("Invoking doFilter...");
        java.lang.Object _doFilter_request = new java.lang.Object();
        java.lang.Object _doFilter_response = new java.lang.Object();
        java.lang.Object _doFilter_chain = new java.lang.Object();
        try {
            port.doFilter(_doFilter_request, _doFilter_response, _doFilter_chain);

        } catch (IOException_Exception e) { 
            System.out.println("Expected exception: IOException has occurred.");
            System.out.println(e.toString());
        } catch (ServletException_Exception e) { 
            System.out.println("Expected exception: ServletException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getInitParameterNames...");
        java.lang.Object _getInitParameterNames__return = port.getInitParameterNames();
        System.out.println("getInitParameterNames.result=" + _getInitParameterNames__return);


        }
        {
        System.out.println("Invoking getServletConfig...");
        java.lang.Object _getServletConfig__return = port.getServletConfig();
        System.out.println("getServletConfig.result=" + _getServletConfig__return);


        }
        {
        System.out.println("Invoking destroy...");
        port.destroy();


        }

        System.exit(0);
    }

}