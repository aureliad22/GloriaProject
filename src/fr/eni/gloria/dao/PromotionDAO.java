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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.eni.gloria.beans.Promotion;
import fr.eni.gloria.utils.AccessBase;
import fr.eni.gloria.utils.GloriaException;
import fr.eni.gloria.utils.GloriaLogger;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public class PromotionDAO implements ICrud<Promotion>{
	Logger logger = GloriaLogger.getLogger(this.getClass().getName());
	
	/**
	 * {@inheritDoc}
	 * @throws GloriaException 
	 * @see fr.eni.gloria.dao.ICrud#insert(java.lang.Object)
	 */
	@Override
	public boolean insert(Promotion data) throws GloriaException {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{ADD_PROMOTION(?)}");
			rqt.setString(1, data.getTitle());
			
			result = rqt.execute();
			data.setId(rqt.getInt(1));
		} catch (SQLException e) {
			logger.severe(this.getClass().getName()+"#insert : "+e.getMessage());
			throw new GloriaException("Erreur liée à la base de données.");
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#update(java.lang.Object)
	 */
	@Override
	public boolean update(Promotion data) throws Exception {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{MODIFY_PROMOTION(?, ?)}");
			rqt.setInt(1, data.getId());
			rqt.setString(2, data.getTitle());
			
			result = rqt.executeUpdate() <1;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#delete(java.lang.Object)
	 */
	@Override
	public boolean delete(Promotion data) throws Exception {
		boolean result = false;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement stm = cnx.prepareCall("{DELETE_PROMOTION(?)}");
			stm.setInt(1, data.getId());
			result = stm.executeUpdate() < 1;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectById(int)
	 */
	@Override
	public Promotion selectById(int id) throws Exception {
		Promotion promotion = null;
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{FIND_BY_ID_PROMOTION(?)}");
			rqt.setInt(1, id);
			ResultSet rs = rqt.executeQuery();
			
			if(rs.next()){
				promotion = itemBuilder(rs);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return promotion;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#selectAll()
	 */
	@Override
	public List<Promotion> selectAll() throws Exception {
		List<Promotion> listePromotions = new ArrayList<Promotion>();
		
		try(Connection cnx = AccessBase.getConnection()){
			CallableStatement rqt = cnx.prepareCall("{FIND_ALL_PROMOTIONS()}");
			
			ResultSet rs = rqt.executeQuery();
			while(rs.next()){
				listePromotions.add(itemBuilder(rs));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return listePromotions;
	}
	/**
	 * {@inheritDoc}
	 * @see fr.eni.gloria.dao.ICrud#itemBuilder(java.sql.ResultSet)
	 */
	@Override
	public Promotion itemBuilder(ResultSet rs) throws Exception {
		Promotion promotion = new Promotion();
		promotion.setId(rs.getInt("id"));
		promotion.setTitle(rs.getString("libelle"));
		return promotion;
	}

}
