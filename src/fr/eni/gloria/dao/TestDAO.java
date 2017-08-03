/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Test;
import fr.eni.gloria.dao.Teacher.TeacherDao;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class TestDAO implements ICrud<Test>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());

	/** 
	 * Méthode permettant d'insérer un nouveau test dans la BdD.
	 * L'id du test sera mis à jour avec l'id autogénéré par la BdD.
	 * 
	 * @param Test à insérer
	 * @return Vrai si l'insertion s'est correctement effectuée.
	 */
	@Override
	public boolean insert(Test data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{? = CALL ADD_TEST(?, ?, ?, ?, ?, ?)}");
			rqt.registerOutParameter(1, Types.INTEGER);
			rqt.setString(2, data.getTitle());
			rqt.setInt(3, data.getSuccessTreshold());
			rqt.setInt(4, data.getSemiSuccessTreshold());
			rqt.setInt(5, data.getDuration());
			rqt.setInt(6, data.getCreator().getId());
			// TODO gestion liste de questions et des nullables
			result = rqt.executeUpdate()==1;
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion du test dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de mettre à jour un test dans la BdD
	 * @param Test à mettre à jour
	 * @return Vrai si la mise à jour a fonctionné.
	 */
	@Override
	public boolean update(Test data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL MODIFY_TEST(?, ?, ?, ?, ?, ?, ?)}");
			rqt.setInt(1, data.getId());
			rqt.setString(2, data.getTitle());
			rqt.setInt(3, data.getSuccessTreshold());
			rqt.setInt(4, data.getSemiSuccessTreshold());
			rqt.setInt(5, data.getDuration());
			rqt.setInt(6, data.getCreator().getId());
			// TODO gestion liste de questions et des nullables
			result = rqt.executeUpdate()==1;
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#update : "+e.getMessage());
			throw new GloriaException("Erreur lors de la modification du test dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de supprimer de la BdD le test entré en parametre.
	 * @param Test à supprimer
	 * @return Vrai si la suppression a eu lieu.
	 */
	@Override
	public boolean delete(Test data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL DELETE_TEST(?)}");
			rqt.setInt(1, data.getId());
	
			result = rqt.executeUpdate()==1;
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#delete : "+e.getMessage());
			throw new GloriaException("Erreur lors de la suppression du test dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode permettant de retourner un test grace à son identifiant.
	 * 
	 * @param id Identifiant du test
	 * @return Test ayant l'id donné
	 */
	@Override
	public Test selectById(int id) throws GloriaException {
		Test result = null;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL FIND_BY_ID_TEST(?)}");
			rqt.setInt(1, id);	
			
			ResultSet rs = rqt.executeQuery();
			if(rs.next()){
				result = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#findById : "+e.getMessage());
			throw new GloriaException("Erreur lors de la recherche du test dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode retournant la liste des tests depuis la BdD.
	 * @return Liste des tests.
	 */
	@Override
	public List<Test> selectAll() throws GloriaException {
		List<Test> result = new ArrayList<>();
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("LIST_TESTS");			
			ResultSet rs = rqt.executeQuery();
			
			while(rs.next()){
				result.add(itemBuilder(rs));
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectAll : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de tous les tests dans la base de données.");
		}
		
		return result;
	}

	/**
	 * Méthode en charge de construire un objet Test
	 * depis la ligne courante du ResultSet donné en parametre.
	 * @param rs ResultSet à lire.
	 * @return result Test construit.
	 */
	@Override
	public Test itemBuilder(ResultSet rs) throws GloriaException {
		Test result = new Test();
		try {
			result.setId(rs.getInt("id"));
			result.setTitle(rs.getString("libelle"));
			result.setSuccessTreshold(rs.getInt("seuilAcquisition"));
			result.setSemiSuccessTreshold(rs.getInt("seuilEnCoursAcquisition"));
			result.setDuration(rs.getInt("durée")); // Pas de colonne durée dans la table test !!!!
			result.setCreator(new TeacherDao().selectById(rs.getInt("idFormateur")));
			// TODO ajout liste questions
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction du test depuis la base de données.");
		}
		return result;
	}


}
