/**
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * Classe DBConnection utilisée seulement pour les tests JUnit car le pool de connexion ne semble par être pris en compte
 * @author adelaune2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class DBConnection {
	public static Connection getConnection() throws SQLException {
		// Chargement du pilote
		DriverManager.registerDriver(new SQLServerDriver());
		// Défnition de la chaîne de connexion
		String url = "jdbc:sqlserver://localhost:1433;databasename=GloriaProject;user=sa;password=Pa$$w0rd";
		// Ouverture de la connexion
		Connection connection = null;
		connection = DriverManager.getConnection(url);
		return connection;
	}
}