/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao.daoPourTests;

import java.sql.CallableStatement;
/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.dao.ICrud;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class CopyPromotionDAO implements ICrud<Promotion>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	
	/**
	 * Méthode permettant d'insérer une promotion
	 * dans la base de données.
	 * 
	 * @param data Promotion à insérer dans la base.
	 * @return True si l'insertion s'est correctement effectuée, False sinon.
	 */
	@Override
	public boolean insert(Promotion data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = DBConnection.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{call ADD_PROMOTION(?)}");
			rqt.setString(1, data.getTitle());
			
			result = rqt.execute();
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion de la promotion dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de mettre à jour une promotion
	 * dans la base de données.
	 * 
	 * @param data Promotion ayant les attributs modifiés.
	 * @return True si la modification s'est correctement effectuée, False sinon.
	 */
	@Override
	public boolean update(Promotion data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = DBConnection.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{call MODIFY_PROMOTION(?, ?)}");
			rqt.setInt(1, data.getId());
			rqt.setString(2, data.getTitle());
			
			result = rqt.executeUpdate() <1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#update : "+e.getMessage());
			throw new GloriaException("Erreur lors de la mise à jour de la promotion.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de supprimer une promotion 
	 * de la base de donnée.
	 * 
	 * @param Promotion à supprimer.
	 * @return True si suppression effectuée correctement, False sinon.
	 */
	@Override
	public boolean delete(Promotion data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = DBConnection.getConnection()){
			CallableStatement stm = cnx.prepareCall("{call DELETE_PROMOTION(?)}");
			stm.setInt(1, data.getId());
			result = stm.executeUpdate() < 1;
		}catch (Exception e) {
			logger.severe(this.getClass().getName()+"#delete : "+e.getMessage());
			throw new GloriaException("Erreur lors de la suppression de la promotion.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de récupérer une promotion
	 * d'après son identifiant en base de données.
	 * 
	 * @param id Identifiant de la promotion à retrouver.
	 * @return La promotion correspondant à l'id donné, null si l'id ne correspond à rien.
	 */
	@Override
	public Promotion selectById(int id) throws GloriaException {
		Promotion promotion = null;
		
		try(Connection cnx = DBConnection.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{call FIND_BY_ID_PROMOTION(?)}");
			rqt.setInt(1, id);
			ResultSet rs = rqt.executeQuery();
			
			if(rs.next()){
				promotion = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectById : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la promotion.");
		}
		return promotion;
	}

	/**
	 * Méthode permettant de récupérer la liste de
	 * l'ensemble des promotions disponibles dans la
	 * base de données.
	 * 
	 * @return La liste des promotion disponibles dans la base de données.
	 */
	@Override
	public List<Promotion> selectAll() throws GloriaException {
		List<Promotion> listePromotions = new ArrayList<Promotion>();
		
		try(Connection cnx = DBConnection.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{call LIST_PROMOTIONS()}");
			
			ResultSet rs = rqt.executeQuery();
			while(rs.next()){
				listePromotions.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectAll : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de la liste des promotions.");
		}
		return listePromotions;
	}
	
	/**
	 * Méthode permettant de construire un objet Promotion à partir
	 * de la ligne courante du ResultSet passé en paramètre.
	 * 
	 * @param ResultSet à lire 
	 * @return Objet promotion correspondant aux valeurs du ResultSet
	 */
	@Override
	public Promotion itemBuilder(ResultSet rs) throws GloriaException {
		Promotion promotion = new Promotion();
		try {
			promotion.setId(rs.getInt("id"));
			promotion.setTitle(rs.getString("libelle"));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction de la promotion.");
		}
		return promotion;
	}
}