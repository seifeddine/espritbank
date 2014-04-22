package edu.esprit.banque.ejb.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.banque.domain.Client;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
public class ClientService implements ClientServiceRemote, ClientServiceLocal {

	@PersistenceContext(name="banquePU")
	private EntityManager entityManager;
	
	@Override
	public void addClient(Client client) {
		entityManager.persist(client);//persist sert a insert seulement
		
	}

	@Override
	public void updateClient(Client client) {
		entityManager.merge(client);//merge sert a insert or update
		
	}

	@Override
	public Client findClientByID(int id) {
		return entityManager.find(Client.class, id);
	}

	@Override
	public void deleteClient(Client client) {
		//TODO modifier ce code
		entityManager.remove(entityManager.merge(client));
	}

	@Override
	public List<Client> findAllClients() {
		//Query q=entityManager.createQuery("select c from Client c",Client.class);
		return entityManager.createQuery("select c from Client c",Client.class).getResultList();
	}

	@Override
	public List<Client> getClientByAge(int age) {
		Query q = entityManager.createQuery("select c from Client c where c.age > :p");
		q.setParameter("p", age);
		return q.getResultList();
	}

	@Override
	public Client getClientByCin(int cin) {
		Query q = entityManager.createQuery("select c from Client c where c.cin = :p");
		q.setParameter("p", cin);
		return (Client) q.getSingleResult();
	}

	@Override
	public Client authenticate(String login, String password) {
		
		Client found = null;
		
		String jpql="select c from Client c where c.login=:login and c.pass=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try 
		{
			found = (Client) query.getSingleResult();
		}
		catch (Exception ex)
		{
			return null;
			
		}
	return found;	
	}
	

  
   

}
