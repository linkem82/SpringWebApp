package com.webdev.emilio.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.ReflectionUtils;

public abstract class AbstractHbnDao<E extends Object> implements Dao<E> {
	
	private @Inject SessionFactory sessionFactory;
	private Class<E> domainClass;
	
	protected Session getSession() { 		
		return this.sessionFactory.getCurrentSession();		
	}	

	public Class<E> getDomainClass() {		
		if(this.domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.domainClass = (Class<E>) thisType.getActualTypeArguments()[0];
		}
		return this.domainClass;	
	}
	
	public String getDomainClassName() {		
		return this.domainClass.getName();		
	}
	
	public void create(E e) {		
		Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated", new Class[]{Date.class});
		if(method != null) {
			try {
				method.invoke(e, new Date());
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		this.getSession().save(e);		
	}
	
	public E load(Serializable id) {		
		return (E)this.getSession().load(getDomainClass(), id);		 
	}
	
	@Override
	public E get(Serializable id) {
		return (E)this.getSession().get(getDomainClass(), id);
	}

	@Override
	public List<E> getAll() {
		return this.getSession().createQuery("from " + this.getDomainClassName()).list();
	}

	@Override
	public void update(E e) {
		this.getSession().update(e);		
	}

	@Override
	public void delete(E e) {
		this.getSession().delete(e);		
	}

	@Override
	public void deleteById(Serializable id) {
		this.getSession().delete(this.load(id));		
	}

	@Override
	public void deleteAll() {
		this.getSession().createQuery("delete " + this.getDomainClassName()).executeUpdate();		
	}

	@Override
	public Long count() {
		return (Long)this.getSession().createQuery("select count(*) from " + this.getDomainClass()).uniqueResult();
	}

	@Override
	public boolean exists(Serializable id) {
		return this.get(id) != null;
	}

}
