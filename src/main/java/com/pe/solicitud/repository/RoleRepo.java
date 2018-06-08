package com.pe.solicitud.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class RoleRepo {

	@PersistenceContext
	private EntityManager em;
	
	
}
