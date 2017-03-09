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
	 * Operação de Web service
	 */
	@WebMethod(operationName = "verificaLogin")
	public Boolean verificaLogin(@WebParam(name = "nomeUsuario") String nomeUsuario, @WebParam(name = "senhaUsuario") String senhaUsuario) {
		try {
			MeuPreparedStatement bd = new MeuPreparedStatement(
				"com.microsoft.sqlserver.jdbc.SQLServerDriver",
				"jdbc:sqlserver://regulus:1433;databasename=BD15191",
				"BD15191", "uregis191");
			Boolean retorno = false;
			try {

				String sql;

				sql = "Select count(*) as todos from Usuario where nome=? AND senha=?";
				bd.prepareStatement(sql);
				bd.setString(1, nomeUsuario);
				bd.setString(2, senhaUsuario);
				MeuResultSet resultado = (MeuResultSet) bd.executeQuery();
				resultado.first();
				retorno = resultado.getInt("todos") != 0;

			} catch (SQLException erro) {
				throw new Exception("Falha na busca do usuário");
			}

			return retorno;
		} catch (Exception e) {
			return false;
		}
	}
}
