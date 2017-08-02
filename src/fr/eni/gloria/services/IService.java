/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
package fr.eni.gloria.services;

import java.util.List;

import fr.eni.gloria.utils.GloriaException;

/**
 * @author lvanhove2017
 * @date 2 août 2017
 * @version GloriaProject V1.0
 */
public interface IService<T> {
	public void add(T data) throws GloriaException;
	public void modify(T data) throws GloriaException;
	public void remove(T data) throws GloriaException;
	public List<T> getAll() throws GloriaException;
	public T getById(int id) throws GloriaException;
}
