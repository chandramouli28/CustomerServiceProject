
package com.utilityservicemanager.customerservice.registration.webservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.3
 * 2016-08-22T20:23:32.904-05:00
 * Generated source version: 2.7.3
 * 
 */
public final class ServicePlanWS_ServicePlanWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://webservice.customerservice.utilitywebservice.com/", "ServicePlanWSService");

    private ServicePlanWS_ServicePlanWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServicePlanWSService.WSDL_LOCATION;
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
      
        ServicePlanWSService ss = new ServicePlanWSService(wsdlURL, SERVICE_NAME);
        ServicePlanWS port = ss.getServicePlanWSPort();  
        
        {
        System.out.println("Invoking getServicePlan...");
        java.util.List<com.utilityservicemanager.customerservice.registration.webservice.ServicePlan> _getServicePlan__return = port.getServicePlan();
        System.out.println("getServicePlan.result=" + _getServicePlan__return);


        }

        System.exit(0);
    }

}
