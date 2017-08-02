/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public interface ICrud<T> {
	public boolean insert(T data) throws Exception;
	public boolean update(T data) throws Exception;
	public boolean delete(T data) throws Exception;
	public T selectById(int id) throws Exception;
	public List<T> selectAll() throws Exception;
	public T itemBuilder(ResultSet rs) throws Exception;
}
