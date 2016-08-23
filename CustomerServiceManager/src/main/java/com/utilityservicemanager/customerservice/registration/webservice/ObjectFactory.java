
package com.utilityservicemanager.customerservice.registration.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.utilityservicemanager.customerservice.registration.webservice package. 
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

    private final static QName _GetServicePlanResponse_QNAME = new QName("http://webservice.customerservice.utilitywebservice.com/", "getServicePlanResponse");
    private final static QName _GetServicePlan_QNAME = new QName("http://webservice.customerservice.utilitywebservice.com/", "getServicePlan");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.utilityservicemanager.customerservice.registration.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServicePlan }
     * 
     */
    public GetServicePlan createGetServicePlan() {
        return new GetServicePlan();
    }

    /**
     * Create an instance of {@link ServicePlan }
     * 
     */
    public ServicePlan createServicePlan() {
        return new ServicePlan();
    }

    /**
     * Create an instance of {@link GetServicePlanResponse }
     * 
     */
    public GetServicePlanResponse createGetServicePlanResponse() {
        return new GetServicePlanResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServicePlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.customerservice.utilitywebservice.com/", name = "getServicePlanResponse")
    public JAXBElement<GetServicePlanResponse> createGetServicePlanResponse(GetServicePlanResponse value) {
        return new JAXBElement<GetServicePlanResponse>(_GetServicePlanResponse_QNAME, GetServicePlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServicePlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.customerservice.utilitywebservice.com/", name = "getServicePlan")
    public JAXBElement<GetServicePlan> createGetServicePlan(GetServicePlan value) {
        return new JAXBElement<GetServicePlan>(_GetServicePlan_QNAME, GetServicePlan.class, null, value);
    }

}
