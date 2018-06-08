package com.pe.solicitud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pe.solicitud.entity.Account;

@Transactional
@Repository
public class AccountRepo {

	@PersistenceContext
	private EntityManager em;

	public Account getById(int id) {
		return em.find(Account.class, id);
	}

	public Account save(Account account) {
		this.em.persist(account);
		return account;
	}

	public Account update(Account account) {
		return ((Account) em.merge(account));
	}

	public Account delete(Account account) {
		return ((Account) em.merge(account));
	}

	@SuppressWarnings("unchecked")
	public List<Account> list() {
		String sql = "select a from Account a where flag = 1";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Account> login(String usuario, String password) {
		String sql = "select a from Account a where  flag = 1 ";
		if (usuario != null) {
			sql = sql + " and usuario = :usuario ";
		}
		if (password != null) {
			sql = sql + " and password = :password ";
		}

		Query query = em.createQuery(sql);

		if (usuario != null) {
			query.setParameter("usuario", usuario);
		}
		if (password != null) {
			query.setParameter("password", password);
		}

		return query.getResultList();

	}

}
