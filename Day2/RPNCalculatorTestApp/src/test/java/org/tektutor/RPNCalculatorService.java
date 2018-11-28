
package org.tektutor;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RPNCalculatorService", targetNamespace = "http://tektutor.org", wsdlLocation = "http://localhost:8080/RPNCalculatorWS/services/RPNCalculator?wsdl")
public class RPNCalculatorService
    extends Service
{

    private final static URL RPNCALCULATORSERVICE_WSDL_LOCATION;
    private final static WebServiceException RPNCALCULATORSERVICE_EXCEPTION;
    private final static QName RPNCALCULATORSERVICE_QNAME = new QName("http://tektutor.org", "RPNCalculatorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/RPNCalculatorWS/services/RPNCalculator?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RPNCALCULATORSERVICE_WSDL_LOCATION = url;
        RPNCALCULATORSERVICE_EXCEPTION = e;
    }

    public RPNCalculatorService() {
        super(__getWsdlLocation(), RPNCALCULATORSERVICE_QNAME);
    }

    public RPNCalculatorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RPNCALCULATORSERVICE_QNAME, features);
    }

    public RPNCalculatorService(URL wsdlLocation) {
        super(wsdlLocation, RPNCALCULATORSERVICE_QNAME);
    }

    public RPNCalculatorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RPNCALCULATORSERVICE_QNAME, features);
    }

    public RPNCalculatorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RPNCalculatorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RPNCalculator
     */
    @WebEndpoint(name = "RPNCalculator")
    public RPNCalculator getRPNCalculator() {
        return super.getPort(new QName("http://tektutor.org", "RPNCalculator"), RPNCalculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RPNCalculator
     */
    @WebEndpoint(name = "RPNCalculator")
    public RPNCalculator getRPNCalculator(WebServiceFeature... features) {
        return super.getPort(new QName("http://tektutor.org", "RPNCalculator"), RPNCalculator.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RPNCALCULATORSERVICE_EXCEPTION!= null) {
            throw RPNCALCULATORSERVICE_EXCEPTION;
        }
        return RPNCALCULATORSERVICE_WSDL_LOCATION;
    }

}
