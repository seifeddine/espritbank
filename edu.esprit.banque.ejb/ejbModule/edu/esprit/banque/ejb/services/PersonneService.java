package edu.esprit.banque.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.banque.domain.Admin;
import edu.esprit.banque.domain.Compte;
import edu.esprit.banque.domain.Personne;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
public class PersonneService implements PersonneServiceRemote, PersonneServiceLocal {

	@PersistenceContext(name="banquePU")
	private EntityManager entityManager;
	
	@Override
	public void addClient(Personne client) {
		entityManager.persist(client);//persist sert a insert seulement
		
		
	}
	
	@Override
	public Boolean Retirer(Personne sender, double somme) {
		if(sender.getSold()<somme){
			return false;
		}
		else 
		{	sender.setSold(sender.getSold()-somme);
			entityManager.merge(sender);
		return true;}
	}

	@Override
	public void updateClient(Personne client) {
		entityManager.merge(client);//merge sert a insert or update
		
	}

	@Override
	public Personne findClientByID(int id) {
		return entityManager.find(Personne.class, id);
	}

	@Override
	public void deleteClient(Personne client) {
		//TODO modifier ce code
		entityManager.remove(entityManager.merge(client));
	}

	@Override
	public List<Personne> findAllClients() {
		//Query q=entityManager.createQuery("select c from Client c",Client.class);
		return entityManager.createQuery("select c from Personne c where isadmin=0 ",Personne.class).getResultList();
	}
	
	

	@Override
	public List<Personne> getClientByAge(int age) {
		Query q = entityManager.createQuery("select c from Personne c where c.age > :p");
		q.setParameter("p", age);
		return q.getResultList();
	}

	@Override
	public Personne getClientByCin(int cin) {
		Query q = entityManager.createQuery("select c from Personne c where c.cin = :p");
		q.setParameter("p", cin);
		return (Personne) q.getSingleResult();
	}

	
	@Override
	public Personne authenticate(String login, String password) {
		
		Personne found = null;
		
		String jpql="select c from Personne c where c.login=:login and c.pass=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try 
		{
			found = (Personne) query.getSingleResult();
		}
		catch (Exception ex)
		{
			return null;
			
		}
	return found;	
	}
	
	
	@Override
	public double ShowSold(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean transferSommeClient(Personne sender,Personne reciever, double somme) {
		if(sender.getSold()<somme){
			return false;
		}
		//System.out.println(reciever.getId());
		sender.setSold(sender.getSold()-somme);
		reciever.setSold(reciever.getSold()+somme);
		entityManager.merge(sender);
		entityManager.merge(reciever);
		return true;
	}

	@Override
	public Personne getClientByName(String name) {
		Query q = entityManager.createQuery("select c from Personne c where c.nom = :p");
		q.setParameter("p", name);
		return (Personne) q.getSingleResult();
		
	}



	
   

}
