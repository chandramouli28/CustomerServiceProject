package com.customerservice.customerdetails.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.3
 * 2016-08-16T14:03:57.394-05:00
 * Generated source version: 2.7.3
 * 
 */
@WebServiceClient(name = "ServicePlanWSService", 
                  wsdlLocation = "file:/C:/BCJ-May16/Development/Workspace/Adv%20Java/CustomerServiceManager/src/main/resources/ServicePlan.wsdl",
                  targetNamespace = "http://webservice.customerdetails.customerservice.com/") 
public class ServicePlanWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.customerdetails.customerservice.com/", "ServicePlanWSService");
    public final static QName ServicePlanWSPort = new QName("http://webservice.customerdetails.customerservice.com/", "ServicePlanWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/BCJ-May16/Development/Workspace/Adv%20Java/CustomerServiceManager/src/main/resources/ServicePlan.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicePlanWSService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/BCJ-May16/Development/Workspace/Adv%20Java/CustomerServiceManager/src/main/resources/ServicePlan.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicePlanWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicePlanWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicePlanWSService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicePlanWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicePlanWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ServicePlanWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ServicePlanWS
     */
    @WebEndpoint(name = "ServicePlanWSPort")
    public ServicePlanWS getServicePlanWSPort() {
        return super.getPort(ServicePlanWSPort, ServicePlanWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicePlanWS
     */
    @WebEndpoint(name = "ServicePlanWSPort")
    public ServicePlanWS getServicePlanWSPort(WebServiceFeature... features) {
        return super.getPort(ServicePlanWSPort, ServicePlanWS.class, features);
    }

}
