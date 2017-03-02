/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginCliente.servico;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author u15191
 */
@WebService(serviceName = "WebServiceServico")
public class WebServiceServico {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "conexao")
    public void realizarConexao(@WebParam(name = "bd") MeuPreparedStatement bd) {
        bd= new MeuPreparedStatement(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    "jdbc:sqlserver://regulus:1433;databasename=GRUPO02",
    "GRUPO02", "coalafamily");
    }
    
    @WebMethod(operationName = "verificarSeExiste")
    public boolean existeUsuario(@WebParam(name = "bd") MeuPreparedStatement bd, @WebParam(name = "nome") String nome) {
        MeuResultSet resultado;
        String sql;
        sql="SELECT * FROM USUARIO WHERE NOME = @nome";
        bd.prepareStatement(sql);
        resultado=bd.executeQuery();
        if(!resultado.first())
            return false;
        
        return resultado;
    }
    
    public MeuResultSet getAcessos() throws Exception{
        MeuResultSet resultado;
        try{
            String sql;
            sql="SELECT * FROM ACESSO";
            bd.prepareStatement(sql);
            resultado=bd.executeQuery();
            if(!resultado.first())
                throw new Exception("Não há acessos cadastrados");
        }
        catch(SQLException erro)
        {
            throw new Exception("Erro ao retornar acesso");
        }
        return resultado;
    }
}
