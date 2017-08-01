/**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao.Teacher;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.utils.AccessBase;


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
		CallableStatement rqt=null;
		Promotion promotion = new Promotion();

		try{
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareCall("{ADD_CANDIDATE()}");
			rqt.setString(1, candidat.getFirstName());
			rqt.setString(2, candidat.getLastName());
			rqt.setString(3, candidat.getEmail());
			rqt.setString(4, candidat.getLogin());
			rqt.setString(5, candidat.getPassword());
			rqt.setInt(6, promotion.getId());
			
			rqt.executeQuery();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de supprimer un candidat dans la BD.
	 */
	public static void supprimer(Candidate candidat) throws Exception{
		Connection cnx=null;
		CallableStatement rqt=null;
		try{
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareCall("{DELETE_CANDIDATE()}");
			rqt.setInt(1, candidat.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	/**
	 * Méthode qui permet de modifier un candidat dans la BD.
	 */
	public static void modifier(Candidate candidat) throws Exception{
		Connection cnx=null;
		CallableStatement rqt=null;
		try{
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareCall("{call MODIFY_CANDIDATE()}");
			rqt.setString(1, candidat.getFirstName());
			rqt.setString(2, candidat.getLastName());
			rqt.setString(3, candidat.getEmail());
			rqt.setString(4, candidat.getPassword());
			rqt.setString(5, candidat.getLogin());
			

			rqt.executeQuery();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	/**
	 * Méthode qui permet de rechercher un candidat dans la BD.
	 */
	public static Candidate rechercher(Candidate candidat) throws Exception{
		Connection cnx=null;
		CallableStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareCall("{call RESEARCH_CANDIDATE()}");
			rqt.setString(1, candidat.getFirstName());
			rqt.setString(2, candidat.getLastName());
			rqt.setString(3, candidat.getEmail());
			
			rs=rqt.executeQuery();
			while (rs.next()){
				candidat.setFirstName(rs.getString("nom"));		
				candidat.setFirstName(rs.getString("prenom"));	
				candidat.setFirstName(rs.getString("email"));	
				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return candidat;
	}
	
	/**
	 * Retourne la liste de candidats dans la BD.
	
	 */
	public static ArrayList<Candidate> lister() throws Exception{
		Connection cnx=null;
		CallableStatement rqt=null;
		ResultSet rs=null;
		ArrayList<Candidate> listeCandidats = new ArrayList<Candidate>();
		try{
			
			cnx=AccessBase.getConnection();
			rqt=cnx.prepareCall("{call LIST_CANDIDATE()}");
			rs=rqt.executeQuery();
			
			Candidate candidat = new Candidate();
			while (rs.next()){
				
									candidat.setFirstName(rs.getString("firstName"));
									candidat.setLastName(rs.getString("lastName"));
									candidat.setLogin(rs.getString("login"));
									candidat.setPassword(rs.getString("password"));
					
				listeCandidats.add(candidat);				
			}
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return listeCandidats;
	}

}
