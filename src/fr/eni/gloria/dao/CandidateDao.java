/**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Candidate;
import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;


 /**
 * @author Administrateur
 * @date 1 août 2017
 * @version GloriaProject V1.0
 */
public class CandidateDao implements ICrud<Candidate>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	
	/**
	 * 
	 * Méthode permettant d'authentifier un candidat d'après
	 * son login et son mot de passe. Le login peut être
	 * l'adresse email ou le login.
	 *  
	 * @param login Adresse e-mail ou login du candidat.
	 * @param password Mot de passe du candidat
	 * @return Le candidat correspondant au couple login/mot de passe fourni.
 	 * 
	 * @throws GloriaException
	 */
	public Candidate authenticate(String login, String password) throws GloriaException{
		Candidate result = null ;
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL AUTHENTICATE_CANDIDATE(?, ?)}");
			rqt.setString(1, login);
			rqt.setString(2, password);
			ResultSet rs= rqt.executeQuery();
			if (rs.next()) {
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#authenticate : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'authentification du candidat.");
		}
			
		return result;
	}
	
	/**
	 * Méthode qui permet de rechercher un candidat dans la BD
	 * d'après ses nom, prenom, et adresse e-mail.
	 * 
	 * @param lastName Patronyme du candidat
	 * @param firstName Prénom du candidat
	 * @param email Adresse e-mail du candidat
	 * @return Le candidat correspondant aux critères données s'il existe, null sinon.
	 */
	public Candidate search(String lastName, String firstName, String email) throws GloriaException{
		Candidate result = null;
		try(Connection cnx=AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL RESEARCH_CANDIDATE(?,?,?)}");
			rqt.setString(1, lastName);
			rqt.setString(2, firstName);
			rqt.setString(3, email);
			
			ResultSet rs=rqt.executeQuery();
			if (rs.next()){
				result = itemBuilder(rs);
			}
			
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#search : "+e.getMessage());
			throw new GloriaException("Erreur lors de la recherche du candidat dans la base de données.");
		}
		
		return result;
	}
	
	/**
	 * Méthode permettant d'inserer un nouveau Candidat dans la
	 * base de données. L'id du candidat sera mis à jour avec 
	 * l'identifiant auto-généré par la base de données.
	 * 
	 * @param Candidat à insérer
	 * @return Vrai si l'insertion s'est effectuée correctement, faux sinon.
	 */
	@Override
	public boolean insert(Candidate data) throws GloriaException {

		CallableStatement rqt=null;
		Promotion promotion = new Promotion();
		boolean result = false ;
		try(Connection cnx=AccessBase.getConnection()){
			
			rqt=cnx.prepareCall("{ADD_CANDIDATE()}");
			rqt.setString(1, data.getFirstName());
			rqt.setString(2, data.getLastName());
			rqt.setString(3, data.getEmail());
			rqt.setString(4, data.getLogin());
			rqt.setString(5, data.getPassword());
			rqt.setInt(6, promotion.getId());
			
			result = rqt.executeUpdate()<1;
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion du candidat dans la base de données.");
		}
		return result;
	}
	
	/**
	 * Méthode permettant de mettre à jour un candidat dans la base de données.
	 * 
	 * @param Candidat mis à jour
	 * @return true si la mise à jour s'est correctement effectuée, faux sinon.
	 */
	@Override
	public boolean update(Candidate data) throws GloriaException {
		boolean result = false ;
		
		try(Connection cnx=AccessBase.getConnection()){
			CallableStatement rqt=cnx.prepareCall("{call MODIFY_CANDIDATE()}");
			rqt.setString(1, data.getFirstName());
			rqt.setString(2, data.getLastName());
			rqt.setString(3, data.getEmail());
			rqt.setString(4, data.getPassword());
			rqt.setString(5, data.getLogin());
			
			result = rqt.executeUpdate() <1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#update : "+e.getMessage());
			throw new GloriaException("Erreur lors de la mise à jour du candidat dans la base de données.");
		}
		return result;
	}
	
	/**
	 * Méthode permettant de supprimer de la base de données le 
	 * candidat donné en paramètre.
	 * 
	 * @param Candidat à supprimer.
	 * @return true si la suppression à réussi, faux sinon.
	 */
	@Override
	public boolean delete(Candidate data) throws GloriaException {
		boolean result = false ;
		try(Connection cnx=AccessBase.getConnection()){
			
			CallableStatement rqt=cnx.prepareCall("{DELETE_CANDIDATE()}");
			rqt.setInt(1, data.getId());
			result = rqt.executeUpdate() <1 ;
			
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#update : "+e.getMessage());
			throw new GloriaException("Erreur lors de la suppression du candidat dans la base de données.");
		}
		return result ;
	}
	
	/**
	 * Méthode permettant d'obtenir un candidat d'après son identifiant
	 * 
	 * @param id Identifiant du candidat
	 * @return Le candidat ayant l'identifiant id
	 */
	@Override
	public Candidate selectById(int id) throws GloriaException {
		Candidate result = null ;
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{call FIND_BY_ID_CANDIDATE(?)}");
			rqt.setInt(1, id);
			ResultSet rs=rqt.executeQuery();
			if (rs.next()){
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#findById : "+e.getMessage());
			throw new GloriaException("Erreur lors de la recherche du candidat dans la base de données.");
		}
			
		return result;
	}
	
	/**
	 * Méthode en charge de construire la liste des candidats 
	 * depuis la base de données.
	 * 
	 * @return La liste des candidats existants.
	 */
	@Override
	public List<Candidate> selectAll() throws GloriaException {
		List<Candidate> result = new ArrayList<Candidate>();
		try(Connection cnx=AccessBase.getConnection()){
			CallableStatement rqt=cnx.prepareCall("{call LIST_CANDIDATES()}");
			ResultSet rs=rqt.executeQuery();
			
			while (rs.next()){
				result.add(itemBuilder(rs));				
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectAll : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste des candidats.");
		} 
		
		return result;
	}

	/**
	 * Méthode en charge de construire un object candidat 
	 * depuis la ligne courante du ResultSet donné en paramètre.
	 * @param rs ResultSet à lire
	 * @return result Candidate construit à partir de rs.
	 * 
	 */
	@Override
	public Candidate itemBuilder(ResultSet rs) throws GloriaException {
		Candidate result = new Candidate();
		try {
			result.setId(rs.getInt("id"));
			result.setFirstName(rs.getString("firstName"));
			result.setLastName(rs.getString("lastName"));
			result.setEmail(rs.getString("email"));
			result.setLogin(rs.getString("login"));
			result.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction du candidat depuis la base de données.");
		}
		return result;
	}

}