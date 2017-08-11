/**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.ThemeQuestion;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

 /**
 * @author Administrateur
 * @date 8 août 2017
 * @version GloriaProject V1.0
 */
public class Theme_QuestionDAO implements ICrud<ThemeQuestion> {
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(ThemeQuestion data) throws GloriaException {
		CallableStatement rqt=null;
		boolean result = false ;		
		try(Connection cnx=AccessBase.getConnection()){			
			rqt=cnx.prepareCall("{CALL ADD_THEME_QUESTION(?,?)}");
			rqt.setInt(1, data.getIdTheme());
			rqt.setInt(2, data.getIdQuestion());
			result = rqt.executeUpdate()== 1;
			
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'insertion d'un Theme_Question dans la base de données.");
		}
		return result;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(ThemeQuestion data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(ThemeQuestion data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public ThemeQuestion selectById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<ThemeQuestion> selectAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public ThemeQuestion itemBuilder(ResultSet rs) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

}
