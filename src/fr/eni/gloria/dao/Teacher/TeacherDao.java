/**
 * @author Administrateur
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao.Teacher;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Teacher;
import fr.eni.gloria.dao.ICrud;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

 /**
 * @author Administrateur
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class TeacherDao implements ICrud<Teacher>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	
	public Teacher authenticate(String login, String password)throws GloriaException{
		
		Teacher result = null;
		try (Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{CALL AUTHENTICATE_TEACHER(?,?)}");
			rqt.setString(1, login);
			rqt.setString(2, password);
			ResultSet rs = rqt.executeQuery();
			if (rs.next()) {
				result= itemBuilder(rs);
				
			}
					
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#authenticate : "+e.getMessage());
			throw new GloriaException("Erreur lors de l'authentification du teacher.");
		}
		
		
		
		return result;
		
		
	}
	
	@Override
	public boolean insert(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Teacher data) throws GloriaException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public Teacher selectById(int id) throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<Teacher> selectAll() throws GloriaException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * {@inheritedoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public Teacher itemBuilder(ResultSet rs) throws GloriaException {
		Teacher result=new Teacher();
		try {
			result.setLogin(rs.getString("login"));
			result.setLogin(rs.getString("password"));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#itemBuilder : "+e.getMessage());
			throw new GloriaException("Erreur lors de la construction du Teacher depuis la base de données.");
		}
		
		
		
		return result;
	}
	
	

}
