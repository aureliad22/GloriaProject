/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
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
	private static final String CALCULATE_TOTAL = "SELECT SUM(poids) as total "
												+ "	FROM questions q "
												+ "	JOIN questions_selectionnees qs ON qs.idQuestion = q.id "
												+ " WHERE idStagiaire = ? "
												+ " AND idTest = ?;";
	private static final String LIST_RESULT_TESTS_CANDIDATE = "SELECT id, libelle, seuilAcquisition, seuilEnCoursAcquisition, "
															+ "resultatCandidat "
															+ "FROM inscriptions "
															+ "JOIN tests ON id = idTest "
															+ "WHERE idStagiaire = ? "
															+ "AND resultatCandidat IS NOT NULL;";
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
	 * depuis la ligne courante du ResultSet donné en parametre.
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
			result.setDuration(rs.getInt("tempsPassage")); 
			result.setCreator(new TeacherDao().selectById(rs.getInt("idFormateur")));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction du test depuis la base de données.");
		}
		return result;
	}

	/**
	 * Méthode en charge de fournir la liste des tests
	 * auquels le candidat, dont l'identifiant est donné
	 * en paramètre, est inscrit.
	 * 
	 * @param idCandidate Identifiant du candidat.
	 * @return Liste des en-têtes de tests à passer pour ce candidat.
	 * @throws GloriaException 
	 */
	public List<Test> selectTestsByCandidateId(int idCandidate) throws GloriaException {
		//TODO Appel de la procStock LIST_TESTS_CANDIDATE
		List<Test> result = new ArrayList<Test>();
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL LIST_TESTS_CANDIDATE(?)}");
			rqt.setInt(1, idCandidate);
			ResultSet rs = rqt.executeQuery();
			
			while(rs.next()){				
				result.add(itemBuilder(rs));			
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectTestsByCandidateId : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de tous les tests du candidat dans la base de données.");
		}
		return result;
	}

	/**
	 * Méthode en charge de fournir la liste des tests complétés et leurs resultats
	 * pour un candidat dont l'identifiant est fourni en paramètre
	 * @param id
	 * @return Liste des tests complétés pour ce candidat
	 * @throws GloriaException 
	 */
	public List<Test> selectResultTestsByCandidateId(int idCandidate) throws GloriaException {
		List<Test> result = new ArrayList<Test>();
		try(Connection cnx = AccessBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(LIST_RESULT_TESTS_CANDIDATE);
			rqt.setInt(1, idCandidate);
			ResultSet rs = rqt.executeQuery();
			
			while(rs.next()){			
				Test test = new Test();	
				test.setId(rs.getInt("id"));
				test.setTitle(rs.getString("libelle"));
				test.setSuccessTreshold(rs.getInt("seuilAcquisition"));
				test.setSemiSuccessTreshold(rs.getInt("seuilEnCoursAcquisition"));
				test.setResult(rs.getInt("resultatCandidat"));
				result.add(test);
			}
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#selectResultTestsByCandidateId : "+e.getMessage());
			throw new GloriaException("Erreur lors de la récupération de tous les tests passés par le candidat dans la base de données.");
		}
		return result;
	}


	/**
	 * Méthode en charge de calculer le total attendu pour un test donné
	 * @param idTest 
	 * @param idStagiaire 
	 * @return le total pour un test
	 * @throws GloriaException 
	 */
	public int getTotal(int idCandidate, int idTest) throws GloriaException {
		int result = 0;
		ResultSet rs = null;
		try(Connection cnx = AccessBase.getConnection()){
			PreparedStatement rqt = cnx.prepareStatement(CALCULATE_TOTAL);
			rqt.setInt(1, idCandidate);
			rqt.setInt(2, idTest);			
			rs = rqt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}			
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#getTotal : "+e.getMessage());
			throw new GloriaException("Erreur lors du calcul du total attendu pour un test donné.");
		}
		return result;	
	}

}
