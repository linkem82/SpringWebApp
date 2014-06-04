package com.webdev.emilio.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<E extends Object> {
	
	public void create(E e);
	public E load(Serializable id);
	public E get(Serializable id);
	public List<E> getAll();
	public void update(E e);
	public void delete(E e);
	public void deleteById(Serializable id);
	public void deleteAll();
	public Long count();
	public boolean exists(Serializable id);

}
