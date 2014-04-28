package edu.esprit.banque.ejb.services;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.banque.domain.Agence;



@Stateless
public class AgenceService implements AgenceServiceLocal, AgenceServiceRemote {

	@PersistenceContext(name="banquePU")
	private EntityManager entityManager;
	
	@Override
	public List<Agence> findAllAgence() {
		return entityManager.createQuery("select c from Personne c where c.isadmin=0",Agence.class).getResultList();
	}

	@Override
	public void addAgence(Agence agence) {
		entityManager.persist(agence);
		
	}

	@Override
	public void updateAgence(Agence agence) {
		entityManager.merge(agence);
		
	}

	
	
}
