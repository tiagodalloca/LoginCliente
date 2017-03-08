/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeservicelogin;

import br.cotuca.unicamp.ServiceLogin;
import br.cotuca.unicamp.ServiceLogin_Service;

/**
 *
 * @author u15191
 */
public class TesteServiceLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        br.cotuca.unicamp.ServiceLogin_Service serv = new ServiceLogin_Service();
        br.cotuca.unicamp.ServiceLogin port = serv.getServiceLoginPort();
        System.out.print(port.soma(2, 3));
    }
    
}
