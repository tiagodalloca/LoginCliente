/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cotuca.unicamp;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author u15191
 */
@WebService(serviceName = "ServiceLogin")
public class ServiceLogin {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "soma")
    public Integer soma(@WebParam(name = "i") int i, @WebParam(name = "i2") int i2) {
        //TODO write your implementation code here:
        return i + i2;
    }
    
        
    
    
}
