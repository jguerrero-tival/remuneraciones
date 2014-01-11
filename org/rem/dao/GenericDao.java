package org.rem.dao;

import java.io.Serializable;
import java.util.List;

/**
 * A super interface for common CRUD functionality. based on <a
 * href='http://www.hibernate.org/328.html'>"Generic Data Access Objects"</a>.
 * 
 * @see <a href='http://www.hibernate.org/328.html'>Generic Data Access Objects</a>
 */
public interface GenericDao<T, ID extends Serializable> {

	public T findById(ID id, boolean lock);

	public List<T> findAll();

	public List<T> findPageByPage(int firstResult, int maxResults);

	public List<T> findByExample(T exampleInstance, String... excludeProperty);

	public T makePersistent(T entity);

	public void makeTransient(T entity);

}