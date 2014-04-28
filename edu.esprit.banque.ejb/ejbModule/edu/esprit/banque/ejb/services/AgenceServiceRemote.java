package edu.esprit.banque.ejb.services;


import java.util.List;

import javax.ejb.Remote;

import edu.esprit.banque.domain.Agence;

@Remote
public interface AgenceServiceRemote {

	public List<Agence> findAllAgence();
	public void addAgence(Agence agence);
	public void updateAgence( Agence agence);
}
