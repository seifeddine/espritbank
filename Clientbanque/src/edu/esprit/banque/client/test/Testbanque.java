package edu.esprit.banque.client.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.esprit.banque.client.utils.ServiceLocator;
import edu.esprit.banque.domain.Admin;
import edu.esprit.banque.domain.Personne;
import edu.esprit.banque.ejb.services.PersonneServiceRemote;


public class Testbanque {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testaddClient() {
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		Personne cli = new Personne();
		//cli.setId(5);
		cli.setNom("nacef");
		cli.setPrenom("nacef");
		cli.setPass("nacef");
		cli.setLogin("nacef");
		cli.setAge(35);
		cli.setCin(78462);
		cli.setSold(80);
		c.addClient(cli);	     
	
	}
	
	@Test
	public void testaddADmin() {
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		Personne cli = new Personne();
		
		cli.setIsadmin(true);
		cli.setNom("Taher");
		cli.setPrenom("belakhder");
		cli.setPass("admin");
		cli.setLogin("admin");
		cli.setAge(50);
		cli.setSold(10);
		cli.setCin(84651);
		c.addClient(cli);	     
	
	}
	
	@Test
	public void delete()
	{
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		Personne cli = new Personne();
	//	cli.setId(5);

		c.deleteClient(cli);
	}
	@Test
	public void testupdate() {
		
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		Personne cli = new Personne();		
		//cli.setId(123);
		cli.setIsadmin(false);
		cli.setNom("seif");
		cli.setPrenom("eddine");
		cli.setPass("seif");
		cli.setLogin("seif");
		cli.setAge(18);
		cli.setCin(69454);
		c.updateClient(cli);
		
		
	}
	
	/*@Test
	public void testfindall() {
		
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		
	
		List<Client> L1 =c.findAllClients();
		
		 for (int i=0; i<=L1.size()-1; i++)
	      {
			Client cli = (Client)L1.get(i);
			 
			  System.out.println(cli);
			 }
			}
	*/
	@Test
	public void testfindbyage() {
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");
		Personne cli =c.findClientByID(2);
		System.out.println(cli);

	}
	
	@Test
	public void testgetbyage() {
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banq/edu.esprit.banque.ejb/PersonneService!edu.esprit.banque.ejb.services.PersonneServiceRemote");

		List<Personne> L1 =c.getClientByAge(17);
		for (int i=0; i<=L1.size()-1; i++)
	      {
			Personne cli = (Personne)L1.get(i);
			 
			  System.out.println(cli);
			 }

	}

	
		
	
}
