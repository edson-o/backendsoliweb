package com.pe.solicitud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pe.solicitud.entity.Account;
import com.pe.solicitud.entity.WebRequest;

@Repository
@Transactional
public class WebRequestRepo {

	@PersistenceContext
	private EntityManager em;

	public WebRequest getById(int id) {
		return em.find(WebRequest.class, id);
	}

	public WebRequest save(WebRequest webRequest) {
		this.em.persist(webRequest);
		return webRequest;
	}

	public WebRequest update(WebRequest webRequest) {
		return ((WebRequest) em.merge(webRequest));
	}

	public WebRequest delete(WebRequest webRequest) {
		return ((WebRequest) em.merge(webRequest));
	}

	@SuppressWarnings("unchecked")
	public List<WebRequest> list(Account account) {
		String sql = " select w from WebRequest w where flag=1 ";
		if (account != null) {
			sql = sql + " and account = :account ";
		}

		Query query = em.createQuery(sql);

		if (account != null) {
			query.setParameter("account", account);
		}

		return query.getResultList();
	}

}
