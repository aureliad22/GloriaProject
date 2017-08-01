/**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.gloria.beans.Candidate;


 /**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateDao {
	/**
	 * Méthode qui permet d'ajouter un candidat dans la BD.
	 */
	public static void ajouter(Candidate candidat) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;

		try{
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareStatement("insert into formations(libelle, debut, fin, description) values (?,?,?,?)");
			rqt.setString(1, formation.getLibelle());
			rqt.setDate(2, new java.sql.Date(formation.getDateDebut().getTime()));
			rqt.setDate(3, new java.sql.Date(formation.getDateFin().getTime()));
			rqt.setString(4, formation.getDescription());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de supprimer une formation dans la BD.
	 * @param formation Bean formation à supprimer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void supprimer(Formation formation) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("delete from formations where id = ?");
			rqt.setInt(1, formation.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de modifier une formation dans la BD.
	 * @param formation Bean formation à modifer.
	 * @throws SQLException Exception de type SQL.
	 */
	public static void modifier(Formation formation) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("update formations set libelle = ?, debut = ?, fin = ?, description = ? where id = ?");
			rqt.setString(1, formation.getLibelle());
			rqt.setDate(2, new java.sql.Date(formation.getDateDebut().getTime()));
			rqt.setDate(3, new java.sql.Date(formation.getDateFin().getTime()));
			rqt.setString(4,formation.getDescription());
			rqt.setInt(5, formation.getId());

			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/**
	 * Méthode qui permet de rechercher une formation dans la BD.
	 * @param formation Bean formation à rechercher.
	 * @throws SQLException Exception de type SQL.
	 */
	public static Formation rechercher(Formation formation) throws Exception{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement("select * from formations where id = ?");
			rqt.setInt(1, formation.getId());
			rs=rqt.executeQuery();
			while (rs.next()){
				formation.setLibelle(rs.getString("libelle"));				
				formation.setDateDebut(rs.getDate("debut"));
				formation.setDateFin(rs.getDate("fin"));
				formation.setDescription(rs.getString("description"));
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return formation;
	}
	
	/**
	 * Retourne la liste des formations présente dans la BD.
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws SQLException Exception de type SQL.
	 */
	public static ArrayList<Formation> lister() throws Exception{
		Connection cnx=null;
		Statement rqt=null;
		ResultSet rs=null;
		ArrayList<Formation> listeFormations = new ArrayList<Formation>();
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.createStatement();			
			rs=rqt.executeQuery("select * from formations");
			Formation formation;
			while (rs.next()){
				formation = new Formation(
									rs.getInt("id"),
									rs.getString("libelle"),
									rs.getDate("debut"),
									rs.getDate("fin"),
									rs.getString("description")
						);
				listeFormations.add(formation);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeFormations;
	}

}
