/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cotuca.unicamp;

import java.sql.SQLException;
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
    public boolean cadastrado(int codigo) throws Exception
    {
            boolean retorno =false;
            
            return retorno;	
    }
    
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

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "verificaLogin")
    public Boolean verificaLogin(@WebParam(name = "nomeUsuario") String nomeUsuario, @WebParam(name = "senhaUsuario") String senhaUsuario) throws ClassNotFoundException, SQLException, Exception {
        MeuPreparedStatement bd = new MeuPreparedStatement(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    "jdbc:sqlserver://regulus:1433;databasename=GRUPO02",
    "GRUPO02", "coalafamily");
        
        Boolean retorno = false;
        try{

                    String sql;


                    sql="Select count(*) as todos from Usuario where nome=?";
                    bd.prepareStatement(sql);
                    bd.setString(1,nomeUsuario);
                    MeuResultSet resultado = (MeuResultSet) bd.executeQuery();
                    resultado.first();
                    retorno = resultado.getInt("todos")!=0;

            }
            catch(SQLException erro)
            {
                    throw new Exception("Falha na busca do usuário");
            }
        
        
        return retorno;
    }
    
        
    
    
}
