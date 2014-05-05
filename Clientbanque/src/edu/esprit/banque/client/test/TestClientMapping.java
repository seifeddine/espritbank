package edu.esprit.banque.client.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import edu.esprit.banque.client.utils.ServiceLocator;
import edu.esprit.banque.domain.Personne;
import edu.esprit.banque.domain.Fiche;
import edu.esprit.banque.ejb.services.PersonneServiceRemote;

public class TestClientMapping {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		PersonneServiceRemote c =(PersonneServiceRemote) ServiceLocator.lookup("/edu.esprit.banque.ejb/ClientService!edu.esprit.banque.ejb.services.ClientServiceRemote");
		Personne cli = new Personne();
		cli.setId(7);
		cli.setCin(123);
		cli.setNom("flappy");
		cli.setPrenom("bird");
		
		Fiche f = new Fiche();
		f.setAddress("Tun");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998,6,12);
		
		f.setDatenaiss(calendar.getTime());
		f.setClient(cli);
		f.setId(13);
		
		//cli.setFiche(f);
		//c.addClient(cli);
	
	}

}
