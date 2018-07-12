package com.accolite.hrms.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author Yogesh Chaturvedi
 * 
 * 
 */

@Transactional
public abstract class BaseService<T, R extends CrudRepository<T, ID>, ID extends Serializable> {

	@Autowired R repository;
	
	/**
	 * Saves a given entity. 
	 *  
	 * @param entity
	 * @return the saved entity
	 */
	@Transactional()
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public <S extends T> Iterable<S> save(Iterable<S> entities){
		return repository.save(entities);
	}

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public T findOne(ID id) {
		return repository.findOne(id);
	}

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id must not be {@literal null}.
	 * @return true if an entity with the given id exists, {@literal false} otherwise
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public boolean exists(ID id) {
		return repository.exists(id);
	}

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	public Iterable<T> findAll(){
		return repository.findAll();
	}

	/**
	 * Returns all instances of the type with the given IDs.
	 * 
	 * @param ids
	 * @return
	 */
	public Iterable<T> findAll(Iterable<ID> ids){
		return repository.findAll();
	}
	
	/**
	 * Returns all instances of the type with the given IDs.
	 * 
	 * @param ids
	 * @return
	 */
	public Iterable<T> findAll(Long ids){
		return repository.findAll();
	}

	/**
	 * Returns the number of entities available.
	 * 
	 * @return the number of entities
	 */
	public long count() {
		return repository.count();
	}

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
	 */
	public void delete(ID id) {
		repository.delete(id);
	}

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	public void delete(T entity) {
		repository.delete(entity);
	}

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 * @throws IllegalArgumentException in case the given {@link Iterable} is {@literal null}.
	 */
	public void delete(Iterable<? extends T> entities) {
		repository.delete(entities);
	}

	/**
	 * Deletes all entities managed by the repository.
	 */
	public void deleteAll() {
		repository.deleteAll();
	}
}
