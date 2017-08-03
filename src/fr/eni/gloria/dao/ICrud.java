/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.ResultSet;
import java.util.List;

import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
	public interface ICrud<T> {
		public boolean insert(T data) throws GloriaException;
		public boolean update(T data) throws GloriaException;
		public boolean delete(T data) throws GloriaException;
		public T selectById(int id) throws GloriaException;
		public List<T> selectAll() throws GloriaException;
		public T itemBuilder(ResultSet rs) throws GloriaException;
	}


