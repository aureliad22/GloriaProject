/**
 * @author Administrateur
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

 /**
 * @author Administrateur
 * @date 31 juil. 2017
 * @version GloriaProject V1.0
 */
public class AccessBase {
	/**
	 * Méthode qui permet de récupérer une connection à la BD.
	 * @return Connection
	 * @throws SQLException Exception de type SQL.
	 */
	public static Connection getConnection() throws Exception{
		
		Connection cnx=null;
		try {
			Context jndi = new InitialContext();
			DataSource ds = (DataSource) jndi.lookup("java:comp/env/jdbc/DSGloria");
			cnx = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new Exception("L'accès à la base de données est impossible pour le moment");
		}
		return cnx;
	}

}